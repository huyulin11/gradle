package com.kaifantech.bean.taskexe;

import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.kaifantech.util.constant.taskexe.WmsDetailOpFlag;
import com.ytgrading.util.AppTool;

public class TaskexeDetailBean {
	private String taskid;
	private Integer siteid;
	private String sitecode;
	private Integer detailsequence;
	private Integer tasksequence;
	private double distancetozero;
	private String arrivedact;
	private String opflag;
	private String addedinfo;
	private String addeddesc;
	private String delflag;

	private TaskSiteInfoBean siteInfo;

	private TaskexeDetailBean past;
	private TaskexeDetailBean next;

	public boolean matchThisSite(CsyAgvMsgBean csyAgvMsgBean) {
		return csyAgvMsgBean.currentSite().equals(getSiteid());
	}

	public boolean matchPastSite(CsyAgvMsgBean csyAgvMsgBean) {
		if (AppTool.isNull(past)) {
			return false;
		}
		return past.matchThisSite(csyAgvMsgBean);
	}

	public boolean matchNextSite(CsyAgvMsgBean csyAgvMsgBean) {
		if (AppTool.isNull(next)) {
			return false;
		}
		return next.matchThisSite(csyAgvMsgBean);
	}

	public boolean matchRelevantSite(CsyAgvMsgBean csyAgvMsgBean) {
		return matchThisSite(csyAgvMsgBean) || matchPastSite(csyAgvMsgBean) || matchNextSite(csyAgvMsgBean);
	}

	public boolean isNew() {
		return WmsDetailOpFlag.NEW.equals(getOpflag());
	}

	public boolean isSend() {
		return WmsDetailOpFlag.SEND.equals(getOpflag());
	}

	public boolean isOver() {
		return WmsDetailOpFlag.OVER.equals(getOpflag());
	}

	public TaskexeDetailBean getPast() {
		return past;
	}

	public void setPast(TaskexeDetailBean past) {
		this.past = past;
	}

	public TaskexeDetailBean getNext() {
		return next;
	}

	public void setNext(TaskexeDetailBean next) {
		this.next = next;
	}

	public TaskexeDetailBean() {
	}

	public TaskexeDetailBean(String taskid, Integer tasksequence) {
		this.taskid = taskid;
		this.tasksequence = tasksequence;
	}

	public TaskexeDetailBean(String taskid, TaskSiteInfoBean tasksiteBean) {
		this.taskid = taskid;
		this.sitecode = tasksiteBean.getSitecode();
		this.siteid = tasksiteBean.getId();
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public Integer getDetailsequence() {
		return detailsequence;
	}

	public TaskexeDetailBean setDetailsequence(Integer sequence) {
		this.detailsequence = sequence;
		return this;
	}

	public String getArrivedact() {
		return arrivedact;
	}

	public void setArrivedact(String arrivedact) {
		this.arrivedact = arrivedact;
	}

	public String getOpflag() {
		return opflag;
	}

	public TaskexeDetailBean setOpflag(String opflag) {
		this.opflag = opflag;
		return this;
	}

	public String getSitecode() {
		return sitecode;
	}

	public void setSitecode(String sitecode) {
		this.sitecode = sitecode;
	}

	public boolean sameSite(TaskexeDetailBean obj) {
		if (!AppTool.isNull(taskid) && !AppTool.isNull(sitecode) && !AppTool.isNull(arrivedact)
				&& !AppTool.isNull(obj.getTaskid()) && !AppTool.isNull(obj.getSitecode())
				&& !AppTool.isNull(obj.getArrivedact()) && taskid.equals(obj.getTaskid())
				&& sitecode.equals(obj.getSitecode()) && arrivedact.equals(obj.getArrivedact())) {
			return true;
		}
		return false;
	}

	public Object clone() {
		TaskexeDetailBean o = null;
		try {
			o = (TaskexeDetailBean) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	public String getAddedinfo() {
		return addedinfo;
	}

	public void setAddedinfo(String addedinfo) {
		this.addedinfo = addedinfo;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public Integer getSiteid() {
		return siteid;
	}

	public TaskexeDetailBean setSiteid(Integer siteid) {
		this.siteid = siteid;
		return this;
	}

	public static double getDistanceOf(TaskexeDetailBean current, TaskexeDetailBean next) {
		if (AppTool.isAnyNull(current, next)) {
			return 0;
		}
		if (AppTool.isAnyNull(current.getDistancetozero(), next.getDistancetozero())) {
			return 0;
		}
		return Math.abs(current.getDistancetozero() - next.getDistancetozero());
	}

	public String toString() {
		return "taskid:" + AppTool.v(taskid) + "," + "siteid:" + AppTool.v(siteid) + "," + "sitecode:"
				+ AppTool.v(sitecode) + "," + "sequence:" + AppTool.v(detailsequence) + "," + "arrivedact:"
				+ AppTool.v(arrivedact) + "," + "opflag:" + AppTool.v(opflag) + "," + "addedinfo:"
				+ AppTool.v(addedinfo);
	}

	public String getAddeddesc() {
		return addeddesc;
	}

	public void setAddeddesc(String addeddesc) {
		this.addeddesc = addeddesc;
	}

	public double getDistancetozero() {
		return distancetozero;
	}

	public void setDistancetozero(double distancetozero) {
		this.distancetozero = distancetozero;
	}

	public Integer getTasksequence() {
		return tasksequence;
	}

	public TaskexeDetailBean setTasksequence(Integer tasksequence) {
		this.tasksequence = tasksequence;
		return this;
	}

	public TaskSiteInfoBean getSiteInfo() {
		return siteInfo;
	}

	public void setSiteInfo(TaskSiteInfoBean siteInfo) {
		this.siteInfo = siteInfo;
	}
}
