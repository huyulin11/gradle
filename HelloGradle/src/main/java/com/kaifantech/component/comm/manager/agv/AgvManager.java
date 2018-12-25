package com.kaifantech.component.comm.manager.agv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaifantech.bean.msg.csy.agv.CsyAgvCacheCommand;
import com.kaifantech.bean.msg.csy.agv.CsyAgvCmdBean;
import com.kaifantech.bean.msg.csy.agv.CsyAgvCommand;
import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.component.comm.cmd.sender.agv.AgvCmdSender;
import com.kaifantech.init.sys.params.CacheKeys;
import com.kaifantech.util.constants.cmd.AgvCmdConstant;
import com.kaifantech.util.hex.AppByteUtil;
import com.kaifantech.util.log.CsyAppFileLogger;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Service
public class AgvManager implements IMultiCacheWorkerGetter {

	@Autowired
	private AgvCmdSender agvCmdSender;

	public AppMsg sendNeedRtn(CsyAgvCommand command) {
		return sendNeedRtn(command, 0);
	}

	public AppMsg sendNeedRtn(CsyAgvCommand command, int repeatTimes) {
		int times = 0;
		AppMsg appMsg = AppMsg.fail();
		while (true) {
			if (repeatTimes > 0 && times > repeatTimes) {
				return AppMsg.fail();
			}
			Integer agvId = command.getAgvId();
			appMsg = agvCmdSender.send(command);
			times++;
			if (!appMsg.isSuccess() || appMsg.getCode() < 0) {
				return appMsg;
			}
			CsyAgvCmdBean agvCmdBean = new CsyAgvCmdBean(appMsg.getMsg());
			ThreadTool.sleep(500);
			Integer msgId = agvCmdBean.getNumId();
			String rtnMsg = getCacheWorker(agvId).get(CacheKeys.agvMsgList(agvId, msgId), "" + msgId);
			if (!AppTool.isNull(rtnMsg)) {
				appMsg.setSuccess(true);
				break;
			} else {
				CsyAppFileLogger.error(agvId + "号AGV未收到发送指令的返回消息，" + "稍后" + "重试！" + "CMDID:" + agvCmdBean.getMsgID()
						+ ";SITEID:" + agvCmdBean.getSiteId() + ";SENDMSG:" + appMsg + ";" + "重试次数：" + times);
			}
		}
		return appMsg;
	}

	public AppMsg send(CsyAgvCommand command) {
		return agvCmdSender.send(command);
	}

	public AppMsg cacheTask(CsyAgvCommand command) {
		return sendNeedRtn(command, 10);
	}

	public AppMsg cacheTask(CsyAgvCacheCommand command) {
		return sendNeedRtn(command, 10);
	}

	public AppMsg incaseofObstacleCorner(int agvId) {
		return sendNeedRtn(new CsyAgvCommand(agvId, AgvCmdConstant.CMD_OBSTACLE_CHANNEL_CORNER), 10);
	}

	public AppMsg incaseofObstacleNormal(int agvId) {
		return sendNeedRtn(new CsyAgvCommand(agvId, AgvCmdConstant.CMD_OBSTACLE_CHANNEL_NORMAL), 10);
	}

	public AppMsg cacheTask(Integer agvId, Integer tasksiteid, String... cmds) {
		return cacheTask(new CsyAgvCacheCommand(agvId, tasksiteid, cmds));
	}

	public AppMsg undoAllCache(int agvId) {
		getCacheWorker(agvId).del(CacheKeys.agvCmdCache(agvId));
		getCacheWorker(agvId).del(CacheKeys.agvMsgCache(agvId));
		return cacheTask(new CsyAgvCommand(agvId, AgvCmdConstant.CMD_TASK_CLEAR_ALL_CACHE));
	}

	public AppMsg pause(int agvId) {
		return sendNeedRtn(new CsyAgvCommand(agvId, AgvCmdConstant.CMD_STOP), 10);
	}

	public AppMsg startup(int agvId) {
		return sendNeedRtn(new CsyAgvCommand(agvId, AgvCmdConstant.CMD_CONTINUE), 10);
	}

	public AppMsg changeSpeed(int agvId, int speed) {
		return sendNeedRtn(new CsyAgvCommand(agvId, AgvCmdConstant.CMD_SPEED, AppByteUtil.int2Str2(speed)), 10);
	}

	protected AppMsg send(String cmd, Integer agvId) {
		String nextCmdIdStr = CsyAgvCmdBean.getnextCmdIdStr(agvId);
		getCacheWorker(agvId).hset(CacheKeys.lastsendcmdid(), "" + agvId, "" + CsyAgvCmdBean.getNumId(nextCmdIdStr));
		String cmdgToSend = CsyAgvMsgBean.getAgvId(agvId) + nextCmdIdStr + cmd;
		return sendNeedRtn(new CsyAgvCommand(agvId, cmdgToSend));
	}

	public AppMsg generalSearch(int agvId) {
		return send(new CsyAgvCommand(agvId, AgvCmdConstant.CMD_GENERAL_SEARCH));
	}
}
