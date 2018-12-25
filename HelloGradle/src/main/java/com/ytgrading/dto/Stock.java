package com.ytgrading.dto;

import java.util.Date;

public class Stock {
    private String id;
    private int notifytimes;

    public int getNotifytimes() {
		return notifytimes;
	}

	public void setNotifytimes(int notifytimes) {
		this.notifytimes = notifytimes;
	}

    private String postion;

    private String remark;

    private Integer acceptid;

    private Date accepttime;

    private Integer sendid;

    private String type;

    private String stockno;
    
    private String requeststatus;
    
    private String requestcode;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        this.type = type;
    }

    public String getStockno() {
        return stockno;
    }

    public void setStockno(String stockno) {
        this.stockno = stockno;
    }

	public String getRequeststatus() {
		return requeststatus;
	}

	public void setRequeststatus(String requeststatus) {
		this.requeststatus = requeststatus;
	}

	public String getRequestcode() {
		return requestcode;
	}

	public void setRequestcode(String requestcode) {
		this.requestcode = requestcode;
	}
}