package com.kaifantech.util.constant.pi;

public interface TaskPathCtrlConstant {

	public static final int NEITHER_WITH_PATH = 1;
	public static final int ONE_WITH_PATH = 2;
	public static final int BOTH_WITH_PATH = 3;

	public static final String NEITHER_WITH_PATH_VALUE = "无无控制";
	public static final String ONE_WITH_PATH_VALUE = "无有控制";
	public static final String BOTH_WITH_PATH_VALUE = "有有控制";

	public static final String TASK_WITH_PATH_VALUE = "有路线";
	public static final String TASK_NON_PATH_VALUE = "无路线";

	public static String getValue(boolean key) {
		return (key ? TaskPathCtrlConstant.TASK_WITH_PATH_VALUE : TaskPathCtrlConstant.TASK_NON_PATH_VALUE);
	}

	public static boolean withPath(int key) {
		if (key == NEITHER_WITH_PATH) {
			return false;
		}
		if (key == ONE_WITH_PATH) {
			return true;
		}
		if (key == BOTH_WITH_PATH) {
			return true;
		}

		return false;
	}
}
