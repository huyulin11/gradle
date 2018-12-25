package com.kaifantech.component.controller.iot.client;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.form.BaseFormController;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.entity.IotClientFormMap;
import com.kaifantech.mappings.IotClientMapper;
import com.kaifantech.mappings.base.BaseMapper;
import com.ytgrading.component.service.erp.system.IBaseService;
import com.ytgrading.erp.plugin.PageView;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/iotinfo/socketdev/")
public class IotClientController extends BaseFormController<IotClientFormMap> {
	@Inject
	private IotClientMapper mapper;

	@Inject
	private IotClientService service;

	public static final String MODULE_NAME = "SOCKET设备管理";

	@ResponseBody
	@RequestMapping("findAllPage")
	public PageView findAllPage(String pageNow, String pageSize) throws Exception {
		IotClientFormMap formMap = getFormMap();
		formMap = toFormMap(formMap, "1", "10000");
		pageView.setRecords(mapper.find(formMap));
		return pageView;
	}

	@Override
	public BaseMapper<IotClientFormMap> getMapper() {
		return mapper;
	}

	@Override
	public IBaseService<IotClientFormMap> getService() {
		return service;
	}

}