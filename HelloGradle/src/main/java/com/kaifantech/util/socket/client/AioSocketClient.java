package com.kaifantech.util.socket.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

import com.kaifantech.util.socket.ISocket;
import com.kaifantech.util.socket.netty.client.InomaNettyClient;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.DateFactory;
import com.ytgrading.util.msg.AppMsg;

public class AioSocketClient extends AbstractSocketClient {

	private AsynchronousSocketChannel sc = null;

	final ByteBuffer buffer = ByteBuffer.allocate(1024);

	public AioSocketClient(String ip, int port, int devtype) {
		super(ip, port, devtype);
	}

	public AioSocketClient(String ip, int port, int devtype, boolean isInit) {
		super(ip, port, devtype, isInit);
	}

	private CompletionHandler<Integer, ByteBuffer> readHandler = new CompletionHandler<Integer, ByteBuffer>() {
		@Override
		public void completed(Integer result, ByteBuffer attachment) {
			try {
				if (result < 0) {
					System.out.println(getClientInfo() + "------" + "服务端断开连接，重新尝试连接");
					closeAndInit();
				} else if (result == 0) {
					System.out.println(getClientInfo() + "------" + "空数据--");
				} else {
					buffer.flip();
					String msg = new String(buffer.array());
					setLatestMsg(msg);
					System.out.println(getClientInfo() + "------" + "接受数据：" + getMsg());
					buffer.clear();
					sc.read(buffer, null, readHandler);
				}
			} catch (Exception e) {
				closeAndInit();
			}
		}

		@Override
		public void failed(Throwable exc, ByteBuffer attachment) {
			exc.printStackTrace();
			System.out.println(getClientInfo() + "------" + "读取失败" + DateFactory.getCurrTime());
			closeAndInit();
		}
	};

	private CompletionHandler<Void, ? super Object> handler = new CompletionHandler<Void, Object>() {
		@Override
		public void completed(Void result, Object attachment) {
			try {
				getErrMsgDeque().push(this.getClass() + "------" + "成功连接" + getClientInfo());
				sc.read(buffer, null, readHandler);
			} catch (Exception e) {
				closeAndInit();
			}
		}

		@Override
		public void failed(Throwable exc, Object attachment) {
			exc.printStackTrace();
			System.out.println(getClientInfo() + "------" + "连接失败" + DateFactory.getCurrTime());
			closeAndInit();
		}
	};

	public synchronized void init() {
		try {
			if (sc == null || !sc.isOpen()) {
				if (sc != null && sc.isOpen()) {
					closeResource();
				}
				sc = AsynchronousSocketChannel.open();
				sc.connect(getServerAddress(), null, handler);
			}
			ThreadTool.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			setLatestMsg("");
			getErrMsgDeque().push("连接初始化失败，稍后重新尝试连接!" + getClientInfo());
			System.out.println(getClientInfo() + "------" + "连接初始化失败，稍后重新尝试连接!");
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
		setLatestMsg("");
		closeResource(sc);
	}

	public static void closeResource(AsynchronousSocketChannel targetSc) {
		if (targetSc != null) {
			try {
				targetSc.shutdownInput();
			} catch (Exception e) {
			}
			try {
				targetSc.shutdownOutput();
			} catch (Exception e) {
			}
			try {
				targetSc.close();
			} catch (Exception e) {
			}
			targetSc = null;
		}
	}

	private void closeAndInit() {
		closeResource();
		init();
	}

	public static void main(String[] args) throws IOException {
		// @SuppressWarnings("unused")
		// AioSocketClient client0 = new AioSocketClient("192.168.0.201",
		// 5300,true);
		// AioSocketClient client1 = new AioSocketClient("192.168.10.105",
		// 5300,true);
		// AioSocketClient client2 = new AioSocketClient("192.168.10.105",
		// 5400,true);
		AioSocketClient client3 = new AioSocketClient("192.168.10.105", 5500, 0, true);
		AioSocketClient client4 = new AioSocketClient("192.168.10.105", 5600, 0, true);
		while (true) {
			// client1.sendMsgAsyISocketClient.str());
			// client2.sendMsgAsy(ISocketClient.str());
			client3.sendMsgAsy(ISocket.str());
			client4.sendMsgAsy(ISocket.str());
			ThreadTool.sleep(500);
		}
	}

}