package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.SkuTypeFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface SkuTypeMapper extends BaseMapper<SkuTypeFormMap> {

	public List<SkuTypeFormMap> findByPage(SkuTypeFormMap formMap);

	public List<SkuTypeFormMap> findOne(SkuTypeFormMap formMap);

	public int add(SkuTypeFormMap formMap);

}
