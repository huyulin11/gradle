package com.kaifantech.component.service.status.iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.component.dao.ControlInfoDao;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.dao.agv.info.AgvOpInitDao;
import com.kaifantech.component.dao.taskexe.op.TaskexeOpDao;
import com.kaifantech.component.service.paper.base.WmsPaperService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.TaskexeOpFlag;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvSiteStatus;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Component
public class AgvToInitDealer {
	@Autowired
	private TaskexeInfoService taskexeInfoService;

	@Autowired
	protected WmsPaperService wmsPaperService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	@Autowired
	private AgvOpInitDao agvOpInitDao;

	@Autowired
	private TaskexeOpDao taskexeTaskDao;

	@Autowired
	private ControlInfoDao controlInfoDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public synchronized AppMsg newTask(AgvBean targetAgv, String taskType) {
		if (AppTool.ifAnd(!(AgvSiteStatus.INIT.equals(targetAgv.getSitestatus())
				&& AgvTaskType.GOTO_INIT.equals(targetAgv.getTaskstatus())))) {
			return new AppMsg(-1, "下达返回初始位置任务到" + targetAgv.getId() + "号AGV出现异常：" + "任务参数有问题：" + taskType);
		}
		try {
			String taskid = getSid();
			if (AgvTaskType.GOTO_INIT.equals(taskType)) {
				taskexeTaskDao.addATask(taskid, targetAgv.getId(), 0, AgvTaskType.GOTO_INIT, 2);
				agvOpInitDao.goWorkToInit(targetAgv.getId(), taskid);
				return new AppMsg(0, "下达回归初始站点任务，将" + targetAgv.getId() + "号AGV" + "调度到初始站点！");
			}
			return new AppMsg(0, targetAgv.getId() + "号AGV" + "充电任务新增成功！");
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
				if (AgvTaskType.GOTO_INIT.equals(taskexeBean.getTasktype())) {
					agvOpInitDao.workOverToInit(tmBean.getId());
					return new AppMsg(0, "任务结束，将" + tmBean.getId() + "号AGV信息更新到初始状态！");
				}
			}
			return new AppMsg(0, "");
		} catch (Exception e) {
			e.printStackTrace();
			return new AppMsg(-1, "出现异常：" + e.getMessage());
		}
	}

	private String getSid() {
		String paperid = controlInfoDao.getPrefixByType("AGV_TOINIT_SID")
				+ String.format("%08d", controlInfoDao.getNextValueByType("AGV_TOINIT_SID"));
		return paperid;
	}

}
