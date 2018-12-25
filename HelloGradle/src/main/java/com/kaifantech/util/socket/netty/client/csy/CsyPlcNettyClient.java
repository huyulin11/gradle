package com.kaifantech.util.socket.netty.client.csy;

import java.util.LinkedList;
import java.util.List;

import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.init.sys.params.CacheKeys;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.set.queue.LimitQueue;
import com.kaifantech.util.socket.netty.client.AbstractNettyClient;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class CsyPlcNettyClient extends AbstractNettyClient implements IMultiCacheWorkerGetter {
	private int seq = 0;
	private LimitQueue<String> limitMsg = new LimitQueue<>(10);

	public CsyPlcNettyClient(String host, int port, int devtype) {
		super(host, port, devtype);
		getHeartBeat().setSendHeartBeat(false);
	}

	public List<String> getList() {
		LinkedList<String> list = new LinkedList<>();
		if (!AppTool.isNull(limitMsg) && limitMsg.size() > 0) {
			list = limitMsg.getList();
		}
		return list;
	}

	public void dealData(ChannelHandlerContext ctx, ByteBuf in) {
		String plcMsgStr = AppByteUtil.getHexStrFrom(in);
		if (!AppTool.isNull(plcMsgStr) && plcMsgStr.length() <= 56) {
			setLatestMsg(plcMsgStr);
			getCacheWorker(getAgvId()).hset(CacheKeys.plcMsgList(getAgvId()), "" + seq++, plcMsgStr);
			getCacheWorker(getAgvId()).hset(CacheKeys.plcMsgKey(), "" + getAgvId(), plcMsgStr);
			limitMsg.offer(plcMsgStr);
		}
	}

	public synchronized AppMsg sendMsg(String innerCmd) {
		if (!isConnected()) {
			return AppMsg.fail();
		}
		ThreadTool.sleep(200);
		String cmd;
		cmd = innerCmd;
		setSendedCmd(cmd);
		getCacheWorker(getAgvId()).hset(CacheKeys.plcCmd(getAgvId()), "" + seq++, cmd);
		boolean isSuccess = super.sendMsg(AppByteUtil.hexStringToBytes(cmd));
		AppMsg appMsg = new AppMsg();
		appMsg.setSuccess(isSuccess);
		appMsg.setMsg(cmd);
		return appMsg;
	}
}
