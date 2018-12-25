package com.ytgrading.dao;

import com.ytgrading.dto.UserValidity;
import com.ytgrading.dto.UserValidityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserValidityMapper {
    int countByExample(String loginname);

    int deleteByExample(UserValidityExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserValidity record);

    int insertSelective(UserValidity record);

    List<UserValidity> selectByExample(UserValidityExample example);

    UserValidity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserValidity record, @Param("example") UserValidityExample example);

    int updateByExample(@Param("record") UserValidity record, @Param("example") UserValidityExample example);

    int updateByPrimaryKeySelective(UserValidity record);

    int updateByPrimaryKey(UserValidity record);
    
    UserValidity selectByInfo(@Param("name") String name,@Param("id") String id);
}