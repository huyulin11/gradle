package com.kaifantech.component.controller.paper.inventory;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseQueryController;
import com.kaifantech.component.service.paper.inventory.InventoryMainService;
import com.kaifantech.entity.InventoryMainFormMap;
import com.kaifantech.mappings.base.BaseMapper;
import com.kaifantech.mappings.inventory.InventoryMainMapper;
import com.kaifantech.util.constant.wms.WmsPaperStatus;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.util.FormMap;

@Controller
@RequestMapping("/inventory/main/")
public class InventoryMainController extends BaseQueryController<InventoryMainFormMap> {
	@Inject
	private InventoryMainMapper mapper;

	@Inject
	private InventoryMainService mainService;

	private static final String MODULE_NAME = "盘点管理";

	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly = false)
	@SystemLog(module = MODULE_NAME, methods = METHOD_DELETE)
	public String deleteEntity() throws Exception {
		String[] ids = getParaValue("ids").split(",");
		InventoryMainFormMap formMap = getFormMap();
		for (String id : ids) {
			formMap.set("id", "'" + id + "'");
			mapper.deleteByLogic(formMap);
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping("execute")
	@Transactional(readOnly = false)
	@SystemLog(module = MODULE_NAME, methods = "下达")
	public String execute() throws Exception {
		String id = getParaValue("id");
		mainService.updateToFrom(id, WmsPaperStatus.TOSEND, WmsPaperStatus.NEW);
		return "success";
	}

	public BaseMapper<FormMap<String, Object>> getMapper() {
		return mapper;
	}
}