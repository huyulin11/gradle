package com.kaifantech.component.timer.taskexe.auto;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kaifantech.component.business.ctrl.deal.ICtrlDealModule;
import com.kaifantech.component.business.task.deal.ITaskexeDealModule;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.thread.ThreadTool;

@Component
@Lazy(false)
public class TaskexeAutoDealTimer {
	private static boolean isTaskRunning = false;
	private static boolean isCtrlRunning = false;
	private static String timerType = "任务处理器";
	private final Logger logger = Logger.getLogger(TaskexeAutoDealTimer.class);

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_TASKEXE_DEALER_MODULE)
	private ITaskexeDealModule taskModule;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_CTRL_DEALER_MODULE)
	private ICtrlDealModule ctrlModule;

	public TaskexeAutoDealTimer() {
		logger.info(timerType + "开始启动！");
	}

	@Scheduled(cron = "0/1 * * * * ?")
	public void resoluteTaskexe() {
		if (!SystemParameters.isConnectIotClient()) {
			return;
		}
		dealCtrl();
		dealTaskexe();
	}

	private void dealTaskexe() {
		ThreadTool.run(() -> {
			if (!isTaskRunning) {
				isTaskRunning = true;
				taskModule.startControl();
			}
			isTaskRunning = false;
		});
	}

	private void dealCtrl() {
		ThreadTool.run(() -> {
			if (!isCtrlRunning) {
				isCtrlRunning = true;
				ctrlModule.startControl();
			}
			isCtrlRunning = false;
		});
	}

}
