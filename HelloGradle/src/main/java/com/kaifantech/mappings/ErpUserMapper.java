package com.kaifantech.mappings;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.bean.system.SystemOperator;
import com.kaifantech.entity.UserFormMap;
import com.kaifantech.mappings.base.BaseMapper;

public interface ErpUserMapper extends BaseMapper<UserFormMap> {

	public List<UserFormMap> findUserPage(UserFormMap userFormMap);

	public List<SystemOperator> searchOperator(@Param("id") int id);
}
