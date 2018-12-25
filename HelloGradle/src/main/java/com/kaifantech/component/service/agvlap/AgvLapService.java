package com.kaifantech.component.service.agvlap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.entity.AgvLapFormMap;
import com.kaifantech.mappings.AgvLapMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.component.service.erp.system.IBaseService;

@Service
public class AgvLapService implements IBaseService<AgvLapFormMap> {
	@Inject
	private AgvLapMapper mapper;

	public void doAddEntity(AgvLapFormMap formMap) throws Exception {
		mapper.addEntity(formMap);// 新增后返回新增信息
	}

	@Override
	public BaseMapper<AgvLapFormMap> getMapper() {
		return mapper;
	}

}
