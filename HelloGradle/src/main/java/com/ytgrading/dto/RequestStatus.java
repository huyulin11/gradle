package com.ytgrading.dto;

import java.util.Date;

public class RequestStatus {
    private String id;

    private String requestid;

    private String status;

    private String updateby;

    private Date updatetime;

    private String ownerid;

    private String internalstates;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public String getInternalstates() {
        return internalstates;
    }

    public void setInternalstates(String internalstates) {
        this.internalstates = internalstates;
    }
}