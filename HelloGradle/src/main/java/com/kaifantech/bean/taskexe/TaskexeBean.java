package com.kaifantech.bean.taskexe;

import java.util.List;

import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.bean.tasksite.TaskSiteInfoBean;
import com.ytgrading.util.AppTool;

public class TaskexeBean {
	private String uuid;
	private String time;
	private String taskid;
	private Integer agvId;
	private String tasktype;
	private Integer lapId;
	private Integer skuId;
	private Integer allocid;
	private String opflag;
	private Integer autoFlag;
	private List<TaskexeDetailBean> detail;

	private Integer tasksequence;
	private String addedinfo;
	private String addeddesc;

	public TaskexeBean() {
	}

	public TaskexeBean get(List<TaskexeDetailBean> list) {
		if (AppTool.isNull(list)) {
			return null;
		}
		this.detailList = list;
		return this;
	}

	public CsyAgvMsgBean msg;
	public List<TaskexeDetailBean> detailList;
	public TaskexeDetailBean currentDetail = null;
	public TaskexeDetailBean nextDetail = null;
	public TaskexeDetailBean nextCornerDetail = null;
	public TaskSiteInfoBean nextCornerSite = null;
	public double distance2NextCorner = 0;
	public TaskexeDetailBean nextStopDetail = null;
	public TaskSiteInfoBean nextStopSite = null;
	public TaskSiteInfoBean currentSite = null;
	public TaskSiteInfoBean nextSite = null;

	public TaskexeBean(String taskid, Integer allocid, Integer agvId, Integer lapId, Integer skuId, int autoFlag) {
		this.taskid = taskid;
		this.allocid = allocid;
		this.agvId = agvId;
		this.lapId = lapId;
		this.skuId = skuId;
		this.autoFlag = autoFlag;
	}

	public TaskexeBean(String taskid, Integer agvId, int autoFlag) {
		this.taskid = taskid;
		this.agvId = agvId;
		this.autoFlag = autoFlag;
	}

	public TaskexeBean(String taskid, Integer agvId) {
		this.taskid = taskid;
		this.agvId = agvId;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUuid() {
		return uuid;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getTaskid() {
		return taskid;
	}

	public TaskexeBean setOpflag(String opflag) {
		this.opflag = opflag;
		return this;
	}

	public String getOpflag() {
		return opflag;
	}

	public Integer getAgvId() {
		return agvId;
	}

	public void setAGVId(Integer agvId) {
		this.agvId = agvId;
	}

	public Integer getLapId() {
		return lapId;
	}

	public void setLapId(Integer lapId) {
		this.lapId = lapId;
	}

	public String getTasktype() {
		return tasktype;
	}

	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}

	public Integer getAutoFlag() {
		return autoFlag;
	}

	public void setAutoFlag(Integer autoFlag) {
		this.autoFlag = autoFlag;
	}

	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	public Integer getAllocid() {
		return allocid;
	}

	public void setAllocid(Integer allocid) {
		this.allocid = allocid;
	}

	public List<TaskexeDetailBean> getDetail() {
		return detail;
	}

	public void setDetail(List<TaskexeDetailBean> detail) {
		this.detail = detail;
	}

	public String getAddedinfo() {
		return addedinfo;
	}

	public void setAddedinfo(String addedinfo) {
		this.addedinfo = addedinfo;
	}

	public String getAddeddesc() {
		return addeddesc;
	}

	public void setAddeddesc(String addeddesc) {
		this.addeddesc = addeddesc;
	}

	public Integer getTasksequence() {
		return tasksequence;
	}

	public void setTasksequence(Integer sequence) {
		this.tasksequence = sequence;
	}
}
