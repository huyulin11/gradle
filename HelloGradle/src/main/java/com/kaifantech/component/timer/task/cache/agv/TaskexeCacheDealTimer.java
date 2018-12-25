package com.kaifantech.component.timer.task.cache.agv;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kaifantech.component.business.ctrl.deal.ICtrlDealModule;
import com.kaifantech.component.business.task.deal.ITaskexeDealModule;
import com.kaifantech.component.business.taskexe.dealer.CsyTaskexeCacheDealer;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.thread.ThreadTool;

@Component
@Lazy(false)
public class TaskexeCacheDealTimer {
	private static boolean isRunning = false;
	private static String timerType = "任务缓存定时器";
	private final Logger logger = Logger.getLogger(TaskexeCacheDealTimer.class);

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_TASKEXE_DEALER_MODULE)
	private ITaskexeDealModule taskModule;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_CTRL_DEALER_MODULE)
	private ICtrlDealModule ctrlModule;

	@Autowired
	private CsyTaskexeCacheDealer taskexeCacheDealer;

	public TaskexeCacheDealTimer() {
		logger.info(timerType + "开始启动！");
	}

	@Scheduled(cron = "0/1 * * * * ?")
	public void resoluteTaskexe() {
		if (!SystemParameters.isConnectIotClient()) {
			return;
		}
		dealTaskexeCache();
	}

	private void dealTaskexeCache() {
		ThreadTool.run(() -> {
			if (!isRunning) {
				isRunning = true;
				taskexeCacheDealer.startControl();
			}
			isRunning = false;
		});
	}

}
