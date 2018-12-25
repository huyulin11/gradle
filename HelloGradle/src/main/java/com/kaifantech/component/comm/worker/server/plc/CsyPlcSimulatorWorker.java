package com.kaifantech.component.comm.worker.server.plc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.bean.iot.relation.IotRelationBean;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.relation.IotRelationService;
import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.init.sys.SystemClient.ProjectName;
import com.kaifantech.init.sys.SystemInitiator;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.IotDevType;
import com.kaifantech.util.socket.netty.server.DefauNettyServer;
import com.kaifantech.util.socket.netty.server.csy.CsyPlcNettyServer;
import com.ytgrading.util.AppTool;

@Service
public class CsyPlcSimulatorWorker implements IPlcSimulatorWorker {
	private Map<Integer, DefauNettyServer> map = new HashMap<>();

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	private IotRelationService iotRelationService;

	public synchronized void init() {
		if (SystemInitiator.alwaysTrue) {
			return;
		}
		if (map == null || map.size() == 0) {
			for (IotClientBean bean : iotClientService.getList()) {
				if (ProjectName.KF_CSY_DAJ.equals(SystemClient.PROJECT_NAME)
						&& bean.getDevtype().equals(IotDevType.PLC_ON_AGV)) {
					IotRelationBean relation = iotRelationService.getIotRelationBean(bean);
					if (AppTool.isNull(relation)) {
						continue;
					}
					if ("127.0.0.1".equals(bean.getIp())) {
						CsyPlcNettyServer simulator = CsyPlcNettyServer.create(bean.getPort());
						simulator.setAgvId(relation.getAgvid());
						map.put(bean.getId(), simulator);
						try {
							simulator.init();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	public synchronized Map<Integer, DefauNettyServer> getMap() {
		return map;
	}

}
