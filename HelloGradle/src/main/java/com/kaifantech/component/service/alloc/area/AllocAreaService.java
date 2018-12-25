package com.kaifantech.component.service.alloc.area;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.component.dao.alloc.AllocAreaDao;
import com.kaifantech.component.service.sys.IInitCacheService;
import com.kaifantech.bean.wms.alloc.AllocationAreaInfoBean;
import com.ytgrading.util.AppTool;

@Service
public class AllocAreaService implements IAllocAreaService, IInitCacheService {

	@Autowired
	private AllocAreaDao allocAreaDao;

	private List<AllocationAreaInfoBean> allocationAreaInfoBeanList;

	@Override
	public AllocationAreaInfoBean getAllocationAreaInfoBeanByAreaId(Integer areaId) {
		return getAllocationAreaInfoBeanList().stream().filter((bean) -> (areaId.equals(bean.getAreaId()))).iterator()
				.next();
	}

	@Override
	public List<AllocationAreaInfoBean> getAllocationAreaInfoBeanList() {
		if (allocationAreaInfoBeanList == null || allocationAreaInfoBeanList.size() <= 0) {
			allocationAreaInfoBeanList = allocAreaDao.getAllAllocationAreaInfoBean();
		}

		return allocationAreaInfoBeanList;
	}

	@Override
	public List<AllocationAreaInfoBean> getAllocationAreaInfoBeanListForShow() {
		if (allocationAreaInfoBeanList == null || allocationAreaInfoBeanList.size() <= 0) {
			allocationAreaInfoBeanList = allocAreaDao.getAllAllocationAreaInfoBean();
		}

		List<Map<String, Object>> areasInfo = allocAreaDao.getAreaStorageInfo();
		for (Map<String, Object> areaInfo : areasInfo) {
			try {
				Integer currentAreaId = (Integer) areaInfo.get("areaId");
				AllocationAreaInfoBean currentBean = allocationAreaInfoBeanList.stream()
						.filter((bean) -> (currentAreaId.equals(bean.getAreaId()))).iterator().next();
				Object allowedSkus = areaInfo.get("allowedSkuNames");
				Object allowedSkuTypes = areaInfo.get("allowedSkuTypeNames");
				Object inSkuNames = areaInfo.get("inSkuNames");
				currentBean.setAllowedSkuNames(AppTool.isNull(allowedSkus) ? "" : allowedSkus.toString());
				currentBean.setAllowedSkuTypeNames(AppTool.isNull(allowedSkuTypes) ? "" : allowedSkuTypes.toString());
				currentBean.setInSkuNames(AppTool.isNull(inSkuNames) ? "" : inSkuNames.toString());
			} catch (Exception e) {
				continue;
			}
		}
		return allocationAreaInfoBeanList;
	}

	@Override
	public void init() {
		allocationAreaInfoBeanList.clear();
	}

}
