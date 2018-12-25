package com.kaifantech.component.service.alloc.info;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kaifantech.bean.wms.alloc.AllocInventoryInfoBean;
import com.kaifantech.cache.manager.ISingleCacheWorkerGetter;
import com.kaifantech.component.dao.alloc.AllocInventoryDao;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Service
public class AllocInventoryInfoService implements ISingleCacheWorkerGetter {

	@Autowired
	private AllocInventoryDao allocDao;

	private List<AllocInventoryInfoBean> cacheList;

	public List<AllocInventoryInfoBean> getList(Integer line) {
		List<AllocInventoryInfoBean> list = new ArrayList<>();
		getCacheList().stream().forEach((bean) -> {
			if ((bean.getLine() - bean.getLine() % 2) + 2 == line * 2) {
				list.add(bean);
			}
		});
		return list;
	}

	public List<Integer> getSiteIdList(Integer line) {
		List<Integer> list = new ArrayList<>();
		getCacheList().stream().allMatch((bean) -> {
			if (line.equals(bean.getLine()) && !list.contains(bean.getSiteid())) {
				list.add(bean.getSiteid());
			}
			return true;
		});
		return list;
	}

	public List<AllocInventoryInfoBean> getList(Integer line, Integer frame, Integer column) {
		List<AllocInventoryInfoBean> list = new ArrayList<>();
		getCacheList().stream().allMatch((bean) -> {
			if (line.equals(bean.getLine()) && frame.equals(bean.getFrame()) && column.equals(bean.getColumn())) {
				list.add(bean);
			}
			return true;
		});
		return list;
	}

	public List<Integer> getSiteIdList(Integer line, Integer frame, Integer column) {
		List<Integer> list = new ArrayList<>();
		getCacheList().stream().allMatch((bean) -> {
			if (line.equals(bean.getLine()) && frame.equals(bean.getFrame()) && column.equals(bean.getColumn())
					&& !list.contains(bean.getSiteid())) {
				list.add(bean.getSiteid());
			}
			return true;
		});
		return list;
	}

	public List<AllocInventoryInfoBean> getList(AllocInventoryInfoBean allocInventoryInfoBean) {
		List<AllocInventoryInfoBean> list = new ArrayList<>();
		getCacheList().stream().allMatch((bean) -> {
			if (allocInventoryInfoBean.getLine().equals(bean.getLine())
					&& allocInventoryInfoBean.getFrame().equals(bean.getFrame())
					&& allocInventoryInfoBean.getColumn().equals(bean.getColumn())) {
				list.add(bean);
			}
			return true;
		});
		return list;
	}

	public List<Integer> getSiteIdList(AllocInventoryInfoBean allocInventoryInfoBean) {
		List<Integer> list = new ArrayList<>();
		getCacheList().stream().allMatch((bean) -> {
			if (allocInventoryInfoBean.getLine().equals(bean.getLine())
					&& allocInventoryInfoBean.getFrame().equals(bean.getFrame())
					&& allocInventoryInfoBean.getColumn().equals(bean.getColumn())
					&& !list.contains(bean.getSiteid())) {
				list.add(bean.getSiteid());
			}
			return true;
		});
		return list;
	}

	public synchronized List<AllocInventoryInfoBean> getCacheList() {
		if (cacheList == null || cacheList.size() <= 0) {
			cacheList = allocDao.getList();
		}
		return cacheList;
	}

	private Object lock = new Object();

	public boolean isShutdownInventory() {
		synchronized (lock) {
			return "TRUE".equals(getCacheWorker().getOrInit("INVENTORY_SHUTDOWN", "FALSE"));
		}
	}

	public synchronized boolean isPauseInventory() {
		synchronized (lock) {
			return "TRUE".equals(getCacheWorker().getOrInit("INVENTORY_PAUSE", "FALSE"));
		}
	}

	public JSONObject getInventoryStatus() {
		boolean isShutdownInventory = isShutdownInventory();
		boolean isPauseInventory = isPauseInventory();
		JSONObject json = new JSONObject();
		json.put("isShutdownInventory", "" + isShutdownInventory);
		json.put("isPauseInventory", "" + isPauseInventory);
		return json;
	}

	public synchronized AppMsg setInventoryParams(JSONObject json) {
		synchronized (lock) {
			String isShutdownInventory = json.getString("isShutdownInventory");
			String isPauseInventory = json.getString("isPauseInventory");
			if (AppTool.isAllNull(isShutdownInventory, isPauseInventory)) {
				return AppMsg.fail().setMsg("未找到有效配置");
			}
			if ("false".equals(isShutdownInventory)) {
				getCacheWorker().set("INVENTORY_SHUTDOWN", "FALSE");
			} else if ("true".equals(isShutdownInventory)) {
				getCacheWorker().set("INVENTORY_SHUTDOWN", "TRUE");
			}
			if ("false".equals(isPauseInventory)) {
				getCacheWorker().set("INVENTORY_PAUSE", "FALSE");
			} else if ("true".equals(isPauseInventory)) {
				getCacheWorker().set("INVENTORY_PAUSE", "TRUE");
			}
			return AppMsg.success();
		}
	}
}
