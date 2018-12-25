package com.ytgrading.bean.wms.de;

import java.util.Date;

public class IShipmentConfim {
	
	private int sid;
	private String company;
	private String wareHouse;
	private String shipmentId;
	private String carrier;
	private String trackingNumber;
	private double fee;
	private String suppliesId;
	private String oQCBench;
	private String weight;
	private String remark;
	private Date shipmentDate;
	private String item;
	private String itemName;
	private int itemCount;
	private String lot;
	private String inventorySts;
	private String expirationDate;
	private int status;
	private int extimes;
	private Date updatetime;
	private Date createtime;
	
	public IShipmentConfim() {
	}

	public IShipmentConfim(IShipmentConfim iShipmentConfim) {
		this.company = iShipmentConfim.company;
		this.wareHouse = iShipmentConfim.wareHouse;
		this.shipmentId = iShipmentConfim.shipmentId;
		this.carrier = iShipmentConfim.carrier;
		this.trackingNumber = iShipmentConfim.trackingNumber;
		this.suppliesId = iShipmentConfim.suppliesId;
		this.oQCBench = iShipmentConfim.oQCBench;
		this.shipmentDate = iShipmentConfim.shipmentDate;
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
	public String getshipmentId() {
		return shipmentId;
	}
	public void setshipmentId(String shipmentid) {
		this.shipmentId = shipmentid;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String gettrackingNumber() {
		return trackingNumber;
	}
	public void settrackingNumber(String trackingnumber) {
		this.trackingNumber = trackingnumber;
	}
	public String getsuppliesId() {
		return suppliesId;
	}
	public void setsuppliesId(String suppliesid) {
		this.suppliesId = suppliesid;
	}
	public String getoQCBench() {
		return oQCBench;
	}
	public void setoQCBench(String oqcbench) {
		this.oQCBench = oqcbench;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getremark() {
		return remark;
	}
	public void setremark(String remark) {
		this.remark = remark;
	}
	public Date getshipmentDate() {
		return shipmentDate;
	}
	public void setshipmentDate(Date shipmentdate) {
		this.shipmentDate = shipmentdate;
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
	public void setitemName(String itemname) {
		this.itemName = itemname;
	}
	public int getitemCount() {
		return itemCount;
	}
	public void setitemCount(int itemcount) {
		this.itemCount = itemcount;
	}
	public String getlot() {
		return lot;
	}
	public void setlot(String lot) {
		this.lot = lot;
	}
	public String getinventorySts() {
		return inventorySts;
	}
	public void setinventorySts(String inventorysts) {
		this.inventorySts = inventorysts;
	}
	public String getexpirationDate() {
		return expirationDate;
	}
	public void setexpirationDate(String expirationdate) {
		this.expirationDate = expirationdate;
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

	public double getfee() {
		return fee;
	}

	public void setfee(double fee) {
		this.fee = fee;
	}
	
	

}
