package com.kaifantech.component.service.iot.client.msg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kaifantech.bean.msg.agv.AGVMsgBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.ytgrading.util.AppTool;

public class IotClientLatestMsg {
	private AGVMsgBean agvMsg = new AGVMsgBean();
	private String latestMsgStr = "";

	public IotClientLatestMsg(AGVMsgBean agvMsg, String latestMsgStr) {
		this.agvMsg = agvMsg;
		this.latestMsgStr = latestMsgStr;
	}

	public AGVMsgBean geAGVMsg() {
		return agvMsg;
	}

	public void setAGVMsg(AGVMsgBean latestMsg) {
		this.agvMsg = latestMsg;
	}

	public void setLatestMsgStr(String latestMsgStr) {
		this.latestMsgStr = latestMsgStr;
	}

	public boolean isLatestTaskexeSuccessDone(TaskexeBean command) {
		try {
			if (AppTool.isNull(agvMsg) || AppTool.isNull(agvMsg.getTime())) {
				return false;
			}
			Date latestMsgTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(agvMsg.getTime());
			Date cmdTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(command.getTime());
			if (latestMsgTime.getTime() - cmdTime.getTime() < 10000) {
				return false;
			}
			if (!command.getTaskid().equals(agvMsg.getTaskid()) || !"1".equals(agvMsg.getTaskIsfinished())) {
				return false;
			} else {
				return true;
			}
		} catch (ParseException e) {
			return false;
		}
	}

	public boolean isLatestTaskexeSendDone() {
		try {
			if (AppTool.isNullStr(latestMsgStr) || latestMsgStr.indexOf("task_isfinished=") < 0
					|| !"0".equals(latestMsgStr.substring(
							latestMsgStr.indexOf("task_isfinished=") + "task_isfinished=".length(),
							latestMsgStr.indexOf("task_isfinished=") + "task_isfinished=".length() + 1))) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isAGVPause() {
		try {
			if (AppTool.isNullStr(latestMsgStr) || latestMsgStr.indexOf("pause_stat=") < 0) {
				return false;
			}
			if (!"0".equals(latestMsgStr.substring(latestMsgStr.indexOf("pause_stat=") + "pause_stat=".length(),
					latestMsgStr.indexOf("pause_stat=") + "pause_stat=".length() + 1))) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}