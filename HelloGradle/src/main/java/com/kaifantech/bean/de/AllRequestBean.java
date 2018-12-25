package com.kaifantech.bean.de;

public class AllRequestBean {
	private String sid;
	private String ip;
	private String interfacename;
	private String msg;
	private String exstatus = "0";
	private String extimes;
	private String errinfo = "";
	private String createtime;

	public AllRequestBean() {
	}

	public AllRequestBean(String ip, String interfacename, String msg) {
		this.ip = ip;
		this.interfacename = interfacename;
		this.msg = msg;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getInterfacename() {
		return interfacename;
	}

	public void setInterfacename(String interfacename) {
		this.interfacename = interfacename;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getExstatus() {
		return exstatus;
	}

	public void setExstatus(String exstatus) {
		this.exstatus = exstatus;
	}

	public String getExtimes() {
		return extimes;
	}

	public void setExtimes(String extimes) {
		this.extimes = extimes;
	}

	public String getErrinfo() {
		return errinfo;
	}

	public void setErrinfo(String errinfo) {
		this.errinfo = errinfo;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

}
