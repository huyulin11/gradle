package com.ytgrading.bean.wms.de;

import java.util.Date;

public class IDeliveryStatusNotification {
	
	private int sid;
	private String company;
	private String wareHouse;
	private String shipmentId;
	private String stepName;
	private String operationTime;
	private String operationBy;
	private String userDef1;
	private String userDef2;
	private String userDef3;
	private String userDef4;
	private int status;
	private int extimes;
	private Date updatetime;
	private Date createtime;
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
	public String getshipmentId() {
		return shipmentId;
	}
	public void setshipmentId(String shipmentid) {
		this.shipmentId = shipmentid;
	}
	public String getstepName() {
		return stepName;
	}
	public void setstepName(String stepname) {
		this.stepName = stepname;
	}
	public String getoperationTime() {
		return operationTime;
	}
	public void setoperationTime(String operationtime) {
		this.operationTime = operationtime;
	}
	public String getoperationBy() {
		return operationBy;
	}
	public void setoperationBy(String operationBy) {
		this.operationBy = operationBy;
	}
	public String getuserDef1() {
		return userDef1;
	}
	public void setuserDef1(String userdef1) {
		this.userDef1 = userdef1;
	}
	public String getuserDef2() {
		return userDef2;
	}
	public void setuserDef2(String userdef2) {
		this.userDef2 = userdef2;
	}
	public String getuserDef3() {
		return userDef3;
	}
	public void setuserDef3(String userdef3) {
		this.userDef3 = userdef3;
	}
	public String getuserDef4() {
		return userDef4;
	}
	public void setuserDef4(String userdef4) {
		this.userDef4 = userdef4;
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
	
	

}
