package com.ytgrading.dto;

import java.math.BigDecimal;

public class SysCoinMunitsvalue {
    private Integer id;

    private Integer munitid;

    private BigDecimal value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMunitid() {
        return munitid;
    }

    public void setMunitid(Integer munitid) {
        this.munitid = munitid;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}