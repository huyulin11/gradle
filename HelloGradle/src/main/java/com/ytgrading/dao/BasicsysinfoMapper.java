package com.ytgrading.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BasicsysinfoMapper {
	public List<?> getUaMapByTableName(@Param("tableName") String tableName);
}
