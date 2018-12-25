package com.ytgrading.component.controller.system.uimanage;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.BaseController;
import com.kaifantech.entity.LogFormMap;
import com.ytgrading.erp.plugin.PageView;
import com.kaifantech.mappings.ErpLogMapper;

@Controller
@RequestMapping("/log/")
public class LogController extends BaseController<LogFormMap> {
	@Inject
	private ErpLogMapper logMapper;

	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		return "/system/log/list";
	}

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage(String pageNow, String pageSize) throws Exception {
		LogFormMap logFormMap = getFormMap();
		String order = " order by id desc";
		logFormMap.put("$orderby", order);
		logFormMap = toFormMap(logFormMap, pageNow, pageSize);
		pageView.setRecords(logMapper.findByPage(logFormMap));
		return pageView;
	}
}