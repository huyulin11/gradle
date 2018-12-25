package com.kaifantech.bean.wms.sku;

public class SkuTypeBean {
	private Integer id;
	private String name;
	private String delflag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer skuTypeId) {
		this.id = skuTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String skuTypeName) {
		this.name = skuTypeName;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

}
