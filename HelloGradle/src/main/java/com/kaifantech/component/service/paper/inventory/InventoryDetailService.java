package com.kaifantech.component.service.paper.inventory;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.paper.inventory.InventoryDetailBean;
import com.kaifantech.bean.wms.paper.inventory.InventoryMainBean;
import com.kaifantech.component.service.paper.base.AbstractWmsPaperDetailService;
import com.kaifantech.entity.InventoryDetailFormMap;
import com.kaifantech.mappings.base.WmsPaperDetailMapper;
import com.kaifantech.mappings.inventory.InventoryDetailMapper;
import com.ytgrading.util.FormMap;

@Service
public class InventoryDetailService
		extends AbstractWmsPaperDetailService<InventoryDetailBean, InventoryMainBean, InventoryDetailFormMap> {
	@Inject
	private InventoryDetailMapper mapper;

	@Override
	public WmsPaperDetailMapper<InventoryDetailBean, InventoryMainBean, InventoryDetailFormMap> getMapper() {
		return mapper;
	}

	@Override
	public FormMap<String, Object> createFormMap() {
		return new InventoryDetailFormMap();
	}

	@Override
	public InventoryDetailBean createDetailObj() {
		return new InventoryDetailBean();
	}

}