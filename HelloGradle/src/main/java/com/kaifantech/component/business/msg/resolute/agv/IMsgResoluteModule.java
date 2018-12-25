package com.kaifantech.component.business.msg.resolute.agv;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.ytgrading.util.msg.AppMsg;

public interface IMsgResoluteModule {
	void resoluteMsg();

	AppMsg resoluteTaskexe(TaskexeBean latestTaskexe);
}
