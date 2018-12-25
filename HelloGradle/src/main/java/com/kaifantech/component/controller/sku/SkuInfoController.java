package com.kaifantech.component.controller.sku;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaifantech.component.controller.base.form.BaseFormController;
import com.kaifantech.component.service.sku.SkuInfoService;
import com.kaifantech.entity.SkuInfoFormMap;
import com.kaifantech.entity.SkuTypeFormMap;
import com.kaifantech.mappings.SkuInfoMapper;
import com.kaifantech.mappings.SkuTypeMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.component.service.erp.system.IBaseService;
import com.ytgrading.util.AppTool;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@SystemLog(module = "SKU类型管理")
@RequestMapping("/sku/info/")
public class SkuInfoController extends BaseFormController<SkuInfoFormMap> {
	@Inject
	private SkuInfoMapper mapper;
	@Inject
	private SkuTypeMapper skuTypeMapper;

	@Inject
	private SkuInfoService service;

	public String defaultEditEntity(String txtGroupsSelect) throws Exception {
		SkuInfoFormMap formMap = getFormMap();
		if (!AppTool.isNull(formMap.get("type"))) {
			String type = formMap.get("type").toString();
			SkuTypeFormMap skuTypeFormMap = new SkuTypeFormMap().setRtn("name", type);
			List<?> types = skuTypeMapper.findOne(skuTypeFormMap);
			if (AppTool.isNull(types) || types.isEmpty()) {
				skuTypeMapper.add(skuTypeFormMap);
			}
		}
		mapper.editEntity(formMap);
		return "success";
	}

	public BaseMapper<SkuInfoFormMap> getMapper() {
		return mapper;
	}

	@Override
	public IBaseService<SkuInfoFormMap> getService() {
		return service;
	}
}