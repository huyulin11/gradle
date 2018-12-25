package com.kaifantech.component.comm.worker.server.robot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kaifantech.util.socket.netty.server.DefauNettyServer;
import com.kaifantech.util.socket.netty.server.csy.CsyRobotNettyServer;

@Service
public class CsyRobotServerWorker implements IRobotServerWorker {
	private Map<Integer, DefauNettyServer> map = new HashMap<>();

	public synchronized Map<Integer, DefauNettyServer> getMap() {
		return map;
	}

	public synchronized void init() {
		if (getMap() == null || getMap().size() == 0) {
			CsyRobotNettyServer simulator = new CsyRobotNettyServer(7788);
			getMap().put(1, simulator);
			try {
				simulator.init();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
