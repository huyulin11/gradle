package com.kaifantech.test.csy;

import com.kaifantech.init.sys.params.CacheKeys;
import com.kaifantech.util.socket.netty.client.csy.CsyAgvNettyClient;
import com.kaifantech.util.socket.netty.client.csy.CsyChargeNettyClient;
import com.kaifantech.util.socket.netty.client.csy.CsyPlcNettyClient;
import com.kaifantech.util.socket.netty.client.csy.CsyScanNettyClient;
import com.kaifantech.util.socket.netty.client.csy.CsyWindowNettyClient;
import com.kaifantech.util.socket.netty.server.csy.CsyRobotNettyServer;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

public class IotTestApp {
	private static CsyAgvNettyClient agv;
	private static CsyRobotNettyServer robot;
	private static CsyChargeNettyClient charge;
	private static CsyScanNettyClient scan;
	private static CsyPlcNettyClient plc;
	private static CsyWindowNettyClient windowPlc;

	static {
		CacheKeys.setTest(true);
	}

	public synchronized static CsyRobotNettyServer getRobot() {
		if (!AppTool.isNull(robot)) {
			return robot;
		}
		robot = new CsyRobotNettyServer(5300);// 127.0.0.1
		ThreadTool.run(() -> {
			try {
				robot.init();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		ThreadTool.sleep(3000);
		return robot;
	}

	public synchronized static CsyAgvNettyClient getAgv() {
		return getAgv(1);
	}

	public synchronized static CsyAgvNettyClient getAgv(Integer agvId) {
		if (!AppTool.isNull(agv)) {
			return agv;
		}
		agv = new CsyAgvNettyClient("192.168.0.110", 5300, 0);// 127.0.0.1
		agv.setAgvId(agvId);
		ThreadTool.run(() -> {
			agv.init();
		});
		ThreadTool.sleep(3000);
		return agv;
	}

	public synchronized static CsyPlcNettyClient getPlc() {
		if (!AppTool.isNull(plc)) {
			return plc;
		}
		plc = new CsyPlcNettyClient("192.168.0.112", 2001, 0);// 127.0.0.1
		plc.setAgvId(1);
		ThreadTool.run(() -> {
			plc.init();
		});
		ThreadTool.sleep(5000);
		return plc;
	}

	public synchronized static CsyScanNettyClient getScan() {
		if (!AppTool.isNull(scan)) {
			return scan;
		}
		scan = new CsyScanNettyClient("192.168.0.110", 5302, 0);// 127.0.0.1
		scan.setAgvId(1);
		scan.setSwitchRead(true);
		ThreadTool.run(() -> {
			scan.init();
		});
		ThreadTool.sleep(3000);
		return scan;
	}

	public synchronized static CsyWindowNettyClient getWindow() {
		if (!AppTool.isNull(windowPlc)) {
			return windowPlc;
		}
		windowPlc = new CsyWindowNettyClient("192.168.0.160", 2000, 0);// 127.0.0.1
		windowPlc.setDevId(1);
		ThreadTool.run(() -> {
			windowPlc.init();
		});
		ThreadTool.sleep(3000);
		return windowPlc;
	}

	public synchronized static CsyChargeNettyClient getCharge() {
		if (!AppTool.isNull(charge)) {
			return charge;
		}
		charge = new CsyChargeNettyClient("192.168.0.101", 8080, 0);// 127.0.0.1
		charge.setDevId(129);
		ThreadTool.run(() -> {
			charge.init();
		});
		ThreadTool.sleep(3000);
		return charge;
	}
}
