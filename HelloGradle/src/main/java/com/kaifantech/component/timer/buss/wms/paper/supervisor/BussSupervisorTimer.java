package com.kaifantech.component.timer.buss.wms.paper.supervisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kaifantech.bean.iot.client.IotClientBean;
import com.kaifantech.component.dao.agv.info.AgvOpChargeDao;
import com.kaifantech.component.service.buss.wms.paper.supervisor.BussSupervisorExecutor;
import com.kaifantech.component.service.iot.client.IotClientService;
import com.kaifantech.component.service.paper.base.WmsPaperService;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.util.seq.ThreadID;

@Component
@Lazy(false)
public class BussSupervisorTimer {
	private static boolean isRunning = false;
	private static String timerType = "任务生成定时器（业务->任务、自动充电、从AGV消息读取信息）";

	@Autowired
	private BussSupervisorExecutor bussSupervisorExecutor;

	@Autowired
	protected WmsPaperService wmsPaperService;

	@Scheduled(cron = "0/2 * * * * ?")
	public void resolute() {
		if (!SystemParameters.isConnectIotClient()) {
			return;
		}
		if (!isRunning) {
			Thread.currentThread().setName(timerType + (ThreadID.number++));
			isRunning = true;
			try {
				bussSupervisorExecutor.doWork();
			} catch (Exception e) {
				e.printStackTrace();
			}
			isRunning = false;
		} else {
			isRunning = false;
		}
	}

	@Autowired
	private AgvOpChargeDao agvOpDao;

	@Autowired
	private IotClientService iotClientService;

	@Scheduled(cron = "0/3 * * * * ?")
	public void updateAgvInfo() {
		if (!SystemParameters.isConnectIotClient()) {
			return;
		}
		for (IotClientBean agv : iotClientService.getAgvCacheList()) {
			agvOpDao.update(agv.getId());
		}
	}
}
