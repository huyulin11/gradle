package com.kaifantech.util.socket.netty.client;

import java.net.InetSocketAddress;

import org.springframework.scheduling.annotation.Async;

import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.socket.HeartBeat;
import com.kaifantech.util.socket.client.AbstractSocketClient;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.DateFactory;
import com.ytgrading.util.msg.AppMsg;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

public abstract class AbstractNettyClient extends AbstractSocketClient {
	private NettySocketClientHandler handler = new NettySocketClientHandler();

	private boolean isRunning = false;
	private boolean isConnected = false;
	private EventLoopGroup group = null;

	public boolean isRunning() {
		return isRunning;
	}

	public boolean isConnected() {
		return isConnected;
	}

	private HeartBeat heartBeat = HeartBeat.createOne();

	public HeartBeat getHeartBeat() {
		return heartBeat;
	}

	public AbstractNettyClient(String host, int port, int devtype) {
		super(host, port, devtype);
	}

	private Integer agvId;

	public Integer getAgvId() {
		return agvId;
	}

	public void setAgvId(Integer agvId) {
		this.agvId = agvId;
	}

	private void doInit() throws Exception {
		try {
			group = new NioEventLoopGroup();
			isRunning = true;
			Thread.currentThread().setName("NETTY" + getClientInfo());
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress(getHost(), getPort()))
					.option(ChannelOption.SO_KEEPALIVE, true).handler(new InitClientHandlerInitializer(handler));
			ChannelFuture f = b.connect().sync();
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			isRunning = false;
			log("连接" + DateFactory.getCurrTime() + "-连接失败，稍后重试！" + e.getMessage() + getClientInfo());
		} finally {
			closeResource();
		}
	}

	public void log(String content) {
		AppFileLogger.connectInfo("AGV编号：" + getAgvId() + "，" + getDevId() + "号设备:" + content);
	}

	@Async
	private void loopInit() {
		log("初始化：" + getClientInfo());
		while (true) {
			ThreadTool.sleep(1500);
			if (!isConnected) {
				log("isConnected" + ":no;isRunning:" + isRunning + ";" + getClientInfo());
			}
			if (!SystemParameters.isConnectIotClient()) {
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
			if (!isConnected) {
				log("isConnected" + ":watch;isRunning:" + isRunning + ";" + getClientInfo());
			}
		}
	}

	@Async
	public void sendToKeepAlive() {
		while (true) {
			ThreadTool.sleep(heartBeat.getHeartBeatInterval());
			if (!heartBeat.isSendHeartBeat() || AppTool.isNull(heartBeat.getHeartBeatStr())) {
				continue;
			}
			if (!SystemParameters.isConnectIotClient()) {
				continue;
			}
			if (heartBeat.isHeartBeatHex()) {
				sendMsg(AppByteUtil.hexStringToBytes(heartBeat.getHeartBeatStr()));
			} else {
				sendMsg(heartBeat.getHeartBeatStr());
			}
		}
	}

	@Async
	public synchronized void init() {
		ThreadTool.run(() -> {
			loopInit();
		});

		ThreadTool.run(() -> {
			sendToKeepAlive();
		});
	}

	@Async
	@Override
	public AppMsg sendMsg(String msg) {
		AppMsg appMsg = new AppMsg();
		try {
			handler.send(Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8));
			appMsg.setSuccess(true);
		} catch (Exception e) {
			appMsg.setSuccess(false);
		}
		return appMsg;
	}

	@Async
	@Override
	public boolean sendMsg(byte[] msg) {
		try {
			handler.send(Unpooled.copiedBuffer(msg));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public void closeResource() {
		isRunning = false;
		try {
			if (!AppTool.isNull(group)) {
				group.shutdownGracefully().sync();
				group = null;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void dealData(ChannelHandlerContext ctx, ByteBuf in) {
	}

	@Sharable
	class NettySocketClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
		private ChannelHandlerContext ctx;

		@Override
		public void handlerAdded(ChannelHandlerContext ctx) {
			this.ctx = ctx;
		}

		@Override
		public void channelActive(ChannelHandlerContext ctx) {
			isConnected = true;
			if (!SystemParameters.isConnectIotClient()) {
				isRunning = false;
				ctx.close();
			}
		}

		@Override
		public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
			try {
				dealData(ctx, in);
				if (!SystemParameters.isConnectIotClient()) {
					isRunning = false;
					ctx.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				log("socketDevMsg:" + getHost() + "-" + getPort() + ":解析错误");
			}
		}

		@Override
		public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
			cause.printStackTrace();
		}

		@Override
		public void channelInactive(ChannelHandlerContext ctx) throws Exception {
			isRunning = false;
			isConnected = false;
			log("连接异常，稍后重新连接");
			super.channelInactive(ctx);
			ctx.close();
		}

		public void send(ByteBuf msg) {
			if (isRunning) {
				ctx.writeAndFlush(msg);
			}
		}
	}
}
