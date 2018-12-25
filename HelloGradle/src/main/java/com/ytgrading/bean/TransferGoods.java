package com.ytgrading.bean;

import java.util.Date;

public class TransferGoods {
	/**
	 * 物品编号（包裹编号/申请单号）
	 */
	private int goodsno;
	/**
	 * 物品类别（包裹/申请单）
	 */
	private String goodstype;
	/**
	 * 物品所属人编号
	 */
	private String ownid;
	/**
	 * 物品状态（内部状态）
	 */
	private String goodsstatus;
	/**
	 * 内部状态（申请单：当为6时，待发货、为7时为已发货；包裹：-1）
	 */
	private String requeststatus;
	private String payinfo; 
	private int paydiffertime; 
	private String payremainingtime;
	
	public String getRequeststatus() {
		return requeststatus;
	}
	public void setRequeststatus(String requeststatus) {
		this.requeststatus = requeststatus;
	}
	/**
	 * 所属人姓名
	 */
	private String ownname;
	private String sendtype;
	private Date handlingtime;
	private String coinnum;
	private int requestnum;
	private Date duetime;
	private String usercode;
	private String stockoutcheck;
	
	
	public String getStockoutcheck() {
		return stockoutcheck;
	}
	public void setStockoutcheck(String stockoutcheck) {
		this.stockoutcheck = stockoutcheck;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public int getRequestnum() {
		return requestnum;
	}
	public void setRequestnum(int requestnum) {
		this.requestnum = requestnum;
	}
	public String getSendtype() {
		return sendtype;
	}
	public void setSendtype(String sendtype) {
		this.sendtype = sendtype;
	}
	public Date getHandlingtime() {
		return handlingtime;
	}
	public void setHandlingtime(Date handlingtime) {
		this.handlingtime = handlingtime;
	}
	public Date getDuetime() {
		return duetime;
	}
	public void setDuetime(Date duetime) {
		this.duetime = duetime;
	}
	public int getGoodsno() {
		return goodsno;
	}
	public void setGoodsno(int goodsno) {
		this.goodsno = goodsno;
	}
	public String getGoodstype() {
		return goodstype;
	}
	public void setGoodstype(String goodstype) {
		this.goodstype = goodstype;
	}
	public String getOwnid() {
		return ownid;
	}
	public void setOwnid(String ownid) {
		this.ownid = ownid;
	}
	public String getGoodsstatus() {
		return goodsstatus;
	}
	public void setGoodsstatus(String goodsstatus) {
		this.goodsstatus = goodsstatus;
	}
	
	public String getOwnname() {
		return ownname;
	}
	public void setOwnname(String ownname) {
		this.ownname = ownname;
	}
	public String getPayinfo() {
		return payinfo;
	}
	public void setPayinfo(String payinfo) {
		this.payinfo = payinfo;
	}
	public int getPaydiffertime() {
		return paydiffertime;
	}
	public void setPaydiffertime(int paydiffertime) {
		this.paydiffertime = paydiffertime;
	}
	public String getPayremainingtime() {
		return payremainingtime;
	}
	public void setPayremainingtime(String payremainingtime) {
		this.payremainingtime = payremainingtime;
	}
	public String getCoinnum() {
		return coinnum;
	}
	public void setCoinnum(String coinnum) {
		this.coinnum = coinnum;
	}
	
}
