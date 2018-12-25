package com.ytgrading.dao;

import com.ytgrading.dto.CoinImg;
import com.ytgrading.dto.CoinImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoinImgMapper {
    int countByExample(CoinImgExample example);

    int deleteByExample(CoinImgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoinImg record);

    int insertSelective(CoinImg record);

    List<CoinImg> selectByExample(CoinImgExample example);

    CoinImg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoinImg record, @Param("example") CoinImgExample example);

    int updateByExample(@Param("record") CoinImg record, @Param("example") CoinImgExample example);

    int updateByPrimaryKeySelective(CoinImg record);
    
    int updateByPrimaryKey(CoinImg record);
}