package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.SkuInfoFormMap;
import com.kaifantech.entity.SkuInfoNameFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface SkuInfoNameMapper extends BaseMapper<SkuInfoNameFormMap> {
	public List<SkuInfoFormMap> findByPage(SkuInfoFormMap formMap);
}
