package com.ytgrading.dto;

import java.util.Date;

public class IndexImages {
	private String id;

	private String path;

	private String url;

	private String imagestype;

	private String usable;

	private Date createdate;

	private String delflag;

	private String sortflag;
	
	private String imagestitle;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImagestype() {
		return imagestype;
	}

	public void setImagestype(String imagestype) {
		this.imagestype = imagestype;
	}

	public String getUsable() {
		return usable;
	}

	public void setUsable(String usable) {
		this.usable = usable;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getSortflag() {
		return sortflag;
	}

	public void setSortflag(String sortflag) {
		this.sortflag = sortflag;
	}

	public String getImagestitle() {
		return imagestitle;
	}

	public void setImagestitle(String imagestitle) {
		this.imagestitle = imagestitle;
	}	
}