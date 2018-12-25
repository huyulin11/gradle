package com.kaifantech.util.constants.plc;

import com.kaifantech.util.constant.taskexe.TurnSide;

public class PlcConstant {
	public static String[] keyVal = { "type", "agvLayer", "window", "windowLayer", "robot", "fork", "frame", "piece" };

	public static PlcParamBean READY_WORK = new PlcParamBean(Allow.YES).setFillZero(false);
	public static PlcParamBean READY_FOR_CHARGE = new PlcParamBean(Allow.YES).setType(Type.PLC_READY_FOR_CHARGE);
	public static PlcParamBean FORBIT_ACT = new PlcParamBean(Allow.NO);
	public static PlcParamBean ERROR_DEAL = new PlcParamBean(Allow.ERROR_DEAL);

	public class Allow {
		public static final String YES = "1";
		public static final String NO = "2";
		public static final String ERROR_DEAL = "3";
	}

	public class Type {
		public static final String WINDOW_TO_AGV = "1";
		public static final String AGV_TO_ALLOC = "2";
		public static final String ALLOC_TO_AGV = "3";
		public static final String AGV_TO_WINDOW = "4";
		public static final String ROBOT_SCAN = "5";
		public static final String PLC_READY_FOR_CHARGE = "6";
		public static final String ROBOT_SCAN_WINDOW = "7";
	}

	public class AgvCacheLayer {
		public static final String ACL_1 = "1";
		public static final String ACL_2 = "2";
		public static final String ACL_3 = "3";
		public static final String ACL_4 = "4";
		public static final String ACL_5 = "5";
		public static final String ACL_6 = "6";
	}

	public class Window {
		public static final String W_1 = "1";
		public static final String W_2 = "2";
		public static final String W_3 = "3";
	}

	public class WindowLayer {
		public static final String WL_1 = "1";
		public static final String WL_2 = "2";
		public static final String WL_3 = "3";
		public static final String WL_4 = "4";
		public static final String WL_5 = "5";
		public static final String WL_6 = "6";
		public static final String WL_7 = "7";
		public static final String WL_8 = "8";
	}

	public class RobotSide {
		public static final String LEFT = "1";
		public static final String RIGHT = "2";
	}

	public class ForkSide {
		public static final String LEFT = "1";
		public static final String RIGHT = "2";
	}

	public class FrameNum {
		public static final String FN_1 = "1";
		public static final String FN_2 = "2";
		public static final String FN_3 = "3";
		public static final String FN_4 = "4";
	}

	public class PieceNum {
		public static final String PN_1 = "1";
		public static final String PN_2 = "2";
		public static final String PN_3 = "3";
		public static final String PN_4 = "4";
		public static final String PN_5 = "5";
		public static final String PN_6 = "6";
		public static final String PN_7 = "7";
		public static final String PN_8 = "8";
		public static final String PN_9 = "9";
		public static final String PN_10 = "10";
		public static final String PN_11 = "11";
		public static final String PN_12 = "12";
	}

	public static String getIndexNum(String allocName) throws Exception {
		return "" + Integer.parseInt(allocName.substring(0, 2));
	}

	public static String getArchiveNum(String allocName) throws Exception {
		return "" + Integer.parseInt(allocName.substring(3, 5));
	}

	public static String getColumnNum(String allocName) throws Exception {
		return "" + Integer.parseInt(allocName.substring(6, 8));
	}

	public static String getFrameNum(String allocName) throws Exception {
		return getFrameNum(Integer.parseInt(allocName.substring(9, 11)));
	}

	public static String getFrameNum(Integer piece) throws Exception {
		int count = piece;
		if (count <= 11) {
			count = 1;
		} else if (count <= 22) {
			count = 2;
		} else if (count <= 33) {
			count = 3;
		} else if (count <= 45) {
			count = 4;
		}
		return "" + count;
	}

	public static String getPieceNum(String allocName) throws Exception {
		int count = Integer.parseInt(allocName.substring(9, 11));
		if (count <= 11) {
		} else if (count <= 22) {
			count = count - 11;
		} else if (count <= 33) {
			count = count - 22;
		} else if (count <= 45) {
			count = count - 33;
		}
		return "" + count;
	}

	public static String getRobotSide(String allocName) throws Exception {
		return getRobotSide(Integer.parseInt(getIndexNum(allocName)));
	}

	public static String getRobotSide(Integer index) throws Exception {
		return "" + (index % 2 == 1 ? TurnSide.LEFT : TurnSide.RIGHT);
	}

	public static String getForkSide(String allocName) throws Exception {
		return getForkSide(Integer.parseInt(allocName.substring(0, 2)), Integer.parseInt(getColumnNum(allocName)));
	}

	public static String getForkSide(Integer line, Integer column) throws Exception {
		return "" + (column % 2 == (line % 2) ? TurnSide.LEFT : TurnSide.RIGHT);
	}

	public static void main(String[] args) {
		try {
			System.out.println(getPieceNum("01-02-03-45"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
