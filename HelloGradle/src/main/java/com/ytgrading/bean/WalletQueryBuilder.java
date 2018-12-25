package com.ytgrading.bean;

public class WalletQueryBuilder extends PageTurning {
	private String userMoblie;
	private String userEmail;
	private String userCode;
	private String userName;
	private String transactionCode;
	private String bankCode;
	private String voucherNo;
	private String transactionType;
	private String fundSource;
	private String queryStartTime;
	private String queryEndTime;
	private String queryType;
	private String userid;
	private String nowURL;

	public String getNowURL() {
		return nowURL;
	}

	public void setNowURL(String nowURL) {
		this.nowURL = nowURL;
	}

	@Override
	public String toString() {
		return "WalletQueryBuilder [userMoblie=" + userMoblie + ", userEmail="
				+ userEmail + ", userCode=" + userCode + ", username="
				+ userName + ", transactionCode=" + transactionCode
				+ ", bankCode=" + bankCode + ", voucherNo=" + voucherNo
				+ ", transactionType=" + transactionType + ", fundSource="
				+ fundSource + ", queryStartTime=" + queryStartTime
				+ ", queryEndTime=" + queryEndTime + ", queryType=" + queryType
				+ ", userid=" + userid + ", page=" + getPage() + ", pageSize="
				+ getPageSize() + "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
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

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getFundSource() {
		return fundSource;
	}

	public void setFundSource(String fundSource) {
		this.fundSource = fundSource;
	}

	public String getQueryStartTime() {
		return queryStartTime;
	}

	public void setQueryStartTime(String queryStartTime) {
		this.queryStartTime = queryStartTime;
	}

	public String getQueryEndTime() {
		return queryEndTime;
	}

	public void setQueryEndTime(String queryEndTime) {
		this.queryEndTime = queryEndTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
