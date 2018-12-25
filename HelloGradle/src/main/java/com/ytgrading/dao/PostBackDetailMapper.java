package com.ytgrading.dao;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.dto.RequestLogistics;

public interface PostBackDetailMapper {
	//根据id找到一条回邮信息
	RequestLogistics getByRequestcode(@Param("requestcode") String requestcode);

}
