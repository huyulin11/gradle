package com.ytgrading.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.dto.Ratingreason;

public interface RatingreasonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ratingreason record);

    int insertSelective(Ratingreason record);

    Ratingreason selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ratingreason record);

    int updateByPrimaryKey(Ratingreason record);
    
    List<Ratingreason> getRatingreason(@Param("reasonType") String reasonType,@Param("entitytype")String entitytype);
}