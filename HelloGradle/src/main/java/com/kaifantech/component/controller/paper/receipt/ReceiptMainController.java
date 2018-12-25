package com.kaifantech.component.controller.paper.receipt;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseQueryController;
import com.kaifantech.component.service.paper.receipt.ReceiptCrudService;
import com.kaifantech.component.service.paper.receipt.ReceiptMainService;
import com.kaifantech.entity.ReceiptMainFormMap;
import com.kaifantech.mappings.base.BaseMapper;
import com.kaifantech.mappings.receipt.ReceiptMainMapper;
import com.kaifantech.util.constant.wms.WmsPaperStatus;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.erp.plugin.PageView;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.msg.AppMsg;

@Controller
@RequestMapping("/receipt/main/")
public class ReceiptMainController extends BaseQueryController<ReceiptMainFormMap> {
	@Inject
	private ReceiptMainMapper mapper;

	@Inject
	private ReceiptCrudService service;

	@Inject
	private ReceiptMainService mainService;

	private static final String MODULE_NAME = "入库管理";

	@ResponseBody
	@RequestMapping("find")
	public PageView find(String pageNow, String pageSize) throws Exception {
		ReceiptMainFormMap formMap = getFormMap();
		formMap = toFormMap(formMap, pageNow, pageSize);
		pageView.setRecords(mapper.findPage(formMap));
		return pageView;
	}

	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly = false)
	@SystemLog(module = MODULE_NAME, methods = METHOD_DELETE)
	public String deleteEntity() throws Exception {
		String[] ids = getParaValue("ids").split(",");
		ReceiptMainFormMap formMap = getFormMap();
		for (String id : ids) {
			formMap.set("id", "'" + id + "'");
			mapper.deleteByLogic(formMap);
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping("execute")
	@Transactional(readOnly = false)
	@SystemLog(module = MODULE_NAME, methods = "下达")
	public String execute() throws Exception {
		String id = getParaValue("id");
		AppMsg msg = service.checkBeforeExecute(id);
		if (msg.getCode() < 0) {
			return msg.getMsg();
		}
		mainService.updateToFrom(id, WmsPaperStatus.TOSEND, WmsPaperStatus.NEW);
		return "success";
	}

	public BaseMapper<FormMap<String, Object>> getMapper() {
		return mapper;
	}
}