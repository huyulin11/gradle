package com.ytgrading.dao;

import com.ytgrading.dto.SysCoinMquality;
import com.ytgrading.dto.SysCoinMqualityExample;
import com.ytgrading.dto.SysCoinMqualityWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCoinMqualityMapper {
    int countByExample(SysCoinMqualityExample example);

    int deleteByExample(SysCoinMqualityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysCoinMqualityWithBLOBs record);

    int insertSelective(SysCoinMqualityWithBLOBs record);

    List<SysCoinMqualityWithBLOBs> selectByExampleWithBLOBs(SysCoinMqualityExample example);

    List<SysCoinMquality> selectByExample(SysCoinMqualityExample example);

    SysCoinMqualityWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysCoinMqualityWithBLOBs record, @Param("example") SysCoinMqualityExample example);

    int updateByExampleWithBLOBs(@Param("record") SysCoinMqualityWithBLOBs record, @Param("example") SysCoinMqualityExample example);

    int updateByExample(@Param("record") SysCoinMquality record, @Param("example") SysCoinMqualityExample example);

    int updateByPrimaryKeySelective(SysCoinMqualityWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysCoinMqualityWithBLOBs record);

    int updateByPrimaryKey(SysCoinMquality record);
}