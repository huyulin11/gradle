package com.kaifantech.util.socket.netty.client.csy;

import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.init.sys.params.CacheKeys;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.socket.netty.client.AbstractNettyClient;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class CsyWindowNettyClient extends AbstractNettyClient implements IMultiCacheWorkerGetter {

	public CsyWindowNettyClient(String host, int port, int devtype) {
		super(host, port, devtype);
		getHeartBeat().setHeartBeatHex(true);
		getHeartBeat().setSendHeartBeat(false);
	}

	public void dealData(ChannelHandlerContext ctx, ByteBuf in) {
		String plcMsgStr = AppByteUtil.getHexStrFrom(in);
		if (!AppTool.isNull(plcMsgStr)) {
			setLatestMsg(plcMsgStr);
			String key = CacheKeys.windowMsg();
			getCacheWorker(getDevId()).hset(key, "" + getDevId(), plcMsgStr);
		}
	}

	public AppMsg sendMsg(String innerCmd) {
		String cmd;
		// String crcCheck = String.format("%04x",
		// CRC.calcCrc16(AppByteUtil.hexStringToBytes(innerCmd)));
		// cmd = innerCmd + crcCheck.substring(2, 4) + crcCheck.substring(0, 2);
		cmd = innerCmd;
		setSendedCmd(cmd);
		getCacheWorker(getDevId()).set(CacheKeys.windowCmd(getDevId()), cmd);
		boolean isSuccess = super.sendMsg(AppByteUtil.hexStringToBytes(cmd));
		AppMsg appMsg = new AppMsg();
		appMsg.setSuccess(isSuccess);
		appMsg.setMsg(cmd);
		return appMsg;
	}
}
