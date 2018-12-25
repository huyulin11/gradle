package com.kaifantech.component.business.ctrl.deal;

import java.util.Map;

public interface ICtrlDealModule {

	public void startControl();

	default Map<Integer, String> getLastCtrlCmd() {
		return null;
	}

	default void startup(Integer agvId) {
	}
}
