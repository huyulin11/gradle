package com.kaifantech.bean.wms.alloc;

public class AllocItemInfoBean {
	private Integer id;
	private Integer areaId;
	private Integer rowId;
	private Integer colId;
	private Integer siteId;
	private Integer zId;
	private Integer columnId;
	private Integer skuId;
	private Integer num;
	private String text;
	private String status;
	private String delflag;
	private int environment;

	private Integer siteid;
	private Integer armactid;

	public Integer getzId() {
		return zId;
	}

	public void setzId(Integer zId) {
		this.zId = zId;
	}

	public Integer getSiteid() {
		return siteid;
	}

	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
	}

	public Integer getArmactid() {
		return armactid;
	}

	public void setArmactid(Integer armactid) {
		this.armactid = armactid;
	}

	public int getEnvironment() {
		return environment;
	}

	public void setEnvironment(int environment) {
		this.environment = environment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getRowId() {
		return rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	public Integer getColId() {
		return colId;
	}

	public void setColId(Integer colId) {
		this.colId = colId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public Integer getZId() {
		return zId;
	}

	public void setZId(Integer zId) {
		this.zId = zId;
	}

	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getColumnId() {
		return columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public String toString() {
		return "text:" + text + ",status:" + status;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
}
