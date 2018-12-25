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
import com.kaifantech.util.log.CsyAppFileLogger;
import com.kaifantech.util.msg.plc.PlcMsgGetter;
import com.kaifantech.util.socket.client.AbstractSocketClient;
import com.kaifantech.util.socket.netty.client.AbstractNettyClient;
import com.kaifantech.util.socket.netty.client.csy.NettyClientFactory;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

@Service
public class CsyPlcWorker implements IClientWorker {
	private Map<Integer, AbstractSocketClient> clientMap = new HashMap<Integer, AbstractSocketClient>();

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	private IotRelationService iotRelationService;

	private boolean isCheckingConnect = false;

	public synchronized void init() {
		if (!ProjectName.KF_CSY_DAJ.equals(SystemClient.PROJECT_NAME)) {
			return;
		}

		if (clientMap != null && clientMap.size() > 0) {
			if (!isCheckingConnect) {
				ThreadTool.run(() -> {
					while (true) {
						isCheckingConnect = true;
						for (Integer agvId : clientMap.keySet()) {
							try {
								String msg = PlcMsgGetter.one().getMsg(agvId);
								if (AppTool.isNull(msg)) {
									clientMap.get(agvId).closeResource();
									CsyAppFileLogger.connectError(agvId + "号AGV的PLC连接中断，持续未收到PLC的反馈消息，中断当前连接后重试！");
								}
							} catch (Exception e) {
								CsyAppFileLogger.connectError(agvId + "号AGV的PLC连接中断重置出现问题！" + e.getMessage());
							}
						}
						ThreadTool.sleep(5000);
					}
				});
			}
			return;
		}

		for (IotClientBean bean : iotClientService.getList()) {
			if ((bean.getDevtype().equals(IotDevType.PLC_ON_AGV))) {
				try {
					AbstractSocketClient client;
					client = NettyClientFactory.create(bean);
					IotRelationBean relation = iotRelationService.getIotRelationBean(bean);
					if (AppTool.isNull(relation)) {
						continue;
					}
					clientMap.put(relation.getAgvid(), client);
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
		return clientMap;
	}
}
