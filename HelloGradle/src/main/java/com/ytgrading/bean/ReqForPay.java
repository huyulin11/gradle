package com.ytgrading.bean;

import java.math.BigDecimal;
/*
 * 待支付单子
 */
public class ReqForPay {
	//单子所属人
	private String userid;
	//待支付单子总数
	private int count;
	//所有待支付单子总费用
	private BigDecimal totalCost;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	
}
