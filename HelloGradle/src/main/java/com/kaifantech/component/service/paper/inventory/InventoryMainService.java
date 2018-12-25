package com.kaifantech.component.service.paper.inventory;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.wms.paper.inventory.InventoryDetailBean;
import com.kaifantech.bean.wms.paper.inventory.InventoryMainBean;
import com.kaifantech.component.service.paper.base.AbstractWmsPaperMainService;
import com.kaifantech.entity.InventoryMainFormMap;
import com.kaifantech.mappings.base.WmsPaperMainMapper;
import com.kaifantech.mappings.inventory.InventoryMainMapper;
import com.ytgrading.util.FormMap;

@Service
public class InventoryMainService
		extends AbstractWmsPaperMainService<InventoryDetailBean, InventoryMainBean, InventoryMainFormMap> {
	@Inject
	private InventoryMainMapper mapper;

	@Autowired
	private InventoryDetailService inventoryDetailService;

	@Override
	public WmsPaperMainMapper<InventoryDetailBean, InventoryMainBean, InventoryMainFormMap> getMapper() {
		return mapper;
	}

	@Override
	public FormMap<String, Object> createFormMap() {
		return new InventoryMainFormMap();
	}

	@Override
	public InventoryMainBean createMainObj() {
		return new InventoryMainBean();
	}

	@Override
	public List<InventoryDetailBean> findDetailsByPaperid(String paperid) {
		return inventoryDetailService.findByPaperid(paperid);
		}

}