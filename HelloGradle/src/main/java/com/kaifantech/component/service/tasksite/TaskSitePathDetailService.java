package com.kaifantech.component.service.tasksite;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.kaifantech.bean.tasksite.TaskSiteLogicBean;

@Service
public class TaskSitePathDetailService {

	public boolean whenWindowBreak(TaskSiteInfoBean startSite, TaskSiteInfoBean targetSite,
			TaskSiteInfoBean currentSite, TaskSiteInfoBean nextSite) {
		if (targetSite.isWindowSite()) {
			if (!currentSite.isAllocSite() && nextSite.isAllocSite()) {
				return true;
			}
		}
		return false;
	}

	public boolean whenChargeBreak(TaskSiteInfoBean startSite, TaskSiteInfoBean targetSite,
			TaskSiteInfoBean currentSite, TaskSiteInfoBean nextSite) {
		if (startSite.isChargeSite() || targetSite.isChargeSite()) {
			if (nextSite.getId().equals(22)) {
				return true;
			}
		}
		if (startSite.isChargeSite() && targetSite.isChargeSite()) {
			if (notPass(currentSite, nextSite, TaskSiteLogicBean.path(10, 13), TaskSiteLogicBean.path(15, 16))) {
				return true;
			}
		}
		if (startSite.isChargeSite() && !targetSite.isChargeSite()) {
			if (passed(currentSite, nextSite, TaskSiteLogicBean.path(15, 16))) {
				return true;
			}
		}
		if (targetSite.isChargeSite()) {
			if (passed(currentSite, nextSite, TaskSiteLogicBean.path(65, 68), TaskSiteLogicBean.path(66, 69),
					TaskSiteLogicBean.path(10, 6), TaskSiteLogicBean.path(15, 19))) {
				return true;
			}
		}
		return false;
	}

	public boolean whenPassAllocRoadStartPoint(TaskSiteInfoBean currentSite, TaskSiteInfoBean nextSite) {
		if (!currentSite.isAllocSite() && nextSite.isAllocSite()) {
			return true;
		}
		return false;
	}

	public boolean whenInitBreak(TaskSiteInfoBean startSite, TaskSiteInfoBean targetSite, TaskSiteInfoBean currentSite,
			TaskSiteInfoBean nextSite, List<TaskSiteInfoBean> overedAllocRoadStartPoints) {
		if (startSite.isInitSite()) {
			if (passed(currentSite, nextSite, TaskSiteLogicBean.path(7, 6), TaskSiteLogicBean.path(2, 4),
					TaskSiteLogicBean.path(479, 4))) {
				return true;
			}
		}
		if (targetSite.isInitSite() && startSite.isWindowSite()) {
			if (overedAllocRoadStartPoints.size() > 0) {
				TaskSiteInfoBean firstOveredAllocRoadStartPoint = overedAllocRoadStartPoints.get(0);
				if (nextSite.isAllocSite() && !nextSite.getLine().equals(firstOveredAllocRoadStartPoint.getLine())) {
					return true;
				}
				if (currentSite.isOutSite() && nextSite.isOutSite()) {
					return true;
				}
			}
		}
		if (targetSite.isInitSite()) {
			if (targetSite.getId().equals(8)) {
				if (notPass(currentSite, nextSite, TaskSiteLogicBean.path(65, 66), TaskSiteLogicBean.path(66, 67),
						TaskSiteLogicBean.path(10, 6))) {
					return true;
				}
			} else if (targetSite.getId().equals(9)) {
				if (notPass(currentSite, nextSite, TaskSiteLogicBean.path(65, 66), TaskSiteLogicBean.path(66, 69))) {
					return true;
				}
			} else if (targetSite.getId().equals(11)) {
				if (notPass(currentSite, nextSite, TaskSiteLogicBean.path(65, 68), TaskSiteLogicBean.path(68, 481),
						TaskSiteLogicBean.path(479, 4))) {
					return true;
				}
			} else if (targetSite.getId().equals(12)) {
				if (notPass(currentSite, nextSite, TaskSiteLogicBean.path(65, 68), TaskSiteLogicBean.path(68, 3))) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean notPass(TaskSiteInfoBean currentSite, TaskSiteInfoBean nextSite, TaskSiteLogicBean... logics) {
		for (TaskSiteLogicBean logic : logics) {
			if (currentSite.getId().equals(logic.getSiteid())) {
				if (!nextSite.getId().equals(logic.getNextid())) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean passed(TaskSiteInfoBean currentSite, TaskSiteInfoBean nextSite, TaskSiteLogicBean... logics) {
		for (TaskSiteLogicBean logic : logics) {
			if (currentSite.getId().equals(logic.getSiteid())) {
				if (nextSite.getId().equals(logic.getNextid())) {
					return true;
				}
			}
		}
		return false;
	}

}