package com.kaifantech.component.timer.server;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kaifantech.component.comm.worker.server.agv.IAgvSimulatorWorker;
import com.kaifantech.component.comm.worker.server.plc.IPlcSimulatorWorker;
import com.kaifantech.component.comm.worker.server.robot.CsyRobotServerWorker;
import com.kaifantech.init.sys.SystemClient;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.seq.ThreadID;
import com.kaifantech.util.thread.ThreadTool;

@Component
@Lazy(false)
public class IotConnectAsServerTimer {
	private static boolean isRunning = false;
	private static String timerType = "IOT_SERVER设备连接器";
	private final Logger logger = Logger.getLogger(IotConnectAsServerTimer.class);

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_SIMULATOR_WORKER)
	private IAgvSimulatorWorker agvServerWorker;

	@Autowired
	private IPlcSimulatorWorker plcServerWorker;

	@Autowired
	private CsyRobotServerWorker robotServerWorker;

	public IotConnectAsServerTimer() {
		logger.info(timerType + "开始启动！");
	}

	@Scheduled(cron = "0/1 * * * * ?")
	public void resolute() {
		if (SystemClient.CLIENT.equals(SystemClient.Client.YUFENG)) {
			return;
		}
		if (!isRunning) {
			Thread.currentThread().setName(timerType + (ThreadID.number++));
			isRunning = true;
			agvSimulate();
			plcSimulate();
			robotStart();
		}
		isRunning = false;
	}

	private void robotStart() {
		ThreadTool.run(() -> {
			robotServerWorker.startConnect();
		});
	}

	private void agvSimulate() {
		ThreadTool.run(() -> {
			agvServerWorker.startConnect();
		});
	}

	private void plcSimulate() {
		ThreadTool.run(() -> {
			plcServerWorker.startConnect();
		});
	}
}
