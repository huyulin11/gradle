package com.kaifantech.component.service.singletask.crud;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.entity.SingletaskFormMap;
import com.kaifantech.mappings.SingletaskMapper;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Service
public class SingletaskMgrService {
	@Inject
	private SingletaskMapper billMapper;

	public void doAddEntity(SingletaskFormMap billFormMap) throws Exception {
		billMapper.addTaskMgr(billFormMap);// 新增后返回新增信息
	}

}