package com.kaifantech.component.dao;

import org.springframework.stereotype.Service;

@Service
public class CTRLInitDataInfoDao extends ControlInfoDao {
	public boolean isInitAlloc() {
		return getValueByType("INIT_DATA_ALLOC") >= 0;
	}

	public boolean isInitTask() {
		return getValueByType("INIT_DATA_TASK") >= 0;
	}

	public boolean isInitLed() {
		return getValueByType("INIT_DATA_LED") >= 0;
	}

	public int stopInitAlloc() {
		return updateControlInfo(-1, null, "INIT_DATA_ALLOC");
	}

	public int stopInitTask() {
		return updateControlInfo(-1, null, "INIT_DATA_TASK");
	}

	public int stopInitLed() {
		return updateControlInfo(-1, null, "INIT_DATA_LED");
	}
}
