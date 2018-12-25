package com.ytgrading.dao;

import com.ytgrading.dto.SysDistrict;
import com.ytgrading.dto.SysDistrictExample;
import com.ytgrading.dto.SysDistrictWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDistrictMapper {
    int countByExample(SysDistrictExample example);

    int deleteByExample(SysDistrictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysDistrictWithBLOBs record);

    int insertSelective(SysDistrictWithBLOBs record);

    List<SysDistrictWithBLOBs> selectByExampleWithBLOBs(SysDistrictExample example);

    List<SysDistrict> selectByExample(SysDistrictExample example);

    SysDistrictWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysDistrictWithBLOBs record, @Param("example") SysDistrictExample example);

    int updateByExampleWithBLOBs(@Param("record") SysDistrictWithBLOBs record, @Param("example") SysDistrictExample example);

    int updateByExample(@Param("record") SysDistrict record, @Param("example") SysDistrictExample example);

    int updateByPrimaryKeySelective(SysDistrictWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysDistrictWithBLOBs record);

    int updateByPrimaryKey(SysDistrict record);
}