package com.ytgrading.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.bean.TransferGoods;

public interface HandOverMapper {
	public List<TransferGoods> SearchCheckAllHandover(@Param("processNum") String processNum, @Param("entityType")String entityType,
			@Param("internalstates")String internalstates, @Param("goodno")String goodno,@Param("usercode")String usercode, @Param("page")int page,
			@Param("pageSize")int pageSize);
	TransferGoods SearchCheckAllHandoverCount(@Param("processNum") String processNum, @Param("entityType")String entityType,
			@Param("internalstates")String internalstates, @Param("goodno")String goodno,@Param("usercode")String usercode);
}
