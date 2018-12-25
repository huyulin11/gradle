package com.ytgrading.dao;

import org.apache.ibatis.annotations.Param;

public interface RequestOpMapper {
	public int updateRequestStatus(@Param("scope") String[] scope,
			@Param("oStatus") String oStatus, @Param("iStatus") String iStatus);
}