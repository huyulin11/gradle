package com.ytgrading.dto;

import java.util.Date;

public class UserValidity {
    private String id;

    private String loginname;

    private Date starttime;

    private String verificationcode;

    private String type;
    
    private String struts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getVerificationcode() {
        return verificationcode;
    }

    public void setVerificationcode(String verificationcode) {
        this.verificationcode = verificationcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	public String getStruts() {
		return struts;
	}

	public void setStruts(String struts) {
		this.struts = struts;
	}
}