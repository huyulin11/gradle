package com.ytgrading.bean;

import java.util.Date;



public class ReqSearchBean {
	private String requestcode;//申请单号
	private String applyTimeK;//申请时间开始
	private String applyTimeJ;//申请时间结束
	private Date applyTime;//申请时间
	private String requestTimeK;//受理时间开始
	private String requestTimeJ;//受理时间结束
	private Date requestTime;//受理时间
	private Date dueTime;//剩余时间
	private Integer totalAmount;//鉴评总数
	private String internalStates;//外部状态
	private String requestStatus;//内部状态
	private  String customer;//收货人姓名
	private Integer usercode;//客户编号
	private String receiverMobile;//收件人手机号码
	private String packageCode;//物流单号
	private String remark;//备注
	private String username;//客户姓名
	private String delflag;
	private String entitytype;
	private String roleId;//角色
	private String serivceRemark;//客服备注
	
	private boolean womFlag;//是否提交出库
	private String deliveryFlag;//发货标识 
	private String sendtype;
	
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	
	public String getDeliveryFlag() {
		return deliveryFlag;
	}
	public void setDeliveryFlag(String deliveryFlag) {
		this.deliveryFlag = deliveryFlag;
	}
	public String getSendtype() {
		return sendtype;
	}
	public void setSendtype(String sendtype) {
		this.sendtype = sendtype;
	}

	//分页的条件
	private Integer page;
	private Integer pagesize;
	private String payinfo;//支付信息
	
	
	//以下是get set 方法
	
	
	public String getSerivceRemark() {
		return serivceRemark;
	}
	public boolean isWomFlag() {
		return womFlag;
	}
	public void setWomFlag(boolean womFlag) {
		this.womFlag = womFlag;
	}
	public void setSerivceRemark(String serivceRemark) {
		this.serivceRemark = serivceRemark;
	}
	
	public String getRequestcode() {
		return requestcode;
	}
	public void setRequestcode(String requestcode) {
		this.requestcode = requestcode;
	}

	public String getApplyTimeK() {
		return applyTimeK;
	}
	public void setApplyTimeK(String applyTimeK) {
		this.applyTimeK = applyTimeK;
	}
	public String getApplyTimeJ() {
		return applyTimeJ;
	}
	public void setApplyTimeJ(String applyTimeJ) {
		this.applyTimeJ = applyTimeJ;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getRequestTimeK() {
		return requestTimeK;
	}
	public void setRequestTimeK(String requestTimeK) {
		this.requestTimeK = requestTimeK;
	}
	public String getRequestTimeJ() {
		return requestTimeJ;
	}
	public void setRequestTimeJ(String requestTimeJ) {
		this.requestTimeJ = requestTimeJ;
	}
	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	public Date getDueTime() {
		return dueTime;
	}
	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getInternalStates() {
		return internalStates;
	}
	public void setInternalStates(String internalStates) {
		this.internalStates = internalStates;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Integer getUsercode() {
		return usercode;
	}
	public void setUsercode(Integer usercode) {
		this.usercode = usercode;
	}
	public String getReceiverMobile() {
		return receiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	public String getPackageCode() {
		return packageCode;
	}
	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public String getPayinfo() {
		return payinfo;
	}
	public void setPayinfo(String payinfo) {
		this.payinfo = payinfo;
	}
	public String getEntitytype() {
		return entitytype;
	}
	public void setEntitytype(String entitytype) {
		this.entitytype = entitytype;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	

	
	
}
