package com.kaifantech.util.socket.netty.client.csy;

import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.init.sys.params.CacheKeys;
import com.kaifantech.util.socket.netty.client.AbstractNettyClient;
import com.ytgrading.util.AppTool;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

public class CsyScanNettyClient extends AbstractNettyClient implements IMultiCacheWorkerGetter {
	private boolean switchRead = false;

	public CsyScanNettyClient(String host, int port, int devtype) {
		super(host, port, devtype);
	}

	public void dealData(ChannelHandlerContext ctx, ByteBuf in) {
		String scanMsgStr = in.toString(CharsetUtil.UTF_8);
		if (!AppTool.isNull(scanMsgStr) && isSwitchRead()) {
			setLatestMsg(scanMsgStr);
			String key = CacheKeys.scanMsg(getAgvId());
			getCacheWorker(key).set(key, scanMsgStr);
		}
	}

	public boolean isSwitchRead() {
		return switchRead;
	}

	public void setSwitchRead(boolean switchRead) {
		this.switchRead = switchRead;
	}
}
