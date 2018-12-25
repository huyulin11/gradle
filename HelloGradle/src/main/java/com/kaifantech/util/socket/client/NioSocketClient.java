package com.kaifantech.util.socket.client;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.UUID;

import com.kaifantech.util.socket.netty.client.InomaNettyClient;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

public class NioSocketClient extends AbstractSocketClient {

	private static Selector selector = null;
	private SocketChannel sc = null;
	private boolean isRunning = false;

	public NioSocketClient(String ip, int port, int devtype) {
		super(ip, port, devtype);
	}

	public NioSocketClient(String ip, int port, int devtype, boolean isInit) {
		super(ip, port, devtype, isInit);
	}

	public synchronized void init() {
		try {
			if (selector == null) {
				selector = Selector.open();
			}
			if (sc == null || !sc.isConnected() || !sc.isOpen()) {
				if (sc != null && sc.isOpen()) {
					closeResource();
				}
				sc = SocketChannel.open(getServerAddress());
				sc.configureBlocking(false);
				sc.register(selector, SelectionKey.OP_READ);
				getErrMsgDeque().push(this.getClass() + "成功连接" + getClientInfo());
			}
			if (!isRunning) {
				ThreadTool.getThreadPool().execute(new ClientThread());
			}
			int sllepTimes = 5000;
			ThreadTool.sleep(sllepTimes);
			init();

		} catch (Exception e) {
			setLatestMsg("");
			getErrMsgDeque().push("连接初始化失败，稍后重新尝试连接!" + getClientInfo());
			System.out.println("连接初始化失败，稍后重新尝试连接!" + getClientInfo());
			ThreadTool.sleep(2000);
			init();
		}
	}

	public AppMsg sendMsg(String msg) {
		String tips = "";
		if (InomaNettyClient.CONTINUE_CMD.equals(msg)) {
			tips = "继续指令";
		} else if (InomaNettyClient.PAUSE_CMD.equals(msg)) {
			tips = "暂停指令";
		} else {
			tips = "任务指令";
		}
		try {
			sc.write(CHARSET.encode(msg));
			getErrMsgDeque().push("发送" + tips + "成功!" + getClientInfo());
			return AppMsg.success();
		} catch (Exception e) {
			getErrMsgDeque().push("发送" + tips + "失败!" + getClientInfo());
			closeResource();
			return AppMsg.fail();
		}
	}

	public void sendMsgAsy(String msg) {
		ThreadTool.getThreadPool().execute(new Runnable() {
			public void run() {
				sendMsg(msg);
			}
		});
	}

	@Override
	public void closeResource() {
		try {

			setLatestMsg("");
			if (sc != null) {
				sc.close();
				sc = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		isRunning = false;
	}

	private int contentNullTimes = 0;

	private class ClientThread extends Thread {
		@Override
		public void run() {
			try {
				isRunning = true;
				while (true) {
					String content = "";
					ByteBuffer bff = ByteBuffer.allocate(1024);
					if (AppTool.isNull(bff)) {
						continue;
					}
					if (AppTool.isNull(sc)) {
						continue;
					}
					while (sc.read(bff) > 0) {
						bff.flip();
						content += CHARSET.decode(bff);
						System.out.println(content);
						bff.clear();
						contentNullTimes = 0;
					}
					if (AppTool.isNull(content)) {
						contentNullTimes++;
						if (contentNullTimes > 10) {
							contentNullTimes = 0;
							getErrMsgDeque().push("连接已成功，但是有一段时间内没有收到来自AGV的消息" + getClientInfo());
							// closeResource();
						}
					} else {
						setLatestMsg(content);
					}
					ThreadTool.sleep(500);
				}

			} catch (Exception io) {
				closeResource();
				io.printStackTrace();
			}
			isRunning = false;
		}
	}

	public static void main(String[] args) {
		// @SuppressWarnings("unused")
		// NioSocketClient client = new NioSocketClient("192.168.0.201", 5300);
		NioSocketClient client3 = new NioSocketClient("192.168.10.105", 5500, 0, true);
		NioSocketClient client4 = new NioSocketClient("192.168.10.105", 5600, 0, true);
		while (true) {
			client3.sendMsgAsy(UUID.randomUUID().toString().replace("-", "") + '\n');
			client4.sendMsgAsy(UUID.randomUUID().toString().replace("-", "") + '\n');
			ThreadTool.sleep(500);
		}
	}

}