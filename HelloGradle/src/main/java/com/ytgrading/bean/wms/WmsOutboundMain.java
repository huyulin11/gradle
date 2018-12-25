package com.ytgrading.bean.wms;

import java.util.Date;

public class WmsOutboundMain {
	private String id;// 唯一编号
	private String outboundcode;// 出库单号（YTO打头）
	private Integer businesstype;// 业务类型（BUSINESS_TYPE）
	private String remark;// 出库备注
	private Date outboundtimeexpect;// 期望出库时间
	private Date outboundtime;// 出库时间
	private Integer outbounduserid;// 出库操作人
	private Integer outboundstatus; // 出库带状态
	private Integer outboundtype; // 出库单类型（OUTBOUND_TYPE）
	private Integer istestok;// 是否合格品（IS_TEST_OK）
	private Integer delflag;// 删除标志（DELFLAG）

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOutboundcode() {
		return outboundcode;
	}

	public void setOutboundcode(String outboundcode) {
		this.outboundcode = outboundcode;
	}

	public Integer getBusinesstype() {
		return businesstype;
	}

	public void setBusinesstype(Integer businesstype) {
		this.businesstype = businesstype;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getOutboundtimeexpect() {
		return outboundtimeexpect;
	}

	public void setOutboundtimeexpect(Date outboundtimeexpect) {
		this.outboundtimeexpect = outboundtimeexpect;
	}

	public Date getOutboundtime() {
		return outboundtime;
	}

	public void setOutboundtime(Date outboundtime) {
		this.outboundtime = outboundtime;
	}

	public Integer getOutbounduserid() {
		return outbounduserid;
	}

	public void setOutbounduserid(Integer outbounduserid) {
		this.outbounduserid = outbounduserid;
	}

	public Integer getOutboundstatus() {
		return outboundstatus;
	}

	public void setOutboundstatus(Integer outboundstatus) {
		this.outboundstatus = outboundstatus;
	}

	public Integer getIstestok() {
		return istestok;
	}

	public void setIstestok(Integer istestok) {
		this.istestok = istestok;
	}

	public Integer getDelflag() {
		return delflag;
	}

	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}

	public Integer getOutboundtype() {
		return outboundtype;
	}

	public void setOutboundtype(Integer outboundtype) {
		this.outboundtype = outboundtype;
	}
}
