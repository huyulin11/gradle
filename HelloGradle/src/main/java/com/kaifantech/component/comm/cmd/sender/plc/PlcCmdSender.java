package com.kaifantech.component.comm.cmd.sender.plc;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.component.comm.worker.client.dev.CsyPlcWorker;
import com.kaifantech.component.log.AgvStatusDBLogger;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.socket.netty.client.csy.CsyPlcNettyClient;
import com.ytgrading.util.msg.AppMsg;

@Service
public class PlcCmdSender {
	@Autowired
	private AgvStatusDBLogger kaifantechDBLogger;

	@Inject
	private CsyPlcWorker csyPlcWorker;

	public AppMsg send(Integer agvId, String cmd) {
		String finalCmd = cmd;
		AppMsg appMsg = csyPlcWorker.get(agvId).sendMsg(finalCmd);
		if (appMsg.isSuccess()) {
			String msg = "向" + agvId + "号AGV的PLC下达命令: " + cmd;
			AppFileLogger.connectInfo(msg);
			kaifantechDBLogger.warning(msg, agvId, AgvStatusDBLogger.MSG_LEVEL_WARNING);
		}
		return appMsg;
	}

	public List<String> getList(Integer agvId) {
		CsyPlcNettyClient client = (CsyPlcNettyClient) csyPlcWorker.get(agvId);
		return client.getList();
	}
}
