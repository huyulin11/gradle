package com.kaifantech.util.socket.client;

import java.net.InetSocketAddress;

import com.kaifantech.util.socket.ISocket;
import com.ytgrading.util.msg.AppMsg;

public interface ISocketClient extends ISocket {
	default String getClientInfo() {
		return "客户端:" + getSocketInfo();
	}

	public AppMsg sendMsg(String msg);

	public String getMsg();

	public String getLatestMsg();

	public void setLatestMsg(String latestMsg);

	public InetSocketAddress getServerAddress();

	public void setServerAddress(InetSocketAddress serverAddress);

}