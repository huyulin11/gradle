package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.Date;

public class BackRequestCoinScore {
    private String rowid;

    private String id;

    private String requestcoinid;

    private String level;

    private BigDecimal score;

    private String remark;

    private Integer scoreby;

    private Date scoretime;

    private String ratingreasondis;

    public String getRowid() {
        return rowid;
    }

    public void setRowid(String rowid) {
        this.rowid = rowid == null ? null : rowid.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRequestcoinid() {
        return requestcoinid;
    }

    public void setRequestcoinid(String requestcoinid) {
        this.requestcoinid = requestcoinid == null ? null : requestcoinid.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getScoreby() {
        return scoreby;
    }

    public void setScoreby(Integer scoreby) {
        this.scoreby = scoreby;
    }

    public Date getScoretime() {
        return scoretime;
    }

    public void setScoretime(Date scoretime) {
        this.scoretime = scoretime;
    }

    public String getRatingreasondis() {
        return ratingreasondis;
    }

    public void setRatingreasondis(String ratingreasondis) {
        this.ratingreasondis = ratingreasondis == null ? null : ratingreasondis.trim();
    }
}