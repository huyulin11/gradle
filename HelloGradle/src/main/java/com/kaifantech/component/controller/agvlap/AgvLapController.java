package com.kaifantech.component.controller.agvlap;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaifantech.component.controller.base.form.BaseFormController;
import com.kaifantech.component.service.agvlap.AgvLapService;
import com.kaifantech.entity.AgvLapFormMap;
import com.kaifantech.mappings.AgvLapMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.component.service.erp.system.IBaseService;

@Controller
@SystemLog(module = "取货点管理")
@RequestMapping("/agv/lap/")
public class AgvLapController extends BaseFormController<AgvLapFormMap> {
	@Inject
	private AgvLapMapper mapper;

	@Inject
	private AgvLapService service;

	@Override
	public BaseMapper<AgvLapFormMap> getMapper() {
		return mapper;
	}

	@Override
	public IBaseService<AgvLapFormMap> getService() {
		return service;
	}

}