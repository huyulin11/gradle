package com.ytgrading.dao;

import com.ytgrading.dto.SysCoinMunitsvalue;
import com.ytgrading.dto.SysCoinMunitsvalueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCoinMunitsvalueMapper {
    int countByExample(SysCoinMunitsvalueExample example);

    int deleteByExample(SysCoinMunitsvalueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysCoinMunitsvalue record);

    int insertSelective(SysCoinMunitsvalue record);

    List<SysCoinMunitsvalue> selectByExample(SysCoinMunitsvalueExample example);

    SysCoinMunitsvalue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysCoinMunitsvalue record, @Param("example") SysCoinMunitsvalueExample example);

    int updateByExample(@Param("record") SysCoinMunitsvalue record, @Param("example") SysCoinMunitsvalueExample example);

    int updateByPrimaryKeySelective(SysCoinMunitsvalue record);

    int updateByPrimaryKey(SysCoinMunitsvalue record);
}