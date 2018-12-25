package com.kaifantech.component.service.status.agv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.bean.taskexe.AgvStatusBean;
import com.kaifantech.component.dao.ControlInfoDao;
import com.kaifantech.component.dao.agv.info.AgvInfoDao;
import com.kaifantech.component.dao.taskexe.AgvStatusDao;
import com.kaifantech.component.service.agv.info.AgvInfoService;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.taskexe.check.ITaskexeCheckService;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Service
public class AgvStatusService extends AgvInfoService {

	@Autowired
	private AgvStatusDao agvStatusDao;

	@Inject
	private IotClientService iotClientService;

	// @Autowired
	// private TaskexeInfoDao taskexeTaskDao;

	@Autowired
	private ControlInfoDao controlInfoDao;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_INFO_DAO)
	private AgvInfoDao agvInfoDao;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_TASKEXECHECK_SERVICE)
	private ITaskexeCheckService taskexeCheckService;

	public Map<String, Object> agvStatus(Integer agvId) {
		Map<String, Object> agvinfo = new HashMap<String, Object>();
		List<Map<String, Object>> listWarning = agvStatusDao.getLastestAgvStatusWarning(agvId);
		agvinfo.put("systemWarning",
				(AppTool.isNull(listWarning) || listWarning.size() <= 0) ? "" : listWarning.get(0).get("msg"));
		if (!agvId.equals(0)) {
			agvinfo.put("agvInfo", agvInfoDao.get(agvId));
			// agvinfo.put("latestCommand",
			// taskexeCheckService.getCheckInfo(agvId));
			// agvinfo.put("currentTask", taskexeTaskDao.getCurrentOne(agvId));
			agvinfo.put("currentTask", taskexeCheckService.getCheckInfo(agvId));
		} else {
			agvinfo.put("agvsOpenPI", controlInfoDao.getAgvsPI());
			agvinfo.put("agvsOpenAutoTask", (SystemParameters.isAutoTask()) ? 1 : 0);
		}
		return agvinfo;
	}

	public AppMsg addStatus(String jobId, Integer agvId, int autoflag) {
		Integer tmpAgvId = checkAgvId(agvId);
		if (tmpAgvId < 0) {
			return new AppMsg(-1, "错误的agv编号");
		}
		if (AppTool.isNull(jobId)) {
			return new AppMsg(-1, "任务编号（taskid）不能为空！");
		}
		if (tmpAgvId.equals(0)) {
			for (IotClientBean agvBean : iotClientService.getAgvCacheList()) {
				agvStatusDao.addAgvStatus(jobId, agvBean.getId(), autoflag);
			}
		}
		agvStatusDao.addAgvStatus(jobId, tmpAgvId, autoflag);
		return new AppMsg(0, "指令下达成功！");
	}

	public AppMsg addStatus(Object obj) {
		AgvStatusBean agvStatusBean = (AgvStatusBean) obj;
		return addStatus(agvStatusBean.getJobId(), agvStatusBean.getAGVId(), agvStatusBean.getAutoFlag());
	}
}
