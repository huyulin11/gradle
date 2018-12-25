package com.kaifantech.util.socket;

import java.nio.charset.Charset;
import java.util.Deque;
import java.util.UUID;

public interface ISocket {

	static Charset CHARSET = Charset.forName("UTF-8");

	default boolean sendMsg(byte[] msg) {
		return false;
	}

	default Deque<String> getErrMsgDeque() {
		return null;
	}

	void init() throws Exception;

	static String str() {
		return UUID.randomUUID().toString().replace("-", "") + '\n';
	}

	String getHost();

	int getPort();

	default String getSocketInfo() {
		return "IP:PORT-" + getHost() + ":" + getPort() + "(" + this.getClass().getSimpleName() + ")";
	}

	void closeResource();

}