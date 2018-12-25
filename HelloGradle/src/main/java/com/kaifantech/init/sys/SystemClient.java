package com.kaifantech.init.sys;

public class SystemClient {
	// public static final Client CLIENT = Client.YUFENG;
	// public static final ProjectName PROJECT_NAME = ProjectName.YUFENG_WUXI;

	public static final Client CLIENT = Client.CSY;
	public static final ProjectName PROJECT_NAME = ProjectName.KF_CSY_DAJ;

	// public static final Client CLIENT = Client.INOMA;
	// public static final ProjectName PROJECT_NAME = ProjectName.XUZHOU_WEIWEI;

	public enum ProjectName {
		HAITIAN_DRIVER, CANGZHOU, HAITIAN_JINGGONG, XUZHOU_WEIWEI, KF_CSY_DAJ, YUFENG_WUXI
	}

	public enum Client {
		CSY, YUFENG, INOMA
	}

}
