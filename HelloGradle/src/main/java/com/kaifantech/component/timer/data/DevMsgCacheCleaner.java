package com.kaifantech.component.timer.data;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kaifantech.component.service.ctrl.cache.CacheCleanService;
import com.kaifantech.util.seq.ThreadID;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Component
@Lazy(false)
public class DevMsgCacheCleaner {
	private static boolean isRunning = false;
	private static String timerType = "AGV历史消息清空器";
	private final Logger logger = Logger.getLogger(DevMsgCacheCleaner.class);

	@Autowired
	private CacheCleanService cacheCleanService;

	@Scheduled(cron = "0 0/10 * * * ?")
	public void resolute() {
		if (!isRunning) {
			Thread.currentThread().setName(timerType + (ThreadID.number++));
			isRunning = true;
			logger.info(timerType + "：开始！");
			try {
				AppMsg msg = cacheCleanService.deleteOUTOfDateData();
				if (!AppTool.isNull(msg)) {
					if (msg.getCode() < 0) {
						if (!AppTool.isNullStr(msg.getMsg())) {
							logger.info(timerType + "：" + msg.getMsg());
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			isRunning = false;
			logger.info(timerType + "：指定任务执行结束");
		} else {
			logger.error(timerType + "：上一次任务执行还未结束");
			isRunning = false;
		}
	}
}
