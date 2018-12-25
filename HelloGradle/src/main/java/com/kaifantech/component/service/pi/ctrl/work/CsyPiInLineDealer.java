package com.kaifantech.component.service.pi.ctrl.work;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.kaifantech.component.service.tasksite.TaskSiteInfoService;
import com.kaifantech.component.service.tasksite.TaskSitePathService;
import com.kaifantech.util.agv.msg.PreventImpactCommand;
import com.ytgrading.util.AppTool;

@Component
public class CsyPiInLineDealer {
	@Autowired
	private TaskSiteInfoService taskSiteInfoService;

	@Autowired
	private TaskSitePathService taskSitePathService;

	@Autowired
	private CsyPiInfoService csyPiInfoService;

	public PreventImpactCommand doCheck2Agvs(TaskexeBean piOne, TaskexeBean piAnother) throws Exception {
		PreventImpactCommand command = new PreventImpactCommand();
		TaskSiteInfoBean siteOne = taskSiteInfoService.getBean(piOne.msg.currentSite());
		TaskSiteInfoBean siteAnother = taskSiteInfoService.getBean(piAnother.msg.currentSite());

		TaskexeBean piSmall = piOne.msg.currentSite() < piAnother.msg.currentSite() ? piOne : piAnother;
		TaskexeBean piBig = piOne.msg.currentSite() >= piAnother.msg.currentSite() ? piOne : piAnother;

		int interalNum = 3;
		if (siteOne.isAllocSite()) {
			interalNum = 8;
		}
		List<TaskSiteInfoBean> path = null;

		if (AppTool.equals(piSmall.msg.currentSite(), 65, 66, 67)) {
			if ((piBig.msg.currentSite() > 473 && piBig.msg.currentSite() <= 478)
					|| (piBig.msg.currentSite() > 85 && piBig.msg.currentSite() <= 93)) {
				interalNum = 6;
				TaskexeBean temp = piSmall;
				piSmall = piBig;
				piBig = temp;
			}
			path = taskSitePathService.getPath(piSmall.msg.currentSite(), piBig.msg.currentSite());
		}
		if (AppTool.equals(piBig.msg.currentSite(), 65, 66, 67)) {
			if (piSmall.msg.currentSite() > 56 && piSmall.msg.currentSite() <= 64) {
				interalNum = 6;
			}
			path = taskSitePathService.getPath(piSmall.msg.currentSite(), piBig.msg.currentSite());
		}

		if ((siteOne.isOutOrWindowSite() && siteAnother.isOutOrWindowSite())
				|| (siteOne.isBackSite() && siteAnother.isBackSite()) || (siteOne.isAllocSite()
						&& siteAnother.isAllocSite() && siteOne.getLine().equals(siteAnother.getLine()))) {
			if (csyPiInfoService.isWindow1And2(piSmall, piBig)) {
				command.safe(piSmall.getAgvId());
				command.setPiInfo(piSmall.getAgvId() + "," + piBig.getAgvId() + "两车在窗口1-2同时放货，不做交通管制！");
				return command;
			}
			path = taskSitePathService.getPath(piSmall.msg.currentSite(), piBig.msg.currentSite());
		}

		if (!AppTool.isNull(path) && path.size() <= interalNum) {
			command.dangerous(piSmall.getAgvId());
			command.safe(piBig.getAgvId());
			command.setPiInfo(piSmall.getAgvId() + "," + piBig.getAgvId() + "两车距离过近，停后车：" + piSmall.getAgvId());
			return command;
		}

		if (siteOne.isOutOrWindowSite() && siteAnother.isAllocSite()) {
			return isTooClose(piOne, piAnother, siteOne, siteAnother);
		} else if (siteAnother.isOutOrWindowSite() && siteOne.isAllocSite()) {
			return isTooClose(piAnother, piOne, siteAnother, siteOne);
		}
		return null;
	}

	public PreventImpactCommand isTooClose(TaskexeBean piOne, TaskexeBean piAnother, TaskSiteInfoBean siteOne,
			TaskSiteInfoBean siteAnother) throws Exception {
		PreventImpactCommand command = new PreventImpactCommand();
		if (piOne.nextStopSite.isAllocSite() && piOne.nextStopSite.getLine().equals(siteAnother.getLine())) {
			List<TaskSiteInfoBean> path = taskSitePathService.getPath(piOne.msg.currentSite(),
					piAnother.msg.currentSite());
			if (!AppTool.isNull(path) && path.size() <= 6) {
				command.dangerous(piOne.getAgvId());
				command.safe(piAnother.getAgvId());
				command.setPiInfo(piOne.getAgvId() + "," + piAnother.getAgvId() + "两车停车距离过近，停后车：" + piOne.getAgvId());
				return command;
			}
		}
		return null;
	}
}
