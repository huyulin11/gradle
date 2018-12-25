package com.kaifantech.util.socket.server;

import com.kaifantech.util.socket.ISocket;

public interface ISocketServer extends ISocket {

	default String getHost() {
		return "127.0.0.1";
	}

	default String getServerInfo() {
		return "服务端:" + getSocketInfo();
	}

}