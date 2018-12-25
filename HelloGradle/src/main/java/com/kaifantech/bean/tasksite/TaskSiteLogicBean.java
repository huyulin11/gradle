package com.kaifantech.bean.tasksite;

import com.ytgrading.util.AppTool;

public class TaskSiteLogicBean implements Cloneable {
	private Integer siteid;
	private Integer nextid;
	private Integer side;
	private TaskSiteLogicBean pre;

	private double distance;

	public TaskSiteLogicBean(Integer current, Integer next) {
		this.siteid = current;
		this.nextid = next;
	}

	public TaskSiteLogicBean() {
	}

	public static TaskSiteLogicBean path(Integer current, Integer next) {
		return new TaskSiteLogicBean(current, next);
	}

	public Integer getSiteid() {
		return siteid;
	}

	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
	}

	public Integer getNextid() {
		return nextid;
	}

	public void setNextid(Integer nextid) {
		this.nextid = nextid;
	}

	public Integer getSide() {
		return side;
	}

	public void setSide(Integer side) {
		this.side = side;
	}

	public TaskSiteLogicBean getPre() {
		return pre;
	}

	public void setPreOne(TaskSiteLogicBean preList) {
		this.pre = preList;
	}

	public String toString() {
		return "siteid:" + AppTool.v(siteid) + "," + "nextid:" + AppTool.v(nextid) + "," + "side:" + AppTool.v(side);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
