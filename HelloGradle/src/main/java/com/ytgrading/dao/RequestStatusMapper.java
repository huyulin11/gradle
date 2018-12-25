package com.ytgrading.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.dto.RequestStatus;
import com.ytgrading.dto.RequestStatusExample;

public interface RequestStatusMapper {
    int countByExample(RequestStatusExample example);

    int deleteByExample(RequestStatusExample example);

    int deleteByPrimaryKey(String id);

    int insert(RequestStatus record);

    int insertSelective(RequestStatus record);

    List<RequestStatus> selectByExample(RequestStatusExample example);

    RequestStatus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RequestStatus record, @Param("example") RequestStatusExample example);

    int updateByExample(@Param("record") RequestStatus record, @Param("example") RequestStatusExample example);

    int updateByPrimaryKeySelective(RequestStatus record);

    int updateByPrimaryKey(RequestStatus record);
        
    int count(RequestStatus requestStatus);
    
    int allCount(Map<String, String> hashMap);
}