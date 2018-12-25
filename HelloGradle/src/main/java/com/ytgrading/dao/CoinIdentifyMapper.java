package com.ytgrading.dao;

import com.ytgrading.dto.CoinIdentify;
import com.ytgrading.dto.CoinIdentifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoinIdentifyMapper {
    int countByExample(CoinIdentifyExample example);

    int deleteByExample(CoinIdentifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoinIdentify record);

    int insertSelective(CoinIdentify record);

    List<CoinIdentify> selectByExample(CoinIdentifyExample example);

    CoinIdentify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoinIdentify record, @Param("example") CoinIdentifyExample example);

    int updateByExample(@Param("record") CoinIdentify record, @Param("example") CoinIdentifyExample example);

    int updateByPrimaryKeySelective(CoinIdentify record);

    int updateByPrimaryKey(CoinIdentify record);
}