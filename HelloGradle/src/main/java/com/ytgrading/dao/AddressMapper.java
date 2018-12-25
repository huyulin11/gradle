package com.ytgrading.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.dto.SysCity;
import com.ytgrading.dto.SysDistrict;
import com.ytgrading.dto.SysProvince;
import com.ytgrading.dto.UserAddress;

public interface AddressMapper {

	/**
	 * 
	 * @Title:
	 * @Description: 查找用户地址
	 * @return UserAddress 返回类型
	 * @throws
	 */
	UserAddress selectByKey(String id);

	/**
	 * @Title:
	 * @Description: 查找省份
	 * @return List<SysDict> 返回类型
	 * @throws
	 */
	List<SysProvince> getAllProvince(@Param("parentid") int parentid);

	/**
	 * 
	 * @Title:
	 * @Description: 查找城市
	 * @return List<SysCity> 返回类型
	 * @throws
	 */
	List<SysCity> getAllCity(@Param("parentid") int parentid);

	/**
	 * 
	 * @Title:
	 * @Description: 查找区县
	 * @return List<SysDistrict> 返回类型
	 * @throws
	 */
	List<SysDistrict> getAllDistrict(@Param("parentid") int parentid);
	
	List selectCountry();
	
	List selectProvince(String parentid);
	
	List selectCity(String parentid);
	
	List selectDistrict(String parentid);
	
	/**
	 * 获取id所对应的国家名，如：中国
	 * @param countryid
	 * @return
	 */
	String getCountry(int countryid);
	
	/**
	 * 获取id所对应的省，如：上海
	 */
	String getProvince(int provinceid);
	
	/**
	 * 获取id所对应市：如 苏州
	 */
	String getCity(int cityid);
	
	/**
	 * 获取id所对应的地区 ，如：浦东新区
	 */
	String getDistrict(int districtid);
	
	
	List searchAddress(@Param("keywords") String keywords); 
}
