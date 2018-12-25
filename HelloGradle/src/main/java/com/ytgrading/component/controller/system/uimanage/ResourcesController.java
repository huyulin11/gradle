package com.ytgrading.component.controller.system.uimanage;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ytgrading.annotation.SystemLog;
import com.kaifantech.component.controller.base.BaseController;
import com.kaifantech.entity.ButtomFormMap;
import com.kaifantech.entity.Params;
import com.kaifantech.entity.ResFormMap;
import com.kaifantech.entity.ResUserFormMap;
import com.kaifantech.entity.RoleResFormMap;
import com.kaifantech.mappings.ErpResourcesMapper;
import com.kaifantech.mappings.ErpRoleResMapper;
import com.ytgrading.util.Common;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.TreeObject;
import com.ytgrading.util.TreeUtil;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/resources/")
public class ResourcesController extends BaseController<ResFormMap> {
	@Inject
	private ErpResourcesMapper resourcesMapper;
	@Inject
	private ErpRoleResMapper roleresMapper;

	private static final String MODULE_NAME = "系统资源管理";

	/**
	 * @param model
	 *            存放返回界面的model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("treelists")
	public ResFormMap findByPage(Model model) {
		ResFormMap resFormMap = getFormMap();
		List<ResFormMap> mps = resourcesMapper.selectTreeResourcess();
		List<TreeObject> list = new ArrayList<TreeObject>();
		for (ResFormMap map : mps) {
			TreeObject ts = new TreeObject();
			Common.flushObject(ts, map);
			list.add(ts);
		}
		TreeUtil treeUtil = new TreeUtil();
		List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0);
		resFormMap = new ResFormMap();
		resFormMap.put("treelists", ns);
		return resFormMap;
	}

	@ResponseBody
	@RequestMapping("reslists")
	public List<TreeObject> reslists(Model model) throws Exception {
		ResFormMap resFormMap = getFormMap();
		List<ResFormMap> mps = resourcesMapper.findByWhere(resFormMap);
		List<TreeObject> list = new ArrayList<TreeObject>();
		for (ResFormMap map : mps) {
			TreeObject ts = new TreeObject();
			Common.flushObject(ts, map);
			list.add(ts);
		}
		TreeUtil treeUtil = new TreeUtil();
		List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0, "　");
		return ns;
	}

	/**
	 * @param model
	 *            存放返回界面的model
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("res", findByRes());
		return "/system/resources/list";
	}

	/**
	 * 跳转到修改界面
	 * 
	 * @param model
	 * @param resourcesId
	 *            修改菜单信息ID
	 * @return
	 */
	@RequestMapping("editUI")
	public String editUI(Model model) {
		String id = getParam("id");
		if (Common.isNotEmpty(id)) {
			model.addAttribute("resources", resourcesMapper.findbyFrist("id", id, ResFormMap.class));
		}
		return "/system/resources/edit";
	}

	/**
	 * 跳转到新增界面
	 * 
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI(Model model) {
		return "/system/resources/add";
	}

	/**
	 * 权限分配页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("permissions")
	public String permissions(Model model) {
		List<ResFormMap> mps = resourcesMapper.selectTreeResourcess();
		List<TreeObject> list = new ArrayList<TreeObject>();
		for (ResFormMap map : mps) {
			TreeObject ts = new TreeObject();
			Common.flushObject(ts, map);
			list.add(ts);
		}
		TreeUtil treeUtil = new TreeUtil();
		List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0);
		model.addAttribute("permissions", ns);
		return "/system/resources/permissions";
	}

	/**
	 * 添加菜单
	 * 
	 * @param resources
	 * @return Map
	 * @throws Exception
	 */
	@RequestMapping("addEntity")
	@ResponseBody
	@Transactional(readOnly = false)
	// 需要事务操作必须加入此注解
	@SystemLog(module = MODULE_NAME, methods = METHOD_ADD)
	// 凡需要处理业务逻辑的.都需要记录操作日志
	public String addEntity() throws Exception {
		ResFormMap resFormMap = getFormMap();
		if ("2".equals(resFormMap.get("type"))) {
			resFormMap.put("description", Common.htmltoString(resFormMap.get("description") + ""));
		}
		Object o = resFormMap.get("ishide");
		if (null == o) {
			resFormMap.set("ishide", "0");
		}

		resourcesMapper.addEntity(resFormMap);
		return "success";
	}

	/**
	 * 更新菜单
	 * 
	 * @param model
	 * @param Map
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly = false)
	// 需要事务操作必须加入此注解
	@SystemLog(module = MODULE_NAME, methods = METHOD_EDIT)
	// 凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity(Model model) throws Exception {
		ResFormMap resFormMap = getFormMap();
		if ("2".equals(resFormMap.get("type"))) {
			resFormMap.put("description", Common.htmltoString(resFormMap.get("description") + ""));
		}
		Object o = resFormMap.get("ishide");
		if (null == o) {
			resFormMap.set("ishide", "0");
		}
		resourcesMapper.editEntity(resFormMap);
		return "success";
	}

	/**
	 * 根据ID删除菜单
	 * 
	 * @param model
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("deleteEntity")
	@SystemLog(module = MODULE_NAME, methods = METHOD_DELETE)
	// 凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity(Model model) throws Exception {
		String[] ids = getParaValues("ids");
		for (String id : ids) {
			resourcesMapper.deleteByAttribute("id", id, ResFormMap.class);
		}
		;
		return "success";
	}

	@RequestMapping("sortUpdate")
	@ResponseBody
	@Transactional(readOnly = false)
	// 需要事务操作必须加入此注解
	public String sortUpdate(Params params) throws Exception {
		List<String> ids = params.getId();
		List<String> es = params.getRowId();
		List<ResFormMap> maps = new ArrayList<ResFormMap>();
		for (int i = 0; i < ids.size(); i++) {
			ResFormMap map = new ResFormMap();
			map.put("id", ids.get(i));
			map.put("level", es.get(i));
			maps.add(map);
		}
		resourcesMapper.updateSortOrder(maps);
		return "success";
	}

	@ResponseBody
	@RequestMapping("findRes")
	public List<ResFormMap> findUserRes() {
		ResFormMap resFormMap = getFormMap();
		List<ResFormMap> rs = resourcesMapper.findRes(resFormMap);
		return rs;
	}

	@ResponseBody
	@RequestMapping("addUserRes")
	@Transactional(readOnly = false)
	// 需要事务操作必须加入此注解
	@SystemLog(module = MODULE_NAME, methods = METHOD_EDIT)
	// 凡需要处理业务逻辑的.都需要记录操作日志
	public String addUserRes() throws Exception {
		String userId = "";
		String u = getParam("userId");
		String g = getParam("roleId");

		if (null != u && !Common.isEmpty(u.toString())) {
			userId = AppTool.trimComma(u.toString());
			resourcesMapper.deleteByAttribute("userId", userId, ResUserFormMap.class);
			String[] s = getParaValues("resId[]");
			if (!AppTool.isNull(s)) {
				List<ResUserFormMap> resUserFormMaps = new ArrayList<ResUserFormMap>();
				for (String rid : s) {
					ResUserFormMap resUserFormMap = new ResUserFormMap();
					resUserFormMap.put("resId", rid);
					resUserFormMap.put("userId", userId);
					resUserFormMaps.add(resUserFormMap);
				}
				resourcesMapper.batchSave(resUserFormMaps);
			}

		} else if (null != g && !Common.isEmpty(g.toString())) {
			roleresMapper.deleteByAttribute("roleId", g.toString(), RoleResFormMap.class);
			String[] s = getParaValues("resId[]");
			if (!AppTool.isNull(s)) {
				List<RoleResFormMap> roleResFormMaps = new ArrayList<RoleResFormMap>();
				for (String rid : s) {
					RoleResFormMap RoleResFormMap = new RoleResFormMap();
					RoleResFormMap.put("resId", rid);
					RoleResFormMap.put("roleId", g.toString());
					roleResFormMaps.add(RoleResFormMap);
				}
				resourcesMapper.batchSave(roleResFormMaps);
			}
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping("findByButtom")
	public List<ButtomFormMap> findByButtom() {
		return resourcesMapper.findByWhere(new ButtomFormMap());
	}

	/**
	 * 验证菜单是否存在
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("isExist")
	@ResponseBody
	public boolean isExist(String name, String resKey) {
		ResFormMap resFormMap = getFormMap();
		List<ResFormMap> r = resourcesMapper.findByNames(resFormMap);
		if (r.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}