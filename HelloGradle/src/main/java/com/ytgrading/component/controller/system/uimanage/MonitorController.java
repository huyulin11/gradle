package com.ytgrading.component.controller.system.uimanage;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.BaseController;
import com.kaifantech.entity.ServerInfoFormMap;
import com.kaifantech.mappings.ErpServerInfoMapper;
import com.ytgrading.erp.plugin.PageView;
import com.ytgrading.util.PropertiesUtils;

/**
 * 
 * 
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/monitor/")
public class MonitorController extends BaseController<ServerInfoFormMap> {

	@Inject
	private ErpServerInfoMapper serverInfoMapper;

	@RequestMapping("list")
	public String listUI() throws Exception {
		return "/system/monitor/list";
	}

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage(String pageNow, String pageSize) throws Exception {
		ServerInfoFormMap serverInfoFormMap = getFormMap();
		serverInfoFormMap = toFormMap(serverInfoFormMap, pageNow, pageSize);
		pageView.setRecords(serverInfoMapper.findByPage(serverInfoFormMap));
		return pageView;
	}

	@RequestMapping("info")
	public String info(Model model) throws Exception {
		model.addAttribute("cpu", PropertiesUtils.findPropertiesKey("cpu"));
		model.addAttribute("jvm", PropertiesUtils.findPropertiesKey("jvm"));
		model.addAttribute("ram", PropertiesUtils.findPropertiesKey("ram"));
		model.addAttribute("toEmail", PropertiesUtils.findPropertiesKey("toEmail"));
		return "/system/monitor/info";
	}

	@RequestMapping("monitor")
	public String monitor() throws Exception {
		return "/system/monitor/monitor";
	}

	/**
	 * 修改配置
	 * 
	 * @param request
	 * @param nodeId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/modifySer")
	public Map<String, Object> modifySer(String key, String value) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			// 从输入流中读取属性列表（键和元素对）
			PropertiesUtils.modifyProperties(key, value);
		} catch (Exception e) {
			dataMap.put("flag", false);
		}
		dataMap.put("flag", true);
		return dataMap;
	}
}