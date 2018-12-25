package com.ytgrading.dao;

import com.ytgrading.dto.SysCity;
import com.ytgrading.dto.SysCityExample;
import com.ytgrading.dto.SysCityWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCityMapper {
    int countByExample(SysCityExample example);

    int deleteByExample(SysCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysCityWithBLOBs record);

    int insertSelective(SysCityWithBLOBs record);

    List<SysCityWithBLOBs> selectByExampleWithBLOBs(SysCityExample example);

    List<SysCity> selectByExample(SysCityExample example);

    SysCityWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysCityWithBLOBs record, @Param("example") SysCityExample example);

    int updateByExampleWithBLOBs(@Param("record") SysCityWithBLOBs record, @Param("example") SysCityExample example);

    int updateByExample(@Param("record") SysCity record, @Param("example") SysCityExample example);

    int updateByPrimaryKeySelective(SysCityWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysCityWithBLOBs record);

    int updateByPrimaryKey(SysCity record);
}