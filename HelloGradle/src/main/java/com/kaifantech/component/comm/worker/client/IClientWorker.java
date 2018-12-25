package com.kaifantech.component.comm.worker.client;

import java.util.Map;

import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.util.socket.client.AbstractSocketClient;

public interface IClientWorker {

	default AbstractSocketClient get(Integer keyId) {
		return getMap().get(keyId);
	}

	Map<Integer, AbstractSocketClient> getMap();

	void init();

	default void startConnect() {
		if (!SystemParameters.isConnectIotClient()) {
			return;
		}
		init();
	}
}
