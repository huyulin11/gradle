package com.ytgrading.bean;

public class PostInfo {
	//申请单号/客户单号
	private int requestcode;
	//寄件人 客户代码
	private String employeeid;
	//收件人
	private String receiver;
	//收件人电话/手机
	private String receivermobile;
	//收件人 公司名称
	private String customer;
	//客户编号
	private int usercode;
	//收件地址 （国家+省份+城市+县区+街道地址）
	private String address;
	//寄达城市
	private String city;
	//收件 邮编
	private String zip;
	//区号
	private String areaCode;
	//寄件人签名
	private String name;
	//日期
	private String date;
	//总估价
	private String totalevaluate;
	//保价费
	private String totalinsurance;
	//收费保价
	private String sendtype;
	
	public String getTotalinsurance() {
		return totalinsurance;
	}
	public void setTotalinsurance(String totalinsurance) {
		this.totalinsurance = totalinsurance;
	}
	public String getSendtype() {
		return sendtype;
	}
	public void setSendtype(String sendtype) {
		this.sendtype = sendtype;
	}
	public String getTotalevaluate() {
		return totalevaluate;
	}
	public void setTotalevaluate(String totalevaluate) {
		this.totalevaluate = totalevaluate;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public int getRequestcode() {
		return requestcode;
	}
	public void setRequestcode(int requestcode) {
		this.requestcode = requestcode;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getReceivermobile() {
		return receivermobile;
	}
	public void setReceivermobile(String receivermobile) {
		this.receivermobile = receivermobile;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public int getUsercode() {
		return usercode;
	}
	public void setUsercode(int usercode) {
		this.usercode = usercode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
