package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.AgvLapFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface AgvLapMapper extends BaseMapper<AgvLapFormMap> {
	public List<AgvLapFormMap> findByPage(AgvLapFormMap formMap); 
}
