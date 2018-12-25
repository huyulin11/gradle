package com.kaifantech.component.service.status.agv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kaifantech.bean.info.agv.AgvBean;
import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvMoveStatus;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Service
public class AgvsCtrlInfoService {
	@Autowired
	private AgvStatusService agvStatusService;

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	private TaskexeInfoService taskInfoService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	public boolean isSystemRunning() {
		return AgvMoveStatus.CONTINUE.equals(agvInfoDao.getMoveStatus(0));
	}

	Map<String, Object> infos = new HashMap<>();
	private int reloadMsgTimes = 0;

	private void gettingMsg() {
		ThreadTool.run(() -> {
			reloadMsgTimes = 0;
			while (reloadMsgTimes++ < 20) {
				try {
					for (AgvBean agvBean : agvInfoDao.getList()) {
						infos.put(agvBean.getId().toString(), agvStatusService.agvStatus(agvBean.getId()));
					}
					Map<String, Object> info0 = agvStatusService.agvStatus(0);
					infos.put("0", info0);
				} catch (Exception e) {
				}
				ThreadTool.sleep(1000);
			}
		});
	}

	public JSONObject agvsStatus() {
		if (reloadMsgTimes >= 20 || reloadMsgTimes == 0) {
			gettingMsg();
		}
		return new JSONObject(infos);
	}

	public AppMsg checkAGV(Integer agvId) {
		if (!AgvMoveStatus.CONTINUE.equals(agvInfoDao.getMoveStatus(agvId))) {
			return new AppMsg(-1, "该AGV正在暂停中，新任务无法下达！");
		}
		return new AppMsg(0, "任务可以下达！");
	}

	public Integer getFreeAgvId() {
		List<TaskexeBean> latestTaskList = taskInfoService.getNotOverList();
		Integer agvId = null;
		String msg = "";
		for (IotClientBean iotClientBean : iotClientService.getAgvCacheList()) {
			AgvBean agv = agvInfoDao.get(iotClientBean.getId());
			Integer tmpAgvId = (Integer) agv.getId();
			AgvBean agvBean = agvInfoDao.get(tmpAgvId);
			if (AppTool.isNull(agvBean)) {
				continue;
			}
			if (latestTaskList.stream().filter((taskexe) -> {
				return !AppTool.isNull(taskexe.getAgvId()) && taskexe.getAgvId().equals(tmpAgvId);
			}).count() > 0) {
				msg += tmpAgvId + "号AGV有任务在身！";
				continue;
			}
			if (AgvBean.CONNECT_FAIL.equals(agvBean.getAgvstatus())) {
				msg += tmpAgvId + "号AGV未连接！";
				continue;
			}
			if (!AgvTaskType.FREE.equals(agvBean.getTaskstatus())) {
				msg += tmpAgvId + "号AGV正在执行" + agvBean.getTaskstatus() + "任务！";
				continue;
			}
			if (!AgvMoveStatus.CONTINUE.equals(agvBean.getMovestatus())) {
				msg += tmpAgvId + "号AGV正在暂停中！";
				continue;
			}
			agvId = tmpAgvId;
			break;
		}
		if (!AppTool.isNull(msg)) {
			AppFileLogger.warning(msg);
		}
		if (AppTool.isNull(agvId)) {
			return null;
		}
		return agvId;
	}

	public List<AgvBean> getRtAgvInfoList() {
		List<AgvBean> rtnList = new ArrayList<>();
		for (IotClientBean iotClientBean : iotClientService.getAgvCacheList()) {
			AgvBean bean = agvInfoDao.get(iotClientBean.getId());
			rtnList.add(bean);
		}
		return rtnList;
	}

}
