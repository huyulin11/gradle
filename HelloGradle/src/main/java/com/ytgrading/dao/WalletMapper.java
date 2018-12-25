package com.ytgrading.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.dto.Wallet;

public interface WalletMapper {
	int insert(Wallet record);

	/**
	 * 查询电子钱包可用不可用
	 */
	String getWallet(@Param("userid") String userid);

	/**
	 * 获取电子钱包余额
	 * 
	 * @param userid
	 * @return
	 */
	BigDecimal getBalance(@Param("userid") String userid);

	int updatePaypassword(Wallet record);

	// 检查邮件激活时间是否过期
	Wallet seleceWallet(@Param("userid") String userid);

	// 充值增加金额
	int walletMoneyPlus(@Param("userid") String userid,
			@Param("amount") BigDecimal amount);

	// 充值增加金额
	int walletMoneyPlus(@Param("userid") String userid,
			@Param("amount") Double amount);

	// 充值减少金额
	int walletMoneyMinus(@Param("userid") String userid,
			@Param("amount") BigDecimal amount);

	/**
	 * 
	 * @Title:
	 * @Description: 修改支付密码
	 * @return int 返回类型
	 * @throws
	 */
	int updatePay(Wallet wallet);

	// 检查邮件激活时间是否过期
	int updatreDeflag(@Param("userid") String userid,
			@Param("delflag") String delflag);

	/**
	 * 为wallet添加事务，以userid为限制条件，锁定该记录
	 * 
	 * @param userid
	 * @return
	 */
	Wallet addTransForWallet(@Param("userid") String userid);

	/**
	 * 
	 * @Title:
	 * @Description: 查询 Wallet
	 * @return Wallet 返回类型
	 * @throws
	 */
	Wallet selectByUserid(String id);

	// 激活电子钱包
	public int activateWallet(Wallet wallet);

	// ------wallet----
	public Wallet getMyWallet(@Param("userId") String userId);

	// 修改金额前，锁表，返回id
	public String tolockWallet(@Param("userId") String userId);

	// 用户注册后，添加一条钱包记录未激活
	public int insertWallet(Wallet wallet);

}