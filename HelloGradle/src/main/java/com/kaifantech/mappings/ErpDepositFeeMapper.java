package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.DepositFeeFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface ErpDepositFeeMapper extends BaseMapper {

	public List<DepositFeeFormMap> findDepositFeePage(
			DepositFeeFormMap DepositFeeFormMap);

}
