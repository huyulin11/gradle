package com.ytgrading.dao;

import com.ytgrading.dto.SysCoinMaterial;
import com.ytgrading.dto.SysCoinMaterialExample;
import com.ytgrading.dto.SysCoinMaterialWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCoinMaterialMapper {
    int countByExample(SysCoinMaterialExample example);

    int deleteByExample(SysCoinMaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysCoinMaterialWithBLOBs record);

    int insertSelective(SysCoinMaterialWithBLOBs record);

    List<SysCoinMaterialWithBLOBs> selectByExampleWithBLOBs(SysCoinMaterialExample example);

    List<SysCoinMaterial> selectByExample(SysCoinMaterialExample example);

    SysCoinMaterialWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysCoinMaterialWithBLOBs record, @Param("example") SysCoinMaterialExample example);

    int updateByExampleWithBLOBs(@Param("record") SysCoinMaterialWithBLOBs record, @Param("example") SysCoinMaterialExample example);

    int updateByExample(@Param("record") SysCoinMaterial record, @Param("example") SysCoinMaterialExample example);

    int updateByPrimaryKeySelective(SysCoinMaterialWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysCoinMaterialWithBLOBs record);

    int updateByPrimaryKey(SysCoinMaterial record);
}