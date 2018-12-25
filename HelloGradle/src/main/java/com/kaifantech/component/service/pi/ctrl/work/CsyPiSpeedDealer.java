package com.kaifantech.component.service.pi.ctrl.work;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.kaifantech.component.comm.manager.agv.AgvManager;
import com.kaifantech.component.dao.taskexe.op.TaskexeOpDao;
import com.kaifantech.component.service.paper.base.WmsPaperService;
import com.kaifantech.component.service.taskexe.detail.TaskexeDetailInfoService;
import com.kaifantech.component.service.tasksite.TaskSiteInfoService;
import com.kaifantech.util.constants.cmd.AgvCmdConstant;
import com.kaifantech.util.log.AppFileLogger;
import com.ytgrading.util.AppTool;

@Service
public class CsyPiSpeedDealer {
	public void watchSpeed(TaskexeBean taskexeBean, List<TaskexeDetailBean> taskexeDetailList) {
		Map<String, Object> target = getTargetSpeed(taskexeBean, taskexeDetailList);
		if (AppTool.isNull(target)) {
			return;
		}

		Object targetSpeed = target.get(AgvCmdConstant.SPEED_CTRL_SPEED);
		if (AppTool.isNull(targetSpeed)) {
			return;
		}
		Integer targetSpeedInt = Integer.parseInt(targetSpeed.toString());
		agvManager.changeSpeed(taskexeBean.getAgvId(), targetSpeedInt);
	}

	public Map<String, Object> getTargetSpeed(TaskexeBean taskexeBean, List<TaskexeDetailBean> taskexeDetailList) {
		Map<String, Object> target = new HashMap<>();
		List<TaskexeDetailBean> list = taskexeDetailService.logic(taskexeDetailList);
		TaskexeBean piObj = csyPiInfoService.get(taskexeBean, list);
		if (AppTool.isNull(piObj)) {
			return null;
		}
		Integer speed = targetSpeed(piObj, taskexeBean, list);
		target.put(AgvCmdConstant.SPEED_CTRL_SPEED, speed);
		return target;
	}

	public Integer targetSpeed(TaskexeBean piObj, TaskexeBean taskexeBean, List<TaskexeDetailBean> list) {
		{
			TaskexeDetailBean next = piObj.currentDetail;
			int num = 0;
			while (!AppTool.isNull(next)) {
				if (AgvCmdConstant.LOOP_SITE_LIST.contains(next.getSiteid())) {
					next = next.getNext();
					num++;
				} else {
					if (num >= 3) {
						AppFileLogger.speedInfo(taskexeBean.getAgvId() + "号AGV:回环------直线");
						return AgvCmdConstant.SPEED_50;
					} else {
						break;
					}
				}
			}
		}

		{
			if (AppTool.isNull(piObj.nextStopDetail)) {
				return null;
			}
			double distanceToStop = 0;
			distanceToStop = piObj.nextStopDetail.getDistancetozero() - piObj.currentDetail.getDistancetozero();
			if (distanceToStop <= AgvCmdConstant.DISTANCE_LOW_TO_STOP) {
				return null;
			} else if (distanceToStop <= AgvCmdConstant.DISTANCE_LOW_READY_STOP) {
				return null;
			} else if (distanceToStop <= AgvCmdConstant.DISTANCE_LOW_PREPARE_STOP) {
				if (piObj.msg.currentSpeed() > AgvCmdConstant.SPEED_50) {
					AppFileLogger.speedInfo(taskexeBean.getAgvId() + "号AGV:停车------开始准备1");
					return AgvCmdConstant.SPEED_50;
				} else {
					return null;
				}
			}
		}

		if (!AppTool.isNull(piObj.nextCornerDetail)) {
			piObj.distance2NextCorner = TaskexeDetailBean.getDistanceOf(piObj.currentDetail, piObj.nextCornerDetail);
			if (piObj.distance2NextCorner <= AgvCmdConstant.DISTANCE_JUDGE_CORNER_OUT_2_ALLOC) {
				return null;
			} else if (piObj.distance2NextCorner <= AgvCmdConstant.DISTANCE_JUDGE_CORNER_HIGH_SLOWER) {
				AppFileLogger.speedInfo(taskexeBean.getAgvId() + "号AGV:转弯------中距离2：" + piObj.distance2NextCorner);
				if (piObj.msg.currentSpeed() > AgvCmdConstant.SPEED_50) {
					return AgvCmdConstant.SPEED_50;
				}
			}
		}

		{
			if (AppTool.equals(piObj.currentSite.getId(), 475, 476, 477, 478)) {
				return null;
			}
			if (AppTool.equals(piObj.currentSite.getId(), 480, 482, 20)) {
				return null;
			}
			if (AppTool.equals(piObj.msg.currentSite(), 8, 9, 11, 12)) {
				AppFileLogger.speedInfo(taskexeBean.getAgvId() + "号AGV:起步控制：" + piObj.distance2NextCorner);
				if (piObj.msg.currentSpeed() < AgvCmdConstant.SPEED_25) {
					return AgvCmdConstant.SPEED_25;
				}
			}
		}

		{
			if (AppTool.isNull(piObj.nextDetail)) {
				return null;
			}
			if (TaskSiteInfoBean.isCorner(piObj.currentSite, piObj.nextSite)) {
				return null;
			} else if (piObj.currentSite.isBackSite() || piObj.currentSite.isOutOrWindowSite()
					|| piObj.currentSite.isAllocSite()) {
				if (piObj.currentSite.isAllocSite() && piObj.msg.currentSpeed() < AgvCmdConstant.SPEED_50) {
					AppFileLogger.speedInfo(taskexeBean.getAgvId() + "号AGV:逻辑------货位站点高速");
					return AgvCmdConstant.SPEED_50;
				}
				if (!piObj.currentSite.isAllocSite() && piObj.msg.currentSpeed() < AgvCmdConstant.SPEED_80) {
					AppFileLogger.speedInfo(taskexeBean.getAgvId() + "号AGV:逻辑------两侧高速");
					return AgvCmdConstant.SPEED_80;
				}
			} else if (piObj.currentSite.isInitSite() || piObj.currentSite.isBaySite()) {
				AppFileLogger.speedInfo(taskexeBean.getAgvId() + "号AGV:逻辑------港湾");
				if (piObj.msg.currentSpeed() != AgvCmdConstant.SPEED_25) {
					return AgvCmdConstant.SPEED_25;
				}
			}
		}
		return null;
	}

	@Autowired
	protected WmsPaperService wmsPaperService;

	@Autowired
	protected TaskexeOpDao taskexeTaskDao;

	@Autowired
	protected TaskSiteInfoService taskSiteInfoService;

	@Autowired
	protected TaskexeDetailInfoService taskexeDetailService;

	@Autowired
	private AgvManager agvManager;

	@Autowired
	private CsyPiInfoService csyPiInfoService;
}
