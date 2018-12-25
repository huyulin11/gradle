package com.kaifantech.init.sys;

import com.kaifantech.cache.manager.AppCacheManager;

public class SystemURL {// symsun.f3322.net:8085
	private static String wmsAddress = AppCacheManager.getWorker().getOrInit("WMS_SERVER_IP", "192.168.0.11:8080");
	private static final String WMS_PRE = "http://" + wmsAddress + "/WMS/acs/";
	public static final String MSG_TO_WMS = WMS_PRE + "addWmsTask.do";
	public static final String LOG_TO_WMS = WMS_PRE + "agvArrange.do";
	public static final String RECEIPT_ERR_TO_WMS = WMS_PRE + "receiptErr.do";
	public static final String INVENTORY_RESULT_TO_WMS = WMS_PRE + "inventory.do";
}
