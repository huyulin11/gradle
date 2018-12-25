package com.ytgrading.dto;

import java.math.BigDecimal;

public class BackRequestDetail {
    private String rowid;

    private String id;

    private Integer coinid;

    private Integer amount;

    private BigDecimal evaluate;

    private BigDecimal score;

    private String requestid;

    private String remark;

    private Integer numindex;

    private BigDecimal totalreqcost;

    private BigDecimal totalevaluate;

    private Integer amountofissue;

    private BigDecimal guestappraisal;
    private String backrecordsid;
    private String guestWRWeight;
    private String guestWRSize;
    private String guestWRGrade;
    private String wmk;
    private String whetherSample;
    private String blockNum;
    private String version;
    private String whetherSeries;
    public String getGuestWRWeight() {
		return guestWRWeight;
	}

	public void setGuestWRWeight(String guestWRWeight) {
		this.guestWRWeight = guestWRWeight;
	}

	public String getGuestWRSize() {
		return guestWRSize;
	}

	public void setGuestWRSize(String guestWRSize) {
		this.guestWRSize = guestWRSize;
	}

	public String getGuestWRGrade() {
		return guestWRGrade;
	}

	public void setGuestWRGrade(String guestWRGrade) {
		this.guestWRGrade = guestWRGrade;
	}

	public String getWmk() {
		return wmk;
	}

	public void setWmk(String wmk) {
		this.wmk = wmk;
	}

	public String getWhetherSample() {
		return whetherSample;
	}

	public void setWhetherSample(String whetherSample) {
		this.whetherSample = whetherSample;
	}

	public String getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(String blockNum) {
		this.blockNum = blockNum;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getWhetherSeries() {
		return whetherSeries;
	}

	public void setWhetherSeries(String whetherSeries) {
		this.whetherSeries = whetherSeries;
	}

	public String getBackrecordsid() {
		return backrecordsid;
	}

	public void setBackrecordsid(String backrecordsid) {
		this.backrecordsid = backrecordsid;
	}

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

    public Integer getCoinid() {
        return coinid;
    }

    public void setCoinid(Integer coinid) {
        this.coinid = coinid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(BigDecimal evaluate) {
        this.evaluate = evaluate;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getRequestid() {
        return requestid;
    }

    public void setRequestid(String requestid) {
        this.requestid = requestid == null ? null : requestid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getNumindex() {
        return numindex;
    }

    public void setNumindex(Integer numindex) {
        this.numindex = numindex;
    }

    public BigDecimal getTotalreqcost() {
        return totalreqcost;
    }

    public void setTotalreqcost(BigDecimal totalreqcost) {
        this.totalreqcost = totalreqcost;
    }

    public BigDecimal getTotalevaluate() {
        return totalevaluate;
    }

    public void setTotalevaluate(BigDecimal totalevaluate) {
        this.totalevaluate = totalevaluate;
    }

    public Integer getAmountofissue() {
        return amountofissue;
    }

    public void setAmountofissue(Integer amountofissue) {
        this.amountofissue = amountofissue;
    }

    public BigDecimal getGuestappraisal() {
        return guestappraisal;
    }

    public void setGuestappraisal(BigDecimal guestappraisal) {
        this.guestappraisal = guestappraisal;
    }
}