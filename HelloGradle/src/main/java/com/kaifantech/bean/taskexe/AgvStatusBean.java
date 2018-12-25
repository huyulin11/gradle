package com.kaifantech.bean.taskexe;

public class AgvStatusBean {
	private String uuid;
	private String time;
	private String jobId;
	private Integer agvId;
	private Integer lapId;
	private Integer skuId;
	private String opflag;
	private Integer autoFlag;

	public AgvStatusBean() {
	}

	public AgvStatusBean(String jobId, Integer agvId, Integer lapId, Integer skuId, int autoFlag) {
		this.jobId = jobId;
		this.agvId = agvId;
		this.lapId = lapId;
		this.skuId = skuId;
		this.autoFlag = autoFlag;
	}

	public AgvStatusBean(String jobId, Integer agvId, int autoFlag) {
		this.jobId = jobId;
		this.agvId = agvId;
		this.autoFlag = autoFlag;
	}

	public AgvStatusBean(String jobId, Integer agvId) {
		this.jobId = jobId;
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

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setOpflag(String opflag) {
		this.opflag = opflag;
	}

	public String getOpflag() {
		return opflag;
	}

	public Integer getAGVId() {
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

}
