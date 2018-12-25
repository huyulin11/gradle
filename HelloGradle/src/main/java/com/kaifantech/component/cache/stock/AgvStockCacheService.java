package com.kaifantech.component.cache.stock;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kaifantech.cache.manager.ISingleCacheWorkerGetter;
import com.kaifantech.init.sys.params.CacheKeys;
import com.ytgrading.util.AppTool;

@Service
public class AgvStockCacheService implements ISingleCacheWorkerGetter {

	public void clearStocks(Integer agvId) {
		getCacheWorker().clear(CacheKeys.agvCacheStock(agvId));
	}

	public Map<String, String> getStocks(Integer agvId) {
		Map<String, String> stocks = getCacheWorker().hgetAll(CacheKeys.agvCacheStock(agvId));
		if (AppTool.isNull(stocks)) {
			stocks = new HashMap<>();
		}
		return stocks;
	}

	public Integer getNextLayerToStock(Integer agvId, String targetAlloc) {
		Integer agvStock = null;
		Map<String, String> stocks = getStocks(agvId);
		for (int layer = 1; layer <= 6; layer++) {
			String isStock = stocks.get("" + layer);
			if (!"0".equals(isStock) && !AppTool.isNull(isStock)) {
				continue;
			} else {
				agvStock = layer;
				getCacheWorker().hset(CacheKeys.agvCacheStock(agvId), "" + agvStock, targetAlloc);
				break;
			}
		}
		return agvStock;
	}

	public Integer getNextLayerToStock(Integer agvId) {
		return getNextLayerToStock(agvId, "A");
	}

	public Integer getNextLayerToGet(Integer agvId) {
		return getNextLayerToGet(agvId, "A");
	}

	public Integer getNextLayerToGet(Integer agvId, String targetAlloc) {
		Integer agvStock = null;
		Map<String, String> stocks = getStocks(agvId);
		for (int layer = 1; layer <= 6; layer++) {
			String isStock = stocks.get("" + layer);
			if (!targetAlloc.equals(isStock)) {
				continue;
			} else {
				agvStock = layer;
				getCacheWorker().hset(CacheKeys.agvCacheStock(agvId), "" + agvStock, "" + 0);
				break;
			}
		}
		return agvStock;
	}

}
