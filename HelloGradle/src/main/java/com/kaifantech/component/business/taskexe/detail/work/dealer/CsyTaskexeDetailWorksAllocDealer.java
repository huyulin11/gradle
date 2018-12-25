package com.kaifantech.component.business.taskexe.detail.work.dealer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.bean.taskexe.TaskexeDetailWorksBean;
import com.kaifantech.component.business.taskexe.dealer.CsyTaskexeDealModule;
import com.kaifantech.component.cache.stock.AgvStockCacheService;
import com.kaifantech.component.comm.manager.plc.PlcManager;
import com.kaifantech.component.comm.worker.server.robot.CsyRobotServerWorker;
import com.kaifantech.component.dao.agv.info.AgvOpWmsDao;
import com.kaifantech.component.service.alloc.info.AllocInventoryInfoService;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.mappings.taskexe.TaskexeDetailMapper;
import com.kaifantech.mappings.taskexe.TaskexeDetailWorksMapper;
import com.kaifantech.util.constant.taskexe.ArrivedAct;
import com.kaifantech.util.constant.taskexe.WmsDetailOpFlag;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.constants.plc.PlcConstant;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.msg.plc.PlcMsgGetter;
import com.kaifantech.util.socket.netty.server.csy.CsyRobotNettyServer;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

@Service
public class CsyTaskexeDetailWorksAllocDealer {

	public void allocStock(CsyAgvMsgBean csyAgvMsgBean, TaskexeBean taskexeBean, TaskexeDetailBean taskexeDetail,
			List<TaskexeDetailWorksBean> works) throws Exception {
		allocAct(csyAgvMsgBean, taskexeBean, taskexeDetail, works, ArrivedAct.ALLOC_STOCK);
	}

	public void allocGet(CsyAgvMsgBean csyAgvMsgBean, TaskexeBean taskexeBean, TaskexeDetailBean taskexeDetail,
			List<TaskexeDetailWorksBean> works) throws Exception {
		allocAct(csyAgvMsgBean, taskexeBean, taskexeDetail, works, ArrivedAct.ALLOC_GET);
	}

	public void allocScan(CsyAgvMsgBean csyAgvMsgBean, TaskexeBean taskexeBean, TaskexeDetailBean taskexeDetail,
			List<TaskexeDetailWorksBean> works) throws Exception {
		allocAct(csyAgvMsgBean, taskexeBean, taskexeDetail, works, ArrivedAct.ALLOC_SCAN);
	}

	public void allocAct(CsyAgvMsgBean csyAgvMsgBean, TaskexeBean taskexeBean, TaskexeDetailBean taskexeDetail,
			List<TaskexeDetailWorksBean> works, String type) throws Exception {
		String taskType = "";
		Integer agvId = csyAgvMsgBean.agvId();
		if (ArrivedAct.ALLOC_STOCK.equals(type)) {
			taskType = AgvTaskType.RECEIPT;
		} else if (ArrivedAct.ALLOC_GET.equals(type)) {
			taskType = AgvTaskType.SHIPMENT;
		} else {
			taskType = AgvTaskType.INVENTORY;
		}

		if (!taskexeDetail.matchThisSite(csyAgvMsgBean)) {
			return;
		}

		if (taskexeDetail.isNew()) {
			if (ArrivedAct.ALLOC_SCAN.equals(type)) {
				boolean isShutdownInventory = allocInventoryInfoService.isShutdownInventory();
				if (isShutdownInventory) {
					csyTaskexeDealModule.cancel(taskexeBean, true);
					return;
				}
			}
			SystemParameters.setTaskstop(agvId, true);
			taskexeDetailMapper.updateOpflag(taskexeDetail.setOpflag(WmsDetailOpFlag.SEND));
			agvOpWmsDao.reachAlloc(agvId, taskType);
			return;
		}

		if (taskexeDetail.isSend()) {
			int overedWorksNum = 0;
			for (int i = 1; i <= works.size(); i++) {
				TaskexeDetailWorksBean work = works.get(i - 1);
				if (work.isOver()) {
					overedWorksNum++;
					continue;
				} else if (work.isSend()) {
					if (PlcMsgGetter.one().isTaskOver(agvId)) {
						taskexeDetailWorksMapper.updateOpflag(work.setOpflag(WmsDetailOpFlag.OVER));
					}
					break;
				} else if (work.isNew()) {
					String robotSide = null, forkSide = null, frameNum = null, pieceNum = null, grid = null;
					if (ArrivedAct.ALLOC_STOCK.equals(type) || ArrivedAct.ALLOC_GET.equals(type)) {
						String allocName = work.getAddedinfo();
						robotSide = PlcConstant.getRobotSide(allocName);
						forkSide = PlcConstant.getForkSide(allocName);
						frameNum = PlcConstant.getFrameNum(allocName);
						pieceNum = PlcConstant.getPieceNum(allocName);
						if (ArrivedAct.ALLOC_STOCK.equals(type)) {
							Integer nextLayer = agvStockCacheService.getNextLayerToGet(agvId, work.getAddedinfo());
							if (AppTool.isNull(nextLayer)) {
								taskexeDetailWorksMapper.updateOpflag(work.setOpflag(WmsDetailOpFlag.OVER));
								break;
							}
							plcManager.agvToAlloc(agvId, "" + nextLayer, robotSide, forkSide, frameNum, pieceNum);
						} else if (ArrivedAct.ALLOC_GET.equals(type)) {
							Integer nextLayer = agvStockCacheService.getNextLayerToStock(agvId);
							plcManager.allocToAgv(agvId, "" + nextLayer, robotSide, forkSide, frameNum, pieceNum);
						}
					} else if (ArrivedAct.ALLOC_SCAN.equals(type)) {
						JSONObject json = (JSONObject) JSONObject.parse(work.getAddedinfo());
						robotSide = PlcConstant.getRobotSide(json.getInteger("line"));
						forkSide = PlcConstant.getForkSide(json.getInteger("line"), json.getInteger("column"));
						grid = "" + json.getInteger("grid");
						CsyRobotNettyServer server = (CsyRobotNettyServer) robotServerWorker.get(1);
						String task = "" + json.getInteger("line") + "-" + json.getInteger("frame") + "-"
								+ json.getInteger("column") + "-" + json.getInteger("grid");
						server.setAgvTask(agvId, taskType, task);
						plcManager.robotScan(agvId, robotSide, forkSide, grid);
					}
					taskexeDetailWorksMapper.updateOpflag(work.setOpflag(WmsDetailOpFlag.SEND));
					break;
				}
			}
			if (overedWorksNum == works.size()) {
				plcManager.forbidAct(agvId);
				while (true) {
					if (SystemParameters.isShutdown(taskexeDetail.getTaskid())) {
						return;
					}
					if (PlcMsgGetter.one().isTaskOver(agvId)) {
						AppFileLogger.warning("收到PLC执行结束的消息后，将bean状态修改为OVER，并下达行走指令到AGV");
						taskexeDetailMapper.updateOpflag(taskexeDetail.setOpflag(WmsDetailOpFlag.OVER));
						agvOpWmsDao.workDoneAlloc(agvId, taskType);
						break;
					}
					ThreadTool.sleep(1000);
				}
				SystemParameters.setTaskstop(agvId, false);
				if (ArrivedAct.ALLOC_SCAN.equals(type)) {
					boolean isShutdownInventory = allocInventoryInfoService.isShutdownInventory();
					if (isShutdownInventory) {
						csyTaskexeDealModule.cancel(taskexeBean, true);
						return;
					}
				}
			}
			return;
		}
	}

	@Autowired
	private PlcManager plcManager;

	@Autowired
	private CsyTaskexeDealModule csyTaskexeDealModule;

	@Autowired
	private CsyRobotServerWorker robotServerWorker;

	@Autowired
	private AgvStockCacheService agvStockCacheService;

	@Autowired
	private TaskexeDetailMapper taskexeDetailMapper;

	@Autowired
	private AllocInventoryInfoService allocInventoryInfoService;

	@Autowired
	private AgvOpWmsDao agvOpWmsDao;

	@Autowired
	private TaskexeDetailWorksMapper taskexeDetailWorksMapper;

}
