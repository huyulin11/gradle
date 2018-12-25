package com.kaifantech.component.controller.ctrl.agv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.kaifantech.bean.singletask.SingletaskBean;
import com.kaifantech.component.service.singletask.info.SingleTaskInfoService;

@Controller
@RequestMapping("/")
public class SingleAgvCtrlController {

	@Autowired
	private SingleTaskInfoService singleTaskInfoService;

	@RequestMapping("getAllSingletask")
	@ResponseBody
	public Object getAllSingletask(Integer agvId) {
		List<SingletaskBean> list = singleTaskInfoService.getAllSingletaskForCurrentUser(agvId);
		return JSONArray.toJSON(list);
	}

	@RequestMapping("getSingletaskByAllocId")
	@ResponseBody
	public Object getSingletaskByAllocId(Integer allocId) {
		List<SingletaskBean> list = singleTaskInfoService.getSingletaskByAllocId(allocId);
		return JSONArray.toJSON(list);
	}

}
