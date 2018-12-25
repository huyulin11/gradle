package com.kaifantech.util.socket.netty.client.csy;

import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.init.sys.params.CacheKeys;
import com.kaifantech.util.constants.cmd.ChargeCmdConstant;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.iot.CRC;
import com.kaifantech.util.socket.netty.client.AbstractNettyClient;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.DateFactory;
import com.ytgrading.util.msg.AppMsg;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class CsyChargeNettyClient extends AbstractNettyClient implements IMultiCacheWorkerGetter {
	public CsyChargeNettyClient(String host, int port, int devtype) {
		super(host, port, devtype);
		getHeartBeat().setHeartBeatHex(false);
		getHeartBeat().setSendHeartBeat(true);
		getHeartBeat().setHeartBeatStr(ChargeCmdConstant.CMD_SEARCH);
	}

	public void dealData(ChannelHandlerContext ctx, ByteBuf in) {
		String chargeMsgStr = AppByteUtil.getHexStrFrom(in);
		if (!AppTool.isNull(chargeMsgStr)) {
			setLatestMsg(chargeMsgStr);
			getCacheWorker(getDevId()).hset(CacheKeys.chargeMsgKey(), "" + getDevId(), chargeMsgStr);
			getCacheWorker(getDevId()).hset(CacheKeys.chargeMsgList(getDevId()), DateFactory.getCurrTime(),
					chargeMsgStr);
		}
	}

	public AppMsg sendMsg(String innerCmd) {
		String crcCheck = String.format("%04x", CRC.calcCrc16(AppByteUtil.hexStringToBytes(innerCmd)));
		String cmd = innerCmd + crcCheck.substring(2, 4) + crcCheck.substring(0, 2);
		setSendedCmd(cmd);
		if (!ChargeCmdConstant.CMD_SEARCH.equals(innerCmd)) {
			getCacheWorker(getDevId()).hset(CacheKeys.chargeCmd(getDevId()), DateFactory.getCurrTime(), cmd);
		}
		boolean isSuccess = super.sendMsg(AppByteUtil.hexStringToBytes(cmd));
		AppMsg appMsg = new AppMsg();
		appMsg.setSuccess(isSuccess);
		appMsg.setMsg(cmd);
		return appMsg;
	}
}
