package com.ytgrading.dto;

public class DepositSearchCondition {
	private String userid;
	private String applytimestart;
	private String applytimeend;
	private String entitytype;
	private String innerno;
	private String reservno;
	private String paystate;
	private String entityid;
	private String aliasname;

	public String getUserid() {
		return userid;
	}

	public String getAliasname() {
		return aliasname;
	}

	public void setAliasname(String aliasname) {
		this.aliasname = aliasname;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getApplytimestart() {
		return applytimestart;
	}

	public String getApplytimeend() {
		return applytimeend;
	}

	public String getEntitytype() {
		return entitytype;
	}

	public String getInnerno() {
		return innerno;
	}

	public String getReservno() {
		return reservno;
	}

	public String getPaystate() {
		return paystate;
	}

	public void setApplytimestart(String applytimestart) {
		this.applytimestart = applytimestart;
	}

	public void setApplytimeend(String applytimeend) {
		this.applytimeend = applytimeend;
	}

	public void setEntitytype(String entitytype) {
		this.entitytype = entitytype;
	}

	public void setInnerno(String innerno) {
		this.innerno = innerno;
	}

	public void setReservno(String reservno) {
		this.reservno = reservno;
	}

	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}

	public String getEntityid() {
		return entityid;
	}

	public void setEntityid(String entityid) {
		this.entityid = entityid;
	}

}