package com.kaifantech.component.controller.paper.shipment;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseQueryController;
import com.kaifantech.component.service.paper.shipment.ShipmentCrudService;
import com.kaifantech.component.service.paper.shipment.ShipmentMainService;
import com.kaifantech.entity.ShipmentMainFormMap;
import com.kaifantech.mappings.base.BaseMapper;
import com.kaifantech.mappings.shipment.ShipmentMainMapper;
import com.kaifantech.util.constant.wms.WmsPaperStatus;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.msg.AppMsg;

@Controller
@RequestMapping("/shipment/main/")
public class ShipmentMainController extends BaseQueryController<ShipmentMainFormMap> {
	@Inject
	private ShipmentMainMapper mapper;

	@Inject
	private ShipmentCrudService service;

	@Inject
	private ShipmentMainService mainService;

	private static final String MODULE_NAME = "出库管理";

	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly = false)
	@SystemLog(module = MODULE_NAME, methods = METHOD_DELETE)
	public String deleteEntity() throws Exception {
		String[] ids = getParaValue("ids").split(",");
		ShipmentMainFormMap formMap = getFormMap();
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

		AppMsg msg = service.checkBeforeExecute(id);
		if (msg.getCode() < 0) {
			return msg.getMsg();
		}

		mainService.updateToFrom(id, WmsPaperStatus.TOSEND, WmsPaperStatus.NEW);
		return "success";
	}

	public BaseMapper<FormMap<String, Object>> getMapper() {
		return mapper;
	}
}