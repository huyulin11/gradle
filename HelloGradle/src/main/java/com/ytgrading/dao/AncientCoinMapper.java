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
import com.ytgrading.bean.SysAncientCoinBasicInfo;

public interface AncientCoinMapper {
	List<Review> selectAncientCoinDetail(@Param("id") String id);

	List<SysAncientCoinBasicInfo> getAncientCoinData(Entityview entityview);

	List<Statement> getAncientCoinStatementListByReqCode(
			@Param("requestcode") int requestcode);

	CoinInfo getAncientCoinInfo(String requestcoinid);

	List<CoinInfo> getAncientCoinInfoByCode(@Param("coincode") String coincode);

	List<CoinChart> getPrintData(@Param("requestCode") String requestCode);// 获得打印标签数据古币

	List<SearchScore> getSecondAncientCoinScores(String requestid);

	List<SearchScore> getFirstAncientCoinScores(
			@Param("requestid") String requestid,
			@Param("scoreby") String scoreby);

	List<RequestCoinBean> getAncientCoin(String requestid);

}
