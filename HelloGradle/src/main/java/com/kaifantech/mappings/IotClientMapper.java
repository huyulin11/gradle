package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.IotClientFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface IotClientMapper extends BaseMapper<IotClientFormMap> {

	public List<IotClientFormMap> find(IotClientFormMap formMap);

	public int add(IotClientFormMap formMap);

}
