package com.kaifantech.bean.wms.paper.inventory;

import com.kaifantech.bean.wms.paper.base.WmsPaperMainBean;

public class InventoryMainBean extends WmsPaperMainBean<InventoryDetailBean> {
	public static final String TYPE_FULL = "FULL";
	public static final String TYPE_COLUMN = "COLUMN";
	public static final String TYPE_LINE = "LINE";

	private String inventorytype;

	public String getInventorytype() {
		return inventorytype;
	}

	public void setInventorytype(String inventorytype) {
		this.inventorytype = inventorytype;
	}
}
