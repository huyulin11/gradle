package com.kaifantech.component.controller.singletask.crud;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseQueryController;
import com.kaifantech.component.service.singletask.crud.SingletaskMgrService;
import com.kaifantech.entity.SingletaskFormMap;
import com.kaifantech.mappings.SingletaskMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.err.SystemBussException;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/agvtasks/")
public class SingletaskController extends BaseQueryController<SingletaskFormMap> {
	@Inject
	private SingletaskMapper mapper;

	@Inject
	private SingletaskMgrService service;

	private static final String MODULE_NAME = "任务管理";

	@ResponseBody
	@RequestMapping("addEntity")
	@SystemLog(module = MODULE_NAME, methods = METHOD_ADD)
	// 凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly = false)
	// 需要事务操作必须加入此注解
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
	// 需要事务操作必须加入此注解
	@SystemLog(module = MODULE_NAME, methods = METHOD_DELETE)
	// 凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String[] ids = getParaValue("ids").split(",");
		SingletaskFormMap formMap = getFormMap();
		for (String id : ids) {
			formMap.set("id", "'" + id + "'");
			mapper.deleteByLogic(formMap);
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly = false)
	// 需要事务操作必须加入此注解
	@SystemLog(module = MODULE_NAME, methods = METHOD_EDIT)
	// 凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity(String txtGroupsSelect) throws Exception {
		SingletaskFormMap formMap = getFormMap();
		mapper.editEntity(formMap);

		return "success";
	}

	@Override
	public BaseMapper<SingletaskFormMap> getMapper() {
		return mapper;
	}
}