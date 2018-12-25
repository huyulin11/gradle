package com.kaifantech.component.controller.bill;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseQueryController;
import com.kaifantech.component.service.bill.BillService;
import com.kaifantech.entity.BillFormMap;
import com.kaifantech.mappings.BussBillMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.annotation.SystemLog;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/bill/")
public class BillController extends BaseQueryController<BillFormMap> {
	@Inject
	private BussBillMapper mapper;

	@Inject
	private BillService service;

	private static final String MODULE_NAME = "报账管理";

	@ResponseBody
	@RequestMapping("addEntity")
	@SystemLog(module = MODULE_NAME, methods = METHOD_ADD)
	@Transactional(readOnly = false)
	public String addEntity() {
		try {
			service.doAddEntity(getFormMap());
		} catch (Exception e) {
			e.printStackTrace();
			return "新增异常，请仔细检查数据、网络连接情况及系统登录情况，请检查！";
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly = false)
	@SystemLog(module = MODULE_NAME, methods = METHOD_DELETE)
	public String deleteEntity() throws Exception {
		String[] ids = getParaValue("ids").split(",");
		BillFormMap formMap = getFormMap();
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
		BillFormMap formMap = getFormMap();
		mapper.editEntity(formMap);

		return "success";
	}

	@Override
	public BaseMapper<BillFormMap> getMapper() {
		return mapper;
	}

}