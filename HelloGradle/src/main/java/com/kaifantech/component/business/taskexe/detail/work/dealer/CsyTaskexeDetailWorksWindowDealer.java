package com.kaifantech.component.business.taskexe.detail.work.dealer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.bean.taskexe.TaskexeDetailWorksBean;
import com.kaifantech.bean.wms.paper.receipt.ReceiptDetailBean;
import com.kaifantech.component.cache.stock.AgvStockCacheService;
import com.kaifantech.component.comm.manager.plc.PlcManager;
import com.kaifantech.component.comm.worker.client.dev.CsyWindowWorker;
import com.kaifantech.component.comm.worker.server.robot.CsyRobotServerWorker;
import com.kaifantech.component.dao.agv.info.AgvOpWmsDao;
import com.kaifantech.component.service.paper.receipt.ReceiptDetailService;
import com.kaifantech.component.service.rest.WmsRestService;
import com.kaifantech.component.service.tasksite.TaskSiteInfoService;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.mappings.taskexe.TaskexeDetailMapper;
import com.kaifantech.mappings.taskexe.TaskexeDetailWorksMapper;
import com.kaifantech.util.constant.taskexe.ArrivedAct;
import com.kaifantech.util.constant.taskexe.WmsDetailOpFlag;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.constant.wms.WmsPaperStatus;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.msg.plc.PlcMsgGetter;
import com.kaifantech.util.msg.robot.RobotMsgGetter;
import com.kaifantech.util.socket.netty.server.csy.CsyRobotNettyServer;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

@Service
public class CsyTaskexeDetailWorksWindowDealer {
	public void windowStock(CsyAgvMsgBean csyAgvMsgBean, TaskexeDetailBean taskexeDetail,
			List<TaskexeDetailWorksBean> works) throws Exception {
		windowAct(csyAgvMsgBean, taskexeDetail, works, ArrivedAct.WINDOW_STOCK);
	}

	public void windowGet(CsyAgvMsgBean csyAgvMsgBean, TaskexeDetailBean taskexeDetail,
			List<TaskexeDetailWorksBean> works) throws Exception {
		windowAct(csyAgvMsgBean, taskexeDetail, works, ArrivedAct.WINDOW_GET);
	}

	public void windowAct(CsyAgvMsgBean csyAgvMsgBean, TaskexeDetailBean taskexeDetail,
			List<TaskexeDetailWorksBean> works, String type) throws Exception {
		final String taskType;
		Integer agvId = csyAgvMsgBean.agvId();
		if (ArrivedAct.WINDOW_STOCK.equals(type)) {
			taskType = AgvTaskType.SHIPMENT;
		} else {
			taskType = AgvTaskType.RECEIPT;
		}

		if (!taskexeDetail.matchThisSite(csyAgvMsgBean)) {
			return;
		}

		String window = taskSiteInfoService.getWindowNumFromSite(taskexeDetail.getSiteid());
		String taskid = taskexeDetail.getTaskid();

		if (taskexeDetail.isNew()) {
			SystemParameters.setTaskstop(agvId, true);
			taskexeDetailMapper.updateOpflag(taskexeDetail.setOpflag(WmsDetailOpFlag.SEND));
			agvOpWmsDao.reachWindow(agvId, taskType);
			return;
		}

		if (taskexeDetail.isSend()) {
			int overedWorksNum = 0;
			int sendWorksNum = 0;
			for (int i = 1; i <= works.size(); i++) {
				TaskexeDetailWorksBean work = works.get(i - 1);
				if (work.isOver()) {
					overedWorksNum++;
					continue;
				} else if (work.isSend()) {
					sendWorksNum++;
					if (PlcMsgGetter.one().isTaskOver(agvId)) {
						taskexeDetailWorksMapper.updateOpflag(work.setOpflag(WmsDetailOpFlag.OVER));
					}
					break;
				} else if (work.isNew()) {
					if (ArrivedAct.WINDOW_STOCK.equals(type)) {
						Integer nextLayer = agvStockCacheService.getNextLayerToGet(agvId);
						plcManager.agvToWindow(agvId, "" + nextLayer, window, "" + i);
						taskexeDetailWorksMapper.updateOpflag(work.setOpflag(WmsDetailOpFlag.SEND));
					} else if (ArrivedAct.WINDOW_GET.equals(type)) {
						Map<Integer, String> receiptData = RobotMsgGetter.one().getReceiptData(taskid);
						if (overedWorksNum == 0 && sendWorksNum == 0 && SystemParameters.isReceiptNeedScan()) {
							int scanTimes = 0;
							CsyRobotNettyServer server = (CsyRobotNettyServer) robotServerWorker.get(1);
							server.setAgvTask(agvId, taskType, taskid);
							plcManager.robotScanWindow(agvId, window);
							scanTimes++;
							List<ReceiptDetailBean> details = getDetailList(taskexeDetail.getTaskid());
							while (true) {
								if (SystemParameters.isShutdown(taskid)) {
									return;
								}
								receiptData = RobotMsgGetter.one().getReceiptData(taskid);
								if (PlcMsgGetter.one().isTaskOver(agvId)) {
									AppFileLogger.warning("机器人成功获取到窗口档案数据!");
									long receiptDataMatchSize = 0;
									if (!AppTool.isNull(receiptData)) {
										receiptDataMatchSize = details.stream().filter((detail) -> {
											for (String data : RobotMsgGetter.one().getReceiptData(taskid).values()) {
												if (detail.getUserdef1().equals(data)) {
													return true;
												}
											}
											return false;
										}).count();
									}
									if (receiptDataMatchSize < details.size() && scanTimes < 3) {
										AppFileLogger.warning(
												"扫描结果数量小于入库单数量，重新尝试!receiptDataMatchSize：" + receiptDataMatchSize);
										plcManager.robotScanWindow(agvId, window);
										scanTimes++;
										continue;
									}
									break;
								}
								ThreadTool.sleep(2000);
							}
						}
						Entry<Integer, String> nextEntry = getAlloc(works, work);
						boolean isAllocInDetails = false;
						if (!AppTool.isNull(nextEntry)) {
							isAllocInDetails = inDetail(nextEntry.getValue(), work.getTaskid());
						}
						if (isAllocInDetails) {
							Integer nextLayer = agvStockCacheService.getNextLayerToStock(agvId, nextEntry.getValue());
							plcManager.windowToAgv(agvId, "" + nextLayer, window, "" + nextEntry.getKey());
							taskexeDetailWorksMapper.updateOpflag(work.setOpflag(WmsDetailOpFlag.SEND));
						} else {
							System.out.println("执行任务（" + taskid + "）时档案不在入库单中，退出档案！"
									+ (AppTool.isNull(nextEntry) ? "" : "退档内容：" + nextEntry.getValue()));
							taskexeDetailWorksMapper.updateOpflag(work.setOpflag(WmsDetailOpFlag.OVER));
						}
					}
					break;
				} else {
					break;
				}
			}
			if (overedWorksNum == works.size()) {
				if (AgvTaskType.SHIPMENT.equals(taskType)) {
					windowOut(csyAgvMsgBean);
				}
				plcManager.forbidAct(agvId);
				List<ReceiptDetailBean> remains = getDetailList(taskexeDetail.getTaskid());
				if (!AppTool.isNull(remains) && remains.size() > 0) {
					ThreadTool.run(() -> {
						List<String> allocs = new ArrayList<>();
						for (ReceiptDetailBean detail : remains) {
							allocs.add("{\"AllocInfo\":\"" + detail.getUserdef1() + "\"}");
						}
						String tosend = "{\"PaperId\":\"" + taskexeDetail.getTaskid() + "\",\"ItemList\": ["
								+ StringUtils.join(allocs.toArray(), ",") + "]}";
						wmsRestService.receiptErrToWms(tosend);
						detailMap.remove(remains);
					});
				}
				RobotMsgGetter.one().removeReceiptData(taskexeDetail.getTaskid());
				while (true) {
					if (SystemParameters.isShutdown(taskid)) {
						return;
					}
					if (PlcMsgGetter.one().isTaskOver(agvId)) {
						AppFileLogger.warning("收到PLC执行结束的消息后，将bean状态修改为OVER，并下达行走指令到AGV");
						if (AgvTaskType.SHIPMENT.equals(taskType)) {
							ThreadTool.run(() -> {
								String notice = "{\"Type\":\"" + taskType + "\",\"PaperId\":\""
										+ taskexeDetail.getTaskid() + "\",\"Status\":\"" + WmsPaperStatus.OVER
										+ "\",\"Description\":\"操作成功结束！\"}";
								wmsRestService.sendToWms(notice);
							});
						}
						taskexeDetailMapper.updateOpflag(taskexeDetail.setOpflag(WmsDetailOpFlag.OVER));
						agvOpWmsDao.workDoneWindow(agvId, taskType);
						SystemParameters.setTaskstop(agvId, false);
						break;
					}
					ThreadTool.sleep(1000);
				}
			}
			return;
		}
	}

	private Map<String, List<ReceiptDetailBean>> detailMap = new HashMap<>();

	private List<ReceiptDetailBean> getDetailList(String key) {
		List<ReceiptDetailBean> list = detailMap.get(key);
		if (list == null) {
			list = receiptDetailService.findByPaperid(key);
			detailMap.put(key, list);
		}
		return list;
	}

	private void windowOut(CsyAgvMsgBean csyAgvMsgBean) {
		Integer windowId = taskSiteInfoService.getWindowIdFromSite(csyAgvMsgBean.currentSite());
		csyWindowWorker.get(windowId).sendMsg(AppByteUtil.int2Str4Reverse(255));
	}

	private Entry<Integer, String> getAlloc(List<TaskexeDetailWorksBean> works, TaskexeDetailWorksBean work)
			throws Exception {
		if (SystemParameters.isReceiptNeedScan()) {
			Map<Integer, String> receiptData = RobotMsgGetter.one().getReceiptData(work.getTaskid());
			Entry<Integer, String> rtnEntry;
			List<ReceiptDetailBean> details = getDetailList(work.getTaskid());
			for (Entry<Integer, String> entry : receiptData.entrySet()) {
				long count = details.stream().filter((detail) -> {
					return detail.getUserdef1().equals(entry.getValue());
				}).count();
				if (count == 0) {
					continue;
				}
				rtnEntry = entry;
				return rtnEntry;
			}
		}
		return null;
	}

	private boolean inDetail(String alloc, String taskid) {
		List<ReceiptDetailBean> details = getDetailList(taskid);
		for (ReceiptDetailBean detail : details) {
			if (alloc.equals(detail.getUserdef1())) {
				details.remove(detail);
				return true;
			}
		}
		return false;
	}

	@Autowired
	private CsyRobotServerWorker robotServerWorker;

	@Autowired
	private CsyWindowWorker csyWindowWorker;

	@Autowired
	private PlcManager plcManager;

	@Autowired
	private ReceiptDetailService receiptDetailService;

	@Autowired
	private AgvStockCacheService agvStockCacheService;

	@Autowired
	private TaskSiteInfoService taskSiteInfoService;

	@Autowired
	private TaskexeDetailMapper taskexeDetailMapper;

	@Autowired
	private AgvOpWmsDao agvOpWmsDao;

	@Autowired
	private TaskexeDetailWorksMapper taskexeDetailWorksMapper;

	@Autowired
	private WmsRestService wmsRestService;

}
