package com.kaifantech.cache.worker;

import java.util.Map;

public interface ICacheWorker {

	public String getOrInit(String param1, String param2, String initVal);

	public String getOrInit(String param, String initVal);

	public String get(String param1, String param2);

	default String getFresh(String param1, String param2) {
		return null;
	}

	public String get(String param);

	default String getFresh(String param) {
		return null;
	}

	default String getCurrentDate(String param) {
		return null;
	}

	public Map<String, String> hgetAll(String redisKey);

	default Map<String, String> hgetAllFresh(String redisKey) {
		return null;
	}

	public Long del(String key);

	public Long clear(String key);

	public Long hset(String key, String field, String value);

	public String set(String key, String value);

	public String getSeparator();
}