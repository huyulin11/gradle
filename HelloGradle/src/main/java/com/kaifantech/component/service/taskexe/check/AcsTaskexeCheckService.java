package com.kaifantech.component.service.taskexe.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.init.sys.qualifier.AcsSystemQualifier;
import com.kaifantech.util.constant.taskexe.TaskexeOpFlag;
import com.ytgrading.util.msg.AppMsg;

@Service(AcsSystemQualifier.TASKEXE_CHECK_SERVICE)
public class AcsTaskexeCheckService implements ITaskexeCheckService {
	@Autowired
	private TaskexeInfoService taskInfoService;

	public AppMsg getCheckInfo(Integer agvId) {
		TaskexeBean latestTask = taskInfoService.getNotOverOneF(agvId);
		if (latestTask != null && !TaskexeOpFlag.OVER.equals(latestTask.getOpflag())) {
			return new AppMsg(-1, latestTask.getAgvId().equals(agvId) ? agvId + "号AGV尚有任务未执行完成！" : "其它agv尚有任务未执行完毕");
		}
		return new AppMsg(0, "可以下达新任务！");
	}

}
