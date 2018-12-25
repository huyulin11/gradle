package com.kaifantech.util.msg.robot;

import java.util.Map;
import java.util.TreeMap;

import com.kaifantech.cache.manager.IMultiCacheWorkerGetter;
import com.ytgrading.util.AppTool;

public class RobotMsgGetter implements IMultiCacheWorkerGetter {
	private static RobotMsgGetter single;
	private Map<String, Map<Integer, String>> receiptDataMap = new TreeMap<>();

	private RobotMsgGetter() {
	}

	public static RobotMsgGetter one() {
		if (AppTool.isNull(single)) {
			single = new RobotMsgGetter();
		}
		return single;
	}

	public Map<Integer, String> getReceiptData(String receiptPaperId) {
		Map<Integer, String> map = receiptDataMap.get(receiptPaperId);
		if (map == null) {
			map = new TreeMap<>();
			receiptDataMap.put(receiptPaperId, map);
		}
		return map;
	}

	public Map<Integer, String> removeReceiptData(String receiptPaperId) {
		Map<Integer, String> map = receiptDataMap.remove(receiptPaperId);
		return map;
	}
}
