package com.kaifantech.component.controller.catcharm.act;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseQueryController;
import com.kaifantech.component.service.armact.ArmactService;
import com.kaifantech.entity.ArmactFormMap;
import com.kaifantech.mappings.ArmactMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.erp.plugin.PageView;

@Controller
@RequestMapping("/armact/")
public class ArmactController extends BaseQueryController<ArmactFormMap> {
	@Inject
	private ArmactMapper mapper;

	@Inject
	private ArmactService service;

	private static final String MODULE_NAME = "AGV上机械手动作管理";

	@ResponseBody
	@RequestMapping("findAllPage")
	public PageView findAllPage() throws Exception {
		return defaultFindByPage("1", "100000", false);
	}

	@ResponseBody
	@RequestMapping("addEntity")
	@SystemLog(module = MODULE_NAME, methods = METHOD_ADD)
	@Transactional(readOnly = false)
	public String addEntity() {
		try {
			service.doAddEntity(getFormMap());
		} catch (Exception e) {
			e.printStackTrace();
			return "新增异常，名称与编码均不能与其它数据重复，请检查！";
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly = false)
	@SystemLog(module = MODULE_NAME, methods = METHOD_DELETE)
	public String deleteEntity() throws Exception {
		String[] ids = getParaValue("ids").split(",");
		ArmactFormMap formMap = getFormMap();
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
		ArmactFormMap formMap = getFormMap();
		mapper.editEntity(formMap);
		return "success";
	}

	@Override
	public BaseMapper<ArmactFormMap> getMapper() {
		return mapper;
	}
}