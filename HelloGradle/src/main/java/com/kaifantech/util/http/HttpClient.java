package com.kaifantech.util.http;

import java.net.URI;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpVersion;

public class HttpClient {

	/**
	 * @param host
	 * @param port
	 * @throws Exception
	 */
	public void connect(String host, int port) throws Exception {
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(workerGroup);
			b.channel(NioSocketChannel.class);
			b.option(ChannelOption.SO_KEEPALIVE, true);
			b.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					// 客户端接收到的是httpResponse响应，所以要使用HttpResponseDecoder进行解码
					ch.pipeline().addLast(new HttpResponseDecoder());
					// 客户端发送的是httprequest，所以要使用HttpRequestEncoder进行编码
					ch.pipeline().addLast(new HttpRequestEncoder());
					ch.pipeline().addLast(new HttpClientInboundHandler());
				}
			});
			// 发起连接.
			ChannelFuture f = b.connect(host, port).sync();
			sendRequest(f);
			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
		}
	}

	/**
	 * @param cf
	 * @throws Exception
	 */
	public static void sendRequest(ChannelFuture cf) throws Exception {
		URI uri = new URI("http://127.0.0.1:99/de/acs/wms/addAcsTask.shtml");
		String msg = "{\"Type\":\"1\",\"Wicket\":\"ck1\",\"ReceiptId\":\"A-1-62e3e0c6674b46c5a5d93620efdd6ea2\",\"ItemList\":[{\"AllocId\":\"001-F1-03\"}],\"WarehouseId\":\"A\"}";
		DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST,
				uri.toASCIIString(), Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));

		// 构建http请求
		request.headers().set(HttpHeaderNames.HOST, "127.0.0.1");
		request.headers().set("Content-Type", "application/json; charset=utf-8");
		request.headers().set(HttpHeaderNames.CONTENT_LENGTH, request.content().readableBytes());
		// 发送http请求
		cf.channel().write(request);
		cf.channel().flush();
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		client.connect("127.0.0.1", 99);
	}
}