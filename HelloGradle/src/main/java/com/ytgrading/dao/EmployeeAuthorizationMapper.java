package com.ytgrading.dao;

import com.ytgrading.dto.EmployeeAuthorization;
import com.ytgrading.dto.EmployeeAuthorizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeAuthorizationMapper {
    int countByExample(EmployeeAuthorizationExample example);

    int deleteByExample(EmployeeAuthorizationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeAuthorization record);

    int insertSelective(EmployeeAuthorization record);

    List<EmployeeAuthorization> selectByExample(EmployeeAuthorizationExample example);

    EmployeeAuthorization selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeAuthorization record, @Param("example") EmployeeAuthorizationExample example);

    int updateByExample(@Param("record") EmployeeAuthorization record, @Param("example") EmployeeAuthorizationExample example);

    int updateByPrimaryKeySelective(EmployeeAuthorization record);

    int updateByPrimaryKey(EmployeeAuthorization record);
}