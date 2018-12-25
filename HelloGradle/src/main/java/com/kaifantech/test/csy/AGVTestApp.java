package com.kaifantech.test.csy;

import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.util.socket.netty.client.csy.CsyAgvNettyClient;
import com.kaifantech.util.thread.ThreadTool;

public class AGVTestApp extends IotTestApp implements IMultiCacheWorkerGetter {
	private static CsyAgvNettyClient agv;
	static {
		agv = getAgv(1);
	}

	public static void main(String[] args) {
		ThreadTool.run(() -> {
			while (true) {
				System.out.println(agv.getMsg());
				ThreadTool.sleepOneSecond();
			}
		});
	}
}