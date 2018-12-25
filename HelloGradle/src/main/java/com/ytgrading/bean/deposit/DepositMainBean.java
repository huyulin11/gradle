/** 
 * 
 * Copyright (c) 2013 , FandaSoft and/or its affiliates. All rights reserved. 
 * FandaSoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.ytgrading.bean.deposit;

import java.util.Date;
import java.util.UUID;

public class DepositMainBean {
	// depositMainBean
	private String id = UUID.randomUUID().toString();

	private String innerno;

	private String reservno;

	private String userid;

	private String payment;

	private String remark;
	private String ownid;
	private String depositstate;
	private String paystate;
	private String notice;
	private String agreement;// 1代表同意，0代表不同意
	private int entitytype;
	private String addedcoinremark;
	private String isproxy;
	private String delflag;

	private Date deposittime;
	private Date applytime;
	private Date updatetime;
	private Date createtime;

	private String applytype;// *** 送评方式（1为上门，2为物流）
	private String packagecode;

	public String getApplytype() {
		return applytype;
	}

	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReservno() {
		return reservno;
	}

	public String getInnerno() {
		return innerno;
	}

	public void setInnerno(String innerno) {
		this.innerno = innerno;
	}

	public void setReservno(String reservno) {
		this.reservno = reservno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getOwnid() {
		return ownid;
	}

	public void setOwnid(String ownid) {
		this.ownid = ownid;
	}

	public String getPaystate() {
		return paystate;
	}

	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}

	public String getNotice() {
		return notice;
	}

	public String getDepositstate() {
		return depositstate;
	}

	public void setDepositstate(String depositstate) {
		this.depositstate = depositstate;
	}

	public Date getDeposittime() {
		return deposittime;
	}

	public void setDeposittime(Date deposittime) {
		this.deposittime = deposittime;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Date getApplytime() {
		return applytime;
	}

	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		agreement = ("on".equals(agreement) || "1".equals(agreement)) ? "1"
				: "0";
		this.agreement = agreement;
	}

	public String getAddedcoinremark() {
		return addedcoinremark;
	}

	public void setAddedcoinremark(String addedcoinremark) {
		this.addedcoinremark = addedcoinremark;
	}

	public int getEntitytype() {
		return entitytype;
	}

	public void setEntitytype(int entitytype) {
		this.entitytype = entitytype;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getIsproxy() {
		return isproxy;
	}

	public void setIsproxy(String isproxy) {
		if (isproxy == null) {
			this.isproxy = null;
		} else {
			this.isproxy = ("on".equals(isproxy) || "1".equals(isproxy)) ? "1"
					: "0";
		}
	}

	@SuppressWarnings("unused")
	private String formatBigDecimal(String price) {
		if (price == null || "".equals(price)) {
			return "0.00";
		}
		return price.trim().replaceAll(",", "");
	}

	public String getPackagecode() {
		return packagecode;
	}

	public void setPackagecode(String packagecode) {
		this.packagecode = packagecode;
	}

}
