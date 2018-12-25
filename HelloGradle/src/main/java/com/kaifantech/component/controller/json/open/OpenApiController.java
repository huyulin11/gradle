package com.kaifantech.component.controller.json.open;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.kaifantech.component.comm.manager.agv.AgvManager;
import com.kaifantech.component.controller.base.BaseController;
import com.kaifantech.component.service.json.open.OpenApiService;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.msg.AppMsg;

@Controller
@RequestMapping("/json/open/")
public class OpenApiController extends BaseController<FormMap<String, Object>> {

	@Autowired
	private OpenApiService openApiService;

	@Autowired
	private AgvManager agvManager;

	@RequestMapping("cacheTask")
	@ResponseBody
	public String cacheTask(@RequestBody JSONObject requestJson, HttpServletRequest request,
			HttpServletResponse response) {
		AppMsg msg = null;
		msg = openApiService.cacheTask(requestJson);
		return msg.getCode() >= 0 ? "success" : msg.getMsg();
	}

	@RequestMapping("stopAgv")
	@ResponseBody
	public String stopAgv(Integer agvid) {
		agvManager.pause(agvid);
		return "success";
	}
}