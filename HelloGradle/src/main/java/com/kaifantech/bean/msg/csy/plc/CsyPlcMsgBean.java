package com.kaifantech.bean.msg.csy.plc;

import com.ytgrading.util.AppTool;

public class CsyPlcMsgBean extends CsyPlcCommBean {

	public CsyPlcMsgBean(String str) {
		super(str);
	}

	public String taskOverFlag() {
		if (AppTool.isNull(getStr()) || getStr().length() != 56) {
			return null;
		} else {
			return getStr().substring(0, 4);
		}
	}

	public String robotErrFlag() {
		if (AppTool.isNull(getStr()) || getStr().length() != 56) {
			return null;
		} else {
			return getStr().substring(4, 8);
		}
	}

	public boolean isRobotErr() {
		return "0001".equals(robotErrFlag());
	}

	public boolean isTaskOver() {
		return "0001".equals(taskOverFlag());
	}

	public boolean isTaskSendAndOver() {
		return "0002".equals(taskOverFlag());
	}

	public boolean isTaskSend() {
		return "0003".equals(taskOverFlag());
	}
}
