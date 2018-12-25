package com.ytgrading.dto;

import java.util.Date;

import com.ytgrading.bean.RequestBean;

public class RequestMainOpLogBean {
	private int id;
	private String requestcode;
	private String opType;
	private int opusertype;
	private String opuserid;
	private String preuserid;
	private String posuserid;
	private String prerequestinnstatus;
	private String posrequestinnstatus;
	private String prerequestoutstatus;
	private String posrequestoutstatus;
	private String pretotalcost;
	private String postotalcost;
	private Integer pretotalamount;
	private Integer postotalamount;
	private String remark;
	private Date createtime;

	/** 简单的状态变更 */
	public static RequestMainOpLogBean getRequestMainOpLogBean(
			RequestBean requestBean, String opType, String opusertype,
			String opuserid) {
		return RequestMainOpLogBean.getRequestMainOpLogBean(requestBean,
				requestBean, opType, opusertype, opuserid, null);
	}

	/** 简单的状态变更 */
	public static RequestMainOpLogBean getRequestMainOpLogBean(
			RequestBean preRequestBean, RequestBean posRequestBean,
			String opType, String opusertype, String opuserid, String remark) {
		RequestMainOpLogBean requestMainOpLogBean = new RequestMainOpLogBean();
		requestMainOpLogBean.setOpType(opType);
		requestMainOpLogBean.setOpuserid(opuserid);
		requestMainOpLogBean.setRemark(remark);

		requestMainOpLogBean.setPreuserid(preRequestBean.getUserid());
		requestMainOpLogBean.setPosuserid(posRequestBean.getUserid());
		requestMainOpLogBean.setPrerequestinnstatus(preRequestBean
				.getInternalstates());
		requestMainOpLogBean.setPosrequestinnstatus(posRequestBean
				.getInternalstates());
		requestMainOpLogBean.setPrerequestoutstatus(preRequestBean
				.getRequeststatus());
		requestMainOpLogBean.setPosrequestoutstatus(posRequestBean
				.getRequeststatus());
		requestMainOpLogBean.setPretotalcost(preRequestBean.getTotalcost());
		requestMainOpLogBean.setPostotalcost(posRequestBean.getTotalcost());
		requestMainOpLogBean.setPretotalamount(preRequestBean.getTotalamount());
		requestMainOpLogBean.setPostotalamount(posRequestBean.getTotalamount());
		return requestMainOpLogBean;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRequestcode() {
		return requestcode;
	}

	public void setRequestcode(String requestcode) {
		this.requestcode = requestcode;
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public int getOpusertype() {
		return opusertype;
	}

	public void setOpusertype(int opusertype) {
		this.opusertype = opusertype;
	}

	public String getOpuserid() {
		return opuserid;
	}

	public void setOpuserid(String opuserid) {
		this.opuserid = opuserid;
	}

	public String getPreuserid() {
		return preuserid;
	}

	public void setPreuserid(String preuserid) {
		this.preuserid = preuserid;
	}

	public String getPosuserid() {
		return posuserid;
	}

	public void setPosuserid(String posuserid) {
		this.posuserid = posuserid;
	}

	public String getPrerequestinnstatus() {
		return prerequestinnstatus;
	}

	public void setPrerequestinnstatus(String prerequestinnstatus) {
		this.prerequestinnstatus = prerequestinnstatus;
	}

	public String getPosrequestinnstatus() {
		return posrequestinnstatus;
	}

	public void setPosrequestinnstatus(String posrequestinnstatus) {
		this.posrequestinnstatus = posrequestinnstatus;
	}

	public String getPrerequestoutstatus() {
		return prerequestoutstatus;
	}

	public void setPrerequestoutstatus(String prerequestoutstatus) {
		this.prerequestoutstatus = prerequestoutstatus;
	}

	public String getPosrequestoutstatus() {
		return posrequestoutstatus;
	}

	public void setPosrequestoutstatus(String posrequestoutstatus) {
		this.posrequestoutstatus = posrequestoutstatus;
	}

	public String getPretotalcost() {
		return pretotalcost;
	}

	public void setPretotalcost(String pretotalcost) {
		this.pretotalcost = pretotalcost;
	}

	public String getPostotalcost() {
		return postotalcost;
	}

	public void setPostotalcost(String postotalcost) {
		this.postotalcost = postotalcost;
	}

	public Integer getPretotalamount() {
		return pretotalamount;
	}

	public void setPretotalamount(Integer pretotalamount) {
		this.pretotalamount = pretotalamount;
	}

	public Integer getPostotalamount() {
		return postotalamount;
	}

	public void setPostotalamount(Integer postotalamount) {
		this.postotalamount = postotalamount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}