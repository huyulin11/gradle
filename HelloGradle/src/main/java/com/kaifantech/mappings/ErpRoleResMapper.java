package com.kaifantech.mappings;

import java.util.List;

import com.kaifantech.entity.RoleResFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface ErpRoleResMapper extends BaseMapper {

	public List<RoleResFormMap> findRoleResPage(RoleResFormMap RoleResFormMap);

}
