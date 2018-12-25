package com.kaifantech.test.csy;

import com.kaifantech.test.csy.IotTestApp;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

public class RobotApp extends IotTestApp {
	public static void main(String[] args) {
		getRobot();

		ThreadTool.run(() -> {
			while (true) {
				String s = getRobot().getMsgReceived();
				if (!AppTool.isNull(s)) {
					System.out.println(s);
				}
				ThreadTool.sleep(1000);
			}
		});
	}
}