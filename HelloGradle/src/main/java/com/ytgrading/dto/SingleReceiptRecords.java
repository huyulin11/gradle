package com.ytgrading.dto;

import java.util.Date;

public class SingleReceiptRecords {
    private String id;

    private Integer requestcode;

    private String resetreason;

    private String causeoferror;

    private String rightreasons;

    private Integer appreseter;

    private Date appresettime;

    private Integer dealer;

    private Date dealtime;

    private String dealremarks;

    private String feedback;

    private String dealtype;

    private String state;

    private Integer serialnumber;
    private Integer ownid;
    private String dealresult;
    public String getDealresult() {
		return dealresult;
	}

	public void setDealresult(String dealresult) {
		this.dealresult = dealresult;
	}

	public Integer getOwnid() {
		return ownid;
	}

	public void setOwnid(Integer ownid) {
		this.ownid = ownid;
	}

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

    public String getResetreason() {
        return resetreason;
    }

    public void setResetreason(String resetreason) {
        this.resetreason = resetreason == null ? null : resetreason.trim();
    }

    public String getCauseoferror() {
        return causeoferror;
    }

    public void setCauseoferror(String causeoferror) {
        this.causeoferror = causeoferror == null ? null : causeoferror.trim();
    }

    public String getRightreasons() {
        return rightreasons;
    }

    public void setRightreasons(String rightreasons) {
        this.rightreasons = rightreasons == null ? null : rightreasons.trim();
    }

    public Integer getAppreseter() {
        return appreseter;
    }

    public void setAppreseter(Integer appreseter) {
        this.appreseter = appreseter;
    }

    public Date getAppresettime() {
        return appresettime;
    }

    public void setAppresettime(Date appresettime) {
        this.appresettime = appresettime;
    }

    public Integer getDealer() {
        return dealer;
    }

    public void setDealer(Integer dealer) {
        this.dealer = dealer;
    }

    public Date getDealtime() {
        return dealtime;
    }

    public void setDealtime(Date dealtime) {
        this.dealtime = dealtime;
    }

    public String getDealremarks() {
        return dealremarks;
    }

    public void setDealremarks(String dealremarks) {
        this.dealremarks = dealremarks == null ? null : dealremarks.trim();
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback == null ? null : feedback.trim();
    }

    public String getDealtype() {
        return dealtype;
    }

    public void setDealtype(String dealtype) {
        this.dealtype = dealtype == null ? null : dealtype.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(Integer serialnumber) {
        this.serialnumber = serialnumber;
    }
}