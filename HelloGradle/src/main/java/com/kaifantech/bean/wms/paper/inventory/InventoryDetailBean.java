package com.kaifantech.bean.wms.paper.inventory;

import java.util.Comparator;

import com.kaifantech.bean.wms.paper.base.WmsPaperDetailBean;

public class InventoryDetailBean extends WmsPaperDetailBean implements Comparator<InventoryDetailBean> {

	@Override
	public int compare(InventoryDetailBean h1, InventoryDetailBean h2) {
		return h1.getSequence().compareTo(h2.getSequence());
	}
}