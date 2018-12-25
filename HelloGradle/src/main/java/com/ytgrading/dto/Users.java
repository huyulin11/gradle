package com.ytgrading.dto;

import java.util.Date;

public class Users {
    private String id;

    private Integer usercode;

    private Date registerdate;

    private String title;

    private String remark;

    private String birthday;

    private String documenttype;

    private String documentcode;

    private String password;

    private String rate;

    private String name;

    private String delflag;

    private String defaultmail;

    private String defaulttel;

    private String defaultmobile;

    private String gender;

    private String url;
    
    private String regdate;
    
    
    
    
    public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUsercode() {
        return usercode;
    }

    public void setUsercode(Integer usercode) {
        this.usercode = usercode;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDocumenttype() {
        return documenttype;
    }

    public void setDocumenttype(String documenttype) {
        this.documenttype = documenttype;
    }

    public String getDocumentcode() {
        return documentcode;
    }

    public void setDocumentcode(String documentcode) {
        this.documentcode = documentcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    public String getDefaultmail() {
        return defaultmail;
    }

    public void setDefaultmail(String defaultmail) {
        this.defaultmail = defaultmail;
    }

    public String getDefaulttel() {
        return defaulttel;
    }

    public void setDefaulttel(String defaulttel) {
        this.defaulttel = defaulttel;
    }

    public String getDefaultmobile() {
        return defaultmobile;
    }

    public void setDefaultmobile(String defaultmobile) {
        this.defaultmobile = defaultmobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}