package com.kaifantech.component.comm.worker.server.agv;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.init.sys.qualifier.CsySystemQualifier;
import com.kaifantech.util.socket.netty.server.DefauNettyServer;
import com.kaifantech.util.socket.netty.server.csy.CsyAgvNettyServer;

@Service(CsySystemQualifier.AGV_SIMULATOR_WORKER)
public class CsyAgvSimulatorWorker implements IAgvSimulatorWorker {
	private Map<Integer, DefauNettyServer> map = new HashMap<>();

	@Autowired
	private IotClientService iotClientService;

	public synchronized void init() {
		if (map == null || map.size() == 0) {
			for (IotClientBean agv : iotClientService.getAgvCacheList()) {
				if ("127.0.0.1".equals(agv.getIp())) {
					CsyAgvNettyServer simulator = CsyAgvNettyServer.create(agv.getPort());
					map.put(agv.getId(), simulator);
					try {
						simulator.init();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public synchronized Map<Integer, DefauNettyServer> getMap() {
		return map;
	}
}
