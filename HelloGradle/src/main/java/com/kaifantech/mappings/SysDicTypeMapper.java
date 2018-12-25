package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.SysDicTypeFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface SysDicTypeMapper extends BaseMapper<SysDicTypeFormMap> {

	public List<SysDicTypeFormMap> find(SysDicTypeFormMap formMap);

	public int add(SysDicTypeFormMap formMap);

}
