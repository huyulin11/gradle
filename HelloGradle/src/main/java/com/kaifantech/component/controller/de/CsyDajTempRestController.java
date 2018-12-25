package com.kaifantech.component.controller.de;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.component.comm.cmd.sender.plc.PlcCmdSender;
import com.kaifantech.component.comm.manager.agv.AgvManager;
import com.kaifantech.component.comm.manager.charge.ChargeManager;
import com.kaifantech.component.comm.manager.plc.PlcManager;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.beanmap.AppBeanMapUtil;
import com.kaifantech.util.constants.cmd.AgvCmdConstant;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.msg.window.WindowMsgGetter;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Controller
@RequestMapping("/de/acs/wms/temp/")
public class CsyDajTempRestController {

	@Autowired
	private AgvManager agvManager;

	@Autowired
	private PlcManager plcManager;

	@Autowired
	private PlcCmdSender plcCmdSender;

	@Autowired
	private ChargeManager chargeManager;

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	@RequestMapping("test")
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response) {
		try {
			AppMsg appMsg = new AppMsg();
			String testtype = request.getParameter("testtype");
			String agvId = request.getParameter("agvId");
			if (AppTool.isNull(testtype)) {
				return "失败:操作类型为空！";
			}
			testtype = testtype.toUpperCase();
			if ("START".equals(testtype)) {
				appMsg = agvManager.startup(Integer.parseInt(agvId));
			} else if ("STOP".equals(testtype)) {
				appMsg = agvManager.pause(Integer.parseInt(agvId));
			} else if ("CLEARCACHE".equals(testtype)) {
				appMsg = agvManager.undoAllCache(Integer.parseInt(agvId));
			} else if ("FAST".equals(testtype) || "SLOW".equals(testtype)) {
				int i = 1;
				AgvBean agv = agvInfoDao.get(Integer.parseInt(agvId));
				Integer speed = agv.getSpeed();
				if (AppTool.isNull(speed)) {
					return "失败:未能获取当前AGV的执行速度";
				}
				if ("SLOW".equals(testtype)) {
					i = -1;
				}
				speed = speed + 5 * i;
				if (speed > 60) {
					return "失败:调试速度不能超过60";
				}
				if (speed <= 0) {
					return "失败:速度不能小于等于0";
				}
				appMsg = agvManager.changeSpeed(Integer.parseInt(agvId), speed);
			} else if ("DOCACHE".equals(testtype)) {
				String finalCmd = "";
				String tasksite = request.getParameter("tasksite");
				String type = request.getParameter("type");
				if (AppTool.isNull(type)) {
					return "失败：未找到指令类型";
				}
				if (AppTool.isNull(tasksite)) {
					return "失败：未找到所需操作站点编号";
				}
				if ("1".equals(type)) {
					finalCmd = AgvCmdConstant.CMD_TASK_CACHE_STOP;
				} else if ("2".equals(type)) {
					finalCmd = AgvCmdConstant.CMD_TASK_CACHE_TURN_LEFT;
				} else if ("3".equals(type)) {
					finalCmd = AgvCmdConstant.CMD_TASK_CACHE_TURN_RIGHT;
				} else if ("4".equals(type)) {
					String speed = request.getParameter("speed");
					finalCmd = AgvCmdConstant.CMD_TASK_CACHE_SPEED + AppByteUtil.int2Str2(Integer.parseInt(speed));
				}
				appMsg = agvManager.cacheTask(Integer.parseInt(agvId), Integer.parseInt(tasksite), finalCmd);
			} else if ("PLCWORK".equals(testtype)) {
				Map<String, Object> params = new HashMap<>();
				Enumeration<String> names = request.getParameterNames();
				while (names.hasMoreElements()) {
					String key = names.nextElement();
					String value = request.getParameter(key);
					params.put(key, value);
				}
				appMsg = plcManager.work(Integer.parseInt(agvId), params);
			} else if ("CHARGE".equals(testtype)) {
				String value = request.getParameter("type");
				String chargeid = request.getParameter("chargeid");
				if ("open".equals(value)) {
					return chargeManager.justStart(Integer.parseInt(chargeid)).getMsg();
				}
				if ("close".equals(value)) {
					return chargeManager.justStop(Integer.parseInt(chargeid)).getMsg();
				}
				if (AppTool.isNull(chargeid)) {
					return "未获取到正常的充电站ID";
				}
			} else {
				return "失败:未知的操作类型";
			}
			return appMsg.isSuccess() ? "成功:" + appMsg.getMsg() : "失败:" + appMsg.getMsg();
		} catch (Exception e) {
			return "失败" + e.getMessage();
		}
	}

	@RequestMapping("plcmsg")
	@ResponseBody
	public Object plcmsg(HttpServletRequest request, HttpServletResponse response) {
		try {
			String agvId = request.getParameter("agvId");
			List<String> list = plcCmdSender.getList(Integer.parseInt(agvId));
			LinkedList<String> newList = new LinkedList<String>();
			if (list == null || list.size() == 0) {
				return null;
			}
			for (String msg : list) {
				String newMsg = "";
				for (int i = 0; i < msg.length(); i = i + 4) {
					String s = msg.substring(i, i + 4);
					newMsg = newMsg + "-" + AppByteUtil.hexStringToInt(s);
				}
				newList.add(newMsg);
			}
			return JSONArray.toJSON(newList);
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping("windows")
	@ResponseBody
	public Object windows(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Map<String, Object>> infos = new ArrayList<>();
			for (IotClientBean window : iotClientService.getWindowCacheList()) {
				Map<String, Object> single = new HashMap<>();
				String layers = WindowMsgGetter.one().getLayers(window.getId());
				single = AppBeanMapUtil.bean2Map(window);
				single.put("info", layers);
				infos.add(single);
			}
			return JSONArray.toJSON(infos);
		} catch (Exception e) {
			return null;
		}
	}
}
