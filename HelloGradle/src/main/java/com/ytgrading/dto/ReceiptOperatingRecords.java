package com.ytgrading.dto;

import java.util.Date;

public class ReceiptOperatingRecords {
    private String id;

    private Integer requestcode;

    private Integer dealpeople;

    private String operate;

    private Date operattime;

    private String reqstate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getRequestcode() {
        return requestcode;
    }

    public void setRequestcode(Integer requestcode) {
        this.requestcode = requestcode;
    }

    public Integer getDealpeople() {
        return dealpeople;
    }

    public void setDealpeople(Integer dealpeople) {
        this.dealpeople = dealpeople;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }

    public Date getOperattime() {
        return operattime;
    }

    public void setOperattime(Date operattime) {
        this.operattime = operattime;
    }

    public String getReqstate() {
        return reqstate;
    }

    public void setReqstate(String reqstate) {
        this.reqstate = reqstate == null ? null : reqstate.trim();
    }
}