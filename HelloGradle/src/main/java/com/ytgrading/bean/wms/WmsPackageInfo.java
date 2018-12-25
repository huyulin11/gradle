package com.ytgrading.bean.wms;

import java.util.Date;

public class WmsPackageInfo {
	private String packageid;
	private String sealouter;
	private String sealinner;
	private String sealsigh;
	private String sealbyuser;
	private Integer amount;
	private Integer createuserid;
	private Date createusertime;
	private String delflag;

	public String getPackageid() {
		return packageid;
	}

	public void setPackageid(String packageid) {
		this.packageid = packageid;
	}

	public String getSealouter() {
		return sealouter;
	}

	public void setSealouter(String sealouter) {
		this.sealouter = sealouter;
	}

	public String getSealinner() {
		return sealinner;
	}

	public void setSealinner(String sealinner) {
		this.sealinner = sealinner;
	}

	public String getSealsigh() {
		return sealsigh;
	}

	public void setSealsigh(String sealsigh) {
		this.sealsigh = sealsigh;
	}

	public String getSealbyuser() {
		return sealbyuser;
	}

	public void setSealbyuser(String sealbyuser) {
		this.sealbyuser = sealbyuser;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(Integer createuserid) {
		this.createuserid = createuserid;
	}

	public Date getCreateusertime() {
		return createusertime;
	}

	public void setCreateusertime(Date createusertime) {
		this.createusertime = createusertime;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

}
