/**
 * 
 */
package com.ytgrading.bean.deposit;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class DepositLogistics {
	private String id;

    private Integer innerno;

    private String logisticsno;

    private Integer packlength;

    private String company;

    private Date createtime;

    private Integer packwidth;

    private Integer packheight;

    private Integer createby;

    private String remark;

    private String logisticsname;
    
    private String name;
	public String getId() {
		return id;
	}

	public String getLogisticsno() {
		return logisticsno;
	}

	public Integer getPacklength() {
		return packlength;
	}

	public String getCompany() {
		return company;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public Integer getPackwidth() {
		return packwidth;
	}

	public Integer getPackheight() {
		return packheight;
	}

	public Integer getCreateby() {
		return createby;
	}

	public String getRemark() {
		return remark;
	}

	public String getLogisticsname() {
		return logisticsname;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLogisticsno(String logisticsno) {
		this.logisticsno = logisticsno;
	}

	public void setPacklength(Integer packlength) {
		this.packlength = packlength;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public void setPackwidth(Integer packwidth) {
		this.packwidth = packwidth;
	}

	public void setPackheight(Integer packheight) {
		this.packheight = packheight;
	}

	public void setCreateby(Integer createby) {
		this.createby = createby;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setLogisticsname(String logisticsname) {
		this.logisticsname = logisticsname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getInnerno() {
		return innerno;
	}

	public void setInnerno(Integer innerno) {
		this.innerno = innerno;
	}


}
