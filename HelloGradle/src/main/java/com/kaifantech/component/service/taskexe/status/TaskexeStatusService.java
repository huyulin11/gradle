package com.kaifantech.component.service.taskexe.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.singletask.SingletaskBean;
import com.kaifantech.component.dao.ControlInfoDao;
import com.kaifantech.component.service.singletask.info.SingleTaskInfoService;
import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.util.constant.taskexe.cangzhou.CangzhouTaskexeStep;
import com.kaifantech.util.constant.taskexe.ctrl.TaskType;
import com.kaifantech.util.constant.taskexe.ctrl.TaskType.NormalTaskType;
import com.ytgrading.util.AppTool;

/***
 * 描述任务从用户下达到发送AGV执行前的逻辑
 ***/
@Service
public class TaskexeStatusService implements ITaskexeStatusService {
	@Autowired
	private ControlInfoDao controlInfoDao;

	@Autowired
	private SingleTaskInfoService singleTaskInfoService;

	public int changeStatusWhenOver(String taskid) {
		SingletaskBean singletaskBean = singleTaskInfoService.getSingletask(taskid);
		if (NormalTaskType.NORMAL.equals(singletaskBean.getTaskType())
				|| NormalTaskType.NOTCONTROL.equals(singletaskBean.getTaskType())
				|| AppTool.isNull(singletaskBean.getTaskType())) {
			return 1;
		}

		if (SystemClient.PROJECT_NAME.equals(SystemClient.ProjectName.CANGZHOU)) {
			if (TaskType.CangzhouTaskType.SONGLIAO.equals(singletaskBean.getTaskType())) {
				return controlInfoDao.updateCurrentTaskexeStatusToV1FromV2(CangzhouTaskexeStep.SONGLIAO_OVER,
						CangzhouTaskexeStep.SONGLIAO_EXE);
			} else if (TaskType.CangzhouTaskType.SHANGLIAO.equals(singletaskBean.getTaskType())) {
				return controlInfoDao.updateCurrentTaskexeStatusToV1FromV2(CangzhouTaskexeStep.SHANGLIAO_OVER,
						CangzhouTaskexeStep.SHANGLIAO_EXE);
			} else if (TaskType.CangzhouTaskType.SONGGUANGZHOU.equals(singletaskBean.getTaskType())) {
				return controlInfoDao.updateCurrentTaskexeStatusToV1FromV2(CangzhouTaskexeStep.INIT_OR_OVER_SGZ,
						CangzhouTaskexeStep.SONGGUANGZHOU_EXE);
			}
		}

		return 0;
	}

	public int changeStatusWhenNew(String taskid) {
		SingletaskBean singletaskBean = singleTaskInfoService.getSingletask(taskid);
		if (AppTool.isNull(singletaskBean.getTaskType())) {
			return 1;
		}
		if (NormalTaskType.NOTCONTROL.equals(singletaskBean.getTaskType())) {
			return 1;
		}

		if (NormalTaskType.GOTO_CHARGE.equals(singletaskBean.getTaskType())
				|| NormalTaskType.BACK_FROM_CHARGE.equals(singletaskBean.getTaskType())) {
			return 1;
		}

		if (SystemClient.PROJECT_NAME.equals(SystemClient.ProjectName.CANGZHOU)) {
			if (NormalTaskType.NORMAL.equals(singletaskBean.getTaskType())) {
				return controlInfoDao.updateCurrentTaskexeStatusToV1FromV2(CangzhouTaskexeStep.TASK_READY,
						CangzhouTaskexeStep.INIT_OR_OVER_SGZ);
			}
			controlInfoDao.updateCurrentEnvironment(singletaskBean.getEnvironmentId());
			if (TaskType.CangzhouTaskType.SONGLIAO.equals(singletaskBean.getTaskType())) {
				return controlInfoDao.updateCurrentTaskexeStatusToV1FromV2(CangzhouTaskexeStep.SONGLIAO_EXE,
						CangzhouTaskexeStep.TASK_READY);
			} else if (TaskType.CangzhouTaskType.SHANGLIAO.equals(singletaskBean.getTaskType())) {
				return controlInfoDao.updateCurrentTaskexeStatusToV1FromV2(CangzhouTaskexeStep.SHANGLIAO_EXE,
						CangzhouTaskexeStep.SONGLIAO_OVER);
			} else if (TaskType.CangzhouTaskType.SONGGUANGZHOU.equals(singletaskBean.getTaskType())) {
				return controlInfoDao.updateCurrentTaskexeStatusToV1FromV2(CangzhouTaskexeStep.SONGGUANGZHOU_EXE,
						CangzhouTaskexeStep.SHANGLIAO_OVER);
			}
		}
		return 0;
	}

}
