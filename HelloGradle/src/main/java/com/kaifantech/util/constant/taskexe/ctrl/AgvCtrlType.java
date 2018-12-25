package com.kaifantech.util.constant.taskexe.ctrl;

public interface AgvCtrlType {
	public static final Integer AGV_PAUSE_BY_USER_VALUE = -1;
	public static final Integer AGV_PAUSE_BY_SYSTEM_VALUE = -2;
	public static final Integer AGV_CONTINUE_VALUE = 0;
	public static final String AGVS_STOP_PI = "stopPI";
	public static final String AGVS_OPEN_PI = "openPI";

	public static final String AGVS_STOP_AUTO_TASK = "stopAutoTask";
	public static final String AGVS_OPEN_AUTO_TASK = "openAutoTask";

	public static final String AGVS_STOP_PI_STR = "关闭交通管制";
	public static final String AGVS_OPEN_PI_STR = "打开交通管制";

	public static final String AGVS_STOP_AUTO_TASK_STR = "关闭自动任务功能";
	public static final String AGVS_OPEN_AUTO_TASK_STR = "打开自动任务功能";

	public static final String INFO = "SYSINFO";
	public static final String WARNING = "SYSWARNING";
	public static final String ERROR = "SYSERROR";

	public static class AgvMoveStatus {
		public static final String PAUSE_USER = "PAUSE_USER";
		public static final String PAUSE_SYS = "PAUSE_SYS";
		public static final String PAUSE_ERR = "PAUSE_ERR";
		public static final String CONTINUE = "CONTINUE";
		public static final String SHUTDOWN = "SHUTDOWN";

		public static boolean contains(String taskid) {
			if (CONTINUE.equals(taskid) || PAUSE_USER.equals(taskid) || PAUSE_SYS.equals(taskid)) {
				return true;
			}
			return false;
		}
	}

	public static class IotDevType {
		public static final Integer AGV = 0;
		public static final Integer RONOT_ON_AGV = 1;
		public static final Integer SCAN = 3;
		public static final Integer PLC_ON_AGV = 4;
		public static final Integer CHARGE = 5;
		public static final Integer WINDOW = 6;
		public static final Integer ROBOT_GOODS_FROM = 9;
	}

	public static class AgvSiteStatus {
		public static final String INIT = "INIT";
		public static final String MOVING = "MOVING";
		public static final String WINDOW_GET = "WINDOW_GET";
		public static final String WINDOW_STOCK = "WINDOW_STOCK";

		public static final String ALLOC_STOCK = "ALLOC_STOCK";
		public static final String ALLOC_GET = "ALLOC_GET";
		public static final String ALLOC_SCAN = "ALLOC_SCAN";

		public static final String CHARGING = "CHARGING";

		public static String alloc(String taskType) {
			if (AgvTaskType.RECEIPT.equals(taskType)) {
				return ALLOC_STOCK;
			}
			if (AgvTaskType.SHIPMENT.equals(taskType)) {
				return ALLOC_GET;
			}
			if (AgvTaskType.INVENTORY.equals(taskType)) {
				return ALLOC_SCAN;
			}
			return null;
		}

		public static String window(String taskType) {
			if (AgvTaskType.RECEIPT.equals(taskType)) {
				return WINDOW_GET;
			}
			if (AgvTaskType.SHIPMENT.equals(taskType)) {
				return WINDOW_STOCK;
			}
			return null;
		}
	}
}
