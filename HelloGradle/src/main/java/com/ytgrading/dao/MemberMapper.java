/** 
 * 
 * Copyright (c) 2013 , FandaSoft and/or its affiliates. All rights reserved. 
 * FandaSoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.ytgrading.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.bean.CoinChart;
import com.ytgrading.bean.CoinFacevalue;
import com.ytgrading.bean.Entityview;
import com.ytgrading.bean.Munits;
import com.ytgrading.bean.RequestCoinBean;
import com.ytgrading.bean.RequestDetailBean;
import com.ytgrading.bean.Review;
import com.ytgrading.bean.SearchScore;
import com.ytgrading.dto.Request;
import com.ytgrading.dto.RequestCoinScore;
import com.ytgrading.dto.SysCity;
import com.ytgrading.dto.SysCoinMaterial;
import com.ytgrading.dto.SysCoinMquality;
import com.ytgrading.dto.SysCoinMunits;
import com.ytgrading.dto.SysDistrict;
import com.ytgrading.dto.SysProvince;
import com.ytgrading.dto.UserAddress;
import com.ytgrading.dto.UserLogin;
import com.ytgrading.dto.Users;

/**
 * 
 * @Title:MemberMapper
 * @Description:
 * @Copyright:Copyright (c) 2013
 * @Company:FandaSoft
 * @Date:2013-4-27
 * @author jiangxx
 * @version 1.0
 */
public interface MemberMapper {
	/**
	 * 
	 * @Title:
	 * @Description: 查找用户
	 * @return User 返回类型
	 * @throws
	 */
	Users selectByPrimaryKey(String id);

	/**
	 * 
	 * @Title:
	 * @Description: 查找申请单
	 * @return int 返回类型
	 * @throws
	 */
	int count(Request request);

	/**
	 * 
	 * @Title:
	 * @Description:查找受理中申请单
	 * @return int 返回类型
	 * @throws
	 */
	int allCount(Map<String, String> hashMap);

	/**
	 * 
	 * @Title:
	 * @Description: 汇款
	 * @return int 返回类型
	 * @throws
	 */
	int getAllCount(String userid);

	/**
	 * 
	 * @Title:
	 * @Description: 退款
	 * @return int 返回类型
	 * @throws
	 */
	int getCount(String userid);

	/**
	 * 
	 * @Title:
	 * @Description: 查找用户地址
	 * @return UserAddress 返回类型
	 * @throws
	 */
	UserAddress selectByKey(String id);

	/**
	 * 获取面值
	 * 
	 * @return
	 */
	List<CoinFacevalue> getAllfacevalue();

	/**
	 * 
	 * @Title:
	 * @Description: 查找省份
	 * @return List<SysDict> 返回类型
	 * @throws
	 */
	List<SysProvince> getAllProvince(@Param("parentid") String parentid);

	/**
	 * 
	 * @Title:
	 * @Description: 查找城市
	 * @return List<SysCity> 返回类型
	 * @throws
	 */
	List<SysCity> getAllCity(@Param("parentid") String parentid);

	/**
	 * 
	 * @Title:
	 * @Description: 查找区县
	 * @return List<SysDistrict> 返回类型
	 * @throws
	 */
	List<SysDistrict> getAllDistrict(@Param("parentid") String parentid);

	/**
	 * 
	 * @Title:
	 * @Description: 查找符合条件的CoinList(from request_detail)
	 * @throws
	 */
	List<Review> getAllCoin(String condition);

	/**
	 * 
	 * @Title:
	 * @Description: 修改登录密码 UserLoign
	 * @return int 返回类型
	 * @throws
	 */
	int updatepassword(UserLogin record);

	/**
	 * 
	 * @Title:
	 * @Description: 修改 User
	 * @return int 返回类型
	 * @throws
	 */
	int updateUser(Users record);

	/**
	 * 
	 * @Title:
	 * @Description: 查询Count(from request_detail)
	 * @return int 返回类型
	 * @throws
	 */
	int RequestDetailCount(String requestid);

	/**
	 * 
	 * @Title:
	 * @Description: 查询材质
	 * @return List<SysCoinMaterial> 返回类型
	 * @throws
	 */
	List<SysCoinMaterial> getAllmaterial(@Param("entitytype") String entitytype);

	/**
	 * 
	 * @Title:
	 * @Description: 查询重量
	 * @return List<Munits> 返回类型
	 * @throws
	 */
	List<Munits> getAllmunits();

	/**
	 * 
	 * @Title:
	 * @Description: 查询制造质量
	 * @return List<SysCoinMquality> 返回类型
	 * @throws
	 */
	List<SysCoinMquality> getAllmquality();

	/**
	 * 
	 * @Title:
	 * @Description:
	 * @return SysCoinMunits 返回类型
	 * @throws
	 */
	SysCoinMunits getMunits(int id);

	/**
	 * 
	 * @Title:
	 * @Description: 查询Coin信息(from coin)
	 * @return List<Review> 返回类型
	 * @throws
	 */
	List<Review> getCoin(Entityview entityview);

	/**
	 * 
	 * @Title:
	 * @Description: 插入 request_detail
	 * @return int 返回类型
	 * @throws
	 */
	int insertDetail(RequestDetailBean record);

	/**
	 * 
	 * @Title:
	 * @Description: 删除 request_detail
	 * @return int 返回类型
	 * @throws
	 */
	int deleteById(String id);

	/**
	 * 
	 * @Title:
	 * @Description: 查询 UserLogin
	 * @return UserLogin 返回类型
	 * @throws
	 */
	Users selectById(String id);

	/**
	 * 
	 * @Title:
	 * @Description: 查询 Request
	 * @return Request 返回类型
	 * @throws
	 */
	Request selectRequestInfo(String requestcode);

	/**
	 * 
	 * @Title:
	 * @Description: 查询requestDetail信息
	 * @return List<Review> 返回类型
	 * @throws
	 */
	List<Review> selectDetail(String requestid);

	/**
	 * 
	 * @Title:
	 * @Description: 查询钱币信息
	 * @return List<RequestCoinBean> 返回类型
	 * @throws
	 */
	List<RequestCoinBean> selectRequestCoins(String requestid);

	/**
	 * 
	 * @Title:
	 * @Description: 保存评审结果
	 * @return int 返回类型
	 * @throws
	 */
	int insertScore(RequestCoinScore score);

	/**
	 * 
	 * @Title:
	 * @Description: 查询送评单信息,用于评审、打盒、制图时查看送评信息
	 * @return Request 返回类型
	 * @throws
	 */
	Request selectRequest(String id);

	/**
	 * 
	 * @Title:
	 * @Description: 获取一审结果
	 * @return List<SearchScore> 返回类型
	 * @throws
	 */
	List<SearchScore> selectSearchScores(@Param("requestid") String requestid,
			@Param("scoreby") String scoreby);

	/**
	 * 
	 * @Title:
	 * @Description:删除原数据
	 * @return int 返回类型
	 * @throws
	 */
	int deleteScore(@Param("id") String id,
			@Param("employeeid") String employeeid, @Param("level") String level);

	/**
	 * 
	 * @Title:
	 * @Description: 更新Request表中internalstates
	 * @return int 返回类型
	 * @throws
	 */
	int updateRequest(Request record);

	List<SearchScore> selectSecondScores(String requestid);

	List<SearchScore> selectFirstScores(@Param("requestid") String requestid,
			@Param("scoreby") String scoreby);

	List<RequestCoinBean> selectCoin(String requestid);

	/**
	 * 记录硬币最终得分
	 * 
	 * @param coincode
	 * @param score
	 * @return
	 */
	public int insertFinalScore(@Param("requestid") String requestid);
	public int insertFinalScores(@Param("requestid") String requestid);

	/**
	 * 通过硬币编号获取硬币ID
	 * 
	 * @param coincode
	 * @return
	 */
	public String getRequestCoinIdByCoinCode(@Param("coincode") String coincode);

	/**
	 * 获取打盒制图钱币信息
	 * 
	 * @param coincode
	 * @return
	 */
	public CoinChart getCoinChartInfo(String coincode);

	List<CoinChart> getChartCoins(String requestCode);

	String getRequestEntitytype(String requestCode);

	List<CoinChart> getPrintData(@Param("requestCode") String requestCode,
			@Param("country") String country);// 获得打印标签数据金银币

	/**
	 * 通过用户ID获取用户code
	 * 
	 * @param id
	 * @return
	 */
	public int getUsercodeById(@Param("id") String id);

	public Request getRequestDecs(@Param("refour") int refour,
			@Param("rethree") int rethree);

	public Request getReqByCode(int requestcode);

	public int getNewReqcode(@Param("refour") int refour,
			@Param("rethree") int rethree);

}
