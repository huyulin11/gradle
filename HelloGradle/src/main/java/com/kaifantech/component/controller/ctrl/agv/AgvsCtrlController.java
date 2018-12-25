package com.kaifantech.component.controller.ctrl.agv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.kaifantech.component.comm.worker.client.agv.IAgvClientWorker;
import com.kaifantech.component.dao.ControlInfoDao;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.lap.LapInfoService;
import com.kaifantech.component.service.singletask.group.SingletaskGroupService;
import com.kaifantech.component.service.singletask.info.SingleTaskInfoService;
import com.kaifantech.component.service.status.agv.AgvsCtrlInfoService;
import com.kaifantech.init.sys.qualifier.SystemQualifier;

@Controller
@RequestMapping("/")
public class AgvsCtrlController {

	@Autowired
	private SingleTaskInfoService singleTaskInfoService;

	@Autowired
	private AgvsCtrlInfoService agvsCtrlInfoService;

	// @Autowired
	// private AllocAreaService allocAreaService;

	@Autowired
	private LapInfoService lapInfoService;

	@Autowired
	private ControlInfoDao controlInfoDao;

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	private SingletaskGroupService singletaskGroupService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_CLIENT_WORKER)
	private IAgvClientWorker agvClientMgr;

	// @Autowired
	// private AllocColumnService allocColumnService;

	// @Autowired
	// private DifferByMsg differByMsg;

	@RequestMapping("initAgvInfo")
	@ResponseBody
	public Object initAgvInfo(String taskid) {
		// singleTaskInfoService.init();
		// agvInfoService.init();
		// lapInfoService.init();
		// allocColumnService.init();
		// allocAreaService.init();
		// differByMsg.init();
		return "初始化结束";
	}

	@RequestMapping("getSingletask")
	@ResponseBody
	public Object getSingletask(String taskid) {
		return JSONArray.toJSON(singleTaskInfoService.getSingletask(taskid));
	}

	@RequestMapping("getTaskGroupInfo")
	@ResponseBody
	public Object getTaskGroupInfo() {
		return JSONArray.toJSON(singletaskGroupService.getSingletaskGroupBeanList());
	}

	@RequestMapping("getControlInfo")
	@ResponseBody
	public Object getControlInfo() {
		return JSONArray.toJSON(controlInfoDao.getControlInfo());
	}

	@RequestMapping("getAGVList")
	@ResponseBody
	public Object getAGVList() {
		return JSONArray.toJSON(iotClientService.getAgvCacheList());
	}

	@RequestMapping("getAGVListSop")
	@ResponseBody
	public Object getAGVListSop() {
		return JSONArray.toJSON(agvsCtrlInfoService.getRtAgvInfoList());
	}

	@RequestMapping("getLapList")
	@ResponseBody
	public Object getLapList() {
		return JSONArray.toJSON(lapInfoService.getAllLapList());
	}

	// @RequestMapping("sysInit")
	// @ResponseBody
	// public String sysInit() {
	// int num = controlInfoDao.updateCurrentTaskexeStatusToInit();
	// if (num > 0) {
	// return "完成重新初始化！";
	// }
	// return "系统已经处于初始状态，无需再初始化！";
	// }

}
