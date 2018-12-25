package com.kaifantech.init.sys.params;

import com.kaifantech.cache.manager.AppCacheManager;
import com.kaifantech.cache.worker.ICacheWorker;
import com.kaifantech.init.sys.SystemClient;

public class SystemParameters {
	private static boolean isConnectIotClient = true;
	private static boolean isConnectIotServer = true;
	private static boolean isAutoTask = false;

	private static boolean isAutoCharge = false;

	private static boolean isInitTaskSiteInfo = false;
	private static boolean isInitTaskSiteLogic = false;

	private static boolean isInitTaskInfo = false;
	private static boolean isInitAllocInfo = false;
	private static boolean isInitLed = false;

	private static boolean isLocalTest = flag(getCacheWorker().getOrInit("IS_LOCAL_TEST", "FALSE"));

	private static boolean isShutdownThenToInit = flag(getCacheWorker().getOrInit("IS_SHUTDOWN_THEN_TO_INIT", "FALSE"));

	private static boolean isReceiptNeedScan = flag(getCacheWorker().getOrInit("IS_RECEIPT_NEED_SCAN", "TRUE"));

	public static void setTaskstop(Integer agvId, boolean flag) {
		getCacheWorker().set("TASKSTOP" + agvId, flag(flag));
	}

	public static boolean getTaskstop(Integer agvId) {
		return flag(getCacheWorker().getOrInit("TASKSTOP" + agvId, "FALSE"));
	}

	static {
		if (SystemClient.CLIENT.equals(SystemClient.Client.YUFENG)) {
			isConnectIotServer = true;
			isConnectIotClient = false;
		} else {
		}
	}

	public static ICacheWorker getCacheWorker() {
		return AppCacheManager.getWorker();
	}

	public synchronized static boolean isInitTaskSiteInfo() {
		return isInitTaskSiteInfo;
	}

	private static String flag(boolean yesOrNo) {
		return yesOrNo ? "TRUE" : "FALSE";
	}

	private static boolean flag(String yesOrNo) {
		return "TRUE".equals(yesOrNo);
	}

	public static boolean isShutdown(String taskid) {
		boolean isShutdown = flag(getCacheWorker().getOrInit(CacheKeys.taskShutdown(), taskid, "FALSE"));
		return isShutdown;
	}

	public static void setShutdown(String taskid) {
		getCacheWorker().hset(CacheKeys.taskShutdown(), taskid, "TRUE");
	}

	public synchronized static void setInitTaskSiteInfo(boolean yesOrNo) {
		getCacheWorker().hset(CacheKeys.initData(), "IS_INIT_TASK_SITE_INFO", flag(yesOrNo));
		SystemParameters.isInitTaskSiteInfo = yesOrNo;
	}

	public synchronized static boolean isInitTaskSiteLogic() {
		return isInitTaskSiteLogic;
	}

	public synchronized static void setInitTaskSiteLogic(boolean yesOrNo) {
		getCacheWorker().hset(CacheKeys.initData(), "IS_INIT_TASK_SITE_LOGIC", flag(yesOrNo));
		SystemParameters.isInitTaskSiteLogic = yesOrNo;
	}

	public synchronized static boolean isInitTaskInfo() {
		return isInitTaskInfo;
	}

	public synchronized static void setInitTaskInfo(boolean yesOrNo) {
		getCacheWorker().hset(CacheKeys.initData(), "IS_INIT_TASK_INFO", flag(yesOrNo));
		SystemParameters.isInitTaskInfo = yesOrNo;
	}

	public synchronized static boolean isInitAllocInfo() {
		return isInitAllocInfo;
	}

	public synchronized static void setInitAllocInfo(boolean yesOrNo) {
		getCacheWorker().hset(CacheKeys.initData(), "IS_INIT_ALLOC_INFO", flag(yesOrNo));
		SystemParameters.isInitAllocInfo = yesOrNo;
	}

	public synchronized static boolean isInitLed() {
		return isInitLed;
	}

	public synchronized static void setInitLed(boolean yesOrNo) {
		getCacheWorker().hset(CacheKeys.initData(), "IS_INIT_LED", flag(yesOrNo));
		SystemParameters.isInitLed = yesOrNo;
	}

	public static boolean isConnectIotClient() {
		return isConnectIotClient;
	}

	public static boolean isConnectIotServer() {
		return isConnectIotServer;
	}

	public static boolean isAutoTask() {
		return isAutoTask;
	}

	public static boolean setAutoTask(boolean isAutoTask) {
		getCacheWorker().hset(CacheKeys.initData(), "IS_AGVS_AUTO_TASK", flag(isAutoTask));
		SystemParameters.isAutoTask = isAutoTask;
		return isAutoTask;
	}

	public static void setAutoTask() {
		String flag = getCacheWorker().get(CacheKeys.initData(), "IS_AGVS_AUTO_TASK");
		SystemParameters.isAutoTask = flag(flag);
	}

	public static void setLocalTest() {
		String flag = getCacheWorker().get("IS_LOCAL_TEST");
		SystemParameters.isLocalTest = flag(flag);
	}

	public static boolean isReceiptNeedScan() {
		return isReceiptNeedScan;
	}

	public static boolean isAutoCharge() {
		return isAutoCharge;
	}

	public static void setAutoCharge(boolean isAutoCharge) {
		SystemParameters.isAutoCharge = isAutoCharge;
	}

	public static void setAutoCharge() {
		SystemParameters.isAutoCharge = flag(getCacheWorker().getOrInit("IS_AUTO_CHARGE", "FALSE"));
	}

	public static boolean isLocalTest() {
		return isLocalTest;
	}

	public static void setLocalTest(boolean isLocalTest) {
		SystemParameters.isLocalTest = isLocalTest;
	}

	public static boolean isShutdownThenToInit() {
		return isShutdownThenToInit;
	}

	public static void setShutdownThenToInit(boolean isShutdownThenToInit) {
		SystemParameters.isShutdownThenToInit = isShutdownThenToInit;
	}
}