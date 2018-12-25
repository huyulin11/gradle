package com.kaifantech.component.controller.paper.shipment;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseQueryController;
import com.kaifantech.component.service.paper.shipment.ShipmentCrudService;
import com.kaifantech.entity.ShipmentDetailFormMap;
import com.kaifantech.mappings.base.BaseMapper;
import com.kaifantech.mappings.shipment.ShipmentDetailMapper;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.err.SystemBussException;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.msg.AppMsg;

@Controller
@RequestMapping("/shipment/detail/")
public class ShipmentDetailController extends BaseQueryController<ShipmentDetailFormMap> {
	@Inject
	private ShipmentDetailMapper mapper;

	@Inject
	private ShipmentCrudService service;

	private static final String MODULE_NAME = "出库明细管理";

	@ResponseBody
	@RequestMapping("addEntity")
	@SystemLog(module = MODULE_NAME, methods = METHOD_ADD)
	@Transactional(readOnly = false)
	public String addEntity() {
		try {
			AppMsg msg = service.doAddEntity(getFormMap(FormMap.class));
			if (msg.getCode() < 0) {
				return msg.getMsg();
			}
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