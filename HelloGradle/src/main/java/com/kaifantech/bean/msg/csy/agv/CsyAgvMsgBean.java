package com.kaifantech.bean.msg.csy.agv;

import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.iot.CsyAgvStatus;
import com.ytgrading.util.AppTool;

public class CsyAgvMsgBean extends CsyAgvCommBean {
	public static final String MSG_GENERAL_TYPE = "FF";
	public static final String MSG_STATUS_SEARCH_TYPE = "82";
	public static final String MSG_TASK_SEARCH_TYPE = "83";

	public CsyAgvMsgBean(String str) {
		super(str);
	}

	public String getMsgType() {
		return getStr().substring(8, 10);
	}

	public static String getMsgType(String str) {
		return str.substring(10, 12);
	}

	public String getMsgCacheType() {
		return getStr().substring(10, 14);
	}

	public static boolean isAGVDriving(String msg) {
		if (!MSG_STATUS_SEARCH_TYPE.equals(getMsgType(msg))) {
			return true;
		}
		if (!MSG_STATUS_SEARCH_TYPE.equals(getMsgType(msg))) {
			return true;
		}
		return CsyAgvStatus.DRIVING.get().equals(msg.substring(10, 12));
	}

	public boolean isAgvDriving() {
		if (!MSG_STATUS_SEARCH_TYPE.equals(getMsgType())) {
			return true;
		}
		return CsyAgvStatus.DRIVING.get().equals(getStr().substring(10, 12));
	}

	public static String getStatus(String msg) {
		if (!MSG_STATUS_SEARCH_TYPE.equals(getMsgType(msg))) {
			return null;
		}
		return msg.substring(10, 12);
	}

	public String getStatus() {
		if (!MSG_STATUS_SEARCH_TYPE.equals(getMsgType())) {
			return null;
		}
		return getStr().substring(10, 12);
	}

	public boolean isSendDone() {
		if (AppTool.isNull(getStr())) {
			return false;
		}
		if (MSG_GENERAL_TYPE.equals(getStr().substring(8, 10)) && CsyAgvCommBean.TASK.equals(getStr().substring(10, 12))
				&& CsyAgvCommBean.SUCCESS.equals(getStr().substring(12, 14))) {
			return true;
		}
		return false;
	}

	public String getCurrentSite() {
		if (!MSG_STATUS_SEARCH_TYPE.equals(getMsgType())) {
			return null;
		}
		return getStr().substring(12, 16);
	}

	public Integer currentSite() {
		String currentSiteStr = getCurrentSite();
		if (AppTool.isNull(currentSiteStr)) {
			return null;
		}
		return AppByteUtil.str42IntReverse(currentSiteStr);
	}

	public double getCurrentBattery() {
		if (!MSG_STATUS_SEARCH_TYPE.equals(getMsgType())) {
			return 0.0;
		}
		String battery = getStr().substring(40, 44);
		return AppByteUtil.hex4StringToPoint2(battery);
	}

	public String getCurrentSpeed() {
		if (!MSG_STATUS_SEARCH_TYPE.equals(getMsgType())) {
			return null;
		}
		return getStr().substring(30, 32);
	}

	public Integer currentSpeed() {
		String current = getCurrentSpeed();
		if (AppTool.isNull(current)) {
			return null;
		}
		return AppByteUtil.hexStringToInt(current);
	}

	public String getMileage() {
		if (!MSG_STATUS_SEARCH_TYPE.equals(getMsgType())) {
			return null;
		}
		return getStr().substring(16, 24);
	}
}
