package com.kaifantech.component.comm.worker.client.agv;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.init.sys.qualifier.CsySystemQualifier;
import com.kaifantech.util.log.CsyAppFileLogger;
import com.kaifantech.util.msg.agv.AgvMsgGetter;
import com.kaifantech.util.socket.client.AbstractSocketClient;
import com.kaifantech.util.socket.netty.client.AbstractNettyClient;
import com.kaifantech.util.socket.netty.client.csy.NettyClientFactory;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

@Service(CsySystemQualifier.AGV_CLIENT_WORKER)
public class CsyAgvClientWorker implements IAgvClientWorker {
	private Map<Integer, AbstractSocketClient> clientMap = new HashMap<Integer, AbstractSocketClient>();

	@Autowired
	private IotClientService iotClientService;

	private boolean isCheckingConnect = false;

	public synchronized void init() {
		if (clientMap == null || clientMap.size() <= 0) {
			for (IotClientBean agvBean : iotClientService.getAgvCacheList()) {
				AbstractSocketClient client = NettyClientFactory.create(agvBean);
				clientMap.put(agvBean.getId(), client);
				((AbstractNettyClient) client).setAgvId(agvBean.getId());
				try {
					client.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		if (clientMap != null && clientMap.size() > 0) {
			if (!isCheckingConnect) {
				ThreadTool.run(() -> {
					while (true) {
						isCheckingConnect = true;
						for (Integer agvId : clientMap.keySet()) {
							try {
								String msg = AgvMsgGetter.one().getMsg(agvId);
								if (AppTool.isNull(msg)) {
									clientMap.get(agvId).closeResource();
									CsyAppFileLogger.connectError(agvId + "号AGV连接中断，持续未收到反馈消息，中断当前连接后重试！");
								}
							} catch (Exception e) {
								CsyAppFileLogger.connectError(agvId + "号AGV连接中断重置出现问题！" + e.getMessage());
							}
						}
						ThreadTool.sleep(5000);
					}
				});
			}
			return;
		}

	}

	public synchronized Map<Integer, AbstractSocketClient> getMap() {
		init();
		return clientMap;
	}
}
