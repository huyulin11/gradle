package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.Date;

public class WalletRefund {
    private String id;

    private Integer refundno;

    private Date refunddate;

    private BigDecimal amount;

    private String type;

    private String walletid;

    private String remark;

    private String status;

    private Date confirmdate;

    private String confirmuserid;

    private String delflag;

    private String userid;

    private String capitalid;

    private Date orderdate;

    private String capitalvalue;

    private Integer mtype;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRefundno() {
        return refundno;
    }

    public void setRefundno(Integer refundno) {
        this.refundno = refundno;
    }

    public Date getRefunddate() {
        return refunddate;
    }

    public void setRefunddate(Date refunddate) {
        this.refunddate = refunddate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWalletid() {
        return walletid;
    }

    public void setWalletid(String walletid) {
        this.walletid = walletid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getConfirmdate() {
        return confirmdate;
    }

    public void setConfirmdate(Date confirmdate) {
        this.confirmdate = confirmdate;
    }

    public String getConfirmuserid() {
        return confirmuserid;
    }

    public void setConfirmuserid(String confirmuserid) {
        this.confirmuserid = confirmuserid;
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

    public String getCapitalid() {
        return capitalid;
    }

    public void setCapitalid(String capitalid) {
        this.capitalid = capitalid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getCapitalvalue() {
        return capitalvalue;
    }

    public void setCapitalvalue(String capitalvalue) {
        this.capitalvalue = capitalvalue;
    }

	public Integer getMtype() {
		return mtype;
	}

	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}
    
}