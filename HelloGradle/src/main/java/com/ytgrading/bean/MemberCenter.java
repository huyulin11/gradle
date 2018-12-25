package com.ytgrading.bean;

public class MemberCenter {
	/**
	 * 草稿
	 */
	private int draft;
	/**
	 * 待确认
	 */
	private int confirm;
	/**
	 * 待支付
	 */
	private int pay;
	/**
	 * 待取件
	 */
	private int send;
	/**
	 * 评审中
	 */
	
	private int total;
	/**
	 * 汇款通知
	 */
	
	private int remit;
	/**
	 * 退款通知
	 */
	
	private int refund;


	public MemberCenter(int draft, int confirm, int pay, int send, int total,
			int remit, int refund) {
		super();
		this.draft = draft;
		this.confirm = confirm;
		this.pay = pay;
		this.send = send;
		this.total = total;
		this.remit = remit;
		this.refund = refund;
	}
	

	public MemberCenter() {
		super();
	}


	public int getConfirm() {
		return confirm;
	}

	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getSend() {
		return send;
	}

	public void setSend(int send) {
		this.send = send;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRemit() {
		return remit;
	}

	public void setRemit(int remit) {
		this.remit = remit;
	}

	public int getRefund() {
		return refund;
	}

	public void setRefund(int refund) {
		this.refund = refund;
	}

	public int getDraft() {
		return draft;
	}

	public void setDraft(int draft) {
		this.draft = draft;
	}

}
