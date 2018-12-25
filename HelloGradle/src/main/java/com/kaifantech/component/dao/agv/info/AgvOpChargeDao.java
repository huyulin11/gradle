package com.kaifantech.component.dao.agv.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvSiteStatus;
import com.kaifantech.component.business.ctrl.deal.ICtrlDealModule;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;

@Service
public class AgvOpChargeDao extends AgvInfoDao {

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_CTRL_DEALER_MODULE)
	private ICtrlDealModule ctrlModule;

	public void commandToCharge(Integer agvId) {
		update(agvId, " taskstatus='" + AgvTaskType.GOTO_CHARGE + "'", " chargeId='" + 0 + "'", " taskid=''",
				AND + " sitestatus='" + AgvSiteStatus.INIT + "'", AND + " taskstatus='" + AgvTaskType.FREE + "'");
	}

	public void commandBackCharge(Integer agvId) {
		update(agvId, " taskstatus='" + AgvTaskType.BACK_CHARGE + "'",
				AND + " sitestatus='" + AgvSiteStatus.CHARGING + "'",
				AND + " taskstatus='" + AgvTaskType.GOTO_CHARGE + "'");
	}

	public void commandChangeCharge(Integer agvId) {
		update(agvId, " taskstatus='" + AgvTaskType.CHANGE_CHARGE + "'",
				AND + " sitestatus='" + AgvSiteStatus.CHARGING + "'",
				AND + " taskstatus='" + AgvTaskType.GOTO_CHARGE + "'");
	}

	public void goWorkToCharge(Integer agvId, Integer chargeId, String taskid) {
		update(agvId, " sitestatus='" + AgvSiteStatus.MOVING + "'", " chargeId='" + chargeId + "'",
				" taskid='" + taskid + "'", AND + " sitestatus='" + AgvSiteStatus.INIT + "'",
				AND + " taskstatus='" + AgvTaskType.GOTO_CHARGE + "'");
		ctrlModule.startup(agvId);
	}

	public void goWorkBackCharge(Integer agvId, String taskid) {
		update(agvId, " sitestatus='" + AgvSiteStatus.MOVING + "'", " taskid='" + taskid + "'",
				AND + " sitestatus='" + AgvSiteStatus.CHARGING + "'",
				AND + " taskstatus='" + AgvTaskType.BACK_CHARGE + "'");
		ctrlModule.startup(agvId);
	}

	public void goWorkChangeCharge(Integer agvId, String taskid, Integer chargeId) {
		update(agvId, " sitestatus='" + AgvSiteStatus.MOVING + "'", " taskid='" + taskid + "'",
				" chargeId='" + chargeId + "'", AND + " sitestatus='" + AgvSiteStatus.CHARGING + "'",
				AND + " taskstatus='" + AgvTaskType.GOTO_CHARGE + "'");
		ctrlModule.startup(agvId);
	}

	public void workOverGotoCharge(Integer agvId) {
		update(agvId, " sitestatus='" + AgvSiteStatus.CHARGING + "'", " taskid=''",
				AND + " sitestatus='" + AgvSiteStatus.MOVING + "'",
				AND + " taskstatus='" + AgvTaskType.GOTO_CHARGE + "'");
	}

	public void workOverBackCharge(Integer agvId) {
		update(agvId, " taskstatus='" + AgvTaskType.FREE + "'", " sitestatus='" + AgvSiteStatus.INIT + "'",
				" chargeId='" + 0 + "'", " taskid=''", AND + " sitestatus='" + AgvSiteStatus.MOVING + "'",
				AND + " taskstatus='" + AgvTaskType.BACK_CHARGE + "'");
	}
}
