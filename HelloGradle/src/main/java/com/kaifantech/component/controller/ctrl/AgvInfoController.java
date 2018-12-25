package com.kaifantech.component.controller.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.kaifantech.component.service.status.agv.AgvStatusService;
import com.kaifantech.component.service.status.agv.AgvsCtrlInfoService;
import com.ytgrading.util.msg.AppMsg;

@Controller
@RequestMapping("/")
public class AgvInfoController {

	@Autowired
	private AgvStatusService agvInfoService;

	@Autowired
	private AgvsCtrlInfoService agvsCtrlInfoService;

	@RequestMapping("agvinfo")
	@ResponseBody
	public JSONObject agvinfo(Integer agvId) {
		if (agvInfoService.checkAgvId(agvId) < 0) {
			return new AppMsg(-1, "错误的agv编号").toAlbbJson();
		}
		return new JSONObject(agvInfoService.agvStatus(agvId));
	}

	@RequestMapping("agvsinfo")
	@ResponseBody
	public JSONObject agvsinfo() {
		return agvsCtrlInfoService.agvsStatus();
	}

}
