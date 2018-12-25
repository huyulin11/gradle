package com.kaifantech.component.controller.sysdic;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseQueryController;
import com.kaifantech.component.service.sysdic.SysDicService;
import com.kaifantech.component.service.sysdic.SysDicTypeService;
import com.kaifantech.entity.SysDicFormMap;
import com.kaifantech.entity.SysDicTypeFormMap;
import com.kaifantech.mappings.SysDicMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.annotation.SystemLog;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/sys/dic/")
public class SysDicController extends BaseQueryController<SysDicFormMap> {
	@Inject
	private SysDicMapper mapper;

	@Inject
	private SysDicService service;

	@Inject
	private SysDicTypeService dicTypeService;

	private static final String MODULE_NAME = "字典管理";

	@ResponseBody
	@RequestMapping("addEntity")
	@SystemLog(module = MODULE_NAME, methods = METHOD_ADD)
	@Transactional(readOnly = false)
	public String addEntity() {
		try {
			SysDicFormMap sysDicFormMap = getFormMap();
			SysDicTypeFormMap sysDicTypeFormMap = getFormMap(SysDicTypeFormMap.class);
			dicTypeService.doAddEntity(sysDicTypeFormMap);
			service.doAddEntity(sysDicTypeFormMap.get("dictype").toString(), sysDicFormMap);
		} catch (Exception e) {
			e.printStackTrace();
			return "添加字典值异常，请确认对应种类字典值是否重复！";
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly = false)
	@SystemLog(module = MODULE_NAME, methods = METHOD_DELETE)
	public String deleteEntity() throws Exception {
		String[] ids = getParaValue("ids").split(",");
		SysDicFormMap formMap = getFormMap();
		for (String id : ids) {
			formMap.set("id", "'" + id + "'");
			mapper.deleteByLogic(formMap);
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly = false)
	@SystemLog(module = MODULE_NAME, methods = METHOD_EDIT)
	public String editEntity(String txtGroupsSelect) throws Exception {
		SysDicFormMap formMap = getFormMap();
		mapper.editEntity(formMap);

		return "success";
	}

	@Override
	public BaseMapper<SysDicFormMap> getMapper() {
		return mapper;
	}

}