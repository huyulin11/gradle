package com.kaifantech.init.sys.params;

import java.util.Map.Entry;

import com.kaifantech.bean.msg.csy.agv.CsyAgvCmdBean;
import com.kaifantech.bean.msg.csy.agv.CsyAgvCommBean;
import com.kaifantech.cache.manager.AppCacheManager;
import com.kaifantech.cache.worker.ICacheWorker;
import com.kaifantech.util.thread.ThreadTool;

public class CacheKeysInitior {
	public static String getSeparator() {
		return AppCacheManager.getWorker().getSeparator();
	}

	static {
		AppCacheManager.getWorker().del("csy_socket%");
	}

	public static void clear() {
		System.out.println("DELETE DATA IN MEMORY!");
		AppCacheManager.getWorker().del("csy%plc%list%");
		AppCacheManager.getWorker().del("csy%charge%list%");
		doClear();
	}

	private static void doClear() {
		try {
			for (Entry<Integer, Integer> item : CsyAgvCmdBean.getNextCmdIdMap().entrySet()) {
				int keyFlagId = CsyAgvCommBean.getIndexOfCmdId(item.getValue());
				delUselessData(CacheKeys.agvMsgList(item.getKey()), keyFlagId);
				delUselessData(CacheKeys.agvCmdList(item.getKey()), keyFlagId);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ThreadTool.sleepOneSecond();
		}
	}

	private static void delUselessData(String key, int keyFlagId) {
		ICacheWorker worker = AppCacheManager.getWorker();
		for (int i = CsyAgvCommBean.FULL_DATA_TABLES - CsyAgvCommBean.KEEP_IN_MEMORY_TABLES - 1; i >= 0; i--) {
			int del = keyFlagId - i - CsyAgvCommBean.KEEP_IN_MEMORY_TABLES;
			del = del >= 0 ? del : CsyAgvCommBean.FULL_DATA_TABLES + del;
			String name = key + "_" + del;
			worker.del(name);
		}
	}

	public static void main(String[] args) {
		int keyFlagId = 13;
		delUselessData("TEST", keyFlagId);
	}
}
