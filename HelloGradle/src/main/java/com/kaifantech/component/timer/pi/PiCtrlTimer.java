package com.kaifantech.component.timer.pi;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kaifantech.component.dao.ControlInfoDao;
import com.kaifantech.component.log.AgvStatusDBLogger;
import com.kaifantech.component.service.pi.ctrl.work.IPiWorkService;
import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.seq.ThreadID;
import com.kaifantech.util.thread.ThreadTool;

@Component
@Lazy(false)
public class PiCtrlTimer {
	private static boolean isRunning = false;
	private static String timerType = "AGV交通管制器";
	private final Logger logger = Logger.getLogger(PiCtrlTimer.class);

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_PI_WORK_SERVICE)
	private IPiWorkService piWorkService;

	@Autowired
	private ControlInfoDao controlInfoDao;

	@Autowired
	private AgvStatusDBLogger kaifantechDBLogger;

	private int tipsTime = 0;

	public PiCtrlTimer() {
		logger.info(timerType + "开始启动！");
	}

	@Scheduled(cron = "0/1 * * * * ?")
	public void resolute() {
		while (true) {
			if (SystemClient.CLIENT.equals(SystemClient.Client.YUFENG)) {
				return;
			}
			if (controlInfoDao.getAgvsPI().equals(0)) {
				if (tipsTime++ > 10) {
					tipsTime = 0;
					kaifantechDBLogger.warning("系统交通管制功能关闭中，请注意AGV运行情况！！！", 0, AgvStatusDBLogger.MSG_LEVEL_INFO);
				}
				break;
			}
			if (!isRunning) {
				Thread.currentThread().setName(timerType + (ThreadID.number++));
				isRunning = true;
				piWorkService.doWork();
			}
			isRunning = false;
			ThreadTool.sleep(500);
		}
	}

}
