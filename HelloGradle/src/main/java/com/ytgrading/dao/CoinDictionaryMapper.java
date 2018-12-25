package com.ytgrading.dao;

import com.ytgrading.dto.CoinDictionary;
import com.ytgrading.dto.CoinDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoinDictionaryMapper {
    int countByExample(CoinDictionaryExample example);

    int deleteByExample(CoinDictionaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoinDictionary record);

    int insertSelective(CoinDictionary record);

    List<CoinDictionary> selectByExample(CoinDictionaryExample example);

    CoinDictionary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoinDictionary record, @Param("example") CoinDictionaryExample example);

    int updateByExample(@Param("record") CoinDictionary record, @Param("example") CoinDictionaryExample example);

    int updateByPrimaryKeySelective(CoinDictionary record);

    int updateByPrimaryKey(CoinDictionary record);
}