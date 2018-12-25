package com.ytgrading.bean.wms;

import java.util.Date;

public class WmsInboundMain {
	private String id;// 唯一编号
	private String inboundcode;// 入库单号（YTI打头）
	private Integer businesstype;// 业务类型（BUSINESS_TYPE）
	private String remark;// 入库备注
	private Date inboundtime;// 入库时间
	private Integer inbounduserid;// 入库操作人
	private int inboundstatus;// 入库单状态
	private Integer istestok;// 是否合格品（IS_TEST_OK）
	private Integer delflag;// 删除标志（DELFLAG）

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInboundcode() {
		return inboundcode;
	}

	public void setInboundcode(String inboundcode) {
		this.inboundcode = inboundcode;
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

	public Date getInboundtime() {
		return inboundtime;
	}

	public void setInboundtime(Date inboundtime) {
		this.inboundtime = inboundtime;
	}

	public Integer getInbounduserid() {
		return inbounduserid;
	}

	public void setInbounduserid(Integer inbounduserid) {
		this.inbounduserid = inbounduserid;
	}
	
	public int getInboundstatus() {
		return inboundstatus;
	}

	public void setInboundstatus(int inboundstatus) {
		this.inboundstatus = inboundstatus;
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

}
