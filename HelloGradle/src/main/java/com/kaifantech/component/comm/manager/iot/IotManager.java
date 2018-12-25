package com.kaifantech.component.comm.manager.iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.cache.manager.ISingleCacheWorkerGetter;
import com.kaifantech.component.comm.manager.charge.ChargeManager;
import com.kaifantech.component.comm.manager.plc.PlcManager;
import com.ytgrading.util.msg.AppMsg;

@Service
public class IotManager implements ISingleCacheWorkerGetter {
	@Autowired
	private PlcManager plcManager;
	@Autowired
	private ChargeManager chargeManager;

	public AppMsg startCharge(Integer agvId, Integer chargeid) throws Exception {
		plcManager.readyForCharge(agvId);
		chargeManager.start(chargeid);
		return AppMsg.success();
	}

	public AppMsg stopCharge(Integer agvId, Integer chargeid) throws Exception {
		chargeManager.stop(chargeid);
		plcManager.forbidAct(agvId);
		return AppMsg.success();
	}
}
