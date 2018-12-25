package com.kaifantech.util.msg.charge;

import com.kaifantech.bean.msg.csy.charge.CsyChargeMsgBean;
import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.kaifantech.init.sys.params.CacheKeys;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

public class ChargeMsgGetter implements IMultiCacheWorkerGetter {
	private static ChargeMsgGetter single;

	private ChargeMsgGetter() {
	}

	public static ChargeMsgGetter one() {
		if (AppTool.isNull(single)) {
			single = new ChargeMsgGetter();
		}
		return single;
	}

	public synchronized String getMsg(Integer agvId) {
		return getCacheWorker(agvId).getOrInit(CacheKeys.chargeMsgKey(), "" + agvId, "0000");
	}

	public synchronized CsyChargeMsgBean getMsgBean(Integer agvId) {
		String msg = getCacheWorker(agvId).getOrInit(CacheKeys.chargeMsgKey(), "" + agvId, "0000");
		return new CsyChargeMsgBean(msg);
	}

	public AppMsg getChargeStatus(Integer chargeId) {
		CsyChargeMsgBean msgBean = getMsgBean(chargeId);
		return msgBean.getChargeStatus();
	}
}
