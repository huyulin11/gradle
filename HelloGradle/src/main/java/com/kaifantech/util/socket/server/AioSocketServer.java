package com.kaifantech.util.socket.server;

import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.UUID;

import com.kaifantech.util.socket.client.AioSocketClient;
import com.kaifantech.util.thread.ThreadTool;

public class AioSocketServer {
	protected int port;
	static int BUFFER_SIZE = 1024;
	protected String strToSend = "helloAio";

	AsynchronousServerSocketChannel serverChannel;

	public AioSocketServer(int port) {
		this.port = port;
		try {
			this.listen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listen() throws Exception {
		this.serverChannel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(port), 100);
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

	private class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AioSocketServer> {
		ByteBuffer writeBuffer = ByteBuffer.allocate(BUFFER_SIZE);

		WriteHandler writeHandler = new WriteHandler();

		private class WriteHandler implements CompletionHandler<Integer, AsynchronousSocketChannel> {
			public void completed(Integer result, AsynchronousSocketChannel client) {
				try {
					writeBuffer.flip();
					strToSend = client.getRemoteAddress() + "||" + UUID.randomUUID().toString().replace("-", "") + '\n';
					System.out.println(client);
					writeBuffer = ByteBuffer.wrap(strToSend.getBytes());
					writeBuffer.clear();
					ThreadTool.sleep(300);
					client.write(writeBuffer, client, writeHandler);
				} catch (Exception e) {
					AioSocketClient.closeResource(client);
					e.printStackTrace();
				}
			}

			public void failed(Throwable exc, AsynchronousSocketChannel client) {
				exc.printStackTrace();
				AioSocketServer.close(client);
			}
		}

		public void completed(final AsynchronousSocketChannel client, AioSocketServer attachment) {
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

		public void failed(Throwable exc, AioSocketServer attachment) {
			exc.printStackTrace();
			attachment.serverChannel.accept(attachment, this);
		}
	}

	private static void close(AsynchronousSocketChannel client) {
		try {
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println("正在启动服务...");
			new AioSocketServer(8888);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}