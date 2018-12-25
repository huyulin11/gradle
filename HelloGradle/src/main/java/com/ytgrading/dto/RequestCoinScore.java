package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.Date;

public class RequestCoinScore {
	private String ratingreasondis;//评级原因
    public String getRatingreasondis() {
		return ratingreasondis;
	}

	public void setRatingreasondis(String ratingreasondis) {
		this.ratingreasondis = ratingreasondis;
	}
	
	private String id;

    private String requestcoinid;

    private String level;

    private BigDecimal score;

    private String remark;

    private Integer scoreby;

    private Date scoretime;
    
    private String scores;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequestcoinid() {
        return requestcoinid;
    }

    public void setRequestcoinid(String requestcoinid) {
        this.requestcoinid = requestcoinid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
        this.remark = remark;
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

	public String getScores() {
		return scores;
	}

	public void setScores(String scores) {
		this.scores = scores;
	}
    
    
}