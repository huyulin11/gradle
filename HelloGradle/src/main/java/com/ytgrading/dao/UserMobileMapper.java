package com.ytgrading.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMobileMapper {
	List<Map<String, String>> getUserMobileList(@Param("userid") String userid);
	Map<String,String> getMobileDetail(@Param("userid") String userid,
			@Param("numble") String numble);
	int editMobile(@Param("id") String userid,
			@Param("numble") String numble);
	
	String getDefaultMobile(@Param("userid") String userid);
	int setMobileDefault(@Param("userid") String userid,
			@Param("numble") String numble);
	
	List<String> getValidMobile(@Param("userid") String userid);
	int setMobileValid(@Param("userid") String userid,
			@Param("numble") String numble);
	int setMobileInvalid(@Param("userid") String userid,
			@Param("numble") String numble);
	boolean checkValidMobile(@Param("userid") String userid,
			@Param("numble") String numble);
	
	int addMobile(@Param("userid") String userid,
			@Param("numble") String numble);
}
