package com.kaifantech.util.agv.taskpath;

import java.util.List;

import com.kaifantech.bean.msg.agv.TaskPathInfoPointBean;

public class TaskPathInfoMap {
	private Integer agvId;
	private String taskid;
	private List<TaskPathInfoPointBean> pathList;

	public TaskPathInfoMap() {
	}

	public TaskPathInfoMap(List<TaskPathInfoPointBean> taskPath) {
		if (taskPath != null && taskPath.size() > 0) {
			this.setTaskid(taskPath.get(0).getTaskid());
			this.setAGVId(taskPath.get(0).getAGVId());
			this.setPathList(taskPath);
		}
	}

	public Integer getAGVId() {
		return agvId;
	}

	public void setAGVId(Integer agvId) {
		this.agvId = agvId;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public List<TaskPathInfoPointBean> getPathList() {
		return pathList;
	}

	public void setPathList(List<TaskPathInfoPointBean> pathList) {
		this.pathList = pathList;
	}
}
