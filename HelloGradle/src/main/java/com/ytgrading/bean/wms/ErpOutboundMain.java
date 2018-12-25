package com.ytgrading.bean.wms;

import java.util.Date;

public class ErpOutboundMain {
	private String id;
	private String outboundcode;
	private int businesstype;
	private int amount;
	private String remark;
	private Date outboundtime;
	private int outbounduserid;
	private int istestok;
	private int delflag;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOutboundcode() {
		return outboundcode;
	}
	public void setOutboundcode(String outboundcode) {
		this.outboundcode = outboundcode;
	}
	public int getBusinesstype() {
		return businesstype;
	}
	public void setBusinesstype(int businesstype) {
		this.businesstype = businesstype;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getOutboundtime() {
		return outboundtime;
	}
	public void setOutboundtime(Date outboundtime) {
		this.outboundtime = outboundtime;
	}
	public int getOutbounduserid() {
		return outbounduserid;
	}
	public void setOutbounduserid(int outbounduserid) {
		this.outbounduserid = outbounduserid;
	}
	public int getIstestok() {
		return istestok;
	}
	public void setIstestok(int istestok) {
		this.istestok = istestok;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	
}