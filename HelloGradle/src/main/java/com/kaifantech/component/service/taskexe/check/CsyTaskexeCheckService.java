package com.kaifantech.component.service.taskexe.check;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.bean.taskexe.TaskexeDetailBean;
import com.kaifantech.component.service.alloc.check.IAllocCheckService;
import com.kaifantech.component.service.paper.base.WmsPaperService;
import com.kaifantech.component.service.taskexe.detail.TaskexeDetailInfoService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.TaskexeOpFlag;
import com.ytgrading.util.msg.AppMsg;

@Service
public class CsyTaskexeCheckService extends AcsTaskexeCheckService {
	@Autowired
	private TaskexeInfoService taskInfoService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_ALLOC_CHECK_SERVICE)
	private IAllocCheckService allocCheckService;

	@Autowired
	protected WmsPaperService wmsPaperService;

	@Autowired
	private TaskexeDetailInfoService taskexeDetailService;

	public AppMsg getCheckInfo(Integer agvId) {
		TaskexeBean taskexeBean = taskInfoService.getNotOverOneF(agvId);
		if (taskexeBean != null && !TaskexeOpFlag.OVER.equals(taskexeBean.getOpflag())) {
			String msgStr = taskexeBean.getAgvId().equals(agvId) ? agvId + "号AGV尚有任务未执行完成！" : "其它agv尚有任务未执行完毕";
			AppMsg msg = new AppMsg(-1, msgStr);
			List<TaskexeDetailBean> taskexeDetailList = taskexeDetailService.find(taskexeBean);
			taskexeBean.setDetail(taskexeDetailList);
			msg.setObject(taskexeBean);
			return msg;
		}
		return new AppMsg(0, "可以下达新任务！");
	}
}
