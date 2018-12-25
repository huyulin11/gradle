package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.DepositMainFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface ErpDepositMainMapper extends BaseMapper {

	public List<DepositMainFormMap> findDepositMainPage(
			DepositMainFormMap DepositMainFormMap);

}
