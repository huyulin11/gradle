package com.ytgrading.bean;


public class DataBean {
	private Integer draft;
	// 待确认
	private Integer confirm;
	// 评审中
	private Integer total;
	// 评审中状态
	// 待支付
	private Integer pay;
	// 待取件
	private Integer send;
	public Integer getDraft() {
		return draft;
	}
	public void setDraft(Integer draft) {
		this.draft = draft;
	}
	public Integer getConfirm() {
		return confirm;
	}
	public void setConfirm(Integer confirm) {
		this.confirm = confirm;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPay() {
		return pay;
	}
	public void setPay(Integer pay) {
		this.pay = pay;
	}
	public Integer getSend() {
		return send;
	}
	public void setSend(Integer send) {
		this.send = send;
	}
	
}
