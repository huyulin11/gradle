package com.kaifantech.component.service.alloc.area;

import java.util.List;

import com.kaifantech.bean.wms.alloc.AllocationAreaInfoBean;

public interface IAllocAreaService {

	public AllocationAreaInfoBean getAllocationAreaInfoBeanByAreaId(Integer areaId);

	public List<AllocationAreaInfoBean> getAllocationAreaInfoBeanList();

	List<AllocationAreaInfoBean> getAllocationAreaInfoBeanListForShow();

}
