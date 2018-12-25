package com.ytgrading.dto;

public class Ratingreason {
    private Integer id;

    private String reasonname;

    private String reasontype;
    private String resoincode;
    private String flag;
    private String reasonBelongType;

    public String getResoincode() {
		return resoincode;
	}

	public void setResoincode(String resoincode) {
		this.resoincode = resoincode;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getReasonBelongType() {
		return reasonBelongType;
	}

	public void setReasonBelongType(String reasonBelongType) {
		this.reasonBelongType = reasonBelongType;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReasonname() {
        return reasonname;
    }

    public void setReasonname(String reasonname) {
        this.reasonname = reasonname == null ? null : reasonname.trim();
    }

    public String getReasontype() {
        return reasontype;
    }

    public void setReasontype(String reasontype) {
        this.reasontype = reasontype == null ? null : reasontype.trim();
    }
}