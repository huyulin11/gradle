package com.kaifantech.component.timer.connect.client;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kaifantech.component.comm.worker.client.dev.CsyChargeWorker;
import com.kaifantech.component.comm.worker.client.dev.CsyPlcWorker;
import com.kaifantech.component.comm.worker.client.dev.CsyWindowWorker;
import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.util.seq.ThreadID;

@Component
@Lazy(false)
public class IotConnectAsClientTimer {
	private static boolean isRunning = false;
	private static String timerType = "IOT_CLIENT_SOCKET设备连接器";
	private final Logger logger = Logger.getLogger(IotConnectAsClientTimer.class);

	@Autowired
	private CsyPlcWorker plcWorker;

	@Autowired
	private CsyChargeWorker chargeWorker;

	@Autowired
	private CsyWindowWorker windowPlcWorker;

	@Scheduled(cron = "0/1 * * * * ?")
	public void resolute() {
		if (SystemClient.CLIENT.equals(SystemClient.Client.YUFENG)) {
			return;
		}
		if (!isRunning) {
			Thread.currentThread().setName(timerType + (ThreadID.number++));
			isRunning = true;
			try {
				plcWorker.startConnect();
				chargeWorker.startConnect();
				windowPlcWorker.startConnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
			isRunning = false;
		} else {
			logger.error(timerType + "：上一次任务执行还未结束");
			isRunning = false;
		}
	}
}
