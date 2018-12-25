package com.kaifantech.bean.msg.csy.agv;

import com.kaifantech.util.hex.AppByteUtil;
import com.ytgrading.util.AppTool;

public abstract class CsyAgvCommBean {
	public static final String PREFIX = "55";
	public static final String SUFFIX = "AA";

	public static final String TASK = "04";
	public static final String CONTINUE = "05";
	public static final String STOP = "06";

	public static final String SUCCESS = "00";
	public static final String OTHER = "09";

	public static final Integer VALID_LENGTH = 52;

	public static final Integer ROWS_IN_TABLE = 5000;

	public static final int FULL_DATA_TABLES = 65025 / ROWS_IN_TABLE + 1;

	public static final int KEEP_IN_MEMORY_TABLES = 2;

	private String str;

	public CsyAgvCommBean(String str) {
		setStr(str);
	}

	public static String getMsgID(String msg) {
		return msg.substring(4, 8);
	}

	public String getMsgID() {
		return getStr().substring(4, 8);
	}

	public Integer getNumId() {
		String s = getMsgID();
		return getNumId(s);
	}

	public static Integer getIndexOfCmdId(Integer cmdId) {
		int keyFlagId = 0;
		if (AppTool.isNull(cmdId)) {
			keyFlagId = 0;
		} else {
			keyFlagId = cmdId / ROWS_IN_TABLE;
		}
		return keyFlagId;
	}

	public static Integer getNumId(String msg) {
		String s = msg.substring(2, 4) + msg.substring(0, 2);
		int val = AppByteUtil.hexStringToInt(s);
		return val;
	}

	public static String getAgvId(Integer agvId) {
		return String.format("%2s", String.format("%x", agvId)).replaceAll("\\s", "0");
	}

	public String getAgvId() {
		return getStr().substring(2, 4);
	}

	public Integer agvId() {
		return Integer.parseInt(getAgvId());
	}

	public static String getFancyAGVCheckNumStr(String cmd) {
		int checkNum = 0;
		int ii = 0;
		for (int i = 0; i < cmd.length(); i++) {
			char x = cmd.charAt(i);
			int k = AppByteUtil.charToHex(x);
			ii = ii + k * (i % 2 == 0 ? 16 : 1);
		}
		checkNum = (0x100 - (ii % 0x100)) % 0x100;
		String checkStr = String.format("%2s", Integer.toHexString(checkNum));
		return checkStr;
	}

	public static boolean isValid(String msg) {
		if (AppTool.isNull(msg)) {
			return false;
		}
		if (msg.length() != VALID_LENGTH) {
			return false;
		}
		if (!msg.startsWith(PREFIX)) {
			return false;
		}
		if (!msg.endsWith(SUFFIX)) {
			return false;
		}
		return true;
	}

	public boolean isValid() {
		if (AppTool.isNull(str)) {
			return false;
		}
		if (str.length() != VALID_LENGTH) {
			return false;
		}
		if (!str.startsWith(PREFIX)) {
			return false;
		}
		if (!str.endsWith(SUFFIX)) {
			return false;
		}
		return true;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public static String getKernelFlag(String str) {
		String kernelFlag = str.substring(8, str.length() - 4);
		return kernelFlag;
	}

	public static void main(String[] args) {
		System.out.println(getFancyAGVCheckNumStr("255"));
		System.out.println(getFancyAGVCheckNumStr("1F02001000FF000FD00000000000000000000000000000"));
		System.out.println(String.format("%2s", Integer.toHexString(255)));
	}
}
