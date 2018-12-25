package com.ytgrading.dao;

import com.ytgrading.dto.RequestLog;
import com.ytgrading.dto.RequestLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RequestLogMapper {
    int countByExample(RequestLogExample example);

    int deleteByExample(RequestLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(RequestLog record);

    int insertSelective(RequestLog record);

    List<RequestLog> selectByExample(RequestLogExample example);

    RequestLog selectByPrimaryKey(@Param("id")String id,@Param("userid")String userid);

    int updateByExampleSelective(@Param("record") RequestLog record, @Param("example") RequestLogExample example);

    int updateByExample(@Param("record") RequestLog record, @Param("example") RequestLogExample example);

    int updateByPrimaryKeySelective(RequestLog record);

    int updateByPrimaryKey(RequestLog record);
}