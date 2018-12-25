package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.SkuInfoFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface SkuInfoMapper extends BaseMapper<SkuInfoFormMap> {

	public List<SkuInfoFormMap> findPage(SkuInfoFormMap formMap);

	public int add(SkuInfoFormMap formMap);

}
