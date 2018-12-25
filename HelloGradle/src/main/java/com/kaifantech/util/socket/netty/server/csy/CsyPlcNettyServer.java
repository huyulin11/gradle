package com.kaifantech.util.socket.netty.server.csy;

import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.init.sys.params.CacheKeys;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.util.socket.netty.server.DefauNettyServer;
import com.kaifantech.util.thread.ThreadTool;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class CsyPlcNettyServer extends DefauNettyServer implements IMultiCacheWorkerGetter {
	public CsyPlcNettyServer(int port) {
		super(port);
	}

	public static CsyPlcNettyServer create(int port) {
		return new CsyPlcNettyServer(port);
	}

	public void dealData(ChannelHandlerContext ctx, ByteBuf in) {
		loopSend(ctx);
	}

	public void loopSend(ChannelHandlerContext ctx) {
		while (true) {
			ThreadTool.sleep(2000);
			if (!SystemParameters.isConnectIotServer()) {
				ctx.close();
				setRunning(false);
				break;
			}
			try {
				send(ctx, getCacheWorker(getAgvId()).getOrInit(CacheKeys.simulatorCurrentPlcAnswer(), "" + getAgvId(),
						"00000001000000000000000000000000000000010000000000020000"));
			} catch (Exception e) {
				closeResource();
				setRunning(false);
				try {
					init();
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		}
	}

	public void doSendToClient(ChannelHandlerContext ctx) {
		ThreadTool.run(() -> {
			loopSend(ctx);
		});
	}
}