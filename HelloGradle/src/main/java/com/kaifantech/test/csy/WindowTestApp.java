package com.kaifantech.test.csy;

import com.kaifantech.util.thread.ThreadTool;

public class WindowTestApp extends IotTestApp {

	public static void main(String[] args) {
		ThreadTool.run(() -> {
			while (true) {
				System.out.println(getWindow().getMsg());
				ThreadTool.sleep(1000);
			}
		});

	}

	public static void main3(String[] args) {
		System.out.println(Integer.toHexString(0x22));
	}
}