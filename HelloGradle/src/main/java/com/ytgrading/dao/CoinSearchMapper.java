package com.ytgrading.dao;

import java.util.List;

import com.ytgrading.bean.CoinDetail;

public interface CoinSearchMapper {
	/**
	 * 通过申请单号查询钱币详细信息
	 * @param number
	 * @return
	 */
	List<CoinDetail> selectCoinDetailByNumber(String number);
	/**
	 * 通过关键字（被钱币表中detailstr字段所包含）搜索钱币详情
	 */
	List<CoinDetail> selectCoinDetailByKeyWord(String keyword);
}
