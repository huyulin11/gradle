package com.ytgrading.dto;

import java.util.Date;

public class BackStock {
	private String rowid;
    public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

    private String id;

    private String stockno;

    private String postion;

    private String remark;

    private Integer acceptid;

    private Date accepttime;

    private Integer sendid;

    private String type;

    private Integer notifytimes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStockno() {
        return stockno;
    }

    public void setStockno(String stockno) {
        this.stockno = stockno == null ? null : stockno.trim();
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion == null ? null : postion.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getAcceptid() {
        return acceptid;
    }

    public void setAcceptid(Integer acceptid) {
        this.acceptid = acceptid;
    }

    public Date getAccepttime() {
        return accepttime;
    }

    public void setAccepttime(Date accepttime) {
        this.accepttime = accepttime;
    }

    public Integer getSendid() {
        return sendid;
    }

    public void setSendid(Integer sendid) {
        this.sendid = sendid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getNotifytimes() {
        return notifytimes;
    }

    public void setNotifytimes(Integer notifytimes) {
        this.notifytimes = notifytimes;
    }
}