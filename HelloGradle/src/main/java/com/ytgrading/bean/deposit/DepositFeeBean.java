package com.ytgrading.bean.deposit;

import java.util.Date;

public class DepositFeeBean {
	private Integer id;
	private String depositid;
	private Integer totalamount;
	private String totalcost;
	private String totalreqcost;
	private String totalevaluate;
	private String totalweight;
	private String totalpremium;
	private String totaltransportation;
	private String totalinsurance;
	private String totalpreferential;
	private String totalboxfee;
	private String othercost;
	private String costremark;
	private Date createtime;
	private Date updatetime;

	public Integer getId() {
		return id;
	}

	public String getDepositid() {
		return depositid;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDepositid(String depositid) {
		this.depositid = depositid;
	}

	public String getOthercost() {
		return othercost;
	}

	public void setOthercost(String othercost) {
		this.othercost = othercost;
	}

	public Integer getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Integer totalamount) {
		this.totalamount = totalamount;
	}

	public String getTotalweight() {
		return totalweight;
	}

	public void setTotalweight(String totalweight) {
		this.totalweight = totalweight;
	}

	public String getTotalevaluate() {
		return totalevaluate;
	}

	public void setTotalevaluate(String totalevaluate) {
		this.totalevaluate = totalevaluate;
	}

	public String getTotalreqcost() {
		return totalreqcost;
	}

	public void setTotalreqcost(String totalreqcost) {
		this.totalreqcost = totalreqcost;
	}

	public String getTotalpremium() {
		return totalpremium;
	}

	public void setTotalpremium(String totalpremium) {
		this.totalpremium = totalpremium;
	}

	public String getTotaltransportation() {
		return totaltransportation;
	}

	public void setTotaltransportation(String totaltransportation) {
		this.totaltransportation = totaltransportation;
	}

	public String getTotalinsurance() {
		return totalinsurance;
	}

	public void setTotalinsurance(String totalinsurance) {
		this.totalinsurance = totalinsurance;
	}

	public String getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(String totalcost) {
		this.totalcost = totalcost;
	}

	public String getTotalpreferential() {
		return totalpreferential;
	}

	public void setTotalpreferential(String totalpreferential) {
		this.totalpreferential = totalpreferential;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getCostremark() {
		return costremark;
	}

	public void setCostremark(String costremark) {
		this.costremark = costremark;
	}

	public String getTotalboxfee() {
		return totalboxfee;
	}

	public void setTotalboxfee(String totalboxfee) {
		this.totalboxfee = totalboxfee;
	}
}
