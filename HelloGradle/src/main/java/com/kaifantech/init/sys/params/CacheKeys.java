package com.kaifantech.init.sys.params;

import com.kaifantech.bean.msg.csy.agv.CsyAgvCommBean;
import com.kaifantech.cache.manager.AppCacheManager;
import com.kaifantech.init.sys.ServicePrefix;
import com.kaifantech.util.hex.AppByteUtil;
import com.ytgrading.util.DateFactory;

public class CacheKeys {
	private static boolean isTest = false;
	private static String packName = "";
	private static String separator = CacheKeysInitior.getSeparator();

	public static boolean isTest() {
		return isTest;
	}

	public static void setTest(boolean isTest) {
		CacheKeys.isTest = isTest;
	}

	public static String agvMsgType(Integer devId) {
		String keyVal = "AGV" + separator + "MSG_TYPE";
		return getSocketKey(devId, keyVal);
	}

	public static String agvMsgCache(Integer devId) {
		String keyVal = "AGV" + separator + "MSG_CACHE";
		return getSocketKey(devId, keyVal);
	}

	public static String agvCmdType(Integer devId) {
		String keyVal = "AGV" + separator + "CMD_TYPE";
		return getSocketKey(devId, keyVal);
	}

	public static String agvCmdCache(Integer devId) {
		String keyVal = "AGV" + separator + "CMD_CACHE";
		return getSocketKey(devId, keyVal);
	}

	public static String agvMsgList(Integer devId) {
		String keyVal = "AGV" + separator + "MSG_LIST";
		return getSocketKey(devId, keyVal);
	}

	public static String agvCacheStock(Integer devId) {
		String keyVal = "AGV" + separator + "CACHE_STOCK";
		return getAgvCacheStockKey(devId, keyVal);
	}

	public static String agvMsgTest(Integer devId) {
		String keyVal = "AGV" + separator + "MSG_TEST";
		return getSocketKey(devId, keyVal);
	}

	public static String agvMsgList(Integer devId, int numId) {
		int keyFlagId = CsyAgvCommBean.getIndexOfCmdId(numId);
		return CacheKeys.agvMsgList(devId) + "_" + keyFlagId;
	}

	public static String agvCmdList(Integer devId) {
		String keyVal = "AGV" + separator + "CMD_LIST";
		return getSocketKey(devId, keyVal);
	}

	public static String agvCmdList(Integer devId, int numId) {
		int keyFlagId = CsyAgvCommBean.getIndexOfCmdId(numId);
		return CacheKeys.agvCmdList(devId) + "_" + keyFlagId;
	}

	public static String scanMsg(Integer devId) {
		String keyVal = "SCAN" + separator + "MSG_LIST";
		return getScanKey(devId, keyVal);
	}

	public static String scanCmd(Integer devId) {
		String keyVal = "SCAN" + separator + "CMD_LIST";
		return getScanKey(devId, keyVal);
	}

	public static String plcMsgList(Integer devId) {
		String keyVal = "PLC" + separator + "MSG_LIST";
		return getSocketKey(devId, keyVal);
	}

	public static String plcMsgKey() {
		String keyVal = "PLC" + separator + "MSG_KEY";
		return getStableKey(null, keyVal);
	}

	public static String taskShutdown() {
		String keyVal = "TASK_SHUTDOWN" + separator + "KEY";
		return getStableKey(null, keyVal);
	}

	public static String plcCmd(Integer devId) {
		String keyVal = "PLC" + separator + "CMD";
		return getSocketKey(devId, keyVal);
	}

	public static String chargeMsgKey() {
		String keyVal = "CHARGE" + separator + "MSG_KEY";
		return getStableKey(null, keyVal);
	}

	public static String chargeMsgList(Integer devId) {
		String keyVal = "CHARGE" + separator + "MSG_LIST";
		return getSocketKey(devId, keyVal);
	}

	public static String chargeCmd(Integer devId) {
		String keyVal = "CHARGE" + separator + "CMD";
		return getSocketKey(devId, keyVal);
	}

	public static String windowMsg() {
		String keyVal = "WINDOW" + separator + "MSG";
		return getStableKey(null, keyVal);
	}

	public static String windowCmd(Integer devId) {
		String keyVal = "WINDOW" + separator + "CMD";
		return getSocketKey(devId, keyVal);
	}

	public static String robotMsg(Object devId) {
		String keyVal = "ROBOT" + separator + "MSG";
		return getRobotKey(devId, keyVal);
	}

	public static String initData() {
		String keyVal = "INIT_DATA";
		return getConfigurekey(keyVal);
	}

	public static String exeCtrl() {
		String keyVal = "EXE_CTRL";
		return getConfigurekey(keyVal);
	}

	public static String lastsendcmdid() {
		String keyVal = "LASTSENDCMDID";
		return getSocketkey(keyVal);
	}

	public static String initagvstartsiteid() {
		String keyVal = "INIT_AGV_START_SITEID";
		return getConfigurekey(keyVal);
	}

	public static String initwindowsiteid() {
		String keyVal = "INIT_WINDOW_SITEID";
		return getConfigurekey(keyVal);
	}

	public static String initchargesiteid() {
		String keyVal = "INIT_CHARGE_SITEID";
		return getConfigurekey(keyVal);
	}

	private static String getStableKey(Object devId, String keyVal) {
		String key = getkeyType("FULL") + separator + (devId == null ? "ALL" : devId) + separator + keyVal;
		return key;
	}

	private static String getSocketKey(Object devId, String keyVal) {
		String key = getkeyType("SOCKET") + separator + (devId == null ? "ALL" : devId) + separator + keyVal;
		return key;
	}

	private static String getScanKey(Object devId, String keyVal) {
		String key = getkeyType("SCAN") + separator + (devId == null ? "ALL" : devId) + separator + keyVal;
		return key;
	}

	private static String getAgvCacheStockKey(Object devId, String keyVal) {
		String key = getkeyType("STOCK") + separator + (devId == null ? "ALL" : devId) + separator + keyVal;
		return key;
	}

	private static String getRobotKey(Object devId, String keyVal) {
		String key = getkeyType("ROBOT") + separator + (devId == null ? "ALL" : devId) + separator + keyVal;
		return key;
	}

	private static String getSocketkey(String keyVal) {
		String key = getkeyType("SOCKET") + separator + keyVal;
		return key;
	}

	private static String getConfigurekey(String keyVal) {
		String key = getkeyType("CONFIGURE") + separator + keyVal;
		return key;
	}

	public static String simulatorCurrentPlcAnswer() {
		String keyVal = "CURRENT_PLC_ANSWER";
		return getSimulatorKey(keyVal);
	}

	public static String simulatorCurrentSite() {
		String keyVal = "CURRENT_SITE";
		return getSimulatorKey(keyVal);
	}

	public static String simulatorCurrentSpeed() {
		String keyVal = "CURRENT_SPEED";
		return getSimulatorKey(keyVal);
	}

	public static String simulatorCurrentBattery() {
		String keyVal = "CURRENT_BATTERY";
		return getSimulatorKey(keyVal);
	}

	private static String getSimulatorKey(String keyVal) {
		String key = getkeyType("SIMULATOR") + separator + keyVal;
		return key;
	}

	public static String getkeyType(String type) {
		String key = getPackName() + separator + type;
		return key;
	}

	public synchronized static String getSeq() {
		String is = AppCacheManager.getWorker().getOrInit("SYS_SEQUENCE", "TEST_SEQ", "0");
		AppCacheManager.getWorker().hset("SYS_SEQUENCE", "TEST_SEQ", "" + (Integer.parseInt(is) + 1));
		return AppByteUtil.int2Str4Reverse(256 * 256 - 1 - Integer.parseInt(is)).toUpperCase();
	}

	private synchronized static String getPackName() {
		packName = ServicePrefix.DEFAULT_SERVICE_PREFIX.toUpperCase();
		if (isTest) {
			packName += separator + "TESTDATA" + separator + DateFactory.getCurrDate() + "_" + getSeq();
		}
		return packName;
	}

}
