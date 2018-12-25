package com.ytgrading.bean.wms;

import java.util.Date;

public class WmsOutboundShow extends WmsOutboundMain{
	private String customer;
	private Integer usercode;
	private String paystatus;
	private Date requesttime;
	private String requestcode;
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Integer getUsercode() {
		return usercode;
	}

	public void setUsercode(Integer usercode) {
		this.usercode = usercode;
	}

	public String getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}

	public Date getRequesttime() {
		return requesttime;
	}

	public void setRequesttime(Date requesttime) {
		this.requesttime = requesttime;
	}

	public String getRequestcode() {
		return requestcode;
	}

	public void setRequestcode(String requestcode) {
		this.requestcode = requestcode;
	}
	
}
