package com.kaifantech.bean.msg.csy.scan;

public abstract class CsyScanCommBean {
	private String str;

	public CsyScanCommBean(String str) {
		setStr(str);
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
