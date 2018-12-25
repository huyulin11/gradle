package com.ytgrading.dao;

import java.util.List;

import com.ytgrading.bean.ReqSearchBean;

public interface reqSearchMapper {
	/**
	 * 查询所有的申请单
	 * 
	 * @param reqsearchbean
	 * @return申请单集合
	 */
	List<ReqSearchBean> selectAllreqsearch(ReqSearchBean reqsearchbean);

	int getreqsearchListCountById(ReqSearchBean reqsearchbean);

	String getStatisticalInfo(ReqSearchBean reqsearchbean);

	List<ReqSearchBean> selectLackreqsearch(ReqSearchBean reqsearchbean);

	int getreqsearchLackListCountById(ReqSearchBean reqsearchbean);

	String getStatisticalLackInfo(ReqSearchBean reqsearchbean);

	List<ReqSearchBean> selectServicereqsearch(ReqSearchBean reqsearchbean);

	int getreqsearchServiceListCountById(ReqSearchBean reqsearchbean);

	String getStatisticalServiceInfo(ReqSearchBean reqsearchbean);
}
