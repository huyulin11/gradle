package com.kaifantech.component.controller.sku;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaifantech.component.controller.base.form.BaseQueryController;
import com.kaifantech.entity.SkuTypeFormMap;
import com.kaifantech.mappings.SkuTypeMapper;
import com.kaifantech.mappings.base.BaseMapper;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/sku/type/")
public class SkuTypeController extends BaseQueryController<SkuTypeFormMap> {
	@Inject
	private SkuTypeMapper mapper;

	static final String MODULE_NAME = "SKU大类管理";

	@Override
	public BaseMapper<SkuTypeFormMap> getMapper() {
		return mapper;
	}
}