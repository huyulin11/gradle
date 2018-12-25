package com.kaifantech.component.timer.agv.server;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kaifantech.component.dao.AGVConnectMsgDao;
import com.kaifantech.component.service.agv.simulator.YufengAgvServerWorker;
import com.kaifantech.component.service.comm.YufengAgvManager;
import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.util.seq.ThreadID;
import com.kaifantech.util.thread.ThreadTool;
import com.ytgrading.util.AppTool;

@Component
@Lazy(false)
public class YufengAgvServerTimer {
	private static boolean isRunning = false;
	private static String timerType = "IOT模拟器";
	private final Logger logger = Logger.getLogger(YufengAgvServerTimer.class);

	@Autowired
	private YufengAgvServerWorker agvServerWorker;

	@Autowired
	private AGVConnectMsgDao msgDao;

	public YufengAgvServerTimer() {
		logger.info(timerType + "开始启动！");
	}

	@Scheduled(cron = "0/1 * * * * ?")
	public void resolute() {
		if (!SystemClient.CLIENT.equals(SystemClient.Client.YUFENG)) {
			return;
		}
		if (!SystemParameters.isConnectIotServer()) {
			return;
		}
		if (!isRunning) {
			Thread.currentThread().setName(timerType + (ThreadID.number++));
			isRunning = true;
			agvSimulate();
		}
		isRunning = false;
	}

	private void agvSimulate() {
		ThreadTool.run(() -> {
			agvServerWorker.startConnect();
		});
	}

	@Scheduled(initialDelay = 5000, fixedDelay = 1000)
	public void getMsgFromAgv() {
		if (!SystemClient.CLIENT.equals(SystemClient.Client.YUFENG)) {
			return;
		}
		String msg = agvServerWorker.getMap().get(1).getMsgReceived();
		if (AppTool.isNull(msg)) {
			return;
		}
		YufengAgvManager.nextMsg = msg;
		msgDao.addAMsg(msg, "getMsgFromAgv", 1);
	}
}
