package com.kaifantech.component.controller.alloc.item;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaifantech.component.controller.base.form.BaseFormController;
import com.kaifantech.component.service.alloc.item.AllocItemService;
import com.kaifantech.entity.AllocItemFormMap;
import com.kaifantech.mappings.AllocItemMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.component.service.erp.system.IBaseService;

@Controller
@SystemLog(module = "货位管理")
@RequestMapping("/alloc/item/")
public class AllocItemController extends BaseFormController<AllocItemFormMap> {
	@Inject
	private AllocItemMapper mapper;

	@Inject
	private AllocItemService service;

	@Override
	public AllocItemFormMap getFormMap() {
		AllocItemFormMap formMap = super.getFormMap();
		if ("true".equals(formMap.get("inStock"))) {
			formMap.set("num", ">0");
		}
		return formMap;
	}

	@Override
	public List<AllocItemFormMap> defaultFindByPage(AllocItemFormMap formMap) throws Exception {
		return mapper.findPage(formMap);
	}

	public BaseMapper<AllocItemFormMap> getMapper() {
		return mapper;
	}

	@Override
	public IBaseService<AllocItemFormMap> getService() {
		return service;
	}
}