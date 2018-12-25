package com.ytgrading.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.bean.CoinChart;
import com.ytgrading.bean.CoinInfo;
import com.ytgrading.bean.Entityview;
import com.ytgrading.bean.RequestCoinBean;
import com.ytgrading.bean.Review;
import com.ytgrading.bean.SearchScore;
import com.ytgrading.bean.Statement;

public interface SuitMapper {

	/**
	 * 
	 * @Title:
	 * @Description: 查询Coin信息(from coin)
	 * @return List<Review> 返回类型
	 * @throws
	 */
	List<Review> getCoin(Entityview entityview);

	public List<Statement> getStatementListByReqCode(
			@Param("requestcode") int requestcode);

	// 查询金银币request_detail
	List<Review> selectDetail(@Param("id") String id);
	
	List<RequestCoinBean> selectCoin(String requestid);
	
	List<SearchScore> selectSecondScores(String requestid);
	
	List<SearchScore> selectSearchScores(@Param("requestid") String requestid,
			@Param("scoreby") String scoreby);
	
	List<CoinChart> getPrintData(@Param("requestCode") String requestCode,
			@Param("country") String country);// 获得打印标签数据金银币
	
	List<CoinInfo> getCoinInfoListByCode(@Param("coincode") String coincode);
	
	List<CoinChart> getChartCoins(String requestCode);
	
}
