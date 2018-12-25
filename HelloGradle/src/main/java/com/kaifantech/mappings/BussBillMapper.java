package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.BillFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface BussBillMapper extends BaseMapper<BillFormMap> {

	public List<BillFormMap> findPage(BillFormMap formMap);

	public int add(BillFormMap formMap);

}
