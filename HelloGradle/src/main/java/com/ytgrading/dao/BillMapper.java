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
import com.ytgrading.bean.SysBillBasicInfo;

public interface BillMapper {

	List<Review> selectBillDetail(@Param("id") String id);

	List<CoinInfo> getBillInfoByCode(@Param("coincode") String coincode);

	CoinInfo getBillInfo(String requestcoinid);

	public List<Statement> getStatementBillListByReqCode(
			@Param("requestcode") int requestcode);

	List<SysBillBasicInfo> getBillData(Entityview entityview);

	List<SearchScore> selectBillScores(@Param("requestid") String requestid,
			@Param("scoreby") String scoreby);

	List<SearchScore> selectSecondBillScores(String requestid);

	List<RequestCoinBean> selectBills(String requestid);

	List<CoinChart> getChartBills(String requestCode);

	List<CoinChart> getPrintData(@Param("requestCode") String requestCode,
			@Param("country") String country);

	List<CoinChart> getPrintDataBack(@Param("requestCode") String requestCode,
			@Param("country") String country);

}
