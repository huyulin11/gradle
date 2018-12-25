package com.kaifantech.util.socket.server;

import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.init.sys.SystemClient.ProjectName;
import com.kaifantech.util.socket.netty.server.DefauNettyServer;
import com.kaifantech.util.socket.netty.server.csy.CsyAgvNettyServer;

public abstract class AbstractServer extends Thread implements ISocketServer {
	public int jStart = 0;
	public int j = jStart;
	boolean started = false;
	private int port;
	private String msgTobeSend = "";
	private String msgReceived = "";

	public static DefauNettyServer create(int port) {
		if (ProjectName.KF_CSY_DAJ.equals(SystemClient.PROJECT_NAME)) {
			return new CsyAgvNettyServer(port);
		} else {
			return new DefauNettyServer(port);
		}
	}

	public AbstractServer(int port) {
		this.setPort(port);
	}

	public void init() throws Exception {
	}

	public String getMsgTobeSend() {
		return msgTobeSend;
	}

	public void closeResource() {

	}

	public void setMsgTobeSend(String msg) {
		this.msgTobeSend = msg;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getMsgReceived() {
		return msgReceived;
	}

	public void setMsgReceived(String msgReceived) {
		this.msgReceived = msgReceived;
	}

}