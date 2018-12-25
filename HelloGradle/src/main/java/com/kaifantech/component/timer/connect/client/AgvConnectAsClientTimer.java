package com.kaifantech.component.timer.connect.client;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kaifantech.component.comm.worker.client.agv.IAgvClientWorker;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.seq.ThreadID;
import com.kaifantech.util.thread.ThreadTool;

@Component
@Lazy(false)
public class AgvConnectAsClientTimer {
	private static boolean isRunning = false;
	private static String timerType = "IOT_CLIENT_AGV设备连接器";
	private final Logger logger = Logger.getLogger(AgvConnectAsClientTimer.class);

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_CLIENT_WORKER)
	private IAgvClientWorker agvWorker;

	public AgvConnectAsClientTimer() {
		logger.info(timerType + "开始启动！");
	}

	@Scheduled(cron = "0/1 * * * * ?")
	public void resolute() {
		if (SystemParameters.isConnectIotClient()) {
			return;
		}
		if (!isRunning) {
			Thread.currentThread().setName(timerType + (ThreadID.number++));
			isRunning = true;
			doWork();
			isRunning = false;
		}
	}

	private void doWork() {
		if (!SystemParameters.isConnectIotClient()) {
			return;
		}
		while (true) {
			try {
				agvWorker.startConnect();
				ThreadTool.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
