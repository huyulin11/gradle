package com.kaifantech.util.constant.taskexe;

import com.kaifantech.bean.taskexe.TaskexeDetailBean;

public class ArrivedAct {
	public static final String START = "0";
	public static final String ALLOC_STOCK = "1";
	public static final String ALLOC_GET = "2";
	public static final String ALLOC_SCAN = "3";
	public static final String CHARGE = "4";
	public static final String WINDOW_STOCK = "5";
	public static final String WINDOW_GET = "6";
	public static final String TURN_LEFT = "7";
	public static final String TURN_RIGHT = "8";
	public static final String STOP = "9";
	public static final String CHANGE_SPEED = "10";

	public static boolean noContinueAct(String act) {
		if (TURN_LEFT.equals(act) || TURN_RIGHT.equals(act) || CHANGE_SPEED.equals(act) || START.equals(act)
				|| STOP.equals(act)) {
			return true;
		}
		return false;
	}

	public static boolean isStopAct(TaskexeDetailBean detail) {
		return isStopAct(detail.getArrivedact());
	}

	public static boolean isStopAct(String act) {
		if (!noContinueAct(act)) {
			return true;
		}
		if (STOP.equals(act)) {
			return true;
		}
		return false;
	}
}
