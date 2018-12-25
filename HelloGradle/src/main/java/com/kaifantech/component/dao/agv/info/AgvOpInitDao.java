package com.kaifantech.component.dao.agv.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvSiteStatus;
import com.kaifantech.component.business.ctrl.deal.ICtrlDealModule;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;

@Service
public class AgvOpInitDao extends AgvInfoDao {

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_CTRL_DEALER_MODULE)
	private ICtrlDealModule ctrlModule;

	public void commandToInit(Integer agvId) {
		update(agvId, " taskstatus='" + AgvTaskType.GOTO_INIT + "'", " taskid=''",
				AND + " sitestatus='" + AgvSiteStatus.INIT + "'", AND + " taskstatus='" + AgvTaskType.FREE + "'");
	}

	public void goWorkToInit(Integer agvId, String taskid) {
		update(agvId, " sitestatus='" + AgvSiteStatus.MOVING + "'", " taskid='" + taskid + "'",
				AND + " sitestatus='" + AgvSiteStatus.INIT + "'", AND + " taskstatus='" + AgvTaskType.GOTO_INIT + "'");
		ctrlModule.startup(agvId);
	}

	public void workOverToInit(Integer agvId) {
		update(agvId, " sitestatus='" + AgvSiteStatus.INIT + "'", " taskstatus='" + AgvTaskType.FREE + "'",
				" taskid=''", AND + " sitestatus='" + AgvSiteStatus.MOVING + "'",
				AND + " taskstatus='" + AgvTaskType.GOTO_INIT + "'");
	}

}
