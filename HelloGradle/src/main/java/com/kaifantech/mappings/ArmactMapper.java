package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.ArmactFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface ArmactMapper extends BaseMapper<ArmactFormMap> {

	public List<ArmactFormMap> findPage(ArmactFormMap formMap);

	public int add(ArmactFormMap formMap);

}
