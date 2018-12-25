package com.kaifantech.util.msg.agv;

import java.util.Map;

import com.kaifantech.bean.msg.csy.agv.CsyAgvMsgBean;
import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.init.sys.params.CacheKeys;
import com.ytgrading.util.AppTool;

public class AgvMsgGetter implements IMultiCacheWorkerGetter {
	private static AgvMsgGetter single;

	private AgvMsgGetter() {
	}

	public static AgvMsgGetter one() {
		if (AppTool.isNull(single)) {
			single = new AgvMsgGetter();
		}
		return single;
	}

	public synchronized Map<String, String> getMsgTypeMap(Integer agvId) {
		return getCacheWorker(agvId).hgetAllFresh(CacheKeys.agvMsgType(agvId));
	}

	public String getMsg(Integer agvId) {
		Map<String, String> msgMap = getMsgTypeMap(agvId);
		if (AppTool.isNull(msgMap)) {
			return null;
		}
		return msgMap.get(CsyAgvMsgBean.MSG_STATUS_SEARCH_TYPE);
	}

	public String getMsgOf(Integer agvId, Integer cmdId) {
		return getCacheWorker(agvId).get(CacheKeys.agvMsgList(agvId, cmdId), "" + cmdId);
	}

	public CsyAgvMsgBean getAgvMsgBean(Integer agvId) {
		String currentMsg = getMsg(agvId);
		if (AppTool.isNull(currentMsg)) {
			return null;
		}
		return new CsyAgvMsgBean(currentMsg);
	}
}
