package com.kaifantech.component.business.msg.info.agv;

import java.util.Map;

import com.kaifantech.bean.msg.agv.AGVMsgBean;

public interface IAgvMsgInfoModule {

	public default String getLatestMsgStr(Integer agvId, Integer sendCmdId) {
		return null;
	}

	public default AGVMsgBean getLatestMsgBean(Integer agvId) {
		return null;
	}

	public default Map<String, String> getLatestMsg(Integer agvId) {
		return null;
	}

	public default void setLatestMsg() {
	}

	public default void storeMsgToPath(AGVMsgBean msg) {
	}
}
