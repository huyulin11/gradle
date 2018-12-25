package com.kaifantech.component.service.status.iot;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.component.comm.manager.iot.IotManager;
import com.kaifantech.component.dao.ControlInfoDao;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.dao.agv.info.AgvOpChargeDao;
import com.kaifantech.component.dao.taskexe.op.TaskexeOpDao;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.paper.base.WmsPaperService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.TaskexeOpFlag;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvSiteStatus;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Component
public class AgvChargeDealer {
	@Autowired
	private TaskexeInfoService taskexeInfoService;

	@Autowired
	protected WmsPaperService wmsPaperService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	@Autowired
	private AgvOpChargeDao agvOpDao;

	@Autowired
	private TaskexeOpDao taskexeTaskDao;

	@Autowired
	private ControlInfoDao controlInfoDao;

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	private IotManager iotManager;

	public synchronized void chargeMgr() {
		Map<Integer, Boolean> chargeStatusMap = iotClientService.isChargingMap();
		if (chargeStatusMap.get(13) && !chargeStatusMap.get(14)) {
			agvInfoDao.getChargedList().stream().anyMatch((agvInCharge) -> {
				if (agvInCharge.isCharging() && agvInCharge.getChargeid().equals(13)
						&& AgvSiteStatus.CHARGING.equals(agvInCharge.getSitestatus())
						&& AgvTaskType.GOTO_CHARGE.equals(agvInCharge.getTaskstatus())) {
					AppMsg msg = newTask(agvInCharge, AgvTaskType.CHANGE_CHARGE);
					if (!AppTool.isNull(msg.getMsg())) {
						AppFileLogger.error(msg.getMsg());
					}
					return true;
				}
				return false;
			});
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized AppMsg newTask(AgvBean targetAgv, String taskType) {
		if (AppTool.ifAnd(
				!(AgvSiteStatus.INIT.equals(targetAgv.getSitestatus())
						&& AgvTaskType.GOTO_CHARGE.equals(targetAgv.getTaskstatus())),
				!(AgvSiteStatus.CHARGING.equals(targetAgv.getSitestatus())
						&& AgvTaskType.BACK_CHARGE.equals(targetAgv.getTaskstatus())),
				!(AgvSiteStatus.CHARGING.equals(targetAgv.getSitestatus())
						&& AgvTaskType.GOTO_CHARGE.equals(targetAgv.getTaskstatus())))) {
			return new AppMsg(-1, "下达充电任务到" + targetAgv.getId() + "号AGV出现异常：" + "任务参数有问题：" + taskType);
		}
		try {
			String taskid = getSid();
			if (AgvTaskType.GOTO_CHARGE.equals(taskType)) {
				Integer choosedChargeId = iotClientService.getFreeChargeId();
				if (AppTool.isNull(choosedChargeId) || choosedChargeId.equals(0)) {
					return new AppMsg(-1, "下达充电任务到" + targetAgv.getId() + "号AGV出现异常：" + "未能找到合适的充电站！");
				}

				if (choosedChargeId.equals(14)) {
					if (agvInfoDao.getChargedList().stream().filter((agvInCharge) -> {
						if (agvInCharge.isCharging() && agvInCharge.getChargeid().equals(13)) {
							return true;
						} else {
							return false;
						}
					}).count() > 0) {
						return new AppMsg(-1, "下达到二号充电站任务到" + targetAgv.getId() + "号AGV出现异常：" + "有agv正在使用1号充电站！");
					}
				}

				taskexeTaskDao.addATask(taskid, targetAgv.getId(), 0, AgvTaskType.GOTO_CHARGE, 2);
				agvOpDao.goWorkToCharge(targetAgv.getId(), choosedChargeId, taskid);
				return new AppMsg(0, "下达充电任务，将" + targetAgv.getId() + "号AGV调度到" + choosedChargeId + "号充电站！");
			} else if (AgvTaskType.BACK_CHARGE.equals(taskType)) {
				iotManager.stopCharge(targetAgv.getId(), targetAgv.getChargeid());
				taskexeTaskDao.addATask(taskid, targetAgv.getId(), 0, AgvTaskType.BACK_CHARGE, 2);
				agvOpDao.goWorkBackCharge(targetAgv.getId(), taskid);
				return new AppMsg(0,
						"下达充电任务，将" + targetAgv.getId() + "号AGV从" + targetAgv.getChargeid() + "号充电站召回到其初始位置！");
			} else if (AgvTaskType.CHANGE_CHARGE.equals(taskType)) {
				iotManager.stopCharge(targetAgv.getId(), targetAgv.getChargeid());
				taskexeTaskDao.addATask(taskid, targetAgv.getId(), 0, AgvTaskType.CHANGE_CHARGE, 2);
				agvOpDao.goWorkChangeCharge(targetAgv.getId(), taskid, 14);
				return new AppMsg(0, "下达充电任务，将" + targetAgv.getId() + "号AGV从" + targetAgv.getChargeid() + "号充电站转移到"
						+ "14号充电站" + "！");
			}
			return new AppMsg(0, "");
		} catch (Exception e) {
			e.printStackTrace();
			return new AppMsg(-1, "出现异常：" + e.getMessage());
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized AppMsg watchTask(AgvBean tmBean) {
		try {
			TaskexeBean taskexeBean = taskexeInfoService.getOne(tmBean.getTaskid());
			if (AppTool.isNull(taskexeBean)) {
				return new AppMsg(0, "");
			}
			if (TaskexeOpFlag.OVER.equals(taskexeBean.getOpflag())) {
				if (AgvTaskType.GOTO_CHARGE.equals(taskexeBean.getTasktype())) {
					agvOpDao.workOverGotoCharge(tmBean.getId());
					return new AppMsg(0, "任务结束，将" + tmBean.getId() + "号AGV信息更新到正在充电状态，并告知PLC契合、充电站供电！");
				}
				if (AgvTaskType.BACK_CHARGE.equals(taskexeBean.getTasktype())) {
					ThreadTool.sleep(10000);
					agvOpDao.workOverBackCharge(tmBean.getId());
					return new AppMsg(0, "任务结束，将" + tmBean.getId() + "号AGV信息更新到初始空闲状态！");
				}
				if (AgvTaskType.CHANGE_CHARGE.equals(taskexeBean.getTasktype())) {
					ThreadTool.sleep(10000);
					agvOpDao.workOverGotoCharge(tmBean.getId());
					return new AppMsg(0, "任务结束，将" + tmBean.getId() + "号AGV" + "更新变更充电站完成，告知PLC契合、充电站供电！");
				}
			}
			return new AppMsg(0, "");
		} catch (Exception e) {
			e.printStackTrace();
			return new AppMsg(-1, "出现异常：" + e.getMessage());
		}
	}

	private String getSid() {
		String paperid = controlInfoDao.getPrefixByType("AGV_CHARGE_SID")
				+ String.format("%08d", controlInfoDao.getNextValueByType("AGV_CHARGE_SID"));
		return paperid;
	}

}
