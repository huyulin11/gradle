package com.kaifantech.bean.wms.paper.receipt;

import com.kaifantech.bean.wms.paper.base.WmsPaperMainBean;

public class ReceiptMainBean extends WmsPaperMainBean<ReceiptDetailBean> {
	private String company;
	private String warehouse;
	private String totalqty;
	private String totallines;
	private String receipttype;
	private String orderdate;
	private String agvid;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getTotalqty() {
		return totalqty;
	}

	public void setTotalqty(String totalqty) {
		this.totalqty = totalqty;
	}

	public String getTotallines() {
		return totallines;
	}

	public void setTotallines(String totallines) {
		this.totallines = totallines;
	}

	public String getReceipttype() {
		return receipttype;
	}

	public void setReceipttype(String receipttype) {
		this.receipttype = receipttype;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getAgvid() {
		return agvid;
	}

	public void setAgvid(String agvid) {
		this.agvid = agvid;
	}

	public String toString() {
		return "id:" + getId() + ",paperid:" + getPaperid();
	}
}
