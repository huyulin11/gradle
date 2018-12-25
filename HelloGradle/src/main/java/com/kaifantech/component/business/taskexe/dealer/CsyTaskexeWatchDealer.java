package com.kaifantech.component.business.taskexe.dealer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.component.business.taskexe.detail.dealer.CsyTaskexeDetailDealer;
import com.kaifantech.component.dao.agv.info.AgvOpWmsDao;
import com.kaifantech.component.dao.taskexe.op.TaskexeOpDao;
import com.kaifantech.component.service.paper.base.WmsPaperService;
import com.kaifantech.mappings.taskexe.TaskexeDetailMapper;
import com.kaifantech.util.constant.taskexe.ArrivedAct;
import com.kaifantech.util.constant.taskexe.WmsDetailOpFlag;
import com.kaifantech.util.constants.Delflag;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.log.CsyAppFileLogger;
import com.kaifantech.util.msg.agv.AgvMsgGetter;
import com.ytgrading.util.AppTool;

@Service
public class CsyTaskexeWatchDealer {
	@Autowired
	private CsyTaskexeDetailDealer taskexeDetailDealer;

	@Autowired
	protected WmsPaperService wmsPaperService;

	@Autowired
	protected TaskexeOpDao taskexeTaskDao;

	@Autowired
	private CsyTaskexeCacheDealer taskexeCacheDealer;

	@Autowired
	private TaskexeDetailMapper taskexeDetailMapper;

	@Autowired
	private AgvOpWmsDao agvOpWmsDao;

	private Map<Integer, TaskexeDetailBean> nextTaskexeDetailMap = new HashMap<>();

	public void watchSingleSite(TaskexeBean taskexeBean, List<TaskexeDetailBean> taskexeDetailList) {
		taskexeCacheDealer.startCache(taskexeBean.getAgvId());
		CsyAgvMsgBean csyAgvMsgBean = AgvMsgGetter.one().getAgvMsgBean(taskexeBean.getAgvId());
		if (AppTool.isNull(csyAgvMsgBean) || !csyAgvMsgBean.isValid()) {
			return;
		}
		int finishedTaskexeDetailsNum = 0;
		TaskexeDetailBean nextTaskexeDetail = null;
		for (TaskexeDetailBean taskexeDetail : taskexeDetailList) {
			if (Delflag.DELETED.equals(taskexeDetail.getDelflag())) {
				continue;
			}
			if (taskexeDetail.isOver()) {
				finishedTaskexeDetailsNum++;
				continue;
			}
			if (!taskexeDetail.isOver()) {
				if (AppTool.isNull(nextTaskexeDetail)) {
					nextTaskexeDetail = taskexeDetail;
				}
			}

			if (!taskexeDetail.matchRelevantSite(csyAgvMsgBean)) {
				agvOpWmsDao.pauseErr(csyAgvMsgBean.agvId());
				CsyAppFileLogger.error(csyAgvMsgBean.agvId() + "号AGV未按照正常的路径形式，可能发生脱轨故障，系统将其停车，等待人工干预，将其手动拖到轨迹上！");
				return;
			} else {
				agvOpWmsDao.startupFromErr(csyAgvMsgBean.agvId());
			}
			try {
				if (!taskexeDetailDealer.dealDetail(taskexeBean, csyAgvMsgBean, taskexeDetail)) {
					return;
				}
			} catch (Exception e) {
				AppFileLogger.error("解析任务时出现异常：" + e.getMessage());
			}
		}

		if (!AppTool.isNull(nextTaskexeDetail)) {
			nextTaskexeDetailMap.put(taskexeBean.getAgvId(), nextTaskexeDetail);
		}

		if (finishedTaskexeDetailsNum == taskexeDetailList.size()) {
			System.out.println(taskexeBean.getAgvId() + "号AGV执行的" + taskexeBean.getTaskid() + "-"
					+ taskexeBean.getTasksequence() + "任务所有明细任务均已执行完毕，更新任务状态为OVER！");
			agvOpWmsDao.workOver(taskexeBean.getAgvId(), taskexeBean.getTasktype());
			taskexeTaskDao.overASendTask(taskexeBean);
		}
	}

	public void watchPassedSite(TaskexeBean taskexeBean, List<TaskexeDetailBean> taskexeDetailList) {
		CsyAgvMsgBean csyAgvMsgBean = AgvMsgGetter.one().getAgvMsgBean(taskexeBean.getAgvId());
		if (!csyAgvMsgBean.isValid()) {
			return;
		}
		boolean gotTheSite = false;
		List<TaskexeDetailBean> passedList = new ArrayList<>();
		Integer currentSite = csyAgvMsgBean.currentSite();
		for (TaskexeDetailBean taskexeDetail : taskexeDetailList) {
			if (Delflag.DELETED.equals(taskexeDetail.getDelflag())) {
				continue;
			}
			if (taskexeDetail.isOver()) {
				continue;
			}
			if (ArrivedAct.noContinueAct(taskexeDetail.getArrivedact())) {
				passedList.add(taskexeDetail);
				if (currentSite.equals(taskexeDetail.getSiteid())) {
					gotTheSite = true;
					break;
				}
			} else {
				if (currentSite.equals(taskexeDetail.getSiteid())) {
					gotTheSite = true;
					break;
				} else {
					return;
				}
			}
		}

		if (!gotTheSite) {
			return;
		}

		for (TaskexeDetailBean passed : passedList) {
			taskexeDetailMapper.updateOpflag(passed.setOpflag(WmsDetailOpFlag.OVER));
		}
		return;
	}

	public TaskexeDetailBean getNextTaskexeDetailMap(Integer agvId) {
		return nextTaskexeDetailMap.get(agvId);
	}
}
