package com.kaifantech.component.timer.data.cache;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.init.sys.params.CacheKeysInitior;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.util.seq.ThreadID;
import com.kaifantech.util.thread.ThreadTool;

@Component
@Lazy(false)
public class DataCacheTimer {
	private static boolean isRunning = false;
	private static String timerType = "数据缓存器";
	private final Logger logger = Logger.getLogger(DataCacheTimer.class);

	public DataCacheTimer() {
		logger.info(timerType + "开始启动！");
	}

	public void resolute() {
		if (SystemClient.CLIENT.equals(SystemClient.Client.YUFENG)) {
			return;
		}
		Thread.currentThread().setName(timerType + (ThreadID.number++));
		if (!isRunning) {
			while (true) {
				isRunning = true;
				// CacheKeysInitior.readCache();
				ThreadTool.sleep(1000);
			}
		}
		isRunning = false;
	}

	@Scheduled(cron = "0 0/10 * * * ?")
	public void clearDataInMemory() {
		if (SystemClient.CLIENT.equals(SystemClient.Client.YUFENG)) {
			return;
		}
		CacheKeysInitior.clear();
	}

	@Scheduled(cron = "0/1 * * * * ?")
	public void readSystemParams() {
		SystemParameters.setLocalTest();
		if (SystemClient.CLIENT.equals(SystemClient.Client.YUFENG)) {
			return;
		}
		SystemParameters.setAutoTask();
		SystemParameters.setAutoCharge();
	}

}
