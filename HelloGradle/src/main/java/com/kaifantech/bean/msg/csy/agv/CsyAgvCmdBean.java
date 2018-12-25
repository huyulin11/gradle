package com.kaifantech.bean.msg.csy.agv;

import java.util.HashMap;
import java.util.Map;

import com.kaifantech.util.constants.cmd.AgvCmdConstant;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppArraysUtil;
import com.ytgrading.util.AppTool;

public class CsyAgvCmdBean extends CsyAgvCommBean {

	private static Map<Integer, Integer> nextCmdId = new HashMap<Integer, Integer>();

	public CsyAgvCmdBean(String str) {
		super(str);
	}

	public String getKernelFlag() {
		String kernelFlag = getStr().substring(8, getStr().length() - 4);
		return kernelFlag;
	}

	public String getCmdType() {
		return getStr().substring(8, 10);
	}

	public String getCmdCacheType() {
		return getStr().substring(8, 12);
	}

	public String getTargetSite() {
		return getStr().substring(12, 16);
	}

	public Integer getSiteId() {
		String s = getTargetSite();
		if (AppTool.isNull(s) || s.length() != 4) {
			return null;
		}
		int val = AppByteUtil.hexStringToInt(s.substring(2, 4) + s.substring(0, 2));
		return val;
	}

	public static String getCmdType(String str) {
		return str.substring(8, 10);
	}

	public synchronized static Map<Integer, Integer> getNextCmdIdMap() {
		return nextCmdId;
	}

	public synchronized static String getnextCmdIdStr(Integer agvId) {
		Integer currentCmdId = nextCmdId.get(agvId);
		if (AppTool.isNull(currentCmdId)) {
			currentCmdId = 0x0000;
		}
		if (currentCmdId >= 0xFFFF) {
			currentCmdId = 0x0000;
		}
		nextCmdId.put(agvId, ++currentCmdId);
		String currentCmd = String.format("%2s", Integer.toHexString(currentCmdId % 256))
				+ String.format("%2s", Integer.toHexString(currentCmdId / 256 % 256));
		return currentCmd.replaceAll("\\s", "0");
	}

	public static String getSitecode(int id) {
		return AppByteUtil.int2Str4(id);
	}

	public static String getTaskCacheCmd(Integer agvId, String... cmds) {
		return getTaskCmd(agvId, AppArraysUtil.addInFirst(cmds, AgvCmdConstant.CMD_TASK_CACHE));
	}

	public static String getTaskCmd(Integer agvId, String... cmds) {
		if (AppTool.isNull(cmds)) {
			return null;
		}
		String finalCmd = "";
		finalCmd = getAgvId(agvId) + getnextCmdIdStr(agvId);
		for (String cmd : cmds) {
			finalCmd += cmd;
		}
		while (finalCmd.length() < 46) {
			finalCmd += "00";
		}
		finalCmd = finalCmd.replaceAll("\\s", "0");
		finalCmd = finalCmd + getFancyAGVCheckNumStr(finalCmd);
		finalCmd = PREFIX + finalCmd + SUFFIX;
		finalCmd = finalCmd.toUpperCase();
		finalCmd = finalCmd.replaceAll("\\s", "0");
		return finalCmd;
	}

	public static String getTaskCmd34(Integer agvId, String... cmds) {
		if (AppTool.isNull(cmds)) {
			return null;
		}
		String finalCmd = "";
		finalCmd = getAgvId(agvId);
		for (String cmd : cmds) {
			finalCmd += cmd;
		}
		while (finalCmd.length() < 26) {
			finalCmd += "00";
		}
		finalCmd = finalCmd.replaceAll("\\s", "0");
		finalCmd = finalCmd + getFancyAGVCheckNumStr(finalCmd);
		finalCmd = PREFIX + finalCmd + SUFFIX;
		finalCmd = finalCmd.toUpperCase();
		finalCmd = finalCmd.replaceAll("\\s", "0");
		return finalCmd;
	}

	public static void main(String[] args) {
		while (true) {
			System.out.println(getnextCmdIdStr(1));
			System.out.println(getTaskCmd(3, "110144"));
			ThreadTool.sleep(1000);
		}
	}
}
