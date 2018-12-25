package com.kaifantech.util.constant.pi.detail;

import com.kaifantech.bean.msg.agv.IXYBean;
import com.ytgrading.util.AppTool;

public class BASIC_INFO {
	public static final int DISTANCE_IN_LINE_DANGEROUS = 1700;
	public static final int DISTANCE_IN_LINE_SAFE = 3000;
	public static final int DISTANCE_XY_REPEAT_POINT = 100;
	public static final int ANGLE_ALLOWED_DEVIATION = 45;
	public static final int ANGLE_ALLOWED_DEVIATION_STRICT = 10;
	public static final int FORKLIFT_LENGTH = 3200;

	public static final int COORDINATE_Y_MAIN_ROAD_NORTH = 1500;
	public static final int COORDINATE_Y_MAIN_ROAD_SOUTH = -2600;
	public static final int COORDINATE_Y_MAIN_ROAD_MIDDLE = (COORDINATE_Y_MAIN_ROAD_NORTH
			+ COORDINATE_Y_MAIN_ROAD_SOUTH) / 2;

	public static final int COORDINATE_X_OF_LAP1 = -13570;
	public static final int COORDINATE_X_OF_LAP2 = -10750;
	public static final int COORDINATE_X_OF_LAP3 = -6650;
	public static final int COORDINATE_X_OF_FORKLIFT4 = 3470;

	public static final int COORDINATE_X_OF_E3 = -21650;
	public static final int COORDINATE_X_OF_C3 = -3650;

	public static final int COORDINATE_y_OF_ROBOTIC_ARM = -11000;

	public static final int BASIC_SPEED = 800;
	public static final int BASIC_SPEED_RADIX = 300;
	public static final int DISTANCE_CTRL_FOR_FAST = 2400;

	public static double addedDistance(double currentSpeed) {
		if (Math.abs(currentSpeed) <= BASIC_SPEED) {
			return 0;
		}
		return (Math.abs(currentSpeed) - BASIC_SPEED) * DISTANCE_CTRL_FOR_FAST / BASIC_SPEED_RADIX;
	}

	public static double addedDistance(IXYBean msg) {
		if (AppTool.isNull(msg)) {
			return 0;
		}
		return addedDistance(msg.getSpeed());
	}
}
