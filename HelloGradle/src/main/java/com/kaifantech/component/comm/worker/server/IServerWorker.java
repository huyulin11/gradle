package com.kaifantech.component.comm.worker.server;

import java.util.Map;

import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.util.socket.netty.server.DefauNettyServer;

public interface IServerWorker {
	void init();

	Map<Integer, DefauNettyServer> getMap();

	default DefauNettyServer get(Integer keyId) {
		return getMap().get(keyId);
	}

	default void startConnect() {
		if (!SystemParameters.isConnectIotServer()) {
			return;
		}
		init();
		if (!SystemParameters.isConnectIotServer()) {
			for (DefauNettyServer t : getMap().values()) {
				t.closeResource();
			}
			getMap().clear();
		}
	}
}
