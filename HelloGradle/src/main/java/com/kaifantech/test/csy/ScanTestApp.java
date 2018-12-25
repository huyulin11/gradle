package com.kaifantech.test.csy;

import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

public class ScanTestApp extends IotTestApp {

	public static void main(String[] args) {
		ThreadTool.run(() -> {
			while (true) {
				String s = getScan().getMsg();
				if (!AppTool.isNull(s)) {
					System.out.println(s);
				}
				ThreadTool.sleep(1000);
			}
		});

	}

	public static void main3(String[] args) {
		System.out.println(Integer.toHexString(0x22));
	}
}