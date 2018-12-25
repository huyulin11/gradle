package com.kaifantech.util.msg.plc;

import com.kaifantech.bean.msg.csy.plc.CsyPlcMsgBean;
import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.init.sys.params.CacheKeys;
import com.ytgrading.util.AppTool;

public class PlcMsgGetter implements IMultiCacheWorkerGetter {
	private static PlcMsgGetter single;

	private PlcMsgGetter() {
	}

	public static PlcMsgGetter one() {
		if (AppTool.isNull(single)) {
			single = new PlcMsgGetter();
		}
		return single;
	}

	public synchronized String getMsg(Integer agvId) {
		return getCacheWorker(agvId).getFresh(CacheKeys.plcMsgKey(), "" + agvId);
	}

	public synchronized CsyPlcMsgBean getMsgBean(Integer agvId) {
		String msg = getMsg(agvId);
		if (AppTool.isNull(msg)) {
			return null;
		}
		return new CsyPlcMsgBean(msg);
	}

	public boolean isRobotErr(Integer agvId) {
		CsyPlcMsgBean msgBean = getMsgBean(agvId);
		if (AppTool.isNull(msgBean)) {
			return false;
		}
		return msgBean.isRobotErr();
	}

	public boolean isTaskOver(Integer agvId) {
		CsyPlcMsgBean msgBean = getMsgBean(agvId);
		if (AppTool.isNull(msgBean)) {
			return false;
		}
		return msgBean.isTaskOver() || msgBean.isTaskSendAndOver();
	}

	public boolean isTaskSend(Integer agvId, String cmd) {
		CsyPlcMsgBean msgBean = getMsgBean(agvId);
		if (AppTool.isNull(msgBean)) {
			return false;
		}
		return msgBean.isTaskSend() || (cmd.startsWith("0002") && msgBean.isTaskSendAndOver());
	}
}
