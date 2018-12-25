package com.kaifantech.component.dao.agv.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvSiteStatus;
import com.kaifantech.component.business.ctrl.deal.ICtrlDealModule;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;

@Service
public class AgvOpWmsDao extends AgvInfoDao {

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_CTRL_DEALER_MODULE)
	private ICtrlDealModule ctrlModule;

	public void command(Integer agvId, String taskType) {
		update(agvId, " taskstatus='" + taskType + "'", AND + " sitestatus='" + AgvSiteStatus.INIT + "'",
				AND + " taskstatus='" + AgvTaskType.FREE + "'");
	}

	public void goWork(Integer agvId, String taskType, String taskid) {
		update(agvId, " sitestatus='" + AgvSiteStatus.MOVING + "'", " taskid='" + taskid + "'",
				AND + " sitestatus='" + AgvSiteStatus.INIT + "'", AND + " taskstatus='" + taskType + "'");
		ctrlModule.startup(agvId);
	}

	public void reachAlloc(Integer agvId, String taskType) {
		update(agvId, " sitestatus='" + AgvSiteStatus.alloc(taskType) + "'",
				AND + " sitestatus='" + AgvSiteStatus.MOVING + "'", AND + " taskstatus='" + taskType + "'");
	}

	public void workDoneAlloc(Integer agvId, String taskType) {
		update(agvId, " sitestatus='" + AgvSiteStatus.MOVING + "'",
				AND + " sitestatus='" + AgvSiteStatus.alloc(taskType) + "'", AND + " taskstatus='" + taskType + "'");
		ctrlModule.startup(agvId);
	}

	public void reachWindow(Integer agvId, String taskType) {
		update(agvId, " sitestatus='" + AgvSiteStatus.window(taskType) + "'",
				AND + " sitestatus='" + AgvSiteStatus.MOVING + "'", AND + " taskstatus='" + taskType + "'");
	}

	public void workDoneWindow(Integer agvId, String taskType) {
		update(agvId, " sitestatus='" + AgvSiteStatus.MOVING + "'",
				AND + " sitestatus='" + AgvSiteStatus.window(taskType) + "'", AND + " taskstatus='" + taskType + "'");
		ctrlModule.startup(agvId);
	}

	public void workOver(Integer agvId, String taskType) {
		update(agvId, " sitestatus='" + AgvSiteStatus.INIT + "'", " taskstatus='" + AgvTaskType.FREE + "'",
				" taskid=''", AND + " sitestatus='" + AgvSiteStatus.MOVING + "'",
				AND + " taskstatus='" + taskType + "'");
	}
}
