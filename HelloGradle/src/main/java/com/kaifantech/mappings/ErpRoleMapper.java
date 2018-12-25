package com.kaifantech.mappings;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kaifantech.entity.RoleFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface ErpRoleMapper extends BaseMapper<RoleFormMap> {
	public List<RoleFormMap> seletUserRole(RoleFormMap map);

	public List<RoleFormMap> seletAllUserRole();

	public void deleteById(RoleFormMap map);

	public int checkButton(@Param("resId") int resId, @Param("userId") int userId);
}
