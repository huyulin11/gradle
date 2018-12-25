package com.kaifantech.util.socket.netty.client.csy;

import com.kaifantech.bean.msg.csy.agv.CsyAgvCmdBean;
import com.kaifantech.bean.msg.csy.agv.CsyAgvCommBean;
import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.init.sys.params.CacheKeys;
import com.kaifantech.util.constants.cmd.AgvCmdConstant;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.socket.netty.client.AbstractNettyClient;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class CsyAgvNettyClient extends AbstractNettyClient implements IMultiCacheWorkerGetter {
	public CsyAgvNettyClient(String host, int port, int devtype) {
		super(host, port, devtype);
		getHeartBeat().setSendHeartBeat(false);
	}

	private void dealMsgRegular(String agvMsgStr) {
		setLatestMsg(agvMsgStr);
		CsyAgvMsgBean agvMsg = new CsyAgvMsgBean(agvMsgStr);
		String key = CacheKeys.agvMsgList(getAgvId());
		int numId = agvMsg.getNumId();

		getCacheWorker(key).hset(CacheKeys.agvMsgList(getAgvId(), numId), "" + numId, agvMsgStr);
		getCacheWorker(key).hset(CacheKeys.agvMsgType(getAgvId()), "" + agvMsg.getMsgType(), agvMsgStr);
		if (AgvCmdConstant.CMD_TASK_CACHE.equals(agvMsg.getMsgCacheType())
				|| AgvCmdConstant.CMD_TASK_DELETE_ONE_CACHE.equals(agvMsg.getMsgCacheType())
				|| AgvCmdConstant.CMD_TASK_CLEAR_ALL_CACHE.equals(agvMsg.getMsgCacheType())) {
			getCacheWorker(key).hset(CacheKeys.agvMsgCache(getAgvId()), agvMsg.getMsgID(), agvMsgStr);
		}
	}

	private void dealMsgUnRegular(String agvMsgStr) {
		if (agvMsgStr.length() % CsyAgvCommBean.VALID_LENGTH == 0) {
			int start = 0;
			int ii = agvMsgStr.length() / CsyAgvCommBean.VALID_LENGTH;
			while (start < ii - 1) {
				String ss = agvMsgStr.substring(CsyAgvCommBean.VALID_LENGTH * start,
						CsyAgvCommBean.VALID_LENGTH * (start + 1));
				dealMsgRegular(ss);
				start++;
			}
			return;
		}

		String reduce = agvMsgStr;
		if (agvMsgStr.length() % CsyAgvCommBean.VALID_LENGTH != 0) {
			while (true) {
				int index = reduce.indexOf(CsyAgvCommBean.PREFIX);
				if (index < 0) {
					break;
				}
				reduce = reduce.substring(index);
				if (reduce.length() < CsyAgvCommBean.VALID_LENGTH) {
					break;
				}
				String ss = reduce.substring(0, CsyAgvCommBean.VALID_LENGTH);
				if (CsyAgvCommBean.isValid(ss)) {
					reduce = reduce.substring(CsyAgvCommBean.VALID_LENGTH);
					dealMsgRegular(ss);
				} else if (index == 0) {
					reduce = reduce.substring(1);
				}
			}
		}
		AppFileLogger.warning(getAgvId() + "号AGV返回非法数据：ORG:" + agvMsgStr + ";DEAL:" + reduce);
	}

	public void dealData(ChannelHandlerContext ctx, ByteBuf in) {
		String agvMsgStr = AppByteUtil.getHexStrFrom(in);
		if (AppTool.isNull(agvMsgStr)) {
			return;
		}

		if (CsyAgvCommBean.isValid(agvMsgStr)) {
			dealMsgRegular(agvMsgStr);
			return;
		}

		dealMsgUnRegular(agvMsgStr);
	}

	private int i = 0;

	public synchronized AppMsg sendMsg(String innerCmd) {
		if (!isConnected()) {
			return AppMsg.fail();
		}
		ThreadTool.sleep(200);
		setSendedCmd(innerCmd);
		CsyAgvCmdBean agvCmd = new CsyAgvCmdBean(innerCmd);
		if (agvCmd.isValid()) {
			int numId = agvCmd.getNumId();
			String key = CacheKeys.agvCmdList(getAgvId(), numId);
			try {
				getCacheWorker(key).hset(key, "" + numId, innerCmd);
				getCacheWorker(key).hset(CacheKeys.agvCmdType(getAgvId()), "" + agvCmd.getCmdType(), innerCmd);
				if (AgvCmdConstant.CMD_TASK_CACHE.equals(agvCmd.getCmdCacheType())
						|| AgvCmdConstant.CMD_TASK_DELETE_ONE_CACHE.equals(agvCmd.getCmdCacheType())
						|| AgvCmdConstant.CMD_TASK_CLEAR_ALL_CACHE.equals(agvCmd.getCmdCacheType())) {
					i = AgvCmdConstant.CMD_TASK_CLEAR_ALL_CACHE.equals(agvCmd.getCmdCacheType()) ? 0 : i + 1;
					getCacheWorker(key).hset(CacheKeys.agvCmdCache(getAgvId()), i + "-" + agvCmd.getSiteId(), innerCmd);
				}
				if (AgvCmdConstant.CMD_CONTINUE.equals(agvCmd.getCmdCacheType())
						|| AgvCmdConstant.CMD_STOP.equals(agvCmd.getCmdCacheType())) {
					System.out.println("debug");
				}
			} catch (Exception e) {
				System.err.println("key:" + key + ",numId" + numId);
				e.printStackTrace();
			}
		}
		boolean isSuccess = super.sendMsg(AppByteUtil.hexStringToBytes(innerCmd));
		AppMsg appMsg = new AppMsg();
		appMsg.setSuccess(isSuccess);
		appMsg.setMsg(innerCmd);
		return appMsg;
	}
}
