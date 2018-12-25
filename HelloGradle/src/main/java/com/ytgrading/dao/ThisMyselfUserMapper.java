package com.ytgrading.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ytgrading.bean.RequestSel;
import com.ytgrading.bean.UserAddressSel;
import com.ytgrading.bean.WalletRefundSel;
import com.ytgrading.bean.WalletRemitSel;
import com.ytgrading.dto.PayRequestReceive;
import com.ytgrading.dto.Request;
import com.ytgrading.dto.UserAddress;
import com.ytgrading.dto.Wallet;
import com.ytgrading.dto.WalletRemit;

public interface ThisMyselfUserMapper {

	// ---------------UserAddress-----------
	List<UserAddress> selectUserAddressList(UserAddressSel userAddressSel);

	List<UserAddress> selectUserAddressListByUserid(String userid);

	int getUserAddressCount(UserAddress userAddress);

	int delSelectedRow(@Param("scope") String[] scope);

	int updateCurDefaultUserAddress(@Param("userAddressId") String userAddressId);

	int updateOldDefault(@Param("userAddressId") String userAddressId,
			@Param("userid") String userid);

	int updateDefaultUserAddress(@Param("addressid") String addressid,
			@Param("userid") String userid);

	int UpdateUserDefaultAddress(@Param("addressid") String addressid,
			@Param("userid") String userid);

	UserAddress getUserAddressbyuserId(@Param("userId") String userId);

	public int validDefaultuserAddressCount(@Param("userid") String userid);

	public int removeDefaultUserAddress(@Param("userid") String userid);

	public String getProvinceName(@Param("id") int id);

	public String getCityName(@Param("id") int id);

	public String getAreaName(@Param("id") int id);

	public Request selectRequestByReqcode(
			@Param("requestcode") String requestcode);

	public void insertRevokeRequest(Request revokeRequest);

	public int addDelRequest(@Param("employeeid") String employeeid,
			@Param("requestcode") String requestcode);

	public int delRequest(@Param("requestcode") String requestcode);

	// ----------------WalletRemit------------
	public int getWalletRemitCount(WalletRemitSel walletRemitSel);

	public List<WalletRemitSel> selectWalletRemitList(
			WalletRemitSel walletRemitSel);

	int delSelectedRowRemit(@Param("scope") String[] scope);

	// 获取汇款记录

	public int getRemitCount(@Param("userId") String userId);

	// 获取汇款总金额
	public Double getTotalRemit(@Param("userId") String userId);

	public int isdisposeRemit(@Param("scope") String[] scope);

	/**
	 * 财务处理汇款通知
	 * 
	 * @param remitno
	 * @return
	 */
	public int remitDispose(@Param("remitno") String remitno);

	public int iscancelRemit(@Param("scope") String[] scope,
			@Param("employeeid") int employeeid,
			@Param("confirmdate") Date confirmdate);

	/**
	 * 财务作废汇款告知
	 * 
	 * @param remitno
	 * @param employeeid
	 * @param confirmdate
	 * @return
	 */
	public int remitCancel(@Param("remitno") String remitno,
			@Param("employeeid") String employeeid,
			@Param("confirmdate") Date confirmdate);

	public int isconfirmRemit(@Param("remitNo") String remitNo,
			@Param("employeeid") int employeeid,
			@Param("confirmdate") Date confirmdate,
			@Param("confirmamount") Double confirmamount);

	// 财务查看汇款情况
	public int getFinancialRemitCount(@Param("status") String status);

	public Double getTotalFinancialRemit(@Param("status") String status);

	// ------WalletRefoud----
	public int getWalletRefundCount(WalletRefundSel walletRefundsel);

	public List<WalletRefundSel> selectWalletRefundList(
			WalletRefundSel walletRefundSel);

	public List<WalletRefundSel> selectWalletRefundDetail(
			WalletRefundSel walletRefundSel);

	int delSelectedRowRefund(@Param("refundno") String refundno);

	// 获取退款记录
	public int getRefundCount(@Param("userId") String userId);

	// 获取扣款记录
	public int getRefundCountKk(@Param("userId") String userId);

	// 获取退款总金额
	public Double getTotalRefund(@Param("userId") String userId);

	// 获取扣款总金额
	public Double getTotalRefundKk(@Param("userId") String userId);

	public int isdisposeRefund(@Param("scope") String[] scope);

	public int iscancelRefund(@Param("refundno") String refundno);

	public int isconfirmRefund(@Param("scope") String[] scope);

	// 财务查看退款情况
	public Double getTotalFinancialrefund(@Param("status") String status);

	public int getFinancialRefundCount(@Param("status") String status);

	// ------Request----
	public int getRequestCount(RequestSel requestSel);

	public List<Request> selectRequestList(RequestSel requestSel);

	public int delSelectedRowRequest(@Param("scope") String[] scope,
			@Param("delflag") String delflag);

	public int confirmSelectedRowRequest(
			@Param("requestcode") String requestcode,
			@Param("updatetime") String updatetime,
			@Param("duetime") String duetime);

	// 财务增加收费检测评审单号
	public Request checkRequestcode(@Param("requestcode") String requestcode);

	// Pay_Request_Receive
	int insertPayRequestReceive(PayRequestReceive payReceive);

	/**
	 * 撤销当前汇款通知
	 * 
	 * @param remitno
	 * @return
	 */
	int delRemit(@Param("remitno") String remitno);

	WalletRemit getWalletRemit(int remitno);

}
