package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.DepositAddressFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface ErpDepositAddressMapper extends BaseMapper {

	public List<DepositAddressFormMap> findDepositAddressPage(DepositAddressFormMap DepositAddressFormMap);

}
