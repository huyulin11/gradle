package com.ytgrading.dto;

import java.util.Date;

public class RequestLog {
    private String id;
    private String userid;
    private String billno;

    private String requestid;

    private Date updatetime;

    private String delflag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequestid() {
        return requestid;
    }

    public void setRequestid(String requestid) {
        this.requestid = requestid;
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

	
	public String getUserid() {
		return userid;
	}

	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	
	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}
    
}