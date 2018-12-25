package com.ytgrading.bean;

import java.util.Date;

/**
 * 交接记录
 * @author Administrator
 *
 */
public class HandRecord {
	/**
	 * 物品类型，P为包裹，R为申请单
	 */
	private String type;
	/**
	 * 物品编号
	 */
	private int goodsid;
	/**
	 * 交出人编号
	 */
	private int transferfrom;
	/**
	 * 交出人姓名
	 */
	private String fromName;
	/**
	 * 接收人编号
	 */
	private int transferto;
	/**
	 * 接收人姓名
	 */
	private String toName;
	/**
	 * 交接时间
	 */
	private Date occurrencetime;
	/**
	 * 物品状态
	 */
	private String status;
	
	private String payinfo; 
	private int paydiffertime; 
	private String payremainingtime;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public synchronized String getType() {
		return type;
	}
	public synchronized void setType(String type) {
		this.type = type;
	}
	public synchronized int getGoodsid() {
		return goodsid;
	}
	public synchronized void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public synchronized int getTransferfrom() {
		return transferfrom;
	}
	public synchronized void setTransferfrom(int transferfrom) {
		this.transferfrom = transferfrom;
	}
	public synchronized String getFromName() {
		return fromName;
	}
	public synchronized void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public synchronized int getTransferto() {
		return transferto;
	}
	public synchronized void setTransferto(int transferto) {
		this.transferto = transferto;
	}
	public synchronized String getToName() {
		return toName;
	}
	public synchronized void setToName(String toName) {
		this.toName = toName;
	}
	public synchronized Date getOccurrencetime() {
		return occurrencetime;
	}
	public synchronized void setOccurrencetime(Date occurrencetime) {
		this.occurrencetime = occurrencetime;
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
}
