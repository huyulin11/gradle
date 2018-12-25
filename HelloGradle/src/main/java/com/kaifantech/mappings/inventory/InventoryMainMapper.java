package com.kaifantech.mappings.inventory;

import com.kaifantech.bean.wms.paper.inventory.InventoryDetailBean;
import com.kaifantech.bean.wms.paper.inventory.InventoryMainBean;
import com.kaifantech.entity.InventoryMainFormMap;
import com.kaifantech.mappings.base.WmsPaperMainMapper;

public interface InventoryMainMapper
		extends WmsPaperMainMapper<InventoryDetailBean, InventoryMainBean, InventoryMainFormMap> {
}
