package com.kaifantech.component.service.pi.ctrl.work;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.kaifantech.component.service.taskexe.detail.TaskexeDetailInfoService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.component.service.tasksite.TaskSiteInfoService;
import com.kaifantech.util.constant.taskexe.ArrivedAct;
import com.kaifantech.util.constants.cmd.AgvCmdConstant;
import com.kaifantech.util.msg.agv.AgvMsgGetter;
import com.ytgrading.util.AppTool;

@Component
public class CsyPiInfoService {
	@Autowired
	private TaskSiteInfoService taskSiteInfoService;

	@Autowired
	private TaskexeInfoService taskexeInfoService;

	@Autowired
	private TaskexeDetailInfoService taskexeDetailService;

	private Map<Integer, TaskexeBean> cache = new HashMap<>();

	public TaskexeBean getCache(Integer agvId) throws Exception {
		return cache.get(agvId);
	}

	public TaskexeBean get(Integer agvId) throws Exception {
		TaskexeBean taskexeBean = taskexeInfoService.getNextOne(agvId);
		if (taskexeBean == null) {
			return null;
		}
		List<TaskexeDetailBean> taskexeDetailList = taskexeDetailService.find(taskexeBean);
		if (AppTool.isNull(taskexeDetailList)) {
			return null;
		}
		return get(taskexeBean, taskexeDetailList);
	}

	public TaskexeBean get(TaskexeBean taskexeBean, List<TaskexeDetailBean> list) {
		TaskexeBean obj = taskexeBean.get(list);
		CsyAgvMsgBean csyAgvMsgBean = AgvMsgGetter.one().getAgvMsgBean(taskexeBean.getAgvId());
		if (AppTool.isNull(csyAgvMsgBean) || !csyAgvMsgBean.isValid()) {
			return null;
		}
		if (AppTool.isNull(list) || list.size() == 0) {
			return null;
		}
		obj.msg = csyAgvMsgBean;

		for (TaskexeDetailBean thisDetail : list) {
			TaskSiteInfoBean thisSite = taskSiteInfoService.getBean(thisDetail);
			if (thisDetail.isOver()) {
				obj.currentDetail = thisDetail;
				obj.currentSite = taskSiteInfoService.getBean(obj.currentDetail);
				continue;
			}
			if (thisDetail.isSend()) {
				obj.currentDetail = thisDetail;
				obj.currentSite = taskSiteInfoService.getBean(obj.currentDetail);
			}

			if (AppTool.isNull(obj.currentDetail)) {
				return null;
			}

			if (!thisDetail.isOver() && AppTool.isNull(obj.nextCornerDetail)) {
				if (obj.currentSite.isOutOrWindowSite() && !thisSite.isOutOrWindowSite()) {
					obj.nextCornerDetail = thisDetail;
					obj.nextCornerSite = taskSiteInfoService.getBean(obj.nextCornerDetail);
				}
			}
			if (!thisDetail.isOver() && AppTool.isNull(obj.nextDetail)) {
				if (TaskexeDetailBean.getDistanceOf(obj.currentDetail,
						thisDetail) >= (obj.currentSite.isOutOrWindowSite()
								? AgvCmdConstant.DISTANCE_JUDGE_CORNER_OUT_2_ALLOC
								: AgvCmdConstant.DISTANCE_JUDGE_CORNER_ALLOC_2_OUT)) {
					obj.nextDetail = thisDetail;
					obj.nextSite = taskSiteInfoService.getBean(obj.nextDetail);
				}
			}
			if (!thisDetail.isOver() && AppTool.isNull(obj.nextStopDetail)
					&& ArrivedAct.isStopAct(thisDetail.getArrivedact())) {
				obj.nextStopDetail = thisDetail;
				obj.nextStopSite = taskSiteInfoService.getBean(obj.nextStopDetail);
			}
		}
		cache.put(obj.getAgvId(), obj);
		return obj;
	}

	public boolean isWindow1And2(TaskexeBean piSmall, TaskexeBean piBig) {
		if (AppTool.equals(piBig.msg.currentSite(), 31)) {
			if (AppTool.equals(piSmall.msg.currentSite(), 28) && piSmall.nextCornerSite.isAllocSite()
					&& AppTool.equals(piSmall.nextCornerSite.getLine(), 7)) {
				return true;
			}
			if (piSmall.msg.currentSite() < 28 && piSmall.nextStopSite.isWindowSite()) {
				return true;
			}
		}
		return false;
	}
}
