package com.kaifantech.component.service.paper.shipment;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.paper.shipment.ShipmentDetailBean;
import com.kaifantech.bean.wms.paper.shipment.ShipmentMainBean;
import com.kaifantech.component.service.paper.base.AbstractWmsPaperMainService;
import com.kaifantech.entity.ShipmentMainFormMap;
import com.kaifantech.mappings.base.WmsPaperMainMapper;
import com.kaifantech.mappings.shipment.ShipmentMainMapper;
import com.ytgrading.util.FormMap;

@Service
public class ShipmentMainService
		extends AbstractWmsPaperMainService<ShipmentDetailBean, ShipmentMainBean, ShipmentMainFormMap> {

	@Inject
	private ShipmentMainMapper mapper;

	@Autowired
	private ShipmentDetailService shipmentDetailService;

	@Override
	public WmsPaperMainMapper<ShipmentDetailBean, ShipmentMainBean, ShipmentMainFormMap> getMapper() {
		return mapper;
	}

	@Override
	public FormMap<String, Object> createFormMap() {
		return new ShipmentMainFormMap();
	}

	@Override
	public ShipmentMainBean createMainObj() {
		return new ShipmentMainBean();
	}

	@Override
	public List<ShipmentDetailBean> findDetailsByPaperid(String paperid) {
		return shipmentDetailService.findByPaperid(paperid);
	}
}