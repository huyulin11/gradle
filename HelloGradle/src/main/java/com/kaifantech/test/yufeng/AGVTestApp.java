package com.kaifantech.test.yufeng;

import com.kaifantech.util.thread.ThreadTool;

public class AGVTestApp extends IotTestApp {
	public static void main(String[] args) {
		getAgvServer();

		ThreadTool.run(() -> {
			while (true) {
				System.out.println(getAgvServer().getMsgReceived());
				ThreadTool.sleep(1000);
			}
		});
	}
}