package com.ytgrading.bean.wms;

public class WmsPackageRelation {
	private Integer businesstype;// 业务类型（BUSINESS_TYPE）
	private String formid;// 单号（目前有评鉴单或托管单）
	private Integer entityid;// 藏品编号
	private Integer amount;// 该箱对应品种数量
	private String packageid;// 箱号
	private Integer delflag;// 删除标志（DELFLAG）

	public Integer getBusinesstype() {
		return businesstype;
	}

	public void setBusinesstype(Integer businesstype) {
		this.businesstype = businesstype;
	}

	public String getFormid() {
		return formid;
	}

	public void setFormid(String formid) {
		this.formid = formid;
	}

	public Integer getEntityid() {
		return entityid;
	}

	public void setEntityid(Integer entityid) {
		this.entityid = entityid;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPackageid() {
		return packageid;
	}

	public void setPackageid(String packageid) {
		this.packageid = packageid;
	}

	public Integer getDelflag() {
		return delflag;
	}

	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}

}
