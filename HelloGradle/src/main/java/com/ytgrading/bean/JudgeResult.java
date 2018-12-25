package com.ytgrading.bean;

import java.util.Date;

import com.ytgrading.bean.deposit.DepositClassBean;

public class JudgeResult {
	
	
	private String depositclassid;
	private int optype;
	private int numreal;
	private int numtestok;
	private int numtestnotok;
	private int numtestunjudged;
	private String remark;
	private int opuserid;
	private Date createtime;
	private int delflag;//删除标志，0是保存，1是删除
	
	public String getDepositclassid() {
		return depositclassid;
	}
	public void setDepositclassid(String depositclassid) {
		this.depositclassid = depositclassid;
	}
	public int getOptype() {
		return optype;
	}
	public void setOptype(int optype) {
		this.optype = optype;
	}
	public int getNumreal() {
		return numreal;
	}
	public void setNumreal(int numreal) {
		this.numreal = numreal;
	}
	public int getNumtestok() {
		return numtestok;
	}
	public void setNumtestok(int numtestok) {
		this.numtestok = numtestok;
	}
	public int getNumtestnotok() {
		return numtestnotok;
	}
	public void setNumtestnotok(int numtestnotok) {
		this.numtestnotok = numtestnotok;
	}
	public int getNumtestunjudged() {
		return numtestunjudged;
	}
	public void setNumtestunjudged(int numtestunjudged) {
		this.numtestunjudged = numtestunjudged;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getOpuserid() {
		return opuserid;
	}
	public void setOpuserid(int opuserid) {
		this.opuserid = opuserid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	
	
	

}
