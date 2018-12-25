package com.kaifantech.component.comm.cmd.sender.agv;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.msg.csy.agv.CsyAgvCmdBean;
import com.kaifantech.bean.msg.csy.agv.CsyAgvCommand;
import com.kaifantech.component.comm.worker.client.agv.IAgvClientWorker;
import com.kaifantech.component.log.AgvStatusDBLogger;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constants.cmd.AgvCmdConstant;
import com.kaifantech.util.log.AppFileLogger;
import com.ytgrading.util.msg.AppMsg;

@Service
public class AgvCmdSender {
	@Autowired
	private AgvStatusDBLogger kaifantechDBLogger;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_CLIENT_WORKER)
	private IAgvClientWorker agvClientMgr;

	public AppMsg send(CsyAgvCommand association) {
		return send(association.getAgvId(), association.getCmds());
	}

	public synchronized AppMsg send(Integer agvId, String... cmds) {
		String finalCmd = CsyAgvCmdBean.getTaskCmd(agvId, cmds);
		String cmd = String.join("", cmds).toUpperCase();
		try {
			AppMsg appMsg = agvClientMgr.get(agvId).sendMsg(finalCmd);
			if (appMsg.isSuccess()) {
				sysout(agvId, cmd);
				appMsg.setCode(0);
			}
			return appMsg;
		} catch (Exception e) {
			String msg = "发送指令（" + cmd + "）失败：" + e.getMessage();
			System.out.println(msg);
			return new AppMsg(-1, msg);
		}
	}

	private Map<Integer, String> lastCmdMap = new HashMap<>();

	private void sysout(Integer agvId, String cmd) {
		if (AgvCmdConstant.CMD_GENERAL_SEARCH.equals(cmd)) {
			return;
		}
		String msg = "向" + agvId + "号AGV下达命令: " + cmd;
		if (AgvCmdConstant.isCacheCmd(cmd)) {
			AppFileLogger.siteCacheInfo(msg);
			return;
		}
		if (AgvCmdConstant.CMD_STOP.equals(cmd) || AgvCmdConstant.CMD_CONTINUE.equals(cmd)) {
			msg = msg + "-启停";
		} else if (AgvCmdConstant.CMD_OBSTACLE_CHANNEL_NORMAL.equals(cmd)) {
			msg = msg + "-切换长距离避障";
		} else if (AgvCmdConstant.CMD_OBSTACLE_CHANNEL_CORNER.equals(cmd)) {
			msg = msg + "-切换短距离避障";
		} else if (cmd.startsWith(AgvCmdConstant.CMD_SPEED)) {
			msg = msg + "-速度控制";
		}
		lastCmdMap.put(agvId, cmd);
		kaifantechDBLogger.warning(msg, agvId, AgvStatusDBLogger.MSG_LEVEL_WARNING);
	}

}
