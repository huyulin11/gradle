package com.kaifantech.component.timer.err.agv;

import java.util.Deque;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kaifantech.component.business.taskexe.dealer.CsyTaskexeCacheDealer;
import com.kaifantech.component.comm.worker.client.agv.IAgvClientWorker;
import com.kaifantech.component.log.AgvStatusDBLogger;
import com.kaifantech.init.sys.params.SystemParameters;
import com.kaifantech.init.sys.qualifier.SystemQualifier;
import com.kaifantech.util.seq.ThreadID;
import com.kaifantech.util.socket.client.AbstractSocketClient;
import com.ytgrading.util.msg.AppMsg;

@Component
@Lazy(false)
public class AgvErrMsgCatchTimer {
	private static boolean isRunning = false;
	private static String timerType = "AGV异常消息捕获器";
	private final Logger logger = Logger.getLogger(AgvErrMsgCatchTimer.class);

	@Autowired
	private AgvStatusDBLogger kaifantechDBLogger;

	@Autowired
	@Qualifier(SystemQualifier.DEFAULT_AGV_CLIENT_WORKER)
	private IAgvClientWorker clientMgr;

	@Autowired
	private CsyTaskexeCacheDealer taskexeCacheDealer;

	public AgvErrMsgCatchTimer() {
		logger.info(timerType + "开始启动！");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Scheduled(cron = "0/2 * * * * ?")
	public void resolute() {
		if (!SystemParameters.isConnectIotClient()) {
			return;
		}
		if (!isRunning) {
			Thread.currentThread().setName(timerType + (ThreadID.number++));
			isRunning = true;
			doWork();
		}
		isRunning = false;
	}

	private void doWork() {
		Iterator<Entry<Integer, AbstractSocketClient>> iterator = clientMgr.getMap().entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, AbstractSocketClient> entry = iterator.next();
			Deque<String> msgDeque = entry.getValue().getErrMsgDeque();
			if (msgDeque != null && msgDeque.size() > 0) {
				while (msgDeque.size() > 0) {
					kaifantechDBLogger.warning(msgDeque.pop(), entry.getKey());
				}
			}
		}

		AppMsg appMsg = taskexeCacheDealer.getCacheError();
		if (!appMsg.isSuccess()) {
			kaifantechDBLogger.error(appMsg.getMsg(), 0);
		}
	}
}
