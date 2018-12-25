package com.kaifantech.bean.msg.csy.plc;

public abstract class CsyPlcCommBean {
	private String str;

	public CsyPlcCommBean(String str) {
		setStr(str);
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
