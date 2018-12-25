package com.ytgrading.dao;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.dto.CoinN;
import com.ytgrading.dto.Request;
import com.ytgrading.bean.RequestCoinBean;
import com.ytgrading.dto.RequestCoinScore;

public interface TheThirdOneMapper {
	int checkEnterpriseUser(@Param("username") String username,
			@Param("password") String password);

	RequestCoinBean getRequestCoinByCoincode(@Param("coincode") String coincode);

	RequestCoinScore getReqCoinScoreByCoincode(
			@Param("coincode") String coincode);

	Request getRequestByrequestcode(@Param("requestcode") String requestcode);

	CoinN getCoinInfoBycoinId(@Param("id") Integer id);
}
