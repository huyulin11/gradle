package com.kaifantech.util.socket.client;

import java.net.InetSocketAddress;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import com.kaifantech.util.thread.ThreadTool;

public abstract class AbstractSocketClient implements ISocketClient {

	private String host = "";
	private int port = 8182;
	private int devtype = 0;
	private Integer devId;
	private String latestMsg = "";
	private String sendedCmd = "";

	private InetSocketAddress serverAddress = null;

	private Deque<String> errMsgDeque = new ArrayDeque<String>();

	public AbstractSocketClient(String host, int port, int devtype) {
		this.host = host;
		this.port = port;
		this.devtype = devtype;
		serverAddress = new InetSocketAddress(host, port);
	}

	public AbstractSocketClient(String host, int port, int devtype, boolean isInit) {
		this(host, port, devtype);
		if (isInit) {
			ThreadTool.getThreadPool().execute(new Runnable() {
				public void run() {
					try {
						init();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	public List<Integer> getLatestMsgList() {
		return null;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public int getPort() {
		return port;
	}

	public Deque<String> getErrMsgDeque() {
		return errMsgDeque;
	}

	public String getLatestMsg() {
		return latestMsg;
	}

	public void setLatestMsg(String latestMsg) {
		this.latestMsg = latestMsg;
	}

	public InetSocketAddress getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(InetSocketAddress serverAddress) {
		this.serverAddress = serverAddress;
	}

	public int getDevtype() {
		return devtype;
	}

	public String getMsg() {
		return getLatestMsg();
	}

	public String getSendedCmd() {
		return sendedCmd;
	}

	public void setSendedCmd(String sendedCmd) {
		this.sendedCmd = sendedCmd;
	}

	public Integer getDevId() {
		return devId;
	}

	public void setDevId(Integer devId) {
		this.devId = devId;
	}

}