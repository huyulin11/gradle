package com.kaifantech.component.controller.base.form;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.BaseController;
import com.kaifantech.component.controller.base.IQueryController;
import com.kaifantech.component.controller.base.IUpdateController;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.erp.plugin.PageView;
import com.ytgrading.util.FormMap;

@Controller
public abstract class BaseFormController<TT extends FormMap<String, Object>> extends BaseController<TT>
		implements IQueryController<TT>, IUpdateController<TT> {

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage(String pageNow, String pageSize) throws Exception {
		return defaultFindByPage(pageNow, pageSize, true);
	}

	@ResponseBody
	@RequestMapping("findFirstPage")
	public PageView findFirstPage() throws Exception {
		return defaultFindFirstPage();
	}

	@ResponseBody
	@RequestMapping("addEntity")
	@SystemLog(methods = METHOD_ADD)
	@Transactional(readOnly = false)
	public String addEntity() {
		try {
			return defaultAddEntity();
		} catch (Exception e) {
			e.printStackTrace();
			return "新增失败，请检查数据是否与已有数据重复";
		}
	}

	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly = false)
	@SystemLog(methods = METHOD_DELETE)
	public String deleteEntity() {
		try {
			return defaultDeleteEntityByLogic();
		} catch (Exception e) {
			e.printStackTrace();
			return "删除失败";
		}
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly = false)
	@SystemLog(methods = METHOD_EDIT)
	public String editEntity(String txtGroupsSelect) {
		try {
			return defaultEditEntity(txtGroupsSelect);
		} catch (Exception e) {
			e.printStackTrace();
			return "修改失败";
		}
	}

}