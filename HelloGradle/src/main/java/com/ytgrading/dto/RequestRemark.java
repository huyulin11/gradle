package com.ytgrading.dto;

import java.util.Date;

public class RequestRemark {

	private Integer id;// 唯一编号
	private String requestcode;// 申请单号
	private String remark;// 操作备注信息
	private Integer opuserid;// 操作人编号
	private Integer isprivate;// 是否私有信息:0代表私有，1代表公共
	private Date createtime;// 创建时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRequestcode() {
		return requestcode;
	}

	public void setRequestcode(String requestcode) {
		this.requestcode = requestcode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOpuserid() {
		return opuserid;
	}

	public void setOpuserid(Integer opuserid) {
		this.opuserid = opuserid;
	}

	public Integer getIsprivate() {
		return isprivate;
	}

	public void setIsprivate(Integer isprivate) {
		this.isprivate = isprivate;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
