package com.kaifantech.util.socket.server.agv;

import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

import com.kaifantech.util.socket.server.AbstractServer;
import com.kaifantech.util.thread.ThreadTool;

public class AGVAioSimulator extends AbstractServer {
	static int BUFFER_SIZE = 1024;

	AsynchronousServerSocketChannel serverChannel;

	// private ByteBuffer readBuffer = ByteBuffer.allocate(BUFFER_SIZE);
	private ByteBuffer writeBuffer = ByteBuffer.allocate(BUFFER_SIZE);

	// ReadHandler readHandler = new ReadHandler();
	WriteHandler writeHandler = new WriteHandler();

	// private boolean isWriting = false;

	public AGVAioSimulator(int port) {
		super(port);
		try {
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() throws Exception {
		this.serverChannel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(getPort()), 100);
		this.serverChannel.accept(this, new AcceptHandler());

		ThreadTool.getThreadPool().execute(new Runnable() {
			public void run() {
				System.out.println("运行中...");
				while (true) {
					ThreadTool.sleep(2000);
				}
			}
		});

	}

	private class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AGVAioSimulator> {
		@Override
		public void completed(final AsynchronousSocketChannel client, AGVAioSimulator attachment) {
			try {
				System.out.println("远程地址：" + client.getRemoteAddress());
				client.setOption(StandardSocketOptions.TCP_NODELAY, true);
				client.setOption(StandardSocketOptions.SO_SNDBUF, 1024);
				client.setOption(StandardSocketOptions.SO_RCVBUF, 1024);

				if (client.isOpen()) {
					writeBuffer.flip();
					System.out.print("client.isOpen：" + client.getRemoteAddress());
					System.out.println(",msg:" + new String(writeBuffer.array()));
					writeBuffer.clear();
					client.write(writeBuffer, client, writeHandler);
					ThreadTool.sleep(100);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				attachment.serverChannel.accept(attachment, this);
			}
		}

		@Override
		public void failed(Throwable exc, AGVAioSimulator attachment) {
			exc.printStackTrace();
			attachment.serverChannel.accept(attachment, this);// 监听新的请求，递归调用。
		}
	}

	// private class ReadHandler implements CompletionHandler<Integer,
	// AsynchronousSocketChannel> {
	// @Override
	// public void completed(Integer result, AsynchronousSocketChannel client) {
	// try {
	// ThreadTool.getThreadPool().execute(new Runnable() {
	// public void run() {
	// System.out.println("运行中...");
	// if (!isWriting) {
	// while (true) {
	// isWriting = true;
	// writeBuffer.clear();
	// writeBuffer.flip();
	// writeBuffer = ByteBuffer.wrap(strToSend.getBytes());
	// System.out.println("发出的数据：" + strToSend);
	// client.write(writeBuffer);
	// ThreadTool.sleep(200);
	// }
	// }
	// }
	// });
	//
	// if (result < 0) {
	// AGVAioSimulator.close(client);
	// } else if (result == 0) {
	// System.out.println("空数据");
	// } else {
	// writeBuffer.clear();
	// writeBuffer.flip();
	// CharBuffer charBuffer = IAGVClient.CHARSET.decode(writeBuffer);
	// System.out.println("读取到的数据：" + charBuffer.toString());
	// client.write(writeBuffer, client, writeHandler);
	//
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// @Override
	// public void failed(Throwable exc, AsynchronousSocketChannel client) {
	// exc.printStackTrace();
	// AGVAioSimulator.close(client);
	// }
	// }

	private class WriteHandler implements CompletionHandler<Integer, AsynchronousSocketChannel> {
		@Override
		public void completed(Integer result, AsynchronousSocketChannel client) {
			try {
				writeBuffer.flip();
				writeBuffer = ByteBuffer.wrap(getMsgTobeSend().getBytes());
				writeBuffer.clear();
				client.write(writeBuffer, client, writeHandler);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void failed(Throwable exc, AsynchronousSocketChannel client) {
			exc.printStackTrace();
			AGVAioSimulator.close(client);
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println("正在启动服务...");
			new AGVAioSimulator(8888);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void close(AsynchronousSocketChannel client) {
		try {
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}