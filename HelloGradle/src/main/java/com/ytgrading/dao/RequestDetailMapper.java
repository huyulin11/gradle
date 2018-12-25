package com.ytgrading.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.bean.RequestDetailBean;
import com.ytgrading.dto.RequestDetailExample;

public interface RequestDetailMapper {
    int countByExample(RequestDetailExample example);

    int deleteByExample(RequestDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(RequestDetailBean record);

    int insertSelective(RequestDetailBean record);

    List<RequestDetailBean> selectByExample(RequestDetailExample example);

    RequestDetailBean selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RequestDetailBean record, @Param("example") RequestDetailExample example);

    int updateByExample(@Param("record") RequestDetailBean record, @Param("example") RequestDetailExample example);

    int updateByPrimaryKeySelective(RequestDetailBean record);

    int updateByPrimaryKey(RequestDetailBean record);
}