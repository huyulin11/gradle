package com.kaifantech.component.comm.cmd.sender.charge;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.component.comm.worker.client.dev.CsyChargeWorker;
import com.kaifantech.component.log.AgvStatusDBLogger;
import com.kaifantech.util.log.AppFileLogger;
import com.ytgrading.util.msg.AppMsg;

@Service
public class ChargeCmdSender  {
	@Autowired
	private AgvStatusDBLogger kaifantechDBLogger;

	@Inject
	private CsyChargeWorker commMgr;

	public AppMsg send(Integer chargeid, String cmd) {
		String finalCmd = cmd;
		AppMsg appMsg = commMgr.get(chargeid).sendMsg(finalCmd);
		if (appMsg.isSuccess()) {
			String msg = "向充电站下达命令: " + cmd;
			AppFileLogger.connectInfo(msg);
			kaifantechDBLogger.warning(msg, 1, AgvStatusDBLogger.MSG_LEVEL_WARNING);
		}
		return appMsg;
	}
}
