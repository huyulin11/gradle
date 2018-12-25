package com.kaifantech.component.controller.de;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.kaifantech.bean.de.AllRequestBean;
import com.kaifantech.component.dao.de.DeWmsRequestDao;
import com.kaifantech.component.service.alloc.info.AllocInventoryInfoService;
import com.kaifantech.component.service.de.DeWmsDataService;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.mappings.DeWmsDataMapper;
import com.kaifantech.util.constants.de.DeStatus;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;
import com.ytgrading.util.msg.MsgFromWMS;

@Controller
@RequestMapping("/de/acs/wms/")
public class CsyRestfulController {
	@Inject
	private DeWmsRequestDao dao;

	@Inject
	private DeWmsDataMapper deWmsDataMapper;

	@Inject
	private DeWmsDataService deWmsDataService;

	@Autowired
	private AllocInventoryInfoService allocInventoryInfoService;

	@RequestMapping("getInventoryStatus")
	@ResponseBody
	public Object getInventoryStatus(HttpServletRequest request, HttpServletResponse response) {
		JSONObject obj = allocInventoryInfoService.getInventoryStatus();
		dao.add(AppTool.getIp(request), "getInventoryStatus", obj);
		return obj;
	}

	@RequestMapping("setInventoryStatus")
	@ResponseBody
	public Object setInventoryStatus(@RequestBody JSONObject requestJson, HttpServletRequest request,
			HttpServletResponse response) {
		AppMsg msg = AppMsg.fail();
		try {
			if (AppTool.isNull(requestJson)) {
				return msg.setMsg("未得到有效数据或数据为空").toAlbbJson();
			}
			AllRequestBean bean = new AllRequestBean(AppTool.getIp(request), "setInventoryStatus",
					requestJson.toString());
			deWmsDataMapper.addBean(bean);
			msg = allocInventoryInfoService.setInventoryParams(requestJson);
		} catch (Exception e1) {
			e1.printStackTrace();
			msg = new AppMsg(-1, "异常！" + e1.getMessage());
		}
		if (msg.getCode() >= 0) {
			return allocInventoryInfoService.getInventoryStatus();
		}
		return msg.toAlbbJson();
	}

	@RequestMapping("shutdown")
	@ResponseBody
	public JSONObject shutdown(@RequestBody JSONObject requestJson, HttpServletRequest request,
			HttpServletResponse response) {
		AppMsg msg = AppMsg.fail();
		try {
			if (AppTool.isNull(requestJson)) {
				return msg.setMsg("未得到有效数据或数据为空").toAlbbJson();
			}
			AllRequestBean bean = new AllRequestBean(AppTool.getIp(request), "shutdown", requestJson.toString());
			String paperId = requestJson.getString("PaperId");
			if (!AppTool.isNull(paperId)) {
				SystemParameters.setShutdown(paperId);
				bean.setErrinfo("取消成功");
				msg = new AppMsg(0, "取消成功！");
			} else {
				msg = new AppMsg(-1, "取消失败！" + msg.getMsg());
				bean.setErrinfo(msg.getMsg());
			}
			deWmsDataMapper.addBean(bean);
		} catch (Exception e1) {
			e1.printStackTrace();
			msg = new AppMsg(-1, "异常！" + e1.getMessage());
		}
		return new MsgFromWMS(msg).toAlbbJson();
	}

	@RequestMapping("addAcsTask")
	@ResponseBody
	public JSONObject addAcsTask(@RequestBody JSONObject requestJson, HttpServletRequest request,
			HttpServletResponse response) {
		AppMsg msg = AppMsg.fail();
		try {
			if (AppTool.isNull(requestJson)) {
				return msg.setMsg("未得到有效数据或数据为空").toAlbbJson();
			}
			AllRequestBean bean = new AllRequestBean(AppTool.getIp(request), "addAcsTask", requestJson.toString());
			msg = deWmsDataService.resolute(null, requestJson.toString(), false);
			if (msg.getCode() >= 0) {
				bean.setExstatus(DeStatus.OVER.toString());
				bean.setErrinfo("直接解析成功");
				msg = new AppMsg(0, "解析成功！");
			} else {
				msg = new AppMsg(-1, "解析错误！" + msg.getMsg());
				bean.setErrinfo(msg.getMsg());
			}
			deWmsDataMapper.addBean(bean);
		} catch (Exception e1) {
			e1.printStackTrace();
			msg = new AppMsg(-1, "异常！" + e1.getMessage());
		}
		return new MsgFromWMS(msg).toAlbbJson();
	}
}
