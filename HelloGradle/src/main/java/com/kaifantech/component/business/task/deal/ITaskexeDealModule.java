package com.kaifantech.component.business.task.deal;

import java.util.Map;

public interface ITaskexeDealModule {

	public void startControl();

	default Map<Integer, String> getLastTaskCmd() {
		return null;
	}

}
