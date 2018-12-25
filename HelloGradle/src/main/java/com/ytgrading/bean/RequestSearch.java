package com.ytgrading.bean;

public class RequestSearch {
	//申请单号
	private String requestcode;
	//客户编号
	private String usercode;
	//申请单外部状态
	private String requeststatus;
	//申请单内部状态
	private String internalstates;
	//申请时间
	private String applytime;
	//客户姓名
	private String name;
	//注册手机或邮箱（已认证过的手机也可以）
	private String loginname;
	public String getRequestcode() {
		return requestcode;
	}
	public void setRequestcode(String requestcode) {
		this.requestcode = requestcode;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getRequeststatus() {
		return requeststatus;
	}
	public void setRequeststatus(String requeststatus) {
		this.requeststatus = requeststatus;
	}
	public String getInternalstates() {
		return internalstates;
	}
	public void setInternalstates(String internalstates) {
		this.internalstates = internalstates;
	}
	public String getApplytime() {
		return applytime;
	}
	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
	
}
