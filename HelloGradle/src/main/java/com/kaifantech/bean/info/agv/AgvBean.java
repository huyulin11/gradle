package com.kaifantech.bean.info.agv;

import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvSiteStatus;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;

public class AgvBean {

	private Integer id;
	private int environment;

	private String ttaskid;
	private String battery;
	private String movestatus;
	private String sitestatus;
	private String taskstatus;
	private String agvstatus;

	private String plcstatus;

	private Integer currentsite;
	private Integer speed;

	private Integer chargeid;

	public static final String NEED_CHARGE = "需要充电";
	public static final String CONNECT_FAIL = "未连接";
	public static final String ROBOT_FAIL = "机器人异常";
	public static final String PLC_FAIL = "PLC连接异常";

	public boolean isCharging() {
		return AgvTaskType.GOTO_CHARGE.equals(getTaskstatus())
				&& (AgvSiteStatus.CHARGING.equals(getSitestatus()) || AgvSiteStatus.MOVING.equals(getSitestatus()));
	}

	public String getMovestatus() {
		return movestatus;
	}

	public void setMovestatus(String movestatus) {
		this.movestatus = movestatus;
	}

	public String getSitestatus() {
		return sitestatus;
	}

	public void setSitestatus(String sitestatus) {
		this.sitestatus = sitestatus;
	}

	public String getTaskstatus() {
		return taskstatus;
	}

	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}

	public int getEnvironment() {
		return environment;
	}

	public void setEnvironment(int environment) {
		this.environment = environment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getTaskid() {
		return ttaskid;
	}

	public void setTaskid(String currenttaskid) {
		this.ttaskid = currenttaskid;
	}

	public Integer getChargeid() {
		return chargeid;
	}

	public void setChargeid(Integer chargeid) {
		this.chargeid = chargeid;
	}

	public Integer getCurrentsite() {
		return currentsite;
	}

	public void setCurrentsite(Integer currentsite) {
		this.currentsite = currentsite;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer currentspeed) {
		this.speed = currentspeed;
	}

	public String getAgvstatus() {
		return agvstatus;
	}

	public void setAgvstatus(String agvstatus) {
		this.agvstatus = agvstatus;
	}

	public String toString() {
		return "" + id;
	}

	public String getPlcstatus() {
		return plcstatus;
	}

	public void setPlcstatus(String plcstatus) {
		this.plcstatus = plcstatus;
	}
}
