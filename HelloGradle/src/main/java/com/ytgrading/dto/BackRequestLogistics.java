package com.ytgrading.dto;

import java.util.Date;

public class BackRequestLogistics {
	private String rowid;
    public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
    private String id;

    private String requestcode;

    private String logisticsno;

    private Integer packlength;

    private String company;

    private Date createtime;

    private Integer packwidth;

    private Integer packheight;

    private Integer createby;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRequestcode() {
        return requestcode;
    }

    public void setRequestcode(String requestcode) {
        this.requestcode = requestcode == null ? null : requestcode.trim();
    }

    public String getLogisticsno() {
        return logisticsno;
    }

    public void setLogisticsno(String logisticsno) {
        this.logisticsno = logisticsno == null ? null : logisticsno.trim();
    }

    public Integer getPacklength() {
        return packlength;
    }

    public void setPacklength(Integer packlength) {
        this.packlength = packlength;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getPackwidth() {
        return packwidth;
    }

    public void setPackwidth(Integer packwidth) {
        this.packwidth = packwidth;
    }

    public Integer getPackheight() {
        return packheight;
    }

    public void setPackheight(Integer packheight) {
        this.packheight = packheight;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}