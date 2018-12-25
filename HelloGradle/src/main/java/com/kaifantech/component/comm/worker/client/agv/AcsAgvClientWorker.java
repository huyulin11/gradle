package com.kaifantech.component.comm.worker.client.agv;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.component.business.msg.info.agv.IAgvMsgInfoModule;
import com.kaifantech.component.dao.AGVConnectMsgDao;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.init.sys.qualifier.AcsSystemQualifier;
import com.kaifantech.util.socket.client.AbstractSocketClient;
import com.kaifantech.util.socket.netty.client.csy.NettyClientFactory;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

@Service(AcsSystemQualifier.AGV_CLIENT_WORKER)
public class AcsAgvClientWorker implements IAgvClientWorker {
	private Map<Integer, AbstractSocketClient> map = new HashMap<Integer, AbstractSocketClient>();

	@Autowired
	private IotClientService iotClientService;

	@Autowired
	private IAgvMsgInfoModule msgFromAGVService;

	@Autowired
	private AGVConnectMsgDao connectMsgDao;

	public void init() {
		if (map == null || map.size() <= 0) {
			for (IotClientBean agvBean : iotClientService.getAgvCacheList()) {
				AbstractSocketClient agvClient = NettyClientFactory.create(agvBean);
				map.put(agvBean.getId(), agvClient);
				try {
					agvClient.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Map<Integer, AbstractSocketClient> getMap() {
		init();
		return map;
	}

	public void startConnect() {
		Iterator<Entry<Integer, AbstractSocketClient>> iterator = getMap().entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, AbstractSocketClient> entry = iterator.next();
			doReceive(entry.getKey(), entry.getValue());
		}
	}

	@Async
	private void doReceive(Integer agvId, AbstractSocketClient client) {
		ThreadTool.run(() -> {
			String msg = client.getMsg();
			if (!AppTool.isNullStr(msg)) {
				ThreadTool.getThreadPool().execute(new Runnable() {
					public void run() {
						connectMsgDao.addAReceiveMsg(msg, agvId);
						msgFromAGVService.setLatestMsg();
					}
				});
			}
		});
	}

}
