package com.kaifantech.util.log;

import com.kaifantech.component.service.rest.WmsRestService;
import com.kaifantech.util.thread.ThreadTool;

public class CsyAppFileLogger extends AppFileLogger {

	public static String connectError(String content) {
		String info = AppFileLogger.connectError(content);

		ThreadTool.run(() -> {
			WmsRestService.one.logToWms(info);
		});
		return info;
	}

	public static String error(String content) {
		String info = AppFileLogger.error(content);

		ThreadTool.run(() -> {
			WmsRestService.one.logToWms(info);
		});
		return info;
	}

}
