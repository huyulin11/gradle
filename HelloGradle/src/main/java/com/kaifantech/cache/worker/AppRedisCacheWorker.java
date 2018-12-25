package com.kaifantech.cache.worker;

import java.util.Map;
import java.util.Set;

import com.ytgrading.util.AppTool;

import redis.clients.jedis.Jedis;

public class AppRedisCacheWorker implements ICacheWorker {

	private String separator = ":";
	private Jedis jedis;

	private Jedis getCacheTool() {
		return jedis;
	}

	public AppRedisCacheWorker(Jedis jedis) {
		this.jedis = jedis;
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

	public synchronized Map<String, String> hgetAll(String redisKey) {
		try {
			return getCacheTool().hgetAll(redisKey);
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
			long rtmVal = 0;
			Set<String> set = jedis.hkeys(key);
			for (String tempKey : set) {
				rtmVal += getCacheTool().del(tempKey);
			}
			return rtmVal;
		} catch (Exception e) {
			System.out.println("cachework set err:" + e.getMessage());
			return null;
		}
	}

	public synchronized Long hset(String key, String field, String value) {
		try {
			return getCacheTool().hset(key, field, value);
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

	public String getSeparator() {
		return separator;
	}
}