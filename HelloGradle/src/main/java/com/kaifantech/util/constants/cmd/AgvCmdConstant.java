package com.kaifantech.util.constants.cmd;

import java.util.Arrays;
import java.util.List;

import com.ytgrading.util.AppTool;

public class AgvCmdConstant {
	public static final String CMD_GENERAL_SEARCH = "02";
	public static final String CMD_TASK_SEARCH = "03";
	public static final String CMD_CACHE_SEARCH = "1100";

	public static final String CMD_CONTINUE = "05";
	public static final String CMD_STOP = "06";
	public static final String CMD_SPEED = "08";

	public static final String CMD_TURN = "07";
	public static final String CMD_TURN_LEFT = "02";
	public static final String CMD_TURN_RIGHT = "03";

	public static final String CMD_TASK_CACHE = "1000";
	public static final String CMD_TASK_DELETE_ONE_CACHE = "1001";
	public static final String CMD_TASK_CLEAR_ALL_CACHE = "1002";
	public static final String CMD_TASK_CACHE_STOP = "0500";
	public static final String CMD_TASK_CACHE_CONTINUE = "0600";
	public static final String CMD_TASK_CACHE_SPEED = "01";
	public static final String CMD_TASK_CACHE_SPEED_80 = CMD_TASK_CACHE_SPEED + "50";
	public static final String CMD_TASK_CACHE_SPEED_50 = CMD_TASK_CACHE_SPEED + "32";
	public static final String CMD_TASK_CACHE_SPEED_25 = CMD_TASK_CACHE_SPEED + "19";
	public static final String CMD_TASK_CACHE_SPEED_10 = CMD_TASK_CACHE_SPEED + "0A";
	public static final String CMD_TASK_CACHE_TEST_LOW_SPEED = CMD_TASK_CACHE_SPEED + "05";

	public static final String CMD_TASK_CACHE_OBSTACLE_CHANNEL_NORMAL = "0B0A";
	public static final String CMD_TASK_CACHE_OBSTACLE_CHANNEL_CORNER = "0B0B";

	public static final String CMD_TASK_CACHE_CLEAR = "1300";
	public static final String CMD_TASK_CACHE_TURN_LEFT = "0900";
	public static final String CMD_TASK_CACHE_TURN_RIGHT = "0901";

	public static final String CMD_OBSTACLE_CHANNEL_NORMAL = "0E0A";
	public static final String CMD_OBSTACLE_CHANNEL_CORNER = "0E0B";

	public static final double DISTANCE_LOW_TO_STOP = 4;
	public static final double DISTANCE_LOW_READY_STOP = 8;
	public static final double DISTANCE_LOW_PREPARE_STOP = 14;
	public static final double DISTANCE_JUDGE_CORNER_HIGH_SLOWER = 17;
	public static final double DISTANCE_JUDGE_CORNER_OUT_2_ALLOC = 12;
	public static final double DISTANCE_JUDGE_CORNER_ALLOC_2_OUT = 8;

	public static final int SPEED_80 = 80;
	public static final int SPEED_50 = 50;
	public static final int SPEED_LOW_READY_STOP = 10;
	public static final int SPEED_LOW_TO_STOP = 10;
	public static final int SPEED_LOW_CORNER = 25;
	public static final int SPEED_25 = 25;

	public static final String SPEED_CTRL_OBSTACLE = "OBSTACLE";
	public static final String SPEED_CTRL_SPEED = "SPEED";
	public static final String OBSTACLE_CORNER = "CORNER";
	public static final String OBSTACLE_NORMAL = "NORMAL";

	public static final List<Integer> LOOP_SITE_LIST = Arrays.asList(68, 481, 479, 480, 482, 20);

	public static boolean isCacheCmd(String cmd) {
		if (AppTool.isNull(cmd)) {
			return false;
		}
		if (cmd.startsWith(CMD_TASK_CACHE) || cmd.startsWith(CMD_TASK_DELETE_ONE_CACHE)
				|| cmd.startsWith(CMD_TASK_CLEAR_ALL_CACHE)) {
			return true;
		}
		return false;
	}
}
