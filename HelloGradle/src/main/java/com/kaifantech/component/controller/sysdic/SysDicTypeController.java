package com.kaifantech.component.controller.sysdic;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseQueryController;
import com.kaifantech.component.service.sysdic.SysDicTypeService;
import com.kaifantech.entity.SysDicTypeFormMap;
import com.kaifantech.mappings.SysDicTypeMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.err.SystemBussException;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/sys/dictype/")
public class SysDicTypeController extends BaseQueryController<SysDicTypeFormMap> {
	@Inject
	private SysDicTypeMapper mapper;

	@Inject
	private SysDicTypeService service;

	@ResponseBody
	@RequestMapping("addEntity")
	@Transactional(readOnly = false)
	public String addEntity() {
		try {
			service.doAddEntity(getFormMap());
		} catch (Exception e) {
			throw new SystemBussException("添加账单异常");
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly = false)
	public String deleteEntity() throws Exception {
		String[] ids = getParaValue("ids").split(",");
		SysDicTypeFormMap formMap = getFormMap();
		for (String id : ids) {
			formMap.set("id", "'" + id + "'");
			mapper.deleteByLogic(formMap);
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly = false)
	public String editEntity(String txtGroupsSelect) throws Exception {
		SysDicTypeFormMap formMap = getFormMap();
		mapper.editEntity(formMap);

		return "success";
	}

	@Override
	public BaseMapper<SysDicTypeFormMap> getMapper() {
		return mapper;
	}

}