package com.kaifantech.cache.manager;

import com.kaifantech.cache.worker.ICacheWorker;

public interface ISingleCacheWorkerGetter {

	public default ICacheWorker getCacheWorker() {
		return AppCacheManager.getWorker(this.toString());
	}
}
