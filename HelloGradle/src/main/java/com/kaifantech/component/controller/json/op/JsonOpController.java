package com.kaifantech.component.controller.json.op;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.bean.taskexe.AgvStatusBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.component.dao.ControlInfoDao;
import com.kaifantech.component.dao.agv.info.AgvOpChargeDao;
import com.kaifantech.component.dao.agv.info.AgvOpInitDao;
import com.kaifantech.component.log.AgvStatusDBLogger;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.status.agv.AgvStatusService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.component.service.taskexe.oper.ITaskexeAddService;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.AgvMoveStatus;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Controller
@RequestMapping("/json/op/")
public class JsonOpController {

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_TASKEXE_ADD_SERVICE)
	private ITaskexeAddService taskexeService;

	@Autowired
	private ControlInfoDao controlInfoDao;

	@Autowired
	private AgvStatusDBLogger kaifantechDBLogger;

	@Autowired
	private AgvStatusService agvStatusService;

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	private TaskexeInfoService taskexeInfoService;

	@Autowired
	private AgvOpChargeDao agvOpChargeDao;

	@Autowired
	private AgvOpInitDao agvOpInitDao;

	@RequestMapping("addTask")
	@ResponseBody
	public JSONObject addTask(String taskid, Integer agvId) {
		try {
			AppMsg msg = taskexeService.addTask(new TaskexeBean(taskid, agvId, 0));
			return msg.toAlbbJson();
		} catch (Exception e) {
			return new AppMsg(-1, "发生错误" + e.getMessage()).toAlbbJson();
		}
	}

	@RequestMapping("addCtrlTask")
	@ResponseBody
	public JSONObject addCtrlTask(String taskid, Integer agvId) {
		try {
			if (AgvCtrlType.AGVS_STOP_PI.equals(taskid) || AgvCtrlType.AGVS_OPEN_PI.equals(taskid)) {
				int num = controlInfoDao.updateAgvsPI(AgvCtrlType.AGVS_STOP_PI.equals(taskid) ? 0 : 1);
				kaifantechDBLogger.warning((AgvCtrlType.AGVS_STOP_PI.equals(taskid) ? AgvCtrlType.AGVS_STOP_PI_STR
						: AgvCtrlType.AGVS_OPEN_PI_STR) + num, 0, AgvStatusDBLogger.MSG_LEVEL_WARNING);
				return new AppMsg(0, "更新成功！").toAlbbJson();
			}

			if (AgvCtrlType.AGVS_STOP_AUTO_TASK.equals(taskid) || AgvCtrlType.AGVS_OPEN_AUTO_TASK.equals(taskid)) {
				boolean num = SystemParameters.setAutoTask(!AgvCtrlType.AGVS_STOP_AUTO_TASK.equals(taskid));
				kaifantechDBLogger
						.warning(
								(AgvCtrlType.AGVS_STOP_AUTO_TASK.equals(taskid) ? AgvCtrlType.AGVS_STOP_AUTO_TASK_STR
										: AgvCtrlType.AGVS_OPEN_AUTO_TASK_STR) + num,
								0, AgvStatusDBLogger.MSG_LEVEL_WARNING);
				return new AppMsg(0, "更新成功！").toAlbbJson();
			}

			if (AgvTaskType.GOTO_CHARGE.equals(taskid)) {
				agvOpChargeDao.commandToCharge(agvId);
			} else if (AgvTaskType.BACK_CHARGE.equals(taskid)) {
				agvOpChargeDao.commandBackCharge(agvId);
			} else if (AgvMoveStatus.PAUSE_USER.equals(taskid)) {
				agvOpChargeDao.pauseByUser(agvId);
				if (agvId.equals(0)) {
					for (IotClientBean agv : iotClientService.getAgvCacheList()) {
						agvOpChargeDao.pauseByUser(agv.getId());
					}
				}
			} else if (AgvMoveStatus.CONTINUE.equals(taskid)) {
				agvOpChargeDao.startup(agvId);
			} else if (AgvMoveStatus.SHUTDOWN.equals(taskid)) {
				TaskexeBean taskexeBean = taskexeInfoService.getNextOne(agvId);
				if (!AppTool.isNull(taskexeBean)) {
					SystemParameters.setShutdown(taskexeBean.getTaskid());
				}
			} else if (AgvTaskType.GOTO_INIT.equals(taskid)) {
				agvOpInitDao.commandToInit(agvId);
			}

			AppMsg msg = agvStatusService.addStatus(new AgvStatusBean(taskid, agvId, 0));
			return msg.toAlbbJson();
		} catch (Exception e) {
			return new AppMsg(-1, "发生错误" + e.getMessage()).toAlbbJson();
		}
	}

}
