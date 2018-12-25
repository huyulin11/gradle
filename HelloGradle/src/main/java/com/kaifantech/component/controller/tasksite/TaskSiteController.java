package com.kaifantech.component.controller.tasksite;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseFormController;
import com.kaifantech.component.service.tasksite.TaskSiteInfoService;
import com.kaifantech.entity.TaskSiteFormMap;
import com.kaifantech.mappings.TaskSiteInfoMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.component.service.erp.system.IBaseService;
import com.ytgrading.erp.plugin.PageView;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@SystemLog(module = "站点管理")
@RequestMapping("/tasksite/")
public class TaskSiteController extends BaseFormController<TaskSiteFormMap> {
	@Inject
	private TaskSiteInfoMapper mapper;

	@Inject
	private TaskSiteInfoService service;

	public PageView defaultFindFirstPage() throws Exception {
		TaskSiteFormMap formMap = getFormMap();
		formMap = toFormMap(formMap, "1", "10");
		formMap.set("delflag", "0");
		return getPageView().setRecords(mapper.findFuzzy(formMap));
	}

	@ResponseBody
	@RequestMapping("findAllPage")
	public PageView findAllPage() throws Exception {
		return defaultFindByPage("1", "100000", false);
	}

	@Override
	public BaseMapper<TaskSiteFormMap> getMapper() {
		return mapper;
	}

	@Override
	public IBaseService<TaskSiteFormMap> getService() {
		return service;
	}
}