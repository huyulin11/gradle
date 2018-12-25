package com.kaifantech.test.yufeng;

import com.kaifantech.init.sys.params.CacheKeys;
import com.kaifantech.util.socket.netty.client.yufeng.YufengNettyClient;
import com.kaifantech.util.socket.netty.server.DefauNettyServer;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

public class IotTestApp {
	private static YufengNettyClient agv;
	private static DefauNettyServer agvServer;

	static {
		CacheKeys.setTest(true);
	}

	public synchronized static YufengNettyClient getAgv() {
		if (!AppTool.isNull(agv)) {
			return agv;
		}
		agv = new YufengNettyClient("192.168.0.110", 5300, 0);// 127.0.0.1
		ThreadTool.run(() -> {
			agv.init();
		});
		ThreadTool.sleep(3000);
		return agv;
	}

	public synchronized static DefauNettyServer getAgvServer() {
		if (!AppTool.isNull(agvServer)) {
			return agvServer;
		}
		agvServer = new DefauNettyServer(5300);// 127.0.0.1
		ThreadTool.run(() -> {
			try {
				agvServer.init();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		ThreadTool.sleep(3000);
		return agvServer;
	}

}
