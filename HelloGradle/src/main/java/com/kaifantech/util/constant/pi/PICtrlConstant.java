package com.kaifantech.util.constant.pi;

public interface PICtrlConstant {
	public static final int PARALLEL = 4;
	public static final int VERTICAL = 5;
	public static final int OTHERS = 6;
	public static final int MAINCTRL = 7;
	public static final int CLASHAREA = 8;

	public static final String PARALLEL_VALUE = "平行控制";
	public static final String VERTICAL_VALUE = "垂直控制";
	public static final String OTHERS_VALUE = "非正角控制";
	public static final String MAINCTRL_VALUE = "总控控制";
	public static final String CLASHAREA_VALUE = "易冲突区域控制";

	public static String getValue(int key) {
		if (key == PICtrlConstant.PARALLEL) {
			return PICtrlConstant.PARALLEL_VALUE;
		}
		if (key == PICtrlConstant.VERTICAL) {
			return PICtrlConstant.VERTICAL_VALUE;
		}
		if (key == PICtrlConstant.OTHERS) {
			return PICtrlConstant.OTHERS_VALUE;
		}
		if (key == PICtrlConstant.MAINCTRL) {
			return PICtrlConstant.MAINCTRL_VALUE;
		}
		if (key == PICtrlConstant.CLASHAREA) {
			return PICtrlConstant.CLASHAREA_VALUE;
		}

		return null;
	}

}
