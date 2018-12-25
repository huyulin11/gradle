package com.kaifantech.bean.wms.alloc;

import java.util.Comparator;

public class AllocColumnInfoBean {
	private Integer columnId;
	private Integer areaId;
	private Integer colId;
	private Integer allowedSkuType;
	private Integer allowedSkuId;
	private Integer allowedLayerHeight;
	private Integer xaxis;
	private String text;
	private String delflag;
	private int environment;

	public int getEnvironment() {
		return environment;
	}

	public void setEnvironment(int environment) {
		this.environment = environment;
	}

	public static Comparator<AllocColumnInfoBean> comparatorInverted = new Comparator<AllocColumnInfoBean>() {
		public int compare(AllocColumnInfoBean o1, AllocColumnInfoBean o2) {
			if (o1.colId > o2.colId) {
				return -1;
			}
			if (o1.colId < o2.colId) {
				return 1;
			}
			return 0;
		}
	};

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

	public Integer getColId() {
		return colId;
	}

	public void setColId(Integer colId) {
		this.colId = colId;
	}

	public Integer getColumnId() {
		return columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public Integer getXaxis() {
		return xaxis;
	}

	public void setXaxis(Integer xaxis) {
		this.xaxis = xaxis;
	}

}
