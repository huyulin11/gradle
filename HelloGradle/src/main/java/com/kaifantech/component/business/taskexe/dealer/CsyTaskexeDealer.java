package com.kaifantech.component.business.taskexe.dealer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.component.dao.taskexe.op.TaskexeOpDao;
import com.kaifantech.component.service.paper.base.WmsPaperService;
import com.kaifantech.component.service.pi.ctrl.work.CsyPiSpeedDealer;
import com.kaifantech.component.service.taskexe.detail.TaskexeDetailInfoService;
import com.kaifantech.util.constant.taskexe.TaskexeOpFlag;
import com.kaifantech.util.msg.agv.AgvMsgGetter;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

@Service
public class CsyTaskexeDealer {
	@Autowired
	private TaskexeDetailInfoService taskexeDetailService;

	@Autowired
	protected WmsPaperService wmsPaperService;

	@Autowired
	protected TaskexeOpDao taskexeTaskDao;

	@Autowired
	private CsyTaskexeCacheDealer taskexeCacheDealer;

	@Autowired
	private CsyTaskexeWatchDealer taskexeWatchDealer;

	@Autowired
	private CsyPiSpeedDealer taskexeSpeedDealer;

	public void dealTaskexe(TaskexeBean taskexeBean) throws Exception {
		List<TaskexeDetailBean> taskexeDetailList = taskexeDetailService.getList(taskexeBean);
		if (AppTool.isNull(taskexeDetailList)) {
			return;
		}
		if (TaskexeOpFlag.NEW.equals(taskexeBean.getOpflag())) {
			startWork(taskexeBean.getAgvId(), taskexeBean, taskexeDetailList);
			return;
		}
		if (TaskexeOpFlag.SEND.equals(taskexeBean.getOpflag())) {
			CsyAgvMsgBean csyAgvMsgBean = AgvMsgGetter.one().getAgvMsgBean(taskexeBean.getAgvId());
			if (AppTool.isNull(csyAgvMsgBean) || !csyAgvMsgBean.isValid()) {
				return;
			}
			taskexeSpeedDealer.watchSpeed(taskexeBean, taskexeDetailList);
			taskexeWatchDealer.watchPassedSite(taskexeBean, taskexeDetailList);
			taskexeWatchDealer.watchSingleSite(taskexeBean, taskexeDetailList);
		}
	}

	/**
	 * TODO 当有取货、放货、盘点等任务时，在车停下并且速度为零的时候， 向对应的硬件指派任务，收到任务执行结束的信号后，
	 * 将当前任务的状态置为OVER，并在后后续任务的前提下， 启动AGV去执行下一任务！
	 */

	private void startWork(Integer agvId, TaskexeBean taskexeBean, List<TaskexeDetailBean> taskexeDetailList) {
		taskexeCacheDealer.cacheClear(agvId);
		taskexeCacheDealer.startCache(taskexeBean.getAgvId());
		ThreadTool.sleep(5000);
		taskexeTaskDao.sendATask(taskexeBean);
	}

}
