package com.kaifantech.util.socket.netty.client.yufeng;

import com.kaifantech.util.socket.netty.client.AbstractNettyClient;
import com.ytgrading.util.AppTool;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

public class YufengNettyClient extends AbstractNettyClient {
	public static final String PREFIX_WHEN_SEND_TASK = "cmd=set task by name;name=";
	public static final String PAUSE_CMD = "cmd=pause;pauseStat=" + 1 + ";";
	public static final String CONTINUE_CMD = "cmd=pause;pauseStat=" + 0 + ";";

	public static final String MSG_PREFIX = "cmd=position;";
	public static final String MSG_SUFFIX = "?";
	public static final String MSG_SUFFIX2 = "�";

	public YufengNettyClient(String host, int port, int devtype) {
		super(host, port, devtype);
	}

	public void dealData(ChannelHandlerContext ctx, ByteBuf in) {
		setLatestMsg(in.toString(CharsetUtil.UTF_8));
		super.dealData(ctx, in);
	}

	public String getMsg() {
		String info = getLatestMsg();
		info = info.replaceAll(MSG_SUFFIX2, "").replaceAll("[" + MSG_SUFFIX + "]", "") + MSG_SUFFIX;

		if (!AppTool.isNullStr(info)) {
			int i = info.indexOf(MSG_PREFIX);
			int ii = info.indexOf(MSG_PREFIX, i + MSG_PREFIX.length());
			if (i < 0) {
				info = "";
			} else if (ii < 0) {
				int iii = info.indexOf(MSG_SUFFIX);
				if (iii < 0) {
					info = "";
				} else {
					info = info.substring(i, iii + 1);
				}
			} else {
				info = info.substring(i, ii);
			}
		}
		return info;
	}

}
