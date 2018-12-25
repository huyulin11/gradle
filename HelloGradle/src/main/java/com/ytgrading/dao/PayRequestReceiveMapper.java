package com.ytgrading.dao;

import com.ytgrading.dto.PayRequestReceive;
import com.ytgrading.dto.PayRequestReceiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayRequestReceiveMapper {
    int countByExample(PayRequestReceiveExample example);

    int deleteByExample(PayRequestReceiveExample example);

    int deleteByPrimaryKey(String id);

    int insert(PayRequestReceive record);

    int insertSelective(PayRequestReceive record);

    List<PayRequestReceive> selectByExample(PayRequestReceiveExample example);

    PayRequestReceive selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PayRequestReceive record, @Param("example") PayRequestReceiveExample example);

    int updateByExample(@Param("record") PayRequestReceive record, @Param("example") PayRequestReceiveExample example);

    int updateByPrimaryKeySelective(PayRequestReceive record);

    int updateByPrimaryKey(PayRequestReceive record);
}