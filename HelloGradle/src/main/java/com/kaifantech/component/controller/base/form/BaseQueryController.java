package com.kaifantech.component.controller.base.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.BaseController;
import com.kaifantech.component.controller.base.IQueryController;
import com.ytgrading.erp.plugin.PageView;
import com.ytgrading.util.FormMap;

@Controller
public abstract class BaseQueryController<TT extends FormMap<String, Object>> extends BaseController<TT>
		implements IQueryController<TT> {
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

}