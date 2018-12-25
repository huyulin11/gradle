package com.ytgrading.bean;

public class PackageRelationBean {
	
	private int businesstype;//业务类型，0是评级，1是托管
	private String formid;
	private int entityid;
	private int amount;
	private String packageid;
	private int delflag;//删除标志，0是保存，1是删除
	private int innerno;
	private String aliasname;
	
	public int getBusinesstype() {
		return businesstype;
	}
	public void setBusinesstype(int businesstype) {
		this.businesstype = businesstype;
	}
	public String getFormid() {
		return formid;
	}
	public void setFormid(String formid) {
		this.formid = formid;
	}
	public int getEntityid() {
		return entityid;
	}
	public void setEntityid(int entityid) {
		this.entityid = entityid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPackageid() {
		return packageid;
	}
	public void setPackageid(String packageid) {
		this.packageid = packageid;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	public int getInnerno() {
		return innerno;
	}
	public void setInnerno(int innerno) {
		this.innerno = innerno;
	}
	public String getAliasname() {
		return aliasname;
	}
	public void setAliasname(String aliasname) {
		this.aliasname = aliasname;
	}
	
	

}
