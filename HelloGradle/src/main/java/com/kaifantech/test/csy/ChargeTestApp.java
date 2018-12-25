package com.kaifantech.test.csy;

import com.kaifantech.util.constants.cmd.ChargeCmdConstant;
import com.kaifantech.util.thread.ThreadTool;

public class ChargeTestApp extends IotTestApp {

	public static void main(String[] args) {
		ThreadTool.run(() -> {
			ThreadTool.sleep(1000);
		});

		ThreadTool.run(() -> {
			while (true) {
				String cmd = ChargeCmdConstant.CMD_SEARCH;// 获取模拟量信息
				getCharge().sendMsg(cmd);
				ThreadTool.sleep(1000);
				System.out.println(getCharge().getMsg());
			}
		});
	}

	public static void main3(String[] args) {
		System.out.println(Integer.toHexString(0x22));
	}
}