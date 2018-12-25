package com.ytgrading.component.controller.system.uimanage;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytgrading.annotation.SystemLog;
import com.kaifantech.component.controller.base.BaseController;
import com.kaifantech.entity.RoleResFormMap;
import com.ytgrading.erp.plugin.PageView;
import com.kaifantech.mappings.ErpRoleResMapper;
import com.ytgrading.util.Common;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/roleres/")
public class RoleResController extends BaseController<RoleResFormMap> {
	@Inject
	private ErpRoleResMapper roleresMapper;

	private static final String MODULE_NAME = "系统资源角色关系管理";

	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return "/system/roleres/list";
	}

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage(String pageNow, String pageSize) throws Exception {
		RoleResFormMap roleresFormMap = getFormMap();
		roleresFormMap = toFormMap(roleresFormMap, pageNow, pageSize);
		pageView.setRecords(roleresMapper.findByPage(roleresFormMap));
		return pageView;
	}

	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception {
		return "/system/roleres/add";
	}

	@ResponseBody
	@RequestMapping("addEntity")
	@Transactional(readOnly = false)
	// 需要事务操作必须加入此注解
	@SystemLog(module = MODULE_NAME, methods = METHOD_ADD)
	// 凡需要处理业务逻辑的.都需要记录操作日志
	public String addEntity() throws Exception {
		RoleResFormMap roleresFormMap = getFormMap();
		roleresMapper.addEntity(roleresFormMap);
		return "success";
	}

	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly = false)
	// 需要事务操作必须加入此注解
	@SystemLog(module = MODULE_NAME, methods = METHOD_DELETE)
	// 凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String[] ids = getParaValues("ids");
		for (String id : ids) {
			roleresMapper.deleteByAttribute("id", id, RoleResFormMap.class);
		}
		return "success";
	}

	@RequestMapping("editUI")
	public String editUI(Model model) throws Exception {
		String id = getParam("id");
		if (Common.isNotEmpty(id)) {
			model.addAttribute("roleres", roleresMapper.findbyFrist("id", id, RoleResFormMap.class));
		}
		return "/system/roleres/edit";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly = false)
	// 需要事务操作必须加入此注解
	@SystemLog(module = MODULE_NAME, methods = METHOD_EDIT)
	// 凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity() throws Exception {
		RoleResFormMap roleresFormMap = getFormMap();
		roleresMapper.editEntity(roleresFormMap);
		return "success";
	}

}