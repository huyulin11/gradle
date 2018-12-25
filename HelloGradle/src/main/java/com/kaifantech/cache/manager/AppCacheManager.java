package com.kaifantech.cache.manager;

import com.kaifantech.cache.worker.AppMysqlMmCacheWorker;
import com.kaifantech.cache.worker.ICacheWorker;

public class AppCacheManager {
	public static ICacheWorker getWorker(String key) {
		// return new AppRedisCacheWorker(RedisPool.getRedis(key));
		return new AppMysqlMmCacheWorker();
	}

	public static ICacheWorker getWorker() {
		return new AppMysqlMmCacheWorker();
	}
}
