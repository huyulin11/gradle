package com.kaifantech.bean.singletask;

public class SingletaskBean {
	private String id;
	private String taskName;
	private String taskText;
	private String taskType;
	private String allocOpType;
	private Integer allocid;
	private Integer environmentId;
	private Integer agvId;
	private Integer lapId;
	private int environment;
	private int isSendToAGV;

	public int getEnvironment() {
		return environment;
	}

	public void setEnvironment(int environment) {
		this.environment = environment;
	}

	public String getAllocOpType() {
		return allocOpType;
	}

	public void setAllocOpType(String allocOpType) {
		this.allocOpType = allocOpType;
	}

	public Integer getAllocid() {
		return allocid;
	}

	public void setAllocid(Integer allocid) {
		this.allocid = allocid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskText() {
		return taskText;
	}

	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public Integer getEnvironmentId() {
		return environmentId;
	}

	public void setEnvironmentId(Integer environmentId) {
		this.environmentId = environmentId;
	}

	public Integer getAGVId() {
		return agvId;
	}

	public void setAGVId(Integer agvId) {
		this.agvId = agvId;
	}

	public String toString() {
		return "编号" + id + ",名称：" + taskText;
	}

	public int getIsSendToAgv() {
		return isSendToAGV;
	}

	public void setIsSendToAGV(int isSendToAGV) {
		this.isSendToAGV = isSendToAGV;
	}

	public Integer getLapId() {
		return lapId;
	}

	public void setLapId(Integer lapId) {
		this.lapId = lapId;
	}
}
