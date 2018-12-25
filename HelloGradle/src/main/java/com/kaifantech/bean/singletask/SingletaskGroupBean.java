package com.kaifantech.bean.singletask;

public class SingletaskGroupBean {
	private String parentTaskid;
	private String taskid;

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getParentTaskid() {
		return parentTaskid;
	}

	public void setParentTaskid(String parentTaskid) {
		this.parentTaskid = parentTaskid;
	}
}
