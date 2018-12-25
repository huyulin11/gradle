package com.kaifantech.component.service.alloc.info;

import java.util.List;

import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;

public interface IAllocInfoService {

	public AllocItemInfoBean getByNameFromCache(String allocItemName);

	public List<AllocItemInfoBean> getCacheList();

	public AllocItemInfoBean getByTaskid(String taskid);

	public AllocItemInfoBean getById(String id);

	public AllocItemInfoBean getByNameFromDB(String allocItemName);
}
