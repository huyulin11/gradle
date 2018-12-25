package com.kaifantech.mappings.shipment;

import com.kaifantech.bean.wms.paper.shipment.ShipmentDetailBean;
import com.kaifantech.bean.wms.paper.shipment.ShipmentMainBean;
import com.kaifantech.entity.ShipmentMainFormMap;
import com.kaifantech.mappings.base.WmsPaperMainMapper;

public interface ShipmentMainMapper
		extends WmsPaperMainMapper<ShipmentDetailBean, ShipmentMainBean, ShipmentMainFormMap> {
}
