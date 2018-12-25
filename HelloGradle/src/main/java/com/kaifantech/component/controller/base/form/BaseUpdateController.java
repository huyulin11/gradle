package com.kaifantech.component.controller.base.form;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.BaseController;
import com.kaifantech.component.controller.base.IUpdateController;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.util.FormMap;

@Controller
public abstract class BaseUpdateController<TT extends FormMap<String, Object>> extends BaseController<TT>
		implements IUpdateController<TT> {
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
	public String deleteEntity() throws Exception {
		return defaultDeleteEntityByLogic();
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly = false)
	@SystemLog(methods = METHOD_EDIT)
	public String editEntity(String txtGroupsSelect) throws Exception {
		return defaultEditEntity(txtGroupsSelect);
	}

}