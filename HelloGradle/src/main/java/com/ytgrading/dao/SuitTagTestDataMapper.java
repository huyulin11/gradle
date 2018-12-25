package com.ytgrading.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.bean.CoinChart;

public interface SuitTagTestDataMapper {
	List<CoinChart> getChartSuits(@Param("requestCode")String requestcode);
}
