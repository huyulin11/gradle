package com.kaifantech.component.controller.paper.inventory;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseQueryController;
import com.kaifantech.component.service.paper.inventory.InventoryCrudService;
import com.kaifantech.entity.InventoryDetailFormMap;
import com.kaifantech.mappings.base.BaseMapper;
import com.kaifantech.mappings.inventory.InventoryDetailMapper;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.err.SystemBussException;
import com.ytgrading.util.FormMap;

@Controller
@RequestMapping("/inventory/detail/")
public class InventoryDetailController extends BaseQueryController<InventoryDetailFormMap> {
	@Inject
	private InventoryDetailMapper mapper;
	@Inject
	private InventoryCrudService service;

	private static final String MODULE_NAME = "盘点明细管理";

	@ResponseBody
	@RequestMapping("addEntity")
	@SystemLog(module = MODULE_NAME, methods = METHOD_ADD)
	@Transactional(readOnly = false)
	public String addEntity() {
		try {
			service.doAddEntity(getFormMap(FormMap.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemBussException("添加出库单异常");
		}
		return "success";
	}

	public BaseMapper<FormMap<String, Object>> getMapper() {
		return mapper;
	}
}