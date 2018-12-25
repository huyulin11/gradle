package com.ytgrading.bean;

import java.util.Date;

public class PackageInfoBean {
	
	private String packageid;
	private String sealouter;
	private String sealinner;
	private String sealsigh;
	private String sealbyuser;
	private int createuserid;
	private Date createusertime;
	private int delflag;//删除标志，0是保存，1是删除
	private int amount;
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
	public int getCreateuserid() {
		return createuserid;
	}
	public void setCreateuserid(int createuserid) {
		this.createuserid = createuserid;
	}
	public Date getCreateusertime() {
		return createusertime;
	}
	public void setCreateusertime(Date createusertime) {
		this.createusertime = createusertime;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
