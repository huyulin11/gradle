package com.kaifantech.init.sys.params;

import java.util.HashMap;
import java.util.Map;

import com.ytgrading.util.AppTool;

public class SystemLock {
	public static Map<Integer, Object> chargeMap = new HashMap<>();

	public static Object charge(Integer id) {
		Object lock = chargeMap.get(id);
		if (AppTool.isNull(lock)) {
			chargeMap.put(id, new Object());
			lock = chargeMap.get(id);
		}
		return lock;
	}
}
