package com.ytgrading.dao;

import com.ytgrading.dto.UserAddress;
import com.ytgrading.dto.UserAddressExample;
import com.ytgrading.dto.UserMail;
import com.ytgrading.dto.UserMobile;
import com.ytgrading.dto.UserTel;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAddressMapper {
	int countByExample(UserAddressExample example);

	int deleteByExample(UserAddressExample example);

	int deleteByPrimaryKey(String id);

	int insert(UserAddress record);

	int insertSelective(UserAddress record);

	List<UserAddress> selectByExample(UserAddressExample example);

	UserAddress selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") UserAddress record,
			@Param("example") UserAddressExample example);

	int updateByExample(@Param("record") UserAddress record,
			@Param("example") UserAddressExample example);

	int updateByPrimaryKeySelective(UserAddress record);

	int updateByPrimaryKey(UserAddress record);

	UserMail selectByUserMail(String id);

	UserMobile selectByUserMobile(String id);

	UserTel selectByUserTel(String id);

	UserAddress selectByUserid(@Param("userid") String userid);

}