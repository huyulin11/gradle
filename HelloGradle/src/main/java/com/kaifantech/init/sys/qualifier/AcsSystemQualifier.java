package com.kaifantech.init.sys.qualifier;

import com.kaifantech.init.sys.ServicePrefix;

public class AcsSystemQualifier {
	public static final String TASKEXE_DEALER_MODULE = ServicePrefix.DEFAULT_SERVICE_PREFIX + "Taskexe" + "Module";
	public static final String CTRL_DEALER_MODULE = ServicePrefix.DEFAULT_SERVICE_PREFIX + "Ctrl" + "Module";
	public static final String AGV_SIMULATOR_WORKER = ServicePrefix.DEFAULT_SERVICE_PREFIX + "AgvSimulatorWorker";
	public static final String TASKEXECHECK_SERVICE = ServicePrefix.DEFAULT_SERVICE_PREFIX + "TaskexeCheckService";

	public static final String AGV_CMD_TASK_MODULE = ServicePrefix.ACS + "AgvCmdTask" + "Module";
	public static final String AGV_CMD_CTRL_MODULE = ServicePrefix.ACS + "AgvCmdCtrl" + "Module";
	public static final String AGV_MSG_RESOLUTE_MODULE = ServicePrefix.ACS + "MsgResolute" + "Module";
	public static final String AGV_MSG_INFO_MODULE = ServicePrefix.ACS + "AgvMsgInfo" + "Module";

	public static final String AGV_CLIENT_WORKER = ServicePrefix.ACS + "AgvClientWorker";

	public static final String AGV_SIMULATOR_MGR = ServicePrefix.ACS + "AgvSimulatorMgr";

	public static final String TASKEXE_ADD_SERVICE = ServicePrefix.ACS + "TaskexeAddService";

	public static final String ALLOC_CHECK_SERVICE = ServicePrefix.WMS + "AllocCheckService";
	public static final String ALLOC_SERVICE = ServicePrefix.ACS + "AllocService";

	public static final String TASKEXE_CHECK_SERVICE = ServicePrefix.ACS + "TaskexeCheckService";
}
