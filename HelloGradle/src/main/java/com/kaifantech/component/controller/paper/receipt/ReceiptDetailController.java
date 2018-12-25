package com.kaifantech.component.controller.paper.receipt;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseQueryController;
import com.kaifantech.component.service.paper.receipt.ReceiptCrudService;
import com.kaifantech.entity.ReceiptDetailFormMap;
import com.kaifantech.mappings.base.BaseMapper;
import com.kaifantech.mappings.receipt.ReceiptDetailMapper;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.msg.AppMsg;

@Controller
@SystemLog(module = "入库明细管理")
@RequestMapping("/receipt/detail/")
public class ReceiptDetailController extends BaseQueryController<ReceiptDetailFormMap> {
	@Inject
	private ReceiptDetailMapper mapper;
	@Inject
	private ReceiptCrudService service;

	@ResponseBody
	@RequestMapping("addEntity")
	@Transactional(readOnly = false)
	@SystemLog(methods = "新增")
	public String addEntity() {
		try {
			AppMsg msg = service.doAddEntity(getFormMap(FormMap.class));
			if (msg.getCode() < 0) {
				return msg.getMsg();
			}
		} catch (Exception e) {
			return "添加出库单异常" + e.getMessage();
		}
		return "success";
	}

	public BaseMapper<FormMap<String, Object>> getMapper() {
		return mapper;
	}
}