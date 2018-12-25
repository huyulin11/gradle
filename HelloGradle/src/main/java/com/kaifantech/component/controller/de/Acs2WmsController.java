package com.kaifantech.component.controller.de;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kaifantech.bean.taskexe.AgvStatusBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.component.controller.base.BaseController;
import com.kaifantech.component.dao.alloc.AllocItemDao;
import com.kaifantech.component.service.status.agv.AgvStatusService;
import com.kaifantech.component.service.taskexe.oper.ITaskexeAddService;
import com.kaifantech.component.service.user.UserService;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.ytgrading.annotation.SystemLog;
import com.ytgrading.util.FormMap;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Controller
@RequestMapping("/de/acs/")
public class Acs2WmsController extends BaseController<FormMap<String, Object>> {

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_TASKEXE_ADD_SERVICE)
	private ITaskexeAddService taskexeService;

	@Autowired
	private AllocItemDao allocDao;

	@Autowired
	private UserService userService;

	@Autowired
	private AgvStatusService agvStatusService;

	private static final String MODULE_NAME = "接口管理";

	@RequestMapping("addTask")
	@ResponseBody
	public JSONObject addTask(String taskid, Integer agvId) {
		AppMsg msg = taskexeService.addTask(new TaskexeBean(taskid, agvId, 0));
		return msg.toAlbbJson();
	}

	@RequestMapping("addCtrlTask")
	@ResponseBody
	public JSONObject addCtrlTask(String taskid, Integer agvId) {
		AppMsg msg = agvStatusService.addStatus(new AgvStatusBean(taskid, agvId, 0));
		return msg.toAlbbJson();
	}

	@RequestMapping("getAllAllocationInfo")
	@ResponseBody
	public Object getAllAllocationInfo() {
		return JSONArray.toJSON(allocDao.getAll());
	}

	@ResponseBody
	@RequestMapping("addTestUser")
	@SystemLog(module = MODULE_NAME, methods = METHOD_ADD)
	@Transactional(readOnly = false)
	public String addTestUser(String userName, String phoneNum) {
		if (AppTool.isNull(phoneNum) || AppTool.isNull(userName)) {
			return "请您输入正确格式的姓名和手机号码！";
		}
		if (phoneNum.length() != 11) {
			return "请您输入正确格式的11位手机号码！";
		}
		try {
			userService.doAddEntity(userName, phoneNum, "201");
		} catch (Exception e) {
			return "添加账号失败！请确实该手机号码是否已申请，如有疑问请与客服联系！";
		}
		return "success";
	}

}
