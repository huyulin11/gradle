package com.kaifantech.component.service.alloc.column;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.singletask.SingletaskBean;
import com.kaifantech.bean.wms.alloc.AllocColumnInfoBean;
import com.kaifantech.bean.wms.alloc.AllocItemInfoBean;
import com.kaifantech.component.dao.alloc.AllocColumnDao;
import com.kaifantech.component.dao.alloc.AllocItemDao;
import com.kaifantech.component.service.singletask.info.SingleTaskInfoService;
import com.kaifantech.component.service.sys.IInitCacheService;

@Service
public class AllocColumnService implements IAllocColumnService, IInitCacheService {

	@Autowired
	private AllocColumnDao allocColumnDao;

	private List<AllocColumnInfoBean> allocationColumnInfoBeanList;

	@Autowired
	private SingleTaskInfoService singleTaskInfoService;

	@Autowired
	private AllocItemDao allocItemDao;

	@Override
	public AllocColumnInfoBean getBeanBy(Integer areaId, Integer colId) {
		return getList().stream().filter((bean) -> (areaId.equals(bean.getAreaId()) && colId.equals(bean.getColId())))
				.iterator().next();
	}

	@Override
	public AllocColumnInfoBean getBeanByTaskid(String taskid) {
		SingletaskBean singletaskOfOne = singleTaskInfoService.getSingletask(taskid);
		AllocItemInfoBean allocItemOfOne = allocItemDao.getAllocationInfoBean(singletaskOfOne.getAllocid());
		return getBeanBy(allocItemOfOne.getAreaId(), allocItemOfOne.getColId());
	}

	@Override
	public List<AllocColumnInfoBean> getBeanBy(Integer areaId) {
		List<AllocColumnInfoBean> tmpAllocationColumnInfoBeanList = new ArrayList<>();
		getList().stream().filter((bean) -> (areaId.equals(bean.getAreaId())))
				.forEach(tmpAllocationColumnInfoBeanList::add);
		return tmpAllocationColumnInfoBeanList;
	}

	@Override
	public List<AllocColumnInfoBean> getListShowBy(Integer areaId) {
		List<AllocColumnInfoBean> tmpAllocationColumnInfoBeanList = new ArrayList<>();
		getList().stream().filter((bean) -> (areaId.equals(bean.getAreaId())))
				.sorted(AllocColumnInfoBean.comparatorInverted).forEach(tmpAllocationColumnInfoBeanList::add);
		return tmpAllocationColumnInfoBeanList;
	}

	@Override
	public List<AllocColumnInfoBean> getList() {
		if (allocationColumnInfoBeanList == null || allocationColumnInfoBeanList.size() <= 0) {
			allocationColumnInfoBeanList = allocColumnDao.getAllAllocationColumnInfoBean();
		}
		return allocationColumnInfoBeanList;
	}

	@Override
	public List<AllocColumnInfoBean> getListBySkuId(Integer environment, Integer allowedSkuId) {
		List<AllocColumnInfoBean> tmpAllocationColumnInfoBeanList = new ArrayList<>();
		getList().stream().filter(
				(bean) -> (environment.equals(bean.getEnvironment()) && allowedSkuId.equals(bean.getAllowedSkuId())))
				.forEach(tmpAllocationColumnInfoBeanList::add);
		return tmpAllocationColumnInfoBeanList;
	}

	@Override
	public List<AllocColumnInfoBean> getListBySkuType(Integer environment, Integer allowedSkuType) {
		List<AllocColumnInfoBean> tmpAllocationColumnInfoBeanList = new ArrayList<>();
		getList().stream()
				.filter((bean) -> (environment.equals(bean.getEnvironment())
						&& allowedSkuType.equals(bean.getAllowedSkuType())))
				.forEach(tmpAllocationColumnInfoBeanList::add);
		return tmpAllocationColumnInfoBeanList;
	}

	@Override
	public List<AllocColumnInfoBean> getListNotNeedAllow(Integer environment) {
		List<AllocColumnInfoBean> tmpAllocationColumnInfoBeanList = new ArrayList<>();
		getList()
				.stream().filter((bean) -> (environment.equals(bean.getEnvironment())
						&& bean.getAllowedSkuType().equals(0) && bean.getAllowedSkuId().equals(0)))
				.forEach(tmpAllocationColumnInfoBeanList::add);
		return tmpAllocationColumnInfoBeanList;
	}

	@Override
	public void init() {
		allocationColumnInfoBeanList.clear();
	}

	@Override
	public List<AllocColumnInfoBean> getListBySkuType(Integer environment, String allowedSkuType) {
		return null;
	}

}
