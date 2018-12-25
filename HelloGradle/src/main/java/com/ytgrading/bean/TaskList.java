package com.ytgrading.bean;

public class TaskList {
	private String requestid;
	private String code;
	private String fullsubject;
	private String boxcode;
	private String requesttime;
	private String requeststatus;
	private String speed;
	private String totalamount;
	private String flag;
	private String status;
	private String updatetime;
	private int differtime;
	private String duetime;
	private String remainingtime;
	private String chatimgpath; // 制图制图图片路径
	private String sendtype;
	private int rebackreqNum; // 正在回退的单子数量
	private int entityType;// 申请单类型

	public int getRebackreqNum() {
		return rebackreqNum;
	}

	public void setRebackreqNum(int rebackreqNum) {
		this.rebackreqNum = rebackreqNum;
	}

	public String getSendtype() {
		return sendtype;
	}

	public void setSendtype(String sendtype) {
		this.sendtype = sendtype;
	}

	public String getChatimgpath() {
		return chatimgpath;
	}

	public void setChatimgpath(String chatimgpath) {
		this.chatimgpath = chatimgpath;
	}

	private String casechartimgpath; // 打盒制图图片路径
	private String payinfo;
	private int paydiffertime;
	private String payremainingtime;

	public String getCasechartimgpath() {
		return casechartimgpath;
	}

	public void setCasechartimgpath(String casechartimgpath) {
		this.casechartimgpath = casechartimgpath;
	}

	public String getRemainingtime() {
		return remainingtime;
	}

	public void setRemainingtime(String remainingtime) {
		this.remainingtime = remainingtime;
	}

	public int getDiffertime() {
		return differtime;
	}

	public void setDiffertime(int differtime) {
		this.differtime = differtime;
	}

	public String getDuetime() {
		return duetime;
	}

	public void setDuetime(String duetime) {
		this.duetime = duetime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBoxcode() {
		return boxcode;
	}

	public void setBoxcode(String boxcode) {
		this.boxcode = boxcode;
	}

	public String getRequesttime() {
		return requesttime;
	}

	public void setRequesttime(String requesttime) {
		this.requesttime = requesttime.replace(".0", "");
	}

	public String getRequeststatus() {
		return requeststatus;
	}

	public void setRequeststatus(String requeststatus) {
		this.requeststatus = requeststatus;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(String totalamount) {
		this.totalamount = totalamount;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	public String getFullsubject() {
		return fullsubject;
	}

	public void setFullsubject(String fullsubject) {
		this.fullsubject = fullsubject;
	}

	public String getPayinfo() {
		return payinfo;
	}

	public void setPayinfo(String payinfo) {
		this.payinfo = payinfo;
	}

	public int getPaydiffertime() {
		return paydiffertime;
	}

	public void setPaydiffertime(int paydiffertime) {
		this.paydiffertime = paydiffertime;
	}

	public String getPayremainingtime() {
		return payremainingtime;
	}

	public void setPayremainingtime(String payremainingtime) {
		this.payremainingtime = payremainingtime;
	}

	public int getEntityType() {
		return entityType;
	}

	public void setEntityType(int entityType) {
		this.entityType = entityType;
	}
}
