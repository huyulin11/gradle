package com.ytgrading.dto;

import java.util.Date;

public class StockOut {
    private String id;

    private Integer outby;

    private Date outtime;

    private Integer goodsid;

    private Integer confirmby;

    private Date confirmtime;

    private String type;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOutby() {
        return outby;
    }

    public void setOutby(Integer outby) {
        this.outby = outby;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getConfirmby() {
        return confirmby;
    }

    public void setConfirmby(Integer confirmby) {
        this.confirmby = confirmby;
    }

    public Date getConfirmtime() {
        return confirmtime;
    }

    public void setConfirmtime(Date confirmtime) {
        this.confirmtime = confirmtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}