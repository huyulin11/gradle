package com.ytgrading.dao;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.bean.RequestFeeBean;

public interface RequestFeeMapper {

	RequestFeeBean selectRequestFee(@Param("id") String id);

	int insert(RequestFeeBean requestFeeBean);

	int update(RequestFeeBean requestFeeBean);

	int delete(RequestFeeBean requestFeeBean);

}
