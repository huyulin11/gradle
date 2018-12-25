package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.Date;

public class WalletJournal implements Cloneable {
	private String id;
	private String walletid;
	private String type;
	private BigDecimal amount;
	private String unit;
	private BigDecimal reallyamount;
	private Date occurdate;
	private Date ipsbanktime;
	private String currencyType;
	private String bankbillno;
	private String ipsbillno;
	private String billno;
	private String updateby;
	private String userid;
	private String userYTid;// 用户编号（非LIFERAY用户编号，源泰业务系统用户编号）
	private String delflag;
	private String status;
	private String fundFlowStatus; // 资金流转状态：0.钱包支付1.现金充值。2.第三方平台充值。3线下汇款。4.pos机充值。5.现金支付。6.第三方支付。7.线下汇款支付。8.pos机支付、9.回退退款。10.撤销退款。11.线下退款
	private String paymentMethod; // 支付方式
	private String bankcarCode; // 银行卡号
	private String voucherNO; // pos凭证号
	private String tradeRemark; // 交易备注
	private String username;
	private String updatebyName;
	private String operateTime;
	private String userMoblie;
	private String userEmail;

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUpdatebyName() {
		return updatebyName;
	}

	public void setUpdatebyName(String updatebyName) {
		this.updatebyName = updatebyName;
	}

	public String getFundFlowStatus() {
		return fundFlowStatus;
	}

	public void setFundFlowStatus(String fundFlowStatus) {
		this.fundFlowStatus = fundFlowStatus;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getBankcarCode() {
		return bankcarCode;
	}

	public void setBankcarCode(String bankcarCode) {
		this.bankcarCode = bankcarCode;
	}

	public String getVoucherNO() {
		return voucherNO;
	}

	public void setVoucherNO(String voucherNO) {
		this.voucherNO = voucherNO;
	}

	public String getTradeRemark() {
		return tradeRemark;
	}

	public void setTradeRemark(String tradeRemark) {
		this.tradeRemark = tradeRemark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWalletid() {
		return walletid;
	}

	public void setWalletid(String walletid) {
		this.walletid = walletid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getReallyamount() {
		return reallyamount;
	}

	public void setReallyamount(BigDecimal reallyamount) {
		this.reallyamount = reallyamount;
	}

	public Date getOccurdate() {
		return occurdate;
	}

	public void setOccurdate(Date occurdate) {
		this.occurdate = occurdate;
	}

	public Date getIpsbanktime() {
		return ipsbanktime;
	}

	public void setIpsbanktime(Date ipsbanktime) {
		this.ipsbanktime = ipsbanktime;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getBankbillno() {
		return bankbillno;
	}

	public void setBankbillno(String bankbillno) {
		this.bankbillno = bankbillno;
	}

	public String getIpsbillno() {
		return ipsbillno;
	}

	public void setIpsbillno(String ipsbillno) {
		this.ipsbillno = ipsbillno;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getUpdateby() {
		return updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public WalletJournal clone() throws CloneNotSupportedException {
		return (WalletJournal) super.clone();
	}

	public String getUserYTid() {
		return userYTid;
	}

	public void setUserYTid(String userYTid) {
		this.userYTid = userYTid;
	}

	public String getUserMoblie() {
		return userMoblie;
	}

	public void setUserMoblie(String userMoblie) {
		this.userMoblie = userMoblie;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}