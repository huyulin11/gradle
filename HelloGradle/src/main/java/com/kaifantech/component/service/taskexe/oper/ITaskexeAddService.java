package com.kaifantech.component.service.taskexe.oper;

import com.ytgrading.util.msg.AppMsg;

/***
 * 描述任务从用户下达到发送AGV执行前的逻辑
 ***/
public interface ITaskexeAddService {
	public AppMsg addTask(Object obj);
}
