package com.ytgrading.dto;

public class UserMobile {
	private String chaozuo;
	private String isremove;
	
    public String getIsremove() {
		return isremove;
	}

	public void setIsremove(String isremove) {
		this.isremove = isremove;
	}

    private String id;

    private String userid;

    private String telephone;

    private String isdefault;

    private String status;

    private String delflag;

    private String remark;
    

    public String getChaozuo() {
		return chaozuo;
	}

	public void setChaozuo(String chaozuo) {
		this.chaozuo = chaozuo;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}