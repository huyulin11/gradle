package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.IotRelationFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface IotRelationMapper extends BaseMapper<IotRelationFormMap> {

	public List<IotRelationFormMap> find(IotRelationFormMap formMap);

	public int add(IotRelationFormMap formMap);

}
