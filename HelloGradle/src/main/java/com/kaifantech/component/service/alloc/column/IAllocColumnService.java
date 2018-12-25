package com.kaifantech.component.service.alloc.column;

import java.util.List;

import com.kaifantech.bean.wms.alloc.AllocColumnInfoBean;

public interface IAllocColumnService {

	public AllocColumnInfoBean getBeanBy(Integer areaId, Integer colId);

	public List<AllocColumnInfoBean> getBeanBy(Integer areaId);

	public List<AllocColumnInfoBean> getList();

	List<AllocColumnInfoBean> getListBySkuId(Integer environment, Integer allowedSkuId);

	List<AllocColumnInfoBean> getListBySkuType(Integer environment, Integer allowedSkuType);

	List<AllocColumnInfoBean> getListBySkuType(Integer environment, String allowedSkuType);

	List<AllocColumnInfoBean> getListNotNeedAllow(Integer environment);

	List<AllocColumnInfoBean> getListShowBy(Integer areaId);

	AllocColumnInfoBean getBeanByTaskid(String taskid);

}
