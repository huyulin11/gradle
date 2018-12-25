package com.kaifantech.component.service.bill;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.entity.BillFormMap;
import com.kaifantech.mappings.BussBillMapper;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Service
public class BillService {
	@Inject
	private BussBillMapper mapper;

	public void doAddEntity(BillFormMap formMap) throws Exception {
		mapper.add(formMap);// 新增后返回新增信息
	}

}