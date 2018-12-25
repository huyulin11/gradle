package com.ytgrading.component.controller.system.uimanage;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.BaseController;
import com.kaifantech.entity.UserLoginFormMap;
import com.ytgrading.erp.plugin.PageView;
import com.kaifantech.mappings.ErpUserLoginMapper;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/userlogin/")
public class UserLoginController extends BaseController<UserLoginFormMap> {
	@Inject
	private ErpUserLoginMapper userLoginErpMapper;

	@RequestMapping("listUI")
	public String listUI(Model model) throws Exception {
		return "/system/userlogin/list";
	}

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage(String pageNow, String pageSize) throws Exception {
		UserLoginFormMap userLoginFormMap = getFormMap();
		String order = " order by id desc";
		userLoginFormMap.put("$orderby", order);
		userLoginFormMap = toFormMap(userLoginFormMap, pageNow, pageSize);
		pageView.setRecords(userLoginErpMapper.findByPage(userLoginFormMap));
		return pageView;
	}

}