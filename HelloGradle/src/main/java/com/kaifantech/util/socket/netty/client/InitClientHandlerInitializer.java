package com.kaifantech.util.socket.netty.client;

import java.util.concurrent.TimeUnit;

import com.kaifantech.util.socket.netty.test.HeartbeatServerHandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

public class InitClientHandlerInitializer extends ChannelInitializer<SocketChannel> {
	private SimpleChannelInboundHandler<ByteBuf> handler = null;

	public InitClientHandlerInitializer(SimpleChannelInboundHandler<ByteBuf> handler) {
		this.handler = handler;
	}

	@Override
	public void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast(handler);
		pipeline.addLast("idleStateHandler", new IdleStateHandler(2, 2, 60, TimeUnit.SECONDS));
		pipeline.addLast(new HeartbeatServerHandler());
	}

}
