package com.kaifantech.util.log;

import com.ytgrading.util.AppFile;

public class AppFileLogger {
	public static void log(String content) {
		AppFile.WriteLogsTo("NORMAL", content);
	}

	public static void out(String content) {
		String info = AppFile.WriteLogsTo("NORMAL", content);
		System.err.println(info);
	}

	public static void siteCacheInfo(String content) {
		AppFile.WriteLogsTo("SITE-CACHE", content);
	}

	public static void piLogs(String content) {
		String info = AppFile.WriteLogsTo("AGVPI-INFO", content);
		System.err.println(info);
	}

	public static void piError(String content) {
		String info = AppFile.WriteLogsTo("AGVPI-ERROR", content);
		System.err.println(info);
	}

	public static void connectInfo(String content) {
		AppFile.WriteLogsTo("CONNECT-INFO", content);
	}

	public static void wmsInfo(String content) {
		AppFile.WriteLogsTo("WMS-INFO", content);
	}

	public static void wmsErr(String content) {
		AppFile.WriteLogsTo("WMS-ERROR", content);
	}

	public static void speedInfo(String content) {
		AppFile.WriteLogsTo("SPEED-INFO", content);
	}

	public static String connectError(String content) {
		return AppFile.WriteLogsTo("CONNECT-ERROR", content);
	}

	public static String error(String content) {
		String info = AppFile.WriteLogsTo("ERROR", content);
		System.err.println(info);
		return info;
	}

	public static String warning(String content) {
		String info = AppFile.WriteLogsTo("WARNING", content);
		System.err.println(info);
		return info;
	}
}
