package com.kaifantech.util.socket.netty.server.csy;

import com.kaifantech.bean.msg.csy.agv.CsyAgvCmdBean;
import com.kaifantech.bean.msg.csy.agv.CsyAgvCommBean;
import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.cache.manager.AppCacheManager;
import com.kaifantech.init.sys.params.CacheKeys;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.iot.CsyAgvStatus;
import com.kaifantech.util.socket.netty.server.DefauNettyServer;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class CsyAgvNettyServer extends DefauNettyServer {
	public CsyAgvNettyServer(int port) {
		super(port);
	}

	public static CsyAgvNettyServer create(int port) {
		return new CsyAgvNettyServer(port);
	}

	private String getCurrentSite(Integer agvId) {
		int siteid = Integer
				.parseInt(AppCacheManager.getWorker().getOrInit(CacheKeys.simulatorCurrentSite(), "" + agvId, "1"));
		return AppByteUtil.int2Str4(siteid);
	}

	private String getCurrentSpeed(Integer agvId) {
		return AppCacheManager.getWorker().getOrInit(CacheKeys.simulatorCurrentSpeed(), "" + agvId, "00");
	}

	private String getCurrentBattery(Integer agvId) {
		return AppCacheManager.getWorker().getOrInit(CacheKeys.simulatorCurrentBattery(), "" + agvId, "1803");
	}

	private String getMsgByCmd(String cmdReceived) {
		// TODO 模拟经过各中途站点
		String msgSend = "";
		if (CsyAgvCommBean.isValid(cmdReceived)) {
			CsyAgvCmdBean cmdBean = new CsyAgvCmdBean(cmdReceived);
			String agvIdStr = cmdBean.getAgvId();
			Integer agvId = Integer.parseInt(agvIdStr);
			String currentCmdId = cmdBean.getMsgID();
			String cmdType = cmdBean.getCmdType();
			if (cmdType.equals(CsyAgvCommBean.TASK)) {
				msgSend = CsyAgvMsgBean.MSG_GENERAL_TYPE + CsyAgvCommBean.TASK + CsyAgvCommBean.SUCCESS
						+ getCurrentSite(agvId);
			} else if (cmdType.equals(CsyAgvCommBean.CONTINUE)) {
				setPause(false);
				msgSend = CsyAgvMsgBean.MSG_GENERAL_TYPE + CsyAgvCommBean.CONTINUE + CsyAgvCommBean.SUCCESS
						+ getCurrentSite(agvId);
			} else if (cmdType.equals(CsyAgvCommBean.STOP)) {
				setPause(true);
				msgSend = CsyAgvMsgBean.MSG_GENERAL_TYPE + CsyAgvCommBean.STOP + CsyAgvCommBean.SUCCESS
						+ getCurrentSite(agvId);
			} else {
				msgSend = CsyAgvMsgBean.MSG_STATUS_SEARCH_TYPE
						+ (isPause() ? CsyAgvStatus.STOPPING.get() : CsyAgvStatus.DRIVING.get())
						+ getCurrentSite(agvId);
			}
			msgSend = String.format("%-40s", msgSend).replaceAll("\\s", "0");
			msgSend = CsyAgvCommBean.PREFIX + agvIdStr + currentCmdId + msgSend;
			msgSend = msgSend.substring(0, 32) + getCurrentSpeed(agvId) + msgSend.substring(34, msgSend.length() - 8)
					+ getCurrentBattery(agvId) + "0000";
			msgSend = msgSend + CsyAgvCommBean.getFancyAGVCheckNumStr(msgSend) + CsyAgvCommBean.SUFFIX;
		}
		return msgSend.toUpperCase();
	}

	public void dealData(ChannelHandlerContext ctx, ByteBuf in) {
		String cmdReceived = AppByteUtil.getHexStrFrom(in);
		if (!AppTool.isNull(cmdReceived)) {
			setMsgReceived(cmdReceived);
			String msgSend = getMsgByCmd(cmdReceived);
			if (!AppTool.isNull(msgSend)) {
				send(ctx, msgSend);
			}
		}
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
				send(ctx, getMsgTobeSend());
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