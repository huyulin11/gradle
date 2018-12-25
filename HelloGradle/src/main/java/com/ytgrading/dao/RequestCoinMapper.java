package com.ytgrading.dao;

import com.ytgrading.bean.RequestCoinBean;
import com.ytgrading.dto.RequestCoinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RequestCoinMapper {
	int countByExample(RequestCoinExample example);

	int deleteByExample(RequestCoinExample example);

	int deleteByPrimaryKey(String id);

	int insert(RequestCoinBean record);

	int insertSelective(RequestCoinBean record);

	List<RequestCoinBean> selectByExampleWithBLOBs(RequestCoinExample example);

	List<RequestCoinBean> selectByExample(RequestCoinExample example);

	RequestCoinBean selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") RequestCoinBean record,
			@Param("example") RequestCoinExample example);

	int updateByExampleWithBLOBs(@Param("record") RequestCoinBean record,
			@Param("example") RequestCoinExample example);

	int updateByExample(@Param("record") RequestCoinBean record,
			@Param("example") RequestCoinExample example);

	int updateByPrimaryKeySelective(RequestCoinBean record);

	int updateByPrimaryKeyWithBLOBs(RequestCoinBean record);

	int updateByPrimaryKey(RequestCoinBean record);
}