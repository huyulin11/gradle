package com.kaifantech.mappings.shipment;

import java.util.List;

import com.kaifantech.bean.wms.paper.shipment.ShipmentDetailBean;
import com.kaifantech.bean.wms.paper.shipment.ShipmentMainBean;
import com.kaifantech.entity.ShipmentDetailFormMap;
import com.kaifantech.mappings.base.WmsPaperDetailMapper;

public interface ShipmentDetailMapper extends WmsPaperDetailMapper<ShipmentDetailBean, ShipmentMainBean,ShipmentDetailFormMap>  {

	public List<ShipmentDetailFormMap> findPage(ShipmentDetailFormMap formMap);

	public int add(ShipmentDetailFormMap billFormMap);

}
