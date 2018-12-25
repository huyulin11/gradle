package com.ytgrading.dao;

import com.ytgrading.dto.SysBank;
import com.ytgrading.dto.SysBankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysBankMapper {
    int countByExample(SysBankExample example);

    int deleteByExample(SysBankExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysBank record);

    int insertSelective(SysBank record);

    List<SysBank> selectByExampleWithBLOBs(SysBankExample example);

    List<SysBank> selectByExample(SysBankExample example);

    SysBank selectByPrimaryKey(String id);
    
    int updateByExampleSelective(@Param("record") SysBank record, @Param("example") SysBankExample example);

    int updateByExampleWithBLOBs(@Param("record") SysBank record, @Param("example") SysBankExample example);

    int updateByExample(@Param("record") SysBank record, @Param("example") SysBankExample example);

    int updateByPrimaryKeySelective(SysBank record);

    int updateByPrimaryKeyWithBLOBs(SysBank record);
}