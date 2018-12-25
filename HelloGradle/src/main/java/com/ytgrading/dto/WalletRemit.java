package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.Date;

public class WalletRemit {
	private String openbank;
	
    public String getOpenbank() {
		return openbank;
	}

	public void setOpenbank(String openbank) {
		this.openbank = openbank;
	}

    private String id;

    private Integer remitno;

    private String type;//0邮局汇款 1银行汇款

    private String userid;

    private BigDecimal amount;//汇款的金额

    private String unit;

    private Date remitdate;//汇款日期

    private String remitname;//开户姓名

    private String remitfrom;//哪个银行

     
    private String remitcode;//回单流水号

    private String remark;//备注信息

    private Date submitdate;

    private String status;

    private Date confirmdate;

    private String confirmuserid;

    private BigDecimal confirmamount;

    private String delflag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRemitno() {
        return remitno;
    }

    public void setRemitno(Integer remitno) {
        this.remitno = remitno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getRemitdate() {
        return remitdate;
    }

    public void setRemitdate(Date remitdate) {
        this.remitdate = remitdate;
    }

    public String getRemitname() {
        return remitname;
    }

    public void setRemitname(String remitname) {
        this.remitname = remitname;
    }

    public String getRemitfrom() {
        return remitfrom;
    }

    public void setRemitfrom(String remitfrom) {
        this.remitfrom = remitfrom;
    }

    public String getRemitcode() {
        return remitcode;
    }

    public void setRemitcode(String remitcode) {
        this.remitcode = remitcode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getSubmitdate() {
        return submitdate;
    }

    public void setSubmitdate(Date submitdate) {
        this.submitdate = submitdate;
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

    public BigDecimal getConfirmamount() {
        return confirmamount;
    }

    public void setConfirmamount(BigDecimal confirmamount) {
        this.confirmamount = confirmamount;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }
}