package com.kaifantech.bean.taskexe;

public class TaskexeDetailWorksBean extends TaskexeDetailBean {
	private Integer worksequence;

	public TaskexeDetailWorksBean() {
	}

	public TaskexeDetailWorksBean setOpflag(String opflag) {
		super.setOpflag(opflag);
		return this;
	}

	public TaskexeDetailWorksBean(TaskexeDetailBean taskexeDetail) {
		this.setArrivedact(taskexeDetail.getAddedinfo());
		this.setTaskid(taskexeDetail.getTaskid());
		this.setSiteid(taskexeDetail.getSiteid());
		this.setDetailsequence(taskexeDetail.getDetailsequence());
		this.setTasksequence(taskexeDetail.getTasksequence());
		this.setArrivedact(taskexeDetail.getArrivedact());
	}

	public Integer getWorksequence() {
		return worksequence;
	}

	public TaskexeDetailWorksBean setWorksequence(Integer worksequence) {
		this.worksequence = worksequence;
		return this;
	}
}
