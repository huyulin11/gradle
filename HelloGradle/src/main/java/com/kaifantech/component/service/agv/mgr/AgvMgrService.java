package com.kaifantech.component.service.agv.mgr;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.entity.agv.AgvMgrFormMap;
import com.kaifantech.mappings.agv.AgvMgrMapper;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Service
public class AgvMgrService {
	@Inject
	private AgvMgrMapper mapper;

	public void doAddEntity(AgvMgrFormMap formMap) throws Exception {
		mapper.add(formMap);// 新增后返回新增信息
	}

}