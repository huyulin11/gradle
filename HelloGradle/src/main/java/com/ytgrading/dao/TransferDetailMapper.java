package com.ytgrading.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.bean.LogisticsTransferBean;

public interface TransferDetailMapper { 
	List<LogisticsTransferBean> selectgetByGoodid(@Param("goodid") String goodid ); 

}
