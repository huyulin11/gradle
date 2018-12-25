package com.kaifantech.mappings;

import java.util.List;

import com.ytgrading.bean.ResourceBean;
import com.kaifantech.entity.ResFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface ErpResourcesMapper extends BaseMapper {
	public List<ResFormMap> findChildlists(ResFormMap map);

	public List<ResFormMap> findRes(ResFormMap map);

	public void updateSortOrder(List<ResFormMap> map);

	public List<ResFormMap> findUserResourcess(String userId);

	public List<ResourceBean> selectAllResourcess();

	public List<ResFormMap> selectTreeResourcess();

}
