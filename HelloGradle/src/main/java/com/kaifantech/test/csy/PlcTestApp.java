package com.kaifantech.test.csy;

import com.kaifantech.util.socket.netty.client.csy.CsyPlcNettyClient;
import com.kaifantech.util.thread.ThreadTool;

public class PlcTestApp extends IotTestApp {

	public static void main(String[] args) {
		// ThreadTool.run(() -> {
		// while (true) {
		// getPlc().sendMsg(SimensPlcConstant.PLC_READ_CMD);
		// ThreadTool.sleep(1000);
		// }
		// });

		ThreadTool.run(() -> {
			String cmd;
			cmd = "0001" + "0002" + "0003" + "0004" + "0005" + "0006" + "0007" + "0008" + "0009";
			CsyPlcNettyClient client = getPlc();
			client.getHeartBeat().setSendHeartBeat(false);
			client.sendMsg(cmd);
			ThreadTool.sleep(1000);
		});
	}

	public static void main3(String[] args) {
		System.out.println(Integer.toHexString(0x22));
	}
}