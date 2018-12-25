package com.kaifantech.component.comm.manager.charge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.component.comm.cmd.sender.charge.ChargeCmdSender;
import com.kaifantech.util.constants.cmd.ChargeCmdConstant;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.log.CsyAppFileLogger;
import com.kaifantech.util.msg.charge.ChargeMsgGetter;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.msg.AppMsg;

@Service
public class ChargeManager {
	@Autowired
	private ChargeCmdSender chargeCmdSender;

	public AppMsg sendNeedRtn(Integer chargeid, String cmd) {
		int times = 0;
		AppMsg chargeMsg = AppMsg.fail();
		int checkAfterSeconds = 5;
		int targetStatus = ChargeCmdConstant.CMD_START.equals(cmd) ? 1 : 0;
		while (true) {
			chargeMsg = chargeCmdSender.send(chargeid, cmd);
			String taskInfo = (ChargeCmdConstant.CMD_START.equals(cmd) ? "供电" : "关闭");
			taskInfo = "向" + (chargeid - 12) + "号充电站下达" + taskInfo + "指令！";
			AppFileLogger.warning(taskInfo + "" + checkAfterSeconds + "秒后确定是否正确收到反馈！");
			ThreadTool.sleep(checkAfterSeconds * 1000);
			if (chargeMsg.isSuccess() && getChargeStatus(chargeid).getCode().equals(targetStatus)) {
				break;
			} else {
				CsyAppFileLogger.error(taskInfo + "失败，未收到反馈，稍后重试！" + "，重试次数：" + times++);
				ThreadTool.sleep(5 * 1000);
			}
		}
		return AppMsg.success();
	}

	public AppMsg start(Integer chargeid) {
		return sendNeedRtn(chargeid, ChargeCmdConstant.CMD_START);
	}

	public AppMsg stop(Integer chargeid) {
		return sendNeedRtn(chargeid, ChargeCmdConstant.CMD_STOP);
	}

	public AppMsg justStart(Integer chargeid) {
		AppMsg appMsg = chargeCmdSender.send(chargeid, ChargeCmdConstant.CMD_START);
		return appMsg;
	}

	public AppMsg justStop(Integer chargeid) {
		AppMsg appMsg = chargeCmdSender.send(chargeid, ChargeCmdConstant.CMD_STOP);
		return appMsg;
	}

	public AppMsg getChargeStatus(Integer chargeid) {
		return ChargeMsgGetter.one().getChargeStatus(chargeid);
	}
}
