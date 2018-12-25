package com.kaifantech.bean.msg.agv;

import com.kaifantech.init.sys.SystemInitiator;
import com.ytgrading.util.AppTool;

public class InomaAgvMsgBeanTransfer {
	public static AGVMsgBean transToBean(Integer agvId, String sFromAGV, AGVMsgBean agvMsgBean) {
		try {
			if (AppTool.isNull(agvId)) {
				return null;
			}

			if (AppTool.isNull(sFromAGV)) {
				return new AGVMsgBean();
			}
			sFromAGV = sFromAGV.trim();

			String finishStatus = "";
			String taskid = "";
			String battery = "";
			String angle = "";
			String taskStep = "";
			String pauseStat = "";
			String x = "";
			String y = "";
			String speed = "";

			if (sFromAGV.toString().trim().indexOf("pause_stat=") >= 0) {
				pauseStat = sFromAGV.substring(sFromAGV.indexOf("pause_stat=") + "pause_stat=".length(),
						sFromAGV.indexOf("pause_stat=") + "pause_stat=".length() + 1);
			}
			if (sFromAGV.toString().trim().indexOf("task_isfinished=") >= 0) {
				finishStatus = sFromAGV.substring(sFromAGV.indexOf("task_isfinished=") + "task_isfinished=".length(),
						sFromAGV.indexOf("task_isfinished=") + "task_isfinished=".length() + 1);
			}

			if (sFromAGV.toString().trim().indexOf(";task=") >= 0) {
				for (int i = 0; i < 20; i++) {
					String c = sFromAGV.substring(sFromAGV.indexOf(";task=") + ";task=".length() + i,
							sFromAGV.indexOf(";task=") + ";task=".length() + i + 1);
					if (Character.isUpperCase(c.charAt(0)) || Character.isDigit(c.charAt(0)) || c.charAt(0) == '-'
							|| c.charAt(0) == '_') {
						taskid += c;
					} else {
						break;
					}
				}
			}

			if (sFromAGV.toString().trim().indexOf(";task_step=") >= 0) {
				for (int i = 0; i < 10; i++) {
					String c = sFromAGV.substring(sFromAGV.indexOf(";task_step=") + ";task_step=".length() + i,
							sFromAGV.indexOf(";task_step=") + ";task_step=".length() + i + 1);
					if (Character.isDigit(c.charAt(0))) {
						taskStep += c;
					} else {
						break;
					}
				}
			}

			if (sFromAGV.toString().trim().indexOf(";battery=") >= 0) {
				for (int i = 0; i < 10; i++) {
					String c = sFromAGV.substring(sFromAGV.indexOf(";battery=") + ";battery=".length() + i,
							sFromAGV.indexOf(";battery=") + ";battery=".length() + i + 1);
					if (Character.isDigit(c.charAt(0)) || c.charAt(0) == '.') {
						battery += c;
					} else {
						break;
					}
				}
			}

			if (sFromAGV.toString().trim().indexOf(";a=") >= 0) {
				for (int i = 0; i < 10; i++) {
					String c = sFromAGV.substring(sFromAGV.indexOf(";a=") + ";a=".length() + i,
							sFromAGV.indexOf(";a=") + ";a=".length() + i + 1);
					if (Character.isDigit(c.charAt(0)) || c.charAt(0) == '.') {
						angle += c;
					} else {
						break;
					}
				}
			}

			if (sFromAGV.toString().trim().indexOf(";x=") >= 0) {
				for (int i = 0; i < 10; i++) {
					String c = sFromAGV.substring(sFromAGV.indexOf(";x=") + ";x=".length() + i,
							sFromAGV.indexOf(";x=") + ";x=".length() + i + 1);
					if (Character.isDigit(c.charAt(0)) || c.charAt(0) == '.' || c.charAt(0) == '-') {
						x += c;
					} else {
						break;
					}
				}
			}

			if (sFromAGV.toString().trim().indexOf(";speed=") >= 0) {
				for (int i = 0; i < 10; i++) {
					String c = sFromAGV.substring(sFromAGV.indexOf(";speed=") + ";speed=".length() + i,
							sFromAGV.indexOf(";speed=") + ";speed=".length() + i + 1);
					if (Character.isDigit(c.charAt(0)) || c.charAt(0) == '.' || c.charAt(0) == '-') {
						speed += c;
					} else {
						break;
					}
				}
			}

			if (sFromAGV.toString().trim().indexOf(";y=") >= 0) {
				for (int i = 0; i < 10; i++) {
					String c = sFromAGV.substring(sFromAGV.indexOf(";y=") + ";y=".length() + i,
							sFromAGV.indexOf(";y=") + ";y=".length() + i + 1);
					if (Character.isDigit(c.charAt(0)) || c.charAt(0) == '.' || c.charAt(0) == '-') {
						y += c;
					} else {
						break;
					}
				}
			}

			agvMsgBean.setTaskName(taskid + ".xml");
			agvMsgBean.setTaskIsfinished(finishStatus);
			agvMsgBean.setBattery(battery);
			agvMsgBean.setAngle(Float.parseFloat(angle));
			agvMsgBean.setPauseStat(pauseStat);

			agvMsgBean.setAGVId(agvId);
			agvMsgBean.setTaskStep(AppTool.isNull(taskStep) ? 0 : Integer.parseInt(taskStep));

			agvMsgBean.setX(Double.parseDouble(x));
			agvMsgBean.setY(Double.parseDouble(y));

			agvMsgBean.setSpeed(Integer.parseInt(speed));

			if (!SystemInitiator.alwaysTrue) {
				if (agvMsgBean.getAGVId().equals(2)) {
					agvMsgBean.setX(agvMsgBean.getX() - 300);
					agvMsgBean.setY(agvMsgBean.getY() - 300);
				} else if (agvMsgBean.getAGVId().equals(3)) {
					agvMsgBean.setX(agvMsgBean.getX() + 300);
					agvMsgBean.setY(agvMsgBean.getY() + 300);
				}
			}

			return agvMsgBean;
		} catch (Exception e) {
			return null;
		}
	}
}
