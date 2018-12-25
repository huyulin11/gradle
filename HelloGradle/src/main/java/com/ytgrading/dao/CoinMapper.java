package com.ytgrading.dao;

import com.ytgrading.dto.Coin;
import com.ytgrading.dto.CoinExample;
import com.ytgrading.dto.CoinWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoinMapper {
    int countByExample(CoinExample example);
    int deleteByExample(CoinExample example);
    int deleteByPrimaryKey(Integer id);
    int insert(CoinWithBLOBs record);
    int insertSelective(CoinWithBLOBs record);
    List<CoinWithBLOBs> selectByExampleWithBLOBs(CoinExample example);
    List<Coin> selectByExample(CoinExample example);
    CoinWithBLOBs selectByPrimaryKey(Integer id);
    int updateByExampleSelective(@Param("record") CoinWithBLOBs record, @Param("example") CoinExample example);
    int updateByExampleWithBLOBs(@Param("record") CoinWithBLOBs record, @Param("example") CoinExample example);
    int updateByExample(@Param("record") Coin record, @Param("example") CoinExample example);
    int updateByPrimaryKeySelective(CoinWithBLOBs record);
    int updateByPrimaryKeyWithBLOBs(CoinWithBLOBs record);
    int updateByPrimaryKey(Coin record);
}