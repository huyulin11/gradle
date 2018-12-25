package com.ytgrading.dto;

public class SysCity {
    private Integer id;

    private String name;
    
    private String code;

    private String hot;

    private String zip;

    private Integer parentid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}