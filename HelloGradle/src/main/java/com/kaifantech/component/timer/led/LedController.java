package com.kaifantech.component.timer.led;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kaifantech.component.service.led.LedDevInfoService;
import com.kaifantech.init.sys.SystemInitiator;
import com.kaifantech.util.seq.ThreadID;

@Component
@Lazy(false)
public class LedController {
	private static boolean isRunning = false;
	private static String timerType = "AGV消息解析器";

	@Autowired
	private LedDevInfoService ledDevInfoService;

	// @Scheduled(cron = "0/10 * * * * ?")
	@Scheduled(cron = "0 0 12 * * ?")
	public void resolute() {
		if (SystemInitiator.alwaysTrue) {
			return;
		}

		if (!isRunning) {
			Thread.currentThread().setName(timerType + (ThreadID.number++));
			isRunning = true;
			try {
				ledDevInfoService.sendToAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			isRunning = false;
		} else {
			isRunning = false;
		}
	}
}
