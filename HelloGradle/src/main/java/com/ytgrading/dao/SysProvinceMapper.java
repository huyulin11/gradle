package com.ytgrading.dao;

import com.ytgrading.dto.SysProvince;
import com.ytgrading.dto.SysProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ytgrading.dto.SysProvinceWithBLOBs;

public interface SysProvinceMapper {

	int countByExample(SysProvinceExample example);

	int deleteByExample(SysProvinceExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SysProvinceWithBLOBs record);

	int insertSelective(SysProvinceWithBLOBs record);

	List<SysProvinceWithBLOBs> selectByExampleWithBLOBs(
			SysProvinceExample example);

	List<SysProvince> selectByExample(SysProvinceExample example);

	SysProvinceWithBLOBs selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") SysProvinceWithBLOBs record,
			@Param("example") SysProvinceExample example);

	int updateByExampleWithBLOBs(@Param("record") SysProvinceWithBLOBs record,
			@Param("example") SysProvinceExample example);

	int updateByExample(@Param("record") SysProvince record,
			@Param("example") SysProvinceExample example);

	int updateByPrimaryKeySelective(SysProvinceWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(SysProvinceWithBLOBs record);

	int updateByPrimaryKey(SysProvince record);
}