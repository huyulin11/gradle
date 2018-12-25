package com.kaifantech.init.sys;

import java.io.IOException;

import com.kaifantech.util.os.OSinfo;
import com.kaifantech.util.thread.ThreadTool;

public class RelativeProgramsStart {
	private static boolean isRunning = false;

	public static void open() {
		try {
			if (SystemClient.CLIENT.equals(SystemClient.Client.YUFENG) || isRunning) {
				return;
			}
			isRunning = true;
			ThreadTool.run(() -> {
				try {
					String isInitNginx = SystemCacheDao.one().getFresh("INIT_NGINX", 24 * 3600);
					if (!"TRUE".equals(isInitNginx)) {
						if (OSinfo.isWindows()) {
							runNginx();
							SystemCacheDao.one().set("INIT_NGINX", "TRUE");
						}
					}
				} catch (IOException e) {
				}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void runRedis() throws IOException {
		Runtime.getRuntime().exec(SystemInitiator.REDIS_BAT);
	}

	public static void runNginx() throws IOException {
		Runtime.getRuntime().exec(SystemInitiator.NGINX_BAT);
	}

	public static void main(String[] args) {
		RelativeProgramsStart.open();
	}
}