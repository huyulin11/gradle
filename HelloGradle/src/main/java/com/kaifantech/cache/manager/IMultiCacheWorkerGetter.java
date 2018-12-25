package com.kaifantech.cache.manager;

import com.kaifantech.cache.worker.ICacheWorker;

public interface IMultiCacheWorkerGetter {

	public default ICacheWorker getCacheWorker(Object key) {
		return AppCacheManager.getWorker(this.toString() + key);
	}
}
