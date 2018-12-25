package com.ytgrading.component.controller.system.uimanage;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseQueryController;
import com.kaifantech.entity.RoleFormMap;
import com.kaifantech.mappings.ErpRoleMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.util.Common;
import com.ytgrading.util.AppTool;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/role/")
public class RoleController extends BaseQueryController<RoleFormMap> {
	@Inject
	private ErpRoleMapper roleMapper;

	private static final String MODULE_NAME = "系统角色管理";

	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return "/system/role/list";
	}

	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception {
		return "/system/role/add";
	}

	@ResponseBody
	@RequestMapping("addEntity")
	@Transactional(readOnly = false)
	// 需要事务操作必须加入此注解
	@SystemLog(module = MODULE_NAME, methods = METHOD_ADD)
	// 凡需要处理业务逻辑的.都需要记录操作日志
	public String addEntity() throws Exception {
		RoleFormMap roleFormMap = getFormMap();
		roleMapper.addEntity(roleFormMap);
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
			roleMapper.deleteByAttribute("id", id, RoleFormMap.class);
		}
		return "success";
	}

	@RequestMapping("editUI")
	public String editUI(Model model) throws Exception {
		String id = getParam("id");
		if (Common.isNotEmpty(id)) {
			model.addAttribute("role", roleMapper.findbyFrist("id", id, RoleFormMap.class));
		}
		return "/system/role/edit";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly = false)
	// 需要事务操作必须加入此注解
	@SystemLog(module = MODULE_NAME, methods = METHOD_EDIT)
	// 凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity() throws Exception {
		RoleFormMap roleFormMap = getFormMap();
		roleMapper.editEntity(roleFormMap);
		return "success";
	}

	@RequestMapping("selRole")
	public String seletRole(Model model) throws Exception {
		RoleFormMap roleFormMap = getFormMap();
		Object userId = roleFormMap.get("userId");
		List<RoleFormMap> list = new LinkedList<RoleFormMap>();
		if (null != userId) {
			list = roleMapper.seletUserRole(roleFormMap);
			String ugid = "";
			for (RoleFormMap ml : list) {
				ugid += ml.get("id") + ",";
			}
			ugid = AppTool.trimComma(ugid);
			model.addAttribute("txtRoleSelect", ugid);
			model.addAttribute("userRole", list);
			// if (StringUtils.isNotBlank(ugid)) {
			// roleFormMap.put("where", " where id not in (" + ugid + ")");
			// }
		}
		List<RoleFormMap> roles = roleMapper.seletAllUserRole();
		roles.removeAll(list);
		model.addAttribute("role", roles);
		return "/system/user/roleSelect";
	}

	@Override
	public BaseMapper<RoleFormMap> getMapper() {
		return roleMapper;
	}

}