package com.kaifantech.component.service.armact;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.entity.ArmactFormMap;
import com.kaifantech.mappings.ArmactMapper;

@Service
public class ArmactService {
	@Inject
	private ArmactMapper mapper;

	public void doAddEntity(ArmactFormMap formMap) throws Exception {
		mapper.add(formMap);// 新增后返回新增信息
	}

}