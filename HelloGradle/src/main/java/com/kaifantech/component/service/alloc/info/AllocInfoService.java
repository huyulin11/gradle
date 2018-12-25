package com.kaifantech.component.service.alloc.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.singletask.SingletaskBean;
import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.component.dao.alloc.AllocItemDao;
import com.kaifantech.component.service.singletask.info.SingleTaskInfoService;
import com.kaifantech.util.thread.ThreadTool;

@Service
public class AllocInfoService implements IAllocInfoService {

	@Autowired
	private AllocItemDao allocDao;

	@Autowired
	private SingleTaskInfoService singleTaskInfoService;

	private List<AllocItemInfoBean> cacheList;

	private boolean isCacheDataOk = false;

	@Override
	public AllocItemInfoBean getByNameFromCache(String allocItemName) {
		if (!isCacheDataOk) {
			ThreadTool.run(() -> {
				getCacheList();
				isCacheDataOk = true;
			});
			return getByNameFromDB(allocItemName);
		}
		return getCacheList().stream().filter((bean) -> (allocItemName.equals(bean.getText()))).iterator().next();
	}

	@Override
	public synchronized List<AllocItemInfoBean> getCacheList() {
		if (cacheList == null || cacheList.size() <= 0) {
			cacheList = allocDao.getAll();
		}
		return cacheList;
	}

	@Override
	public AllocItemInfoBean getByTaskid(String taskid) {
		SingletaskBean singletaskBean = singleTaskInfoService.getSingletask(taskid);
		if (singletaskBean == null) {
			return null;
		}
		return allocDao.getAllocationInfoBean(singletaskBean.getAllocid());
	}

	@Override
	public AllocItemInfoBean getById(String id) {
		return allocDao.getAllocationInfoBean(id);
	}

	@Override
	public AllocItemInfoBean getByNameFromDB(String allocItemName) {
		return allocDao.getAllocationInfoBean(allocItemName);
	}
}
