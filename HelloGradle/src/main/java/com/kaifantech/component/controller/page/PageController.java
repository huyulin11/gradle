package com.kaifantech.component.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaifantech.component.service.status.agv.AgvStatusService;
import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.init.sys.SystemClient.ProjectName;

@Controller
@RequestMapping("/")
public class PageController {

	@Autowired
	private AgvStatusService agvInfoService;

	@RequestMapping("agvmgr")
	public String agvmgr() throws Exception {
		return "/agvmgr/index";
	}

	@RequestMapping("agvmsg")
	public String agvmsg() throws Exception {
		return "/agvmgr/msg";
	}

	@RequestMapping("agvTaskMgr")
	public String agvTaskMgr(Integer agvId) throws Exception {
		if (agvInfoService.checkAgvId(agvId) < 0) {
			return "/agvmgr/agvNotFound";
		}
		if (ProjectName.HAITIAN_DRIVER.equals(SystemClient.PROJECT_NAME)) {
			return "/agvmgr/haitianDriver/agvmgrHaitianDriver";
		} else if (ProjectName.CANGZHOU.equals(SystemClient.PROJECT_NAME)) {
			return "/agvmgr/cangzhou/agvmgrCZ";
		} else if (ProjectName.XUZHOU_WEIWEI.equals(SystemClient.PROJECT_NAME)) {
			return "/agvmgr/xuzhouWeiwei/agvmgrXZWW";
		} else {
			return "/404/404";
		}
	}

}
