package com.kaifantech.component.service.alloc.check;

import com.kaifantech.bean.singletask.SingletaskBean;
import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperDetailBean;
import com.kaifantech.bean.wms.paper.base.WmsPaperMainBean;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

public interface IAllocCheckService {

	AppMsg checkLatestTaskexe(Integer agvId);

	default <TD extends WmsPaperDetailBean, TM extends WmsPaperMainBean<TD>> AppMsg checkAlloc(TM obj,
			Integer agvId) {
		return null;
	}

	default AppMsg checkBeforeAddTask(Object obj, Integer agvId) {
		AppMsg msg;

		SingletaskBean singletaskBean = (SingletaskBean) obj;
		if (!AgvTaskType.ZUHE_RENWU.equals(singletaskBean.getAllocOpType())) {
			msg = checkLatestTaskexe(agvId);
			if (msg.getCode() < 0) {
				return msg;
			}
		} else {
			msg = checkTaskGroup(singletaskBean);
			if (msg.getCode() < 0) {
				return msg;
			}
		}

		if (AppTool.isNull(singletaskBean)) {
			return new AppMsg(-1, "无法找到对应的任务类型！");
		}
		return checkTaskinfo(singletaskBean);
	}

	AppMsg checkTaskGroup(SingletaskBean singletaskBean);

	AppMsg checkTaskinfo(SingletaskBean singletaskBean);

	AppMsg checkAllocInfo(AllocItemInfoBean allocationInfoBean, String taskOpType);

	AppMsg checkAllocLogic(AllocItemInfoBean allocationInfoBean, String taskOpType);
}
