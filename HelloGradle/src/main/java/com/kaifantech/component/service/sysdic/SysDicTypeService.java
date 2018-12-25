package com.kaifantech.component.service.sysdic;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.entity.SysDicTypeFormMap;
import com.kaifantech.mappings.SysDicTypeMapper;

@Service
public class SysDicTypeService {

	@Inject
	private SysDicTypeMapper mapper;

	public void doAddEntity(SysDicTypeFormMap formMap) throws Exception {
		mapper.add(formMap);// 新增后返回新增信息
	}
}
