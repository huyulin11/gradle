package com.kaifantech.util.socket.netty.server;

import java.net.InetSocketAddress;

import org.springframework.scheduling.annotation.Async;

import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.socket.HeartBeat;
import com.kaifantech.util.socket.server.AbstractServer;
import com.kaifantech.util.thread.ThreadTool;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

public class DefauNettyServer extends AbstractServer implements IMultiCacheWorkerGetter {
	private EventLoopGroup group;
	private boolean isRunning = false;
	private boolean isPause = false;
	private Integer agvId;

	private HeartBeat heartBeat = HeartBeat.createOne();

	public HeartBeat getHeartBeat() {
		return heartBeat;
	}

	public EventLoopGroup getGroup() {
		return group;
	}

	public void setGroup(EventLoopGroup group) {
		this.group = group;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public DefauNettyServer(int port) {
		super(port);
	}

	public void closeResource() {
		try {
			group.shutdownGracefully().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Async
	private synchronized void loopInit() {
		while (true) {
			ThreadTool.sleep(1500);
			if (!SystemParameters.isConnectIotServer()) {
				continue;
			}
			if (isRunning) {
				continue;
			}
			try {
				doInit();
			} catch (Exception e) {
				isRunning = false;
			}
		}
	}

	@Async
	public void sendToKeepAlive() {
		while (true) {
			ThreadTool.sleep(getHeartBeat().getHeartBeatInterval());
		}
	}

	public void send(ChannelHandlerContext ctx, String hexString) {
		byte[] bytes = AppByteUtil.hexStringToBytes(hexString);
		if (!(bytes == null)) {
			ctx.writeAndFlush(Unpooled.copiedBuffer(bytes));
		}
		ThreadTool.sleep(100);
	}

	private void doInit() throws Exception {
		try {
			System.out.println("初始化：" + getServerInfo());
			isRunning = true;
			final NettySocketServerHandler serverHandler = new NettySocketServerHandler();
			group = new NioEventLoopGroup();
			ServerBootstrap b = new ServerBootstrap();
			b.group(group).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(getPort()))
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(serverHandler);
						}
					});
			ChannelFuture f = b.bind().sync();
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			System.out.println(e.getMessage() + getServerInfo());
		} finally {
			group.shutdownGracefully().sync();
			isRunning = false;
		}
	}

	public void init() throws Exception {
		ThreadTool.run(() -> {
			loopInit();
		});
	}

	public void doSendToClient(ChannelHandlerContext ctx) {
		ThreadTool.run(() -> {
			while (true) {
				if (!SystemParameters.isConnectIotServer()) {
					ctx.close();
					isRunning = false;
					break;
				}
				try {
					ctx.writeAndFlush(Unpooled.copiedBuffer(getMsgTobeSend(), CharsetUtil.UTF_8));
					ThreadTool.sleep(100);
				} catch (Exception e) {
					closeResource();
					isRunning = false;
					try {
						init();
					} catch (Exception ee) {
						ee.printStackTrace();
					}
				}
			}
		});
	}

	private int cacheSeq = 1;

	public synchronized void dealData(ChannelHandlerContext ctx, ByteBuf in) {
		String s = in.toString(CharsetUtil.UTF_8);
		getCacheWorker("").hset("YUFENG:SOCKET:MSG", "" + cacheSeq++, s);
		setMsgReceived(s);
		ctx.writeAndFlush(Unpooled.copiedBuffer(getHeartBeat().getHeartBeatStr(), CharsetUtil.UTF_8));
	}

	@Sharable
	class NettySocketServerHandler extends ChannelInboundHandlerAdapter {

		@Override
		public void channelRead(ChannelHandlerContext ctx, Object msg) {
			ByteBuf in = (ByteBuf) msg;
			in.toString(CharsetUtil.UTF_8);
			dealData(ctx, in);
		}

		@Override
		public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
			cause.printStackTrace();
			ctx.close();
			isRunning = false;
		}

		/*
		 * 建立连接时，返回消息
		 */
		@Override
		public void channelActive(ChannelHandlerContext ctx) throws Exception {
			doSendToClient(ctx);
			super.channelActive(ctx);
		}
	}

	public boolean isPause() {
		return isPause;
	}

	public void setPause(boolean isPause) {
		this.isPause = isPause;
	}

	public Integer getAgvId() {
		return agvId;
	}

	public void setAgvId(Integer agvId) {
		this.agvId = agvId;
	}

}