package com.kaifantech.component.service.taskexe.status;

import org.springframework.stereotype.Service;

/***
 * 描述任务从用户下达到发送AGV执行前的逻辑
 ***/
@Service
public interface ITaskexeStatusService {
	public int changeStatusWhenOver(String taskid);

	public int changeStatusWhenNew(String taskid);
}
