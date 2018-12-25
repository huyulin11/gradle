package com.kaifantech.component.comm.worker.server.agv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.bean.msg.agv.TaskPathInfoPointBean;
import com.kaifantech.bean.msg.agv.XYBean;
import com.kaifantech.bean.taskexe.TaskexeBean;
import com.kaifantech.component.business.ctrl.deal.ICtrlDealModule;
import com.kaifantech.component.business.task.deal.ITaskexeDealModule;
import com.kaifantech.component.dao.simulator.TestPathDao;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.singletask.info.SingleTaskInfoService;
import com.kaifantech.component.service.taskexe.info.TaskexeInfoService;
import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.init.sys.SystemClient.ProjectName;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.init.sys.qualifier.AcsSystemQualifier;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.constant.taskexe.TaskexeOpFlag;
import com.kaifantech.util.constants.cmd.AgvCmdConstant;
import com.kaifantech.util.socket.netty.client.InomaNettyClient;
import com.kaifantech.util.socket.netty.server.DefauNettyServer;
import com.kaifantech.util.socket.server.AbstractServer;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

@Service(AcsSystemQualifier.AGV_SIMULATOR_MGR)
public class AcsAgvSimulatorWorker implements IAgvSimulatorWorker {
	private Map<Integer, DefauNettyServer> map = new HashMap<>();

	@Autowired
	private TestPathDao testPathDao;

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	private SingleTaskInfoService singleTaskInfoService;

	@Autowired
	private TaskexeInfoService taskexeInfoService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_TASKEXE_DEALER_MODULE)
	private ITaskexeDealModule commandTaskService;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_CTRL_DEALER_MODULE)
	private ICtrlDealModule commandCtrlService;

	private Map<Integer, XYBean> addXY = new HashMap<>();

	private final static int step = 3000;

	private void intAddXY() {
		addXY.put(1, new XYBean(0, 0));
		addXY.put(2, new XYBean(step, step));
		addXY.put(3, new XYBean(-step, step));
		addXY.put(4, new XYBean(-step * 4, -step));
		addXY.put(5, new XYBean(-step * 4, -step * 3));
		addXY.put(6, new XYBean(step * 2, 0));
		addXY.put(7, new XYBean(-step * 2, -step * 2));
		addXY.put(8, new XYBean(step * 2, -step * 2));
		addXY.put(9, new XYBean(-step * 4, -step * 4));
		addXY.put(10, new XYBean(-step * 3, -step * 3));
	}

	public AcsAgvSimulatorWorker() {
		intAddXY();
	}

	private synchronized AbstractServer getAGVSimulator(Integer agvId) {
		if (map == null || map.size() == 0) {
			getAGVSimulatorMap();
		}
		return map.get(agvId);
	}

	private Map<Integer, List<TaskPathInfoPointBean>> dsMap = new HashMap<>();

	private Map<Integer, List<Map<String, Object>>> ds2Map = new HashMap<>();

	private List<TaskPathInfoPointBean> getPathDS(Integer agvId) {
		List<TaskPathInfoPointBean> beans = dsMap.get(agvId);
		if (AppTool.isNull(beans) || beans.isEmpty()) {
			beans = testPathDao.selectPath(agvId.equals(1) ? 1130 : (agvId.equals(2) ? 1130 : 4026));
			dsMap.put(agvId, beans);
		}
		return beans;
	}

	private List<Map<String, Object>> getPathDS2(Integer agvId, String taskName) {
		List<Map<String, Object>> beans = ds2Map.get(agvId);
		if (AppTool.isNull(beans) || beans.isEmpty()) {
			if (!AppTool.isNull(taskName)) {
				beans = testPathDao.getNextMsgFromSQL(taskName);
			} else {
				beans = testPathDao.getNextMsgFromSQL(agvId);
			}
			ds2Map.put(agvId, beans);
		}
		return beans;
	}

	class Temp {
		String msgFromAGV;
		Integer count;
	}

	private Temp getMsgFromAGV(Integer agvId) {
		Temp temp = new Temp();
		String xPatten = "XVALUE";
		String yPatten = "YVALUE";
		String aPatten = "AVALUE";
		String batteryPatten = "BATTERY_VALUE";
		String msgFromAGV = "cmd=position;pause_stat=0;battery=" + batteryPatten + ";error=0;x=" + xPatten + ";y="
				+ yPatten + ";a=" + aPatten + ";z=-2;gAlarm=1;speed=48;" + "task=1-Q-5-6-1-114.xml;"
				+ "veer_angle=75.000000;task_step=7;" + "task_isfinished=0;" + "task_error=327688;walk_path_id=-1?";
		List<TaskPathInfoPointBean> beans = getPathDS(agvId);
		Integer count = beans.size();
		TaskPathInfoPointBean bean = beans.get(getAGVSimulator(agvId).j % (count));
		msgFromAGV = msgFromAGV.replaceAll(xPatten, "" + (bean.getX() + addXY.get(agvId).x));
		msgFromAGV = msgFromAGV.replaceAll(yPatten, "" + (bean.getY() + addXY.get(agvId).y));
		msgFromAGV = msgFromAGV.replaceAll(aPatten, "" + bean.getAngle());
		msgFromAGV = msgFromAGV.replaceAll(batteryPatten,
				"" + (agvId.equals(1) ? 950 : (agvId.equals(2) ? 658 : (agvId.equals(3) ? 557 : 369))));
		temp.count = count;
		temp.msgFromAGV = msgFromAGV;
		return temp;
	}

	private String getMsgToSend(Integer agvId) {
		Temp temp = new Temp();
		String msgFromAGV;
		Integer count;
		List<Map<String, Object>> beans = null;

		if (agvId.equals(2)) {
			beans = getPathDS2(agvId, null);
			count = beans.size();
		} else if (agvId.equals(1)) {
			beans = getPathDS2(agvId, "1-I-4-3-1-114.xml");
			count = beans.size();
		} else {
			temp = getMsgFromAGV(agvId);
			count = temp.count;
		}

		if (!AppTool.isNull(beans)) {
			if (getAGVSimulator(agvId).j >= count - 1) {
				getAGVSimulator(agvId).j = count - 1;
			}
			msgFromAGV = beans.get(getAGVSimulator(agvId).j % (count)).get("msg").toString();
		} else {
			msgFromAGV = temp.msgFromAGV;
		}

		if (!AppTool.isNull(msgFromAGV)) {
			String taskid;
			String taskName = null;
			TaskexeBean latestTaskexe;
			String lastCtrlCMD;

			latestTaskexe = taskexeInfoService.getNotOverOneF(agvId);
			taskid = commandTaskService.getLastTaskCmd().get(agvId);
			if (AppTool.isNull(taskid)) {
				if (latestTaskexe != null) {
					taskid = latestTaskexe.getTaskid();
				}
			}
			if (!AppTool.isNull(taskid)) {
				taskName = singleTaskInfoService.getSingletask(taskid).getTaskName();
			}

			lastCtrlCMD = commandCtrlService.getLastCtrlCmd().get(agvId);

			if (!AppTool.isNull(taskName)) {
				String orgiTaskName = msgFromAGV.substring(msgFromAGV.indexOf("task="),
						msgFromAGV.indexOf(".xml;") + ".xml;".length());
				msgFromAGV = msgFromAGV.replaceAll(orgiTaskName, "task=" + taskName + ";");
			}
			if (latestTaskexe != null && !TaskexeOpFlag.OVER.equals(latestTaskexe.getOpflag())) {
				if (getAGVSimulator(agvId).j >= count - 1) {
					msgFromAGV = msgFromAGV.replaceAll("task_isfinished=0;", "task_isfinished=1;");
				}
			} else {
				getAGVSimulator(agvId).j = getAGVSimulator(agvId).jStart;
				msgFromAGV = msgFromAGV.replaceAll("task_isfinished=0;", "task_isfinished=1;");
			}

			if (!AppTool.isNull(lastCtrlCMD) && lastCtrlCMD.equals(InomaNettyClient.PAUSE_CMD)) {
				msgFromAGV = msgFromAGV.replaceAll("pause_stat=0;", "pause_stat=1;");
			} else {
				if (getAGVSimulator(agvId).j < count - 1) {
					getAGVSimulator(agvId).j += 1;
				}
				msgFromAGV = msgFromAGV.replaceAll("pause_stat=1;", "pause_stat=0;");
			}
			if (agvId.equals(2)) {
				count = count + 1 - 1;
			}
		}
		return msgFromAGV;
	}

	public void sendNextMsg(Integer agvId) {
		if (ProjectName.KF_CSY_DAJ.equals(SystemClient.PROJECT_NAME)) {
			getAGVSimulator(agvId).setMsgTobeSend(AgvCmdConstant.CMD_STOP);
		} else {
			String msgFromAGV = getMsgToSend(agvId);
			if (!AppTool.isNull(msgFromAGV)) {
				getAGVSimulator(agvId).setMsgTobeSend(msgFromAGV);
			}
		}

	}

	public void startConnect() {
		if (!SystemParameters.isConnectIotClient()) {
			return;
		}
		while (true) {
			if (!SystemParameters.isConnectIotClient()) {
				for (AbstractServer t : map.values()) {
					t.closeResource();
				}
				map.clear();
				break;
			}
			for (IotClientBean agv : iotClientService.getAgvCacheList()) {
				IotClientBean iotClientBean = iotClientService.getBean(agv.getId());
				if ("127.0.0.1".equals(iotClientBean.getIp())) {
					sendNextMsg(agv.getId());
				}
			}
			ThreadTool.sleep(1000);
		}
	}

	private synchronized Map<Integer, DefauNettyServer> getAGVSimulatorMap() {
		return map;
	}

	@Override
	public synchronized void init() {
		if (map == null || map.size() == 0) {
			for (IotClientBean agv : iotClientService.getAgvCacheList()) {
				IotClientBean iotClientBean = iotClientService.getBean(agv.getId());
				DefauNettyServer simulator = AbstractServer.create(iotClientBean.getPort());
				map.put(agv.getId(), simulator);
				try {
					simulator.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public synchronized Map<Integer, DefauNettyServer> getMap() {
		return map;
	}
}
