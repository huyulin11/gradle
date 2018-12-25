package com.kaifantech.component.service.taskexe.check;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.ytgrading.util.msg.AppMsg;

public interface ITaskexeCheckService {

	public AppMsg getCheckInfo(Integer agvId);

	default AppMsg checkAllocBeforeAddTask(TaskexeBean obj, Integer agvId) {
		return new AppMsg(0, "");
	}
}
