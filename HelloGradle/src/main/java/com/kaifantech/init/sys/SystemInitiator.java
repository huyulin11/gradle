package com.kaifantech.init.sys;

import com.kaifantech.util.os.OSinfo;

public class SystemInitiator {
	public static boolean alwaysTrue = true;

	public static final String SPLIT = "$";

	public static final String SPLIT_REG = "\\$";

	public static boolean isNeedRoboticArm = false;

	public static boolean isCatcharmOn = false;

	private static final String PANFU = "D:";
	private static final String LOG_PATH_LINUX = "/acs/logs/";
	private static final String LOG_PATH_WINDOWS = PANFU + "/acs/logs/";
	public static final String LOG_PATH = OSinfo.isWindows() ? LOG_PATH_WINDOWS : LOG_PATH_LINUX;

	private static final String CMD_PATH = PANFU + "/acs/";// 服务器脚本 acs
	public static final String REDIS_BAT = "cmd /k start " + CMD_PATH + "Redis.bat";
	public static final String NGINX_BAT = "cmd /k start " + CMD_PATH + "Nginx.bat";

	static {
		RelativeProgramsStart.open();
	}
}
