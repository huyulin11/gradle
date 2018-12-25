package com.ytgrading.bean;

import java.util.Date;

public class LogisticsTransferBean {
	private String goodsid;
	private Integer transferfrom;
	private String tf_name;
	private Integer transferto;
	private String tt_name;
	private Date occurrencetime;
	private String type;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//get，set 方法
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public Integer getTransferfrom() {
		return transferfrom;
	}
	public void setTransferfrom(Integer transferfrom) {
		this.transferfrom = transferfrom;
	}
	public String getTf_name() {
		return tf_name;
	}
	public void setTf_name(String tf_name) {
		this.tf_name = tf_name;
	}
	public Integer getTransferto() {
		return transferto;
	}
	public void setTransferto(Integer transferto) {
		this.transferto = transferto;
	}
	public String getTt_name() {
		return tt_name;
	}
	public void setTt_name(String tt_name) {
		this.tt_name = tt_name;
	}
	public Date getOccurrencetime() {
		return occurrencetime;
	}
	public void setOccurrencetime(Date occurrencetime) {
		this.occurrencetime = occurrencetime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

	
	

}
