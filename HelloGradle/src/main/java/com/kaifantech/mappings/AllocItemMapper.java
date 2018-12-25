package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.AllocItemFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface AllocItemMapper extends BaseMapper<AllocItemFormMap> {
	public List<AllocItemFormMap> findPage(AllocItemFormMap formMap);

	public List<AllocItemFormMap> findFirstPage(AllocItemFormMap AllocItemFormMap);

	public int add(AllocItemFormMap AllocItemFormMap);

}
