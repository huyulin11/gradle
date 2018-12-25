package com.kaifantech.util.constant.taskexe.ctrl;

import com.ytgrading.util.AppTool;

public class AgvTaskType {
	public static final String FREE = "FREE";
	public static final String RECEIPT = "RECEIPT";
	public static final String SHIPMENT = "SHIPMENT";
	public static final String INVENTORY = "INVENTORY";
	public static final String TRANSFER = "TRANSFER";
	public static final String ZUHE_RENWU = "ZUHE_RENWU";
	public static final String GOTO_CHARGE = "GOTO_CHARGE";
	public static final String BACK_CHARGE = "BACK_CHARGE";
	public static final String CHANGE_CHARGE = "CHANGE_CHARGE";

	public static final String GOTO_INIT = "GOTO_INIT";

	public static boolean fromUser(String taskid) {
		if (GOTO_CHARGE.equals(taskid) || BACK_CHARGE.equals(taskid)) {
			return true;
		}
		return false;
	}

	public static boolean match(String taskType) {
		if (AppTool.equals(taskType, RECEIPT, SHIPMENT, INVENTORY, GOTO_CHARGE, BACK_CHARGE, CHANGE_CHARGE,
				GOTO_INIT)) {
			return true;
		}
		return false;
	}

	public static boolean chargeOrInit(String taskType) {
		if (AppTool.equals(taskType, GOTO_CHARGE, BACK_CHARGE, CHANGE_CHARGE, GOTO_INIT, GOTO_INIT)) {
			return true;
		}
		return false;
	}
}