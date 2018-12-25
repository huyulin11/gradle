package com.kaifantech.component.controller.agvlap;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaifantech.component.controller.base.form.BaseFormController;
import com.kaifantech.entity.SkuInfoNameFormMap;
import com.kaifantech.mappings.SkuInfoNameMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.component.service.erp.system.IBaseService;

@Controller
@SystemLog(module = "SKU类型管理")
@RequestMapping("/sku/info/name/")
public class SkuInfoNameController extends BaseFormController<SkuInfoNameFormMap> {
	@Inject
	private SkuInfoNameMapper mapper;

	@Override
	public BaseMapper<SkuInfoNameFormMap> getMapper() {
		return mapper;
	}

	@Override
	public IBaseService<SkuInfoNameFormMap> getService() {
		return null;
	}

}
