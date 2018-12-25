package com.ytgrading.dao;

import java.util.List;

import com.ytgrading.dto.EmailAddress;


public interface EmailAddressMapper {
	List<EmailAddress> findAll();
	/*
	 * 根据邮箱后缀获取邮箱完整地址
	 */
	EmailAddress selectEmailAddress(String suffix);
}
