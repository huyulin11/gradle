package com.ytgrading.dto;

public class SysDistrict {
    private Integer id;

    private String name;
    
    private String code;

    private String hot;

    private String zip;

    private Integer parentid;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public String getHot() {
		return hot;
	}

	public String getZip() {
		return zip;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setHot(String hot) {
		this.hot = hot;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
    

}