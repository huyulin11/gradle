package com.ytgrading.bean.wms.de;

import java.util.Date;
import java.util.List;

public class IReceiptConfim {

	private int sid;
	private String company;
	private String wareHouse;
	private String receiptId;
	private String receiptType;
	private Date receiptDate;
	private String remark;
	private int totalCount;
	private int status;
	private int extimes;
	private Date updatetime;
	private Date createtime;
	private String item;
	private String itemName;
	private Integer itemCount;
	private String inventorySts;
	private String expirationDate;

	public IReceiptConfim() {
	}

	public IReceiptConfim(IReceiptConfim iReceiptConfim) {
		this.company = iReceiptConfim.company;
		this.wareHouse = iReceiptConfim.wareHouse;
		this.receiptId = iReceiptConfim.receiptId;
		this.receiptType = iReceiptConfim.receiptType;
		this.receiptDate = iReceiptConfim.receiptDate;
		this.remark = iReceiptConfim.remark;
		this.totalCount = iReceiptConfim.totalCount;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getwareHouse() {
		return wareHouse;
	}

	public void setwareHouse(String warehouse) {
		this.wareHouse = warehouse;
	}

	public String getreceiptId() {
		return receiptId;
	}

	public void setreceiptId(String receiptid) {
		this.receiptId = receiptid;
	}

	public String getreceiptType() {
		return receiptType;
	}

	public void setreceiptType(String receipttype) {
		this.receiptType = receipttype;
	}

	public Date getreceiptDate() {
		return receiptDate;
	}

	public void setreceiptDate(Date receiptdate) {
		this.receiptDate = receiptdate;
	}

	public String getremark() {
		return remark;
	}

	public void setremark(String remark) {
		this.remark = remark;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getExtimes() {
		return extimes;
	}

	public void setExtimes(int extimes) {
		this.extimes = extimes;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getitemName() {
		return itemName;
	}

	public void setitemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getitemCount() {
		return itemCount;
	}

	public void setitemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	public String getinventorySts() {
		return inventorySts;
	}

	public void setinventorySts(String inventorySts) {
		this.inventorySts = inventorySts;
	}

	public int gettotalCount() {
		return totalCount;
	}

	public void settotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getexpirationDate() {
		return expirationDate;
	}

	public void setexpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	

}
