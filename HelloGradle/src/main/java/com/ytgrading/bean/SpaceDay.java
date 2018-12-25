package com.ytgrading.bean;

public class SpaceDay {
	private String coinrequestcode;
	private int coinamount;
	private String billrequestcode;
	private int billamount;
	private int leftCount;
	private int rightCount;
	
	
	public int getLeftCount() {
		return leftCount;
	}
	public void setLeftCount(int leftCount) {
		this.leftCount = leftCount;
	}
	public int getRightCount() {
		return rightCount;
	}
	public void setRightCount(int rightCount) {
		this.rightCount = rightCount;
	}
	public String getCoinrequestcode() {
		return coinrequestcode;
	}
	public void setCoinrequestcode(String coinrequestcode) {
		this.coinrequestcode = coinrequestcode;
	}
	public int getCoinamount() {
		return coinamount;
	}
	public void setCoinamount(int coinamount) {
		this.coinamount = coinamount;
	}
	public String getBillrequestcode() {
		return billrequestcode;
	}
	public void setBillrequestcode(String billrequestcode) {
		this.billrequestcode = billrequestcode;
	}
	public int getBillamount() {
		return billamount;
	}
	public void setBillamount(int billamount) {
		this.billamount = billamount;
	}
	
}
