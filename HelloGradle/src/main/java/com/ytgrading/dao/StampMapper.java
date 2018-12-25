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
import com.ytgrading.bean.SysStampBasicInfo;

public interface StampMapper {
	// 查询古钱币request_detail
	List<Review> selectStampDetail(@Param("id") String id);

	List<SysStampBasicInfo> getStampData(Entityview entityview);

	List<Statement> getStampStatementListByReqCode(
			@Param("requestcode") int requestcode);

	CoinInfo getStampInfo(String requestcoinid);

	List<CoinInfo> getStampInfoByCode(@Param("coincode") String coincode);

	List<CoinChart> getPrintData(@Param("requestCode") String requestCode);// 获得打印标签数据古币

	List<SearchScore> getSecondStampScores(String requestid);

	List<SearchScore> getFirstStampScores(@Param("requestid") String requestid,
			@Param("scoreby") String scoreby);

	List<RequestCoinBean> getStamp(String requestid);

	SysStampBasicInfo selectStampInfo(int id);
}
