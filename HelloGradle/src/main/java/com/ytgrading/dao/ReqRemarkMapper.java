package com.ytgrading.dao;

import com.ytgrading.dto.RequestRemark;

public interface ReqRemarkMapper {
	
	int insertReqRemark(RequestRemark record);
	
	String selectReqRemark(String requestcode);
	
	int updateReqRemark(RequestRemark record);
	
	int deleteReqRemark(String requestcode);
 
}
