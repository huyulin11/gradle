package com.kaifantech.component.service.paper.shipment;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.paper.shipment.ShipmentDetailBean;
import com.kaifantech.bean.wms.paper.shipment.ShipmentMainBean;
import com.kaifantech.component.service.paper.base.AbstractWmsPaperDetailService;
import com.kaifantech.entity.ShipmentDetailFormMap;
import com.kaifantech.mappings.base.WmsPaperDetailMapper;
import com.kaifantech.mappings.shipment.ShipmentDetailMapper;
import com.ytgrading.util.FormMap;

@Service
public class ShipmentDetailService
		extends AbstractWmsPaperDetailService<ShipmentDetailBean, ShipmentMainBean, ShipmentDetailFormMap> {
	@Inject
	private ShipmentDetailMapper mapper;

	@Override
	public WmsPaperDetailMapper<ShipmentDetailBean, ShipmentMainBean, ShipmentDetailFormMap> getMapper() {
		return mapper;
	}

	@Override
	public FormMap<String, Object> createFormMap() {
		return new ShipmentDetailFormMap();
	}

	@Override
	public ShipmentDetailBean createDetailObj() {
		return new ShipmentDetailBean();
	}

}