package com.kaifantech.component.service.sku;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.taskexe.SkuInfoBean;
import com.kaifantech.bean.wms.sku.SkuTypeBean;
import com.kaifantech.component.dao.sku.SkuInfoDao;
import com.kaifantech.component.dao.sku.SkuTypeDao;
import com.kaifantech.entity.SkuInfoFormMap;
import com.kaifantech.mappings.SkuInfoMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.component.service.erp.system.IBaseService;

@Service
public class SkuInfoService implements IBaseService<SkuInfoFormMap> {

	@Autowired
	protected SkuInfoDao skuInfoDao;

	@Autowired
	protected SkuTypeDao skuTypeDao;

	private List<SkuInfoBean> skuInfoBeanList;
	private List<SkuTypeBean> skuTypeBeanList;

	@Inject
	private SkuInfoMapper mapper;

	public void doAddEntity(SkuInfoFormMap formMap) throws Exception {
		mapper.add(formMap);// 新增后返回新增信息
	}

	public List<SkuInfoBean> getSkuInfoBeanList() {
		if (skuInfoBeanList == null || skuInfoBeanList.size() == 0) {
			skuInfoBeanList = skuInfoDao.getAllList();
		}
		return skuInfoBeanList;
	}

	public List<SkuTypeBean> getSkuTypeBeanList() {
		if (skuTypeBeanList == null || skuTypeBeanList.size() == 0) {
			skuTypeBeanList = skuTypeDao.getAllList();
		}
		return skuTypeBeanList;
	}

	public SkuInfoBean getSkuInfoBeanById(Integer skuId) {
		try {
			return getSkuInfoBeanList().stream().filter((bean) -> (skuId.equals(bean.getId()))).iterator().next();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public SkuInfoBean getSkuInfoBeanByType(Integer skuTypeId) {
		return getSkuInfoBeanList().stream().filter((bean) -> (skuTypeId.equals(bean.getType()))).iterator().next();
	}

	@Override
	public BaseMapper<SkuInfoFormMap> getMapper() {
		return null;
	}

}
