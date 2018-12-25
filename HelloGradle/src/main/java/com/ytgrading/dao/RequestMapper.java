package com.ytgrading.dao;

import com.ytgrading.bean.RequestCoinBean;
import com.ytgrading.dto.Request;
import com.ytgrading.dto.RequestExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RequestMapper {
    int countByExample(RequestExample example);

    int deleteByExample(RequestExample example);

    int deleteByPrimaryKey(String id);

    int insert(Request record);

    int insertSelective(Request record);

    List<Request> selectByExample(RequestExample example);

    Request selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Request record, @Param("example") RequestExample example);

    int updateByExample(@Param("record") Request record, @Param("example") RequestExample example);

    int updateByPrimaryKeySelective(Request record);

    int updateByPrimaryKey(Request record);
    
    String[] ImgCoincode(@Param("page") int page);
    
    int ImgCount();
}