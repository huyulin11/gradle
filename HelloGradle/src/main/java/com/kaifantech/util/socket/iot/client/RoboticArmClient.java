package com.kaifantech.util.socket.iot.client;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.apache.log4j.Logger;

import com.kaifantech.util.socket.client.AbstractSocketClient;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.msg.AppMsg;

public class RoboticArmClient extends AbstractSocketClient {

	private static Selector selector = null;
	private SocketChannel sc = null;

	private boolean shaked = false;

	private Deque<String> errMsg = new ArrayDeque<String>();

	private final Logger logger = Logger.getLogger(RoboticArmClient.class);

	public RoboticArmClient(String host, int port) {
		super(host, port, 9);
	}

	public synchronized Deque<String> getErrMsg() {
		return errMsg;
	}

	private int lapEquals0Times = 0;

	public synchronized List<Integer> getLatestMsgList() {
		List<Integer> lapIds = new ArrayList<>();
		if (doClose) {
			return null;
		}
		try {
			byte[] content = null;
			getSocketChannel();
			if (sendMsg(RoboticArmMsgStr.O_COLLECT_DATA).isSuccess()) {
				ThreadTool.sleep(200);
				content = receriveMsg();
			} else {
				throw new Exception("发送获取消息指令失败！");
			}
			if (HexString.toString(HexString.toHex(RoboticArmMsgStr.I_COMMAND_FROM_LAP1))
					.equals(HexString.toString(content))) {
				lapIds.add(1);
				lapEquals0Times = 0;
			} else if (HexString.toString(HexString.toHex(RoboticArmMsgStr.I_COMMAND_FROM_LAP2))
					.equals(HexString.toString(content))) {
				lapIds.add(2);
				lapEquals0Times = 0;
			} else if (HexString.toString(HexString.toHex(RoboticArmMsgStr.I_COMMAND_FROM_LAP3))
					.equals(HexString.toString(content))) {
				lapIds.add(3);
				lapEquals0Times = 0;
			} else if (HexString.toString(HexString.toHex(RoboticArmMsgStr.I_COMMAND_FROM_LAP12))
					.equals(HexString.toString(content))) {
				lapIds.add(1);
				lapIds.add(2);
				lapEquals0Times = 0;
			} else if (HexString.toString(HexString.toHex(RoboticArmMsgStr.I_COMMAND_FROM_LAP13))
					.equals(HexString.toString(content))) {
				lapIds.add(1);
				lapIds.add(3);
				lapEquals0Times = 0;
			} else if (HexString.toString(HexString.toHex(RoboticArmMsgStr.I_COMMAND_FROM_LAP23))
					.equals(HexString.toString(content))) {
				lapIds.add(2);
				lapIds.add(3);
				lapEquals0Times = 0;
			} else if (HexString.toString(HexString.toHex(RoboticArmMsgStr.I_COMMAND_FROM_LAP123))
					.equals(HexString.toString(content))) {
				lapIds.add(1);
				lapIds.add(2);
				lapIds.add(3);
				lapEquals0Times = 0;
			} else {
				lapEquals0Times++;
			}
			if (lapEquals0Times > 3) {
				closeResource();
			}
			return lapIds;
		} catch (Exception e) {
			closeResource();
			e.printStackTrace();
		}
		return null;
	}

	private synchronized SocketChannel getSocketChannel() throws Exception {
		init();
		return sc;
	}

	private void doInit() throws Exception {
		if (selector == null) {
			selector = Selector.open();
		}
		if (sc == null || !sc.isConnected() || !sc.isOpen()) {
			if (sc != null && sc.isOpen()) {
				closeResource();
			}
			sc = SocketChannel.open(new InetSocketAddress(getHost(), getPort()));
			sc.configureBlocking(false);
			sc.register(selector, SelectionKey.OP_READ);
			errMsg.push("成功连接到" + ":" + getHost() + ":" + getPort());
		}
	}

	public void init() {
		try {
			doInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private synchronized boolean send(byte[] msg) throws Exception {
		if (send(ByteBuffer.wrap(msg))) {
			return true;
		}
		return false;
	}

	private synchronized boolean send(ByteBuffer msg) throws Exception {
		getSocketChannel().write(msg);
		errMsg.push("发送成功：" + msg);
		return true;
	}

	public synchronized AppMsg sendMsg(String msg) {
		if (shaked) {
			return AppMsg.success();
		}
		try {
			shakeHands();
			byte[] bytes = HexString.toHex(msg);
			if (send(bytes)) {
				return AppMsg.success();
			}
		} catch (Exception e) {
			closeResource();
			e.printStackTrace();
		}
		return AppMsg.fail();
	}

	public synchronized byte[] receriveMsg() throws Exception {
		ByteBuffer bff = ByteBuffer.allocate(1024);

		while (sc.read(bff) > 0) {
			bff.flip();
		}

		byte[] bs = new byte[bff.remaining()];
		bff.get(bs, 0, bs.length);

		return bs;

	}

	private synchronized void shakeHands() throws Exception {
		if (send(HexString.toHex(RoboticArmMsgStr.O_SHAKE_HANDS))) {
			ThreadTool.sleep(200);
			byte[] content = receriveMsg();
			if (HexString.toString(HexString.toHex(RoboticArmMsgStr.I_SHAKE_HANDS_OVER))
					.equals(HexString.toString(content))
					|| HexString.toString(HexString.toHex(RoboticArmMsgStr.I_SHAKE_HANDS_OVER2))
							.equals(HexString.toString(content))) {
				shaked = true;
			} else {
				doClose = true;
				throw new Exception("握手失败！");
			}
		} else {
			throw new Exception("发送握手指令失败！");
		}
	}

	private boolean doClose = false;

	public synchronized void closeResource() {
		try {
			doClose = true;
			shaked = false;
			logger.info("ERROR WHEN CONNET TO " + ":" + getHost() + ":" + getPort());
			if (sc != null) {
				sc.close();
				sc = null;
			}
			doClose = false;
		} catch (Exception e) {
			closeResource();
			e.printStackTrace();
		}
	}

	@Override
	protected void finalize() throws java.lang.Throwable {
		errMsg.push("系统关闭，连接关闭：" + getHost() + ":" + getPort());
		closeResource();
		super.finalize();

	}

	public static void main(String[] args) {
		RoboticArmClient c = new RoboticArmClient("192.168.0.1", 9600);
		Integer lapId = 2;

		String msgToRobotic = "";
		if (lapId.equals(1)) {
			msgToRobotic = RoboticArmMsgStr.O_OVER_FROM_LAP1;
		} else if (lapId.equals(2)) {
			msgToRobotic = RoboticArmMsgStr.O_OVER_FROM_LAP2;
		} else if (lapId.equals(3)) {
			msgToRobotic = RoboticArmMsgStr.O_OVER_FROM_LAP3;
		}

		c.sendMsg(msgToRobotic);
		c.closeResource();
	}

}