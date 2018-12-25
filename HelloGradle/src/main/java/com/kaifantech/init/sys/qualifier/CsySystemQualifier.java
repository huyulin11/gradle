package com.kaifantech.init.sys.qualifier;

import com.kaifantech.init.sys.ServicePrefix;

public class CsySystemQualifier {
	public static final String TASKEXE_DEALER_MODULE = ServicePrefix.DEFAULT_SERVICE_PREFIX + "Taskexe" + "Module";
	public static final String CTRL_DEALER_MODULE = ServicePrefix.DEFAULT_SERVICE_PREFIX + "Ctrl" + "Module";
	public static final String AGV_MSG_RESOLUTE_MODULE = ServicePrefix.ACS + "MsgResolute" + "Module";

	public static final String AGV_SIMULATOR_WORKER = ServicePrefix.DEFAULT_SERVICE_PREFIX + "AgvSimulatorWorker";
	public static final String AGV_CLIENT_WORKER = ServicePrefix.DEFAULT_SERVICE_PREFIX + "AgvClientWorker";

	public static final String TASKEXE_ADD_SERVICE = ServicePrefix.DEFAULT_SERVICE_PREFIX + "TaskexeAddService";

	public static final String ALLOC_CHECK_SERVICE = ServicePrefix.DEFAULT_SERVICE_PREFIX + "AllocCheckService";
	public static final String ALLOC_SERVICE = ServicePrefix.WMS + "AllocService";

	public static final String TASKEXECHECK_SERVICE = ServicePrefix.DEFAULT_SERVICE_PREFIX + "TaskexeCheckService";

	public static final String PI_WORK_SERVICE = ServicePrefix.DEFAULT_SERVICE_PREFIX + "PiWorkService";

	public static final String CSY_TASK_SITE_INFO_INIT_WORKER = "csyTaskSiteInfoInitWorker";
	public static final String CSY_TASK_SITE_LOGIC_INIT_WORKER = "csyTaskSiteLogicInitWorker";
}
