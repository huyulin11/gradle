package com.kaifantech.component.service.taskexe.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.singletask.SingletaskBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.component.service.alloc.check.IAllocCheckService;
import com.kaifantech.component.service.alloc.info.IAllocInfoService;
import com.kaifantech.component.service.alloc.status.IAllocStatusMgrService;
import com.kaifantech.component.service.singletask.info.SingleTaskInfoService;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.init.sys.qualifier.WmsSystemQualifier;
import com.ytgrading.util.msg.AppMsg;

@Service(WmsSystemQualifier.TASKEXE_CHECK_SERVICE)
public class WmsTaskexeCheckService extends AcsTaskexeCheckService {
	@Autowired
	private IAllocInfoService allocInfoService;

	@Autowired
	private IAllocStatusMgrService allocService;

	@Autowired
	private SingleTaskInfoService singleTaskInfoService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_ALLOC_CHECK_SERVICE)
	private IAllocCheckService allocCheckService;

	public AppMsg checkAllocBeforeAddTask(TaskexeBean taskexeBean, Integer agvId) {
		SingletaskBean singletaskBean = singleTaskInfoService.getSingletaskBy(taskexeBean.getAllocid(), agvId,
				taskexeBean.getLapId());
		if (singletaskBean == null) {
			return new AppMsg(-1, "未获取到对应基础任务信息！");
		}
		AppMsg msg = allocCheckService.checkBeforeAddTask(singletaskBean, agvId);
		if (msg.getCode() >= 0) {
			AllocItemInfoBean allocItem = allocInfoService.getByTaskid(taskexeBean.getTaskid());
			allocService.lockTheAllocation(allocItem, taskexeBean.getSkuId(), singletaskBean.getAllocOpType());
		}
		return msg;
	}
}
