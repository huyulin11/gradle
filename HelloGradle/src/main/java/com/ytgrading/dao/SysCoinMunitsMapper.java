package com.ytgrading.dao;

import com.ytgrading.dto.SysCoinMunits;
import com.ytgrading.dto.SysCoinMunitsExample;
import com.ytgrading.dto.SysCoinMunitsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCoinMunitsMapper {
    int countByExample(SysCoinMunitsExample example);

    int deleteByExample(SysCoinMunitsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysCoinMunitsWithBLOBs record);

    int insertSelective(SysCoinMunitsWithBLOBs record);

    List<SysCoinMunitsWithBLOBs> selectByExampleWithBLOBs(SysCoinMunitsExample example);

    List<SysCoinMunits> selectByExample(SysCoinMunitsExample example);

    SysCoinMunitsWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysCoinMunitsWithBLOBs record, @Param("example") SysCoinMunitsExample example);

    int updateByExampleWithBLOBs(@Param("record") SysCoinMunitsWithBLOBs record, @Param("example") SysCoinMunitsExample example);

    int updateByExample(@Param("record") SysCoinMunits record, @Param("example") SysCoinMunitsExample example);

    int updateByPrimaryKeySelective(SysCoinMunitsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysCoinMunitsWithBLOBs record);

    int updateByPrimaryKey(SysCoinMunits record);
}