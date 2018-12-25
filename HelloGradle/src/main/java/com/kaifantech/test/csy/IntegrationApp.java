package com.kaifantech.test.csy;

import com.kaifantech.bean.msg.csy.agv.CsyAgvCmdBean;
import com.kaifantech.util.constants.cmd.AgvCmdConstant;
import com.kaifantech.util.thread.ThreadTool;

public class IntegrationApp extends IotTestApp {
	static {
		getAgv();
		// getPlc();
		// getWindowPlc();
		// getCharge();

		getAgv().sendMsg(CsyAgvCmdBean.getTaskCmd(getAgv().getAgvId(), AgvCmdConstant.CMD_TASK_CLEAR_ALL_CACHE));

		// 通用查询指令
		ThreadTool.run(() -> {
			while (true) {
				getAgv().sendMsg(CsyAgvCmdBean.getTaskCmd(getAgv().getAgvId(), AgvCmdConstant.CMD_GENERAL_SEARCH));
				ThreadTool.sleep(1000);
			}
		});
	}

	public static void main(String[] args) {

		getAgv().sendMsg(CsyAgvCmdBean.getTaskCmd(getAgv().getAgvId(), AgvCmdConstant.CMD_STOP));

		ThreadTool.run(() -> {
			while (true) {
				System.out.println(getAgv().getMsg());
				ThreadTool.sleep(1000);
			}
		});

	}

	public static void main3(String[] args) {
		System.out.println(Integer.toHexString(0x22));
	}
}