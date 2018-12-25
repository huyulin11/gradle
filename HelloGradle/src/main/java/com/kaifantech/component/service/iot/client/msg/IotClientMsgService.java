package com.kaifantech.component.service.iot.client.msg;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.bean.msg.agv.AGVMsgBean;
import com.kaifantech.component.dao.AGVConnectMsgDao;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.ytgrading.util.AppTool;

@Service
public class IotClientMsgService {
	private Map<Integer, IotClientLatestMsg> latestMsgMap = new HashMap<Integer, IotClientLatestMsg>();

	@Autowired
	private AGVConnectMsgDao connectMsgDao;

	@Autowired
	private IotClientService iotClientService;

	public IotClientLatestMsg getLatestMsg(Integer agvId) {
		IotClientLatestMsg latestMsgObj = latestMsgMap.get(agvId);
		if (latestMsgObj == null) {
			latestMsgMap.put(agvId, new IotClientLatestMsg(new AGVMsgBean(), ""));
		}
		return latestMsgMap.get(agvId);
	}

	public void setLatestMsg() {
		for (IotClientBean agvBean : iotClientService.getAgvCacheList()) {
			new Runnable() {
				public void run() {
					getLatestMsgFromDB(agvBean.getId());
				}
			}.run();
		}
	}

	private void getLatestMsgFromDB(Integer agvId) {
		try {
			Map<String, Object> msgFromAGVF = connectMsgDao.getLatestMsgFromDB(agvId);

			if (AppTool.isNull(msgFromAGVF)) {
				return;
			}
			Object sFromAGV = msgFromAGVF.get("msg");
			if (AppTool.isNull(msgFromAGVF)) {
				return;
			}

			Object agvObjectId = msgFromAGVF.get("agvId");
			if (AppTool.isNull(agvObjectId)) {
				return;
			}

			String latestMsgStr = "";
			if (!AppTool.isNull(sFromAGV)) {
				latestMsgStr = sFromAGV.toString().trim();
			} else {
				return;
			}

			String finishStatus = "";
			String taskid = "";
			String battery = "";
			String x = "";
			String y = "";
			String time = msgFromAGVF.get("time").toString();

			if (sFromAGV.toString().trim().indexOf("task_isfinished=") >= 0) {
				finishStatus = latestMsgStr.substring(
						latestMsgStr.indexOf("task_isfinished=") + "task_isfinished=".length(),
						latestMsgStr.indexOf("task_isfinished=") + "task_isfinished=".length() + 1);
			}
			if (sFromAGV.toString().trim().indexOf(";task=") >= 0) {
				for (int i = 0; i < 10; i++) {
					String c = latestMsgStr.substring(latestMsgStr.indexOf(";task=") + ";task=".length() + i,
							latestMsgStr.indexOf(";task=") + ";task=".length() + i + 1);
					if (Character.isDigit(c.charAt(0))) {
						taskid += c;
					} else {
						break;
					}
				}
			}
			if (sFromAGV.toString().trim().indexOf(";battery=") >= 0) {
				for (int i = 0; i < 10; i++) {
					String c = latestMsgStr.substring(latestMsgStr.indexOf(";battery=") + ";battery=".length() + i,
							latestMsgStr.indexOf(";battery=") + ";battery=".length() + i + 1);
					if (Character.isDigit(c.charAt(0)) || c.charAt(0) == '.') {
						battery += c;
					} else {
						break;
					}
				}
			}
			if (sFromAGV.toString().trim().indexOf(";x=") >= 0) {
				for (int i = 0; i < 10; i++) {
					String c = latestMsgStr.substring(latestMsgStr.indexOf(";x=") + ";x=".length() + i,
							latestMsgStr.indexOf(";x=") + ";x=".length() + i + 1);
					if (Character.isDigit(c.charAt(0)) || c.charAt(0) == '.' || c.charAt(0) == '-') {
						x += c;
					} else {
						break;
					}
				}
			}
			if (sFromAGV.toString().trim().indexOf(";y=") >= 0) {
				for (int i = 0; i < 10; i++) {
					String c = latestMsgStr.substring(latestMsgStr.indexOf(";y=") + ";y=".length() + i,
							latestMsgStr.indexOf(";y=") + ";y=".length() + i + 1);
					if (Character.isDigit(c.charAt(0)) || c.charAt(0) == '.' || c.charAt(0) == '-') {
						y += c;
					} else {
						break;
					}
				}
			}

			AGVMsgBean latestMsg = new AGVMsgBean();
			latestMsg.setTaskid(taskid);
			latestMsg.setTaskIsfinished(finishStatus);
			latestMsg.setBattery(battery);
			latestMsg.setX(Integer.parseInt(x));
			latestMsg.setY(Integer.parseInt(y));
			latestMsg.setTime(time);

			IotClientLatestMsg latestMsgObj = latestMsgMap.get(agvObjectId);

			if (latestMsgObj == null) {
				latestMsgMap.put((Integer) agvObjectId, new IotClientLatestMsg(latestMsg, latestMsgStr));
			} else {
				latestMsgObj.setAGVMsg(latestMsg);
				latestMsgObj.setLatestMsgStr(latestMsgStr);
			}
		} catch (Exception e) {
			return;
		}
	}

}
