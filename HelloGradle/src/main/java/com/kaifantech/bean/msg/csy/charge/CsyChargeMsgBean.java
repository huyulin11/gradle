package com.kaifantech.bean.msg.csy.charge;

import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

public class CsyChargeMsgBean {
	private String str;

	public CsyChargeMsgBean(String str) {
		setStr(str);
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public AppMsg getChargeStatus() {
		if (AppTool.isNull(getStr()) || getStr().length() != 30) {
			return new AppMsg(-1, "未得到合適的消息");
		}
		String current = getStr().substring(10, 14);
		if (!current.equals("0000")) {
			return new AppMsg(1, "正在充電");
		}
		return new AppMsg(0, "未在充電");
	}
}
