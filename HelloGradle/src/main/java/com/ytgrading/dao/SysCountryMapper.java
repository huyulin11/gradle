package com.ytgrading.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.dto.SysCountry;

public interface SysCountryMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(SysCountry record);

	int insertSelective(SysCountry record);

	SysCountry selectByPrimaryKey(Integer id);

	SysCountry selectACountry(@Param("id") int id);

	List<SysCountry> getAllCountry();

}