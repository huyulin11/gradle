package com.kaifantech.util.msg.window;

import java.util.List;

import com.kaifantech.bean.msg.csy.window.CsyWindowMsgBean;
import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.init.sys.params.CacheKeys;
import com.ytgrading.util.AppTool;

public class WindowMsgGetter implements IMultiCacheWorkerGetter {
	private static WindowMsgGetter single;

	private WindowMsgGetter() {
	}

	public static WindowMsgGetter one() {
		if (AppTool.isNull(single)) {
			single = new WindowMsgGetter();
		}
		return single;
	}

	public synchronized String getMsg(Integer windowId) {
		return getCacheWorker(windowId).getOrInit(CacheKeys.windowMsg(), "" + windowId, "0000");
	}

	public synchronized CsyWindowMsgBean getMsgBean(Integer windowId) {
		String msg = getCacheWorker(windowId).getOrInit(CacheKeys.windowMsg(), "" + windowId, "0000");
		return new CsyWindowMsgBean(msg);
	}

	public String getLayers(Integer WindowId) {
		CsyWindowMsgBean msgBean = getMsgBean(WindowId);
		return msgBean.getLayers();
	}

	public List<String> getLayersList(Integer WindowId) {
		CsyWindowMsgBean msgBean = getMsgBean(WindowId);
		return msgBean.getLayersList();
	}
}
