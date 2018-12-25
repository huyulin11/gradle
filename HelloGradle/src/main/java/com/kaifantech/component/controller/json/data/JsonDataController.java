package com.kaifantech.component.controller.json.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.msg.agv.AGVMsgBean;
import com.kaifantech.bean.msg.agv.TaskPathInfoPointBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.component.business.msg.info.agv.IAgvMsgInfoModule;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.dao.taskexe.TaskPathInfoDao;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Controller
@RequestMapping("/json/data/")
public class JsonDataController {
	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	@Autowired
	private IAgvMsgInfoModule msgService;

	@Autowired
	private TaskexeInfoService taskInfoService;

	@Autowired
	private TaskPathInfoDao taskPathInfoDao;

	@RequestMapping("getLatestMsg")
	@ResponseBody
	public Object getLatestMsg() {
		List<AgvBean> agvList = agvInfoDao.getList();
		Map<Integer, AGVMsgBean> latestMsg = new HashMap<Integer, AGVMsgBean>();
		for (AgvBean bean : agvList) {
			AGVMsgBean msg = msgService.getLatestMsgBean(bean.getId());
			latestMsg.put(bean.getId(), msg);
		}
		return JSONArray.toJSON(latestMsg);
	}

	@RequestMapping("getTaskPathData")
	@ResponseBody
	public Object getTaskPathData(String received) {
		List<TaskexeBean> latestTaskexeList = taskInfoService.getNotOverList();
		if (latestTaskexeList == null || latestTaskexeList.size() <= 0) {
			return JSONArray.toJSON(new AppMsg(-2, "没有任务尚在执行中……"));
		}
		if ("true".equals(received) && (latestTaskexeList != null && latestTaskexeList.size() > 0)) {
			return JSONArray.toJSON(new AppMsg(-1, "任务执行中……"));
		}
		Map<String, List<TaskPathInfoPointBean>> latestMsg = new HashMap<String, List<TaskPathInfoPointBean>>();
		for (TaskexeBean bean : latestTaskexeList) {
			List<TaskPathInfoPointBean> msg = taskPathInfoDao.selectPath(bean.getAgvId(), bean.getTaskid());
			if (!AppTool.isNull(msg) && msg.size() > 0) {
				latestMsg.put(bean.getTaskid(), msg);
			}
		}
		return JSONArray.toJSON(latestMsg);
	}

}
