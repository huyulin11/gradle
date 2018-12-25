package com.kaifantech.cache.worker;

import java.util.Map;

import com.kaifantech.init.sys.SystemCacheDao;
import com.ytgrading.util.AppTool;

public class AppMysqlMmCacheWorker implements ICacheWorker {

	private String separator = "_";

	private SystemCacheDao getCacheTool() {
		return new SystemCacheDao();
	}

	public String getSeparator() {
		return separator;
	}

	public synchronized String getOrInit(String param1, String param2, String initVal) {
		String finalVal = get(param1, param2);
		if (AppTool.isNull(finalVal) && !AppTool.isNull(initVal)) {
			finalVal = initVal;
			getCacheTool().hset(param1, param2, finalVal);
		}
		return finalVal;
	}

	public synchronized String getOrInit(String param, String initVal) {
		String finalVal = get(param);
		if (AppTool.isNull(finalVal) && !AppTool.isNull(initVal)) {
			finalVal = initVal;
			getCacheTool().set(param, finalVal);
		}
		return finalVal;
	}

	public synchronized String get(String param1, String param2) {
		return getCacheTool().hget(param1, param2);
	}

	public synchronized String get(String param) {
		return getCacheTool().get(param);
	}

	public synchronized String getFresh(String param1, String param2) {
		return getCacheTool().getFresh(param1, param2);
	}

	public synchronized String getFresh(String param) {
		return getCacheTool().getFresh(param);
	}

	public synchronized String getCurrentDate(String param) {
		return getCacheTool().getFresh(param, 24 * 3600);
	}

	public synchronized Map<String, String> hgetAll(String redisKey) {
		try {
			return getCacheTool().hgetAll(redisKey);
		} catch (Exception e) {
			System.out.println("cachework hgetAll err:" + e.getMessage());
			return null;
		}
	}

	public synchronized Map<String, String> hgetAllFresh(String redisKey) {
		try {
			return getCacheTool().hgetAllFresh(redisKey);
		} catch (Exception e) {
			System.out.println("cachework hgetAll err:" + e.getMessage());
			return null;
		}
	}

	public synchronized Long del(String key) {
		return getCacheTool().del(key);
	}

	public synchronized Long clear(String key) {
		try {
			return del(key);
		} catch (Exception e) {
			System.out.println("cachework set err:" + e.getMessage());
			return null;
		}
	}

	public synchronized Long hset(String field, String key, String value) {
		try {
			return getCacheTool().hset(field, key, value);
		} catch (Exception e) {
			System.out.println("cachework hset err:" + e.getMessage());
			return null;
		}
	}

	public synchronized String set(String key, String value) {
		try {
			return getCacheTool().set(key, value);
		} catch (Exception e) {
			System.out.println("cachework set err:" + e.getMessage());
			return null;
		}
	}
}