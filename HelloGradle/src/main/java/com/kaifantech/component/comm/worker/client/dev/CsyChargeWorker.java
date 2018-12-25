package com.kaifantech.component.comm.worker.client.dev;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.component.comm.worker.client.IClientWorker;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.init.sys.SystemClient.ProjectName;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.IotDevType;
import com.kaifantech.util.socket.client.AbstractSocketClient;
import com.kaifantech.util.socket.netty.client.csy.NettyClientFactory;

@Service
public class CsyChargeWorker implements IClientWorker {
	private Map<Integer, AbstractSocketClient> clientMap = new HashMap<Integer, AbstractSocketClient>();

	@Autowired
	private IotClientService iotClientService;

	public synchronized void init() {
		if (!ProjectName.KF_CSY_DAJ.equals(SystemClient.PROJECT_NAME)) {
			return;
		}

		if (!(clientMap == null || clientMap.size() <= 0)) {
			return;
		}

		for (IotClientBean bean : iotClientService.getList()) {
			if ((bean.getDevtype().equals(IotDevType.CHARGE))) {
				try {
					AbstractSocketClient client;
					client = NettyClientFactory.create(bean);
					clientMap.put(bean.getId(), client);
					client.init();
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}
		}
	}

	public Map<Integer, AbstractSocketClient> getMap() {
		init();
		return clientMap;
	}
}
