package com.kaifantech.util.iot;

public enum CsyAgvStatus {
	STOPPING("00"), // 待机停车
	DRIVING("01"), // 行驶状态
	JERK("02"), // 急停触发
	BUG1("03"), // 驱动器故障
	BUG2("04"), // 脱线
	BUG3("05"), // 满线
	BUG4("06"), // 机械防撞触发
	OBSTACLE("07"), // 光电避障传感器触发
	BUG6("08"), // 电量不足
	BUG7("09"), // 内部错误
	BUG8("0A"), // 调度指令超时或中断
	UNREADY("FF"); // 未准备
	private final String val;

	private CsyAgvStatus(String val) {
		this.val = val;
	}

	public String get() {
		return val;
	}

	public static String getStatusName(String val) {
		if ("00".equals(val)) {
			return "待机停车";
		} else if ("01".equals(val)) {
			return "行驶状态";
		} else if ("02".equals(val)) {
			return "急停触发";
		} else if ("03".equals(val)) {
			return "驱动器故障";
		} else if ("04".equals(val)) {
			return "脱线";
		} else if ("05".equals(val)) {
			return "满线";
		} else if ("06".equals(val)) {
			return "机械防撞触发";
		} else if ("07".equals(val)) {
			return "光电避障传感器触发";
		} else if ("08".equals(val)) {
			return "电量不足";
		} else if ("09".equals(val)) {
			return "内部错误";
		} else if ("0A".equals(val)) {
			return "调度指令超时或中断";
		} else if ("FF".equals(val)) {
			return "未准备";
		}
		return null;
	}
}
