package com.ytgrading.dao;

import com.ytgrading.dto.StockOut;
import com.ytgrading.dto.StockOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockOutMapper {
    int countByExample(StockOutExample example);

    int deleteByExample(StockOutExample example);

    int deleteByPrimaryKey(String id);

    int insert(StockOut record);

    int insertSelective(StockOut record);

    List<StockOut> selectByExample(StockOutExample example);

    StockOut selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StockOut record, @Param("example") StockOutExample example);

    int updateByExample(@Param("record") StockOut record, @Param("example") StockOutExample example);

    int updateByPrimaryKeySelective(StockOut record);

    int updateByPrimaryKey(StockOut record);
}