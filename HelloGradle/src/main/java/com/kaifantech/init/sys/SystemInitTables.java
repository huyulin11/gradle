package com.kaifantech.init.sys;

public class SystemInitTables {
	public static final String SYS_DICTIONARY_INFO = SystemInitDB.BUSS_DB_NAME + "." + "sys_dictionary_info ";

	public static final String CONTROL_INFO = SystemInitDB.OP_DB_NAME + "." + "control_info ";
	public static final String CONTROL_PI_INFO = SystemInitDB.OP_DB_NAME + "." + "control_pi_info ";

	public static final String TASK_SITE_LOGIC = SystemInitDB.OP_DB_NAME + "." + "task_site_logic ";
	public static final String TASK_SITE_INFO = SystemInitDB.OP_DB_NAME + "." + "task_site_info ";

	public static final String SINGLETASK_INFO = SystemInitDB.OP_DB_NAME + "." + "singletask_info ";
	public static final String SINGLETASK_ROLE = SystemInitDB.OP_DB_NAME + "." + "singletask_role ";
	public static final String SINGLETASK_GROUP = SystemInitDB.OP_DB_NAME + "." + "singletask_group ";

	public static final String AGV_INFO = SystemInitDB.OP_DB_NAME + "." + "agv_info ";
	public static final String IOT_CLIENT_INFO = SystemInitDB.IOT_DB_NAME + "." + "iot_client_info ";
	public static final String IOT_RELATION_INFO = SystemInitDB.IOT_DB_NAME + "." + "iot_relation_info ";

	public static final String TASK_PATH_INFO = SystemInitDB.OP_DB_NAME + "." + "task_path_info ";
	public static final String TASK_PATH_MEMORY = SystemInitDB.OP_DB_NAME + "." + "task_path_memory ";

	public static final String TASKEXE_S2C_TASK = SystemInitDB.OP_DB_NAME + "." + "taskexe_s2c_task ";
	public static final String TASKEXE_S2C_DETAIL = SystemInitDB.OP_DB_NAME + "." + "taskexe_s2c_detail ";
	public static final String TASKEXE_S2C_DETAIL_WORKS = SystemInitDB.OP_DB_NAME + "." + "taskexe_s2c_detail_works ";

	public static final String AGV_STATUS_LOG = SystemInitDB.IOT_DB_NAME + "." + "agv_status_log ";

	public static final String WMS_INVENTORY_REQUEST_MAIN = SystemInitDB.WMS_DB_NAME + "."
			+ "wms_inventory_request_main ";
	public static final String WMS_RECEIPT_REQUEST_MAIN = SystemInitDB.WMS_DB_NAME + "." + "wms_receipt_request_main ";
	public static final String WMS_SHIPMENT_REQUEST_MAIN = SystemInitDB.WMS_DB_NAME + "."
			+ "wms_shipment_request_main ";

	public static final String SKU_INFO = SystemInitDB.WMS_DB_NAME + "." + "sku_info ";
	public static final String SKU_TYPE = SystemInitDB.WMS_DB_NAME + "." + "sku_type ";

	public static final String LAP_INFO = SystemInitDB.IOT_DB_NAME + "." + "lap_info ";
	public static final String LAP_FORKLIFT_INFO = SystemInitDB.IOT_DB_NAME + "." + "lap_agv_info ";

	public static final String ALLOCATION_ITEM_INFO = SystemInitDB.WMS_DB_NAME + "." + "allocation_item_info ";
	public static final String ALLOCATION_INVENTORY_INFO = SystemInitDB.WMS_DB_NAME + "."
			+ "allocation_inventory_info ";
	public static final String ALLOCATION_COLUMN_INFO = SystemInitDB.WMS_DB_NAME + "." + "allocation_column_info ";
	public static final String ALLOCATION_AREA_INFO = SystemInitDB.WMS_DB_NAME + "." + "allocation_area_info ";
	public static final String ALLOC_ITEM_RELATION = SystemInitDB.WMS_DB_NAME + "." + "alloc_item_relation ";
	public static final String ALLOC_ITEM_INFO_WITH_RELATION = "(SELECT ai.*,ar.areaId,ar.colId,ar.zId,ar.columnid from "
			+ ALLOCATION_ITEM_INFO + " ai, " + ALLOC_ITEM_RELATION
			+ " ar where ai.id=ar.id and ai.delflag=0 and ar.delflag=0)";

	public static final String LED_DEV_INFO = SystemInitDB.IOT_DB_NAME + "." + "led_dev_info ";

	public static final String I_ALL_REQUEST = SystemInitDB.DATA_EXCHANGE_DB_NAME + "." + "i_all_request ";
	public static final String O_ALL_RESPONSE = SystemInitDB.DATA_EXCHANGE_DB_NAME + "." + "o_all_response ";

	public static final String CONNECT_MSG_AGV = SystemInitDB.IOT_DB_NAME + "." + "connect_msg_agv ";
	public static final String CONNECT_MSG_SOCKETDEV = SystemInitDB.IOT_DB_NAME + "." + "connect_msg_socketdev ";
	public static final String CONNECT_ROBOTICARM_MSG = SystemInitDB.IOT_DB_NAME + "." + "connect_roboticarm_msg ";

	public static final String CACHE_KEY_TABLE = SystemInitDB.CACHE_DB_NAME + "." + SystemCacheDao.DEFAULT_CACHE_TABLE;
}
