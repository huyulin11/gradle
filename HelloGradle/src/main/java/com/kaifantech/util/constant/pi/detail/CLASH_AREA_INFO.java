package com.kaifantech.util.constant.pi.detail;

import java.util.ArrayList;

public class CLASH_AREA_INFO {

	public static final ClashArea CLASH_AREA_1_1 = new ClashArea(
			new Area(BASIC_INFO.COORDINATE_X_OF_E3 - 10000, BASIC_INFO.COORDINATE_X_OF_E3,
					BASIC_INFO.COORDINATE_Y_MAIN_ROAD_MIDDLE, BASIC_INFO.COORDINATE_Y_MAIN_ROAD_NORTH + 2000));

	public static final ClashArea CLASH_AREA_1_2 = new ClashArea(
			new Area(BASIC_INFO.COORDINATE_X_OF_C3, BASIC_INFO.COORDINATE_X_OF_C3 + 10000,
					BASIC_INFO.COORDINATE_Y_MAIN_ROAD_SOUTH - 2000, BASIC_INFO.COORDINATE_Y_MAIN_ROAD_MIDDLE),
			0, 2000);

	private static ArrayList<Area> addedeClashAreaList = new ArrayList<>();

	static {
		addedeClashAreaList.add(CLASH_AREA_1_1);
		addedeClashAreaList.add(CLASH_AREA_1_2);
	}

	public static final ClashArea CLASH_AREA_1 = new ClashArea(
			new Area(BASIC_INFO.COORDINATE_X_OF_E3, BASIC_INFO.COORDINATE_X_OF_C3,
					BASIC_INFO.COORDINATE_Y_MAIN_ROAD_SOUTH, BASIC_INFO.COORDINATE_Y_MAIN_ROAD_NORTH),
			0, 2000);

	public static final int DISTANCE_IN_LOCATION_ALLOWED_DEVIATION = 1000;
	public static final int DISTANCE_IN_TARGET_ALLOWED_DEVIATION = 1500;

	public static final int DISTANCE_ALLOWED_IN_SAME_ROAD = 2500;

	public static final int DISTANCE_SAFE_WHEN_IN_SAME_ROAD_XY = 8000;
	public static final int DISTANCE_SAFE_WHEN_IN_SAME_ROAD_YY = 8000;
	public static final int DISTANCE_SAFE_WHEN_IN_SAME_ROAD_Y_ONE = 4000;
	public static final int DISTANCE_TO_MIDDLE_ROAD_SAFE_WHEN_IN_SAME_ROAD = 10000;

	public static final int DISTANCE_SAFE_TO_CLASH_AREA = 6000;

}
