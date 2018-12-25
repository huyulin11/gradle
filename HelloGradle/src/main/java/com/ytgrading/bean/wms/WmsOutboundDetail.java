package com.ytgrading.bean.wms;

public class WmsOutboundDetail {
	private String id;// 唯一编号
	private String mainid;// 主表ID
	private String packageid;// 箱号
	private Integer amount;// 件数（当前默认为1）
	private Integer delflag;// 删除标志（DELFLAG）

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMainid() {
		return mainid;
	}

	public void setMainid(String mainid) {
		this.mainid = mainid;
	}

	public String getPackageid() {
		return packageid;
	}

	public void setPackageid(String packageid) {
		this.packageid = packageid;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getDelflag() {
		return delflag;
	}

	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}

}
