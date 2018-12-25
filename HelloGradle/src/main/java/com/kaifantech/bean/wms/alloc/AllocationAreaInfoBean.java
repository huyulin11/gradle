package com.kaifantech.bean.wms.alloc;

public class AllocationAreaInfoBean {
	private Integer areaId;
	private Integer allowedSkuType;
	private Integer allowedSkuId;
	private Integer allowedLayerHeight;
	private String text;
	private Integer colNum;
	private Integer rowNum;
	private Integer zNum;
	private int environment;
	private int location;
	private String allowedSkuNames = "";
	private String allowedSkuTypeNames = "";
	private String inSkuNames = "";

	public String getAllowedSkuNames() {
		return allowedSkuNames;
	}

	public void setAllowedSkuNames(String allowedSkuNames) {
		this.allowedSkuNames = allowedSkuNames;
	}

	public String getAllowedSkuTypeNames() {
		return allowedSkuTypeNames;
	}

	public void setAllowedSkuTypeNames(String allowedSkuTypeNames) {
		this.allowedSkuTypeNames = allowedSkuTypeNames;
	}

	public String getInSkuNames() {
		return inSkuNames;
	}

	public void setInSkuNames(String inSkuNames) {
		this.inSkuNames = inSkuNames;
	}

	public int getEnvironment() {
		return environment;
	}

	public void setEnvironment(int environment) {
		this.environment = environment;
	}

	public Integer getColNum() {
		return colNum;
	}

	public void setColNum(Integer colNum) {
		this.colNum = colNum;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

	public Integer getzNum() {
		return zNum;
	}

	public void setzNum(Integer zNum) {
		this.zNum = zNum;
	}

	private String delflag;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getAllowedSkuType() {
		return allowedSkuType;
	}

	public void setAllowedSkuType(Integer allowedSkuType) {
		this.allowedSkuType = allowedSkuType;
	}

	public Integer getAllowedSkuId() {
		return allowedSkuId;
	}

	public void setAllowedSkuId(Integer allowedSkuId) {
		this.allowedSkuId = allowedSkuId;
	}

	public Integer getAllowedLayerHeight() {
		return allowedLayerHeight;
	}

	public void setAllowedLayerHeight(Integer allowedLayerHeight) {
		this.allowedLayerHeight = allowedLayerHeight;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

}
