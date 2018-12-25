package com.ytgrading.bean.wms;

import java.util.Date;

public class ReuqetsInAndOutBound {
	private String id;
	private String requestcode;
	private String boundcode;
	private int boundstatus;
	private Date boundtime;
	private String boundtype;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRequestcode() {
		return requestcode;
	}
	public void setRequestcode(String requestcode) {
		this.requestcode = requestcode;
	}
	public String getBoundcode() {
		return boundcode;
	}
	public void setBoundcode(String boundcode) {
		this.boundcode = boundcode;
	}
	public int getBoundstatus() {
		return boundstatus;
	}
	public void setBoundstatus(int boundstatus) {
		this.boundstatus = boundstatus;
	}
	public Date getBoundtime() {
		return boundtime;
	}
	public void setBoundtime(Date boundtime) {
		this.boundtime = boundtime;
	}
	public String getBoundtype() {
		return boundtype;
	}
	public void setBoundtype(String boundtype) {
		this.boundtype = boundtype;
	}
}
