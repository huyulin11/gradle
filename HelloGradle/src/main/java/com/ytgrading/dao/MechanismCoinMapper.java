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
import com.ytgrading.bean.SysMechanismCoinBasicInfo;

public interface MechanismCoinMapper {
	List<Review> selectMechanismCoinDetail(@Param("id") String id);

	List<SysMechanismCoinBasicInfo> getMechanismCoinData(Entityview entityview);

	List<CoinInfo> getMechanismCoinInfoByCode(@Param("coincode") String coincode);

	CoinInfo getMechanismCoinInfo(String requestcoinid);

	public List<Statement> getMechanismCoinListByReqCode(
			@Param("requestcode") int requestcode);

	List<SearchScore> getFirstMechanismCoinScores(
			@Param("requestid") String requestid,
			@Param("scoreby") String scoreby);

	List<SearchScore> getSecondMechanismCoinScores(String requestid);

	List<RequestCoinBean> getMechanismCoin(String requestid);

	List<CoinChart> getChartMechanismCoins(String requestCode);

	List<CoinChart> getPrintData(@Param("requestCode") String requestCode);// 获得打印标签数据机制币

}
