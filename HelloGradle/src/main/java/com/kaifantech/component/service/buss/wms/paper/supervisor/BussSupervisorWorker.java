package com.kaifantech.component.service.buss.wms.paper.supervisor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperDetailBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperMainBean;
import com.kaifantech.component.dao.agv.info.AgvOpWmsDao;
import com.kaifantech.component.dao.taskexe.op.TaskexeOpDao;
import com.kaifantech.component.service.alloc.info.AllocInventoryInfoService;
import com.kaifantech.component.service.alloc.info.IAllocInfoService;
import com.kaifantech.component.service.alloc.status.IAllocStatusMgrService;
import com.kaifantech.component.service.paper.base.WmsPaperService;
import com.kaifantech.component.service.rest.WmsRestService;
import com.kaifantech.component.service.status.agv.AgvsCtrlInfoService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.component.service.taskexe.oper.CsyTaskexeAddService;
import com.kaifantech.util.constant.taskexe.TaskexeOpFlag;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.constant.wms.WmsPaperStatus;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.log.CsyAppFileLogger;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Component
@Lazy(false)
public class BussSupervisorWorker {

	@Autowired
	private WmsRestService wmsRestService;

	@Autowired
	private IAllocInfoService allocInfoService;

	@Autowired
	private IAllocStatusMgrService allocStatusMgrService;

	@Autowired
	private CsyTaskexeAddService<?, ?> taskexeService;

	@Autowired
	private TaskexeInfoService taskexeInfoService;

	@Autowired
	protected WmsPaperService wmsPaperService;

	@Autowired
	private AgvOpWmsDao agvOpWmsDao;

	@Autowired
	private TaskexeOpDao taskexeOpDao;

	@Autowired
	private AgvsCtrlInfoService agvsCtrlInfoService;

	@Autowired
	private AllocInventoryInfoService allocInventoryInfoService;

	@Autowired
	protected TaskexeOpDao taskexeTaskDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized <TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>> AppMsg newTask(TM tmBean) {
		try {
			AppMsg msg = taskexeService.addTask(tmBean);
			if (msg.getCode() < 0) {
			} else {
				String taskType = wmsPaperService.getTaskType(tmBean);
				wmsPaperService.getMainService(tmBean).updateToFrom(tmBean.getId(), WmsPaperStatus.EXECUTING,
						WmsPaperStatus.TOSEND);
				ThreadTool.run(() -> {
					String notice = "{\"Type\":\"" + taskType + "\",\"PaperId\":\"" + tmBean.getPaperid()
							+ "\",\"Status\":\"" + WmsPaperStatus.TOSEND + "\",\"Description\":\"完成下达！\"}";
					wmsRestService.sendToWms(notice);
					ThreadTool.run(() -> {
						String notice2 = "{\"Type\":\"" + taskType + "\",\"PaperId\":\"" + tmBean.getPaperid()
								+ "\",\"Status\":\"" + WmsPaperStatus.EXECUTING + "\",\"Description\":\"开始执行！\"}";
						ThreadTool.sleep(5000);
						wmsRestService.sendToWms(notice2);
					});
				});
			}
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			return new AppMsg(-1, "出现异常：" + e.getMessage());
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized <TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>> void watchTask(TM tmBean) {
		try {
			TaskexeBean taskexeBean = taskexeInfoService.getOne(tmBean.getPaperid());
			if (AppTool.isNull(taskexeBean)) {
				return;
			}
			if (TaskexeOpFlag.OVER.equals(taskexeBean.getOpflag())) {
				overPaper(tmBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized <TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>> void watchInventoryTask(
			TM tmBean) {
		try {
			List<TaskexeBean> taskexeList = taskexeInfoService.getAllList(tmBean.getPaperid());
			if (AppTool.isNull(taskexeList)) {
				return;
			}
			int finishedTaskexesNum = 0;
			for (TaskexeBean taskexeBean : taskexeList) {
				if (TaskexeOpFlag.OVER.equals(taskexeBean.getOpflag())) {
					finishedTaskexesNum++;
					continue;
				}
				if (TaskexeOpFlag.SEND.equals(taskexeBean.getOpflag())) {
					break;
				}
			}

			if (finishedTaskexesNum == taskexeList.size()) {
				overPaper(tmBean);
				AppFileLogger.warning("单号" + tmBean.getPaperid() + "已执行完毕，更新盘点单状态为OVER！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized <TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>> void arrangeInventoryTask(
			TM tmBean) {
		try {
			boolean isShutdownInventory = allocInventoryInfoService.isShutdownInventory();
			boolean isPauseInventory = allocInventoryInfoService.isPauseInventory();
			List<TaskexeBean> taskexeList = taskexeInfoService.getAllList(tmBean.getPaperid());
			if (AppTool.isNull(taskexeList)) {
				return;
			}
			for (TaskexeBean taskexeBean : taskexeList) {
				if (TaskexeOpFlag.NEW.equals(taskexeBean.getOpflag())) {
					if (isShutdownInventory) {
						taskexeTaskDao.overANormalTask(taskexeBean);
						continue;
					}
					if (isPauseInventory) {
						break;
					}
					if (AppTool.isNull(taskexeBean.getAgvId())) {
						Integer tmpAgvId = agvsCtrlInfoService.getFreeAgvId();
						if (AppTool.isNull(tmpAgvId)) {
							CsyAppFileLogger.error("未找到空闲AGV执行此" + "盘点任务！" + taskexeBean.getTaskid() + "-"
									+ taskexeBean.getTasksequence());
							return;
						}
						taskexeOpDao.assignT2Agv(taskexeBean, tmpAgvId);
						agvOpWmsDao.command(tmpAgvId, AgvTaskType.INVENTORY);
						agvOpWmsDao.goWork(tmpAgvId, AgvTaskType.INVENTORY, tmBean.getPaperid());
					}
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private <TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>> void overPaper(TM tmBean) {
		String taskType = wmsPaperService.getTaskType(tmBean);
		wmsPaperService.getMainService(tmBean).updateToFrom(tmBean.getId(), WmsPaperStatus.OVER,
				WmsPaperStatus.EXECUTING);
		if (AgvTaskType.RECEIPT.equals(taskType) || AgvTaskType.SHIPMENT.equals(taskType)) {
			for (WmsPaperDetailBean bean : wmsPaperService.getMainService(tmBean)
					.findDetailsByPaperid(tmBean.getPaperid())) {
				AllocItemInfoBean allocItem = allocInfoService.getByNameFromDB(bean.getUserdef1());
				AppMsg msg = AgvTaskType.RECEIPT.equals(taskType) ? allocStatusMgrService.transferUpDone(allocItem)
						: allocStatusMgrService.transferDownDone(allocItem);
				System.out.println(msg);
			}
		}
		if (!AgvTaskType.SHIPMENT.equals(taskType)) {
			ThreadTool.run(() -> {
				String notice = "{\"Type\":\"" + taskType + "\",\"PaperId\":\"" + tmBean.getPaperid()
						+ "\",\"Status\":\"" + WmsPaperStatus.OVER + "\",\"Description\":\"操作成功结束！\"}";
				wmsRestService.sendToWms(notice);
			});
		}
	}
}
