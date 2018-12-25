package com.kaifantech.util.socket.netty.server.csy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.kaifantech.cache.manager.AppCacheManager;
import com.kaifantech.component.service.rest.WmsRestService;
import com.kaifantech.init.sys.params.CacheKeys;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.util.constant.taskexe.ctrl.AgvTaskType;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.msg.robot.RobotMsgGetter;
import com.kaifantech.util.socket.netty.server.DefauNettyServer;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

public class CsyRobotNettyServer extends DefauNettyServer {

	public CsyRobotNettyServer(int port) {
		super(port);
	}

	public static CsyRobotNettyServer create(int port) {
		return new CsyRobotNettyServer(port);
	}

	private int cacheSeq = 1;

	private String getRemoteIp(ChannelHandlerContext ctx) {
		String remoteAddress = ctx.channel().remoteAddress().toString();
		remoteAddress = remoteAddress.substring(remoteAddress.indexOf("/") + 1, remoteAddress.indexOf(":"));
		return remoteAddress;
	}

	public void dealData(ChannelHandlerContext ctx, ByteBuf in) {
		String s = in.toString(CharsetUtil.UTF_8);
		if (AppTool.isNull(s)) {
			return;
		}
		Integer agvId = getAgvFromIp(getRemoteIp(ctx));
		String taskType = agvTaskTypeMap.get(agvId);
		String task = agvTaskMap.get(agvId);
		task = AppTool.isNull(task) ? "" : task;
		String[] arr = s.split("\n");
		List<String> itemList = new ArrayList<>();
		for (String item : arr) {
			item = item.trim();
			if (AgvTaskType.INVENTORY.equals(taskType)) {
				item = "{\"AllocColumn\":\"" + task + "\",\"AllocInfo\":\"" + item + "\"}";
				itemList.add(item);
				ThreadTool.run(() -> {
					String inventoryResult = "{\"Type\":\"INVENTORY\",\"ItemList\":["
							+ StringUtils.join(itemList.toArray(), ",") + "]}";
					WmsRestService.one.inventoryResultToWms(inventoryResult);
				});
			} else if (AgvTaskType.RECEIPT.equals(taskType)) {
				String index = getAllocIndex(item);
				String alloc = getAllocFrom(item);
				if (!AppTool.isAnyNull(index, alloc)) {
					RobotMsgGetter.one().getReceiptData(task).put(Integer.parseInt(index), alloc);
				}
			}
			getCacheWorker("").hset(CacheKeys.robotMsg(agvId), "" + cacheSeq++, item);
			setMsgReceived(item);
			ctx.writeAndFlush(Unpooled.copiedBuffer(getHeartBeat().getHeartBeatStr(), CharsetUtil.UTF_8));
		}
	}

	private String getAllocIndex(String info) {
		int index = info.indexOf(':');
		if (index <= 0 || index >= info.length() - 1) {
			return null;
		}
		return info.substring(index + 1, index + 2);
	}

	private String getAllocFrom(String info) {
		int index = info.indexOf(';');
		if (index < 11) {
			return null;
		}
		return info.substring(index - 11, index);
	}

	public void send(ChannelHandlerContext ctx, String hexString) {
		byte[] bytes = AppByteUtil.hexStringToBytes(hexString);
		if (!(bytes == null)) {
			ctx.writeAndFlush(Unpooled.copiedBuffer(bytes));
		}
		ThreadTool.sleep(100);
	}

	public void loopSend(ChannelHandlerContext ctx) {
		while (true) {
			ThreadTool.sleep(2000);
			if (!SystemParameters.isConnectIotClient()) {
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

	public static void main(String[] args) throws Exception {
		CsyRobotNettyServer server = new CsyRobotNettyServer(7777);
		System.out.println(server.getAllocFrom("@王某某,2327211999001010511,01-01-01-12;"));
		// ThreadTool.run(() -> {
		// try {
		// server.init();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// });
	}

	private Map<Integer, String> agvTaskMap = new HashMap<>();

	private Map<Integer, String> agvTaskTypeMap = new HashMap<>();

	public void setAgvTask(Integer agvId, String taskType, String task) {
		agvTaskTypeMap.put(agvId, taskType);
		agvTaskMap.put(agvId, task);
	}

	private Map<String, Integer> ipAgvMap = new HashMap<>();

	public Integer getAgvFromIp(String ip) {
		if (ipAgvMap.size() == 0) {
			ipAgvMap.put(AppCacheManager.getWorker().getOrInit("ROBOT_1_IP", "192.168.0.113"), 1);
			ipAgvMap.put(AppCacheManager.getWorker().getOrInit("ROBOT_2_IP", "192.168.0.123"), 2);
			ipAgvMap.put(AppCacheManager.getWorker().getOrInit("ROBOT_3_IP", "192.168.0.133"), 3);
			ipAgvMap.put(AppCacheManager.getWorker().getOrInit("ROBOT_4_IP", "192.168.0.143"), 4);
		}
		return ipAgvMap.get(ip);
	}
}