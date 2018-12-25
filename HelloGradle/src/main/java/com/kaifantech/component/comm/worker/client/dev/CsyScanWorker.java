package com.kaifantech.component.comm.worker.client.dev;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.bean.iot.relation.IotRelationBean;
import com.kaifantech.component.comm.worker.client.IClientWorker;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.relation.IotRelationService;
import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.init.sys.SystemClient.ProjectName;
import com.kaifantech.util.constant.taskexe.ctrl.AgvCtrlType.IotDevType;
import com.kaifantech.util.socket.client.AbstractSocketClient;
import com.kaifantech.util.socket.netty.client.AbstractNettyClient;
import com.kaifantech.util.socket.netty.client.csy.NettyClientFactory;
import com.ytgrading.util.AppTool;

@Service
@Deprecated
public class CsyScanWorker implements IClientWorker {
	private Map<Integer, AbstractSocketClient> map = new HashMap<Integer, AbstractSocketClient>();

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	private IotRelationService iotRelationService;

	public synchronized void init() {
		if (!ProjectName.KF_CSY_DAJ.equals(SystemClient.PROJECT_NAME)) {
			return;
		}

		if (!(map == null || map.size() <= 0)) {
			return;
		}

		for (IotClientBean bean : iotClientService.getList()) {
			if (bean.getDevtype().equals(IotDevType.SCAN)) {
				try {
					AbstractSocketClient client;
					client = NettyClientFactory.create(bean);
					IotRelationBean relation = iotRelationService.getIotRelationBean(bean);
					if (AppTool.isNull(relation)) {
						continue;
					}
					map.put(relation.getAgvid(), client);
					((AbstractNettyClient) client).setAgvId(relation.getAgvid());
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
		return map;
	}
}
