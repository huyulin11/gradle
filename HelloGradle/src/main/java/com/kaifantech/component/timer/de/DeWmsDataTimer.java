package com.kaifantech.component.timer.de;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kaifantech.bean.de.AllRequestBean;
import com.kaifantech.component.dao.de.DeWmsRequestDao;
import com.kaifantech.component.service.de.DeWmsDataService;
import com.kaifantech.init.sys.params.SystemParameters;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-shiro.xml", "classpath:spring-application.xml",
		"classpath:spring-mvc-scan.xml" })
@Component
@Lazy(false)
public class DeWmsDataTimer {
	private static boolean isRunning = false;
	private static String timerType = "单据转换器（将单据转换成为任务）";

	@Autowired
	private DeWmsRequestDao deWmsDataDao;

	@Autowired
	private DeWmsDataService deWmsDataService;

	@Scheduled(cron = "0/2 * * * * ?")
	public void resolute() {
		if (!SystemParameters.isConnectIotClient()) {
			return;
		}
		if (!isRunning) {
			Thread.currentThread().setName(timerType);
			isRunning = true;
			try {
				doWork();
			} catch (Exception e) {
				e.printStackTrace();
			}
			isRunning = false;
		} else {
			isRunning = false;
		}
	}

	@Test
	public synchronized void doWork() throws Exception {
		List<AllRequestBean> data = deWmsDataDao.getAll();
		for (AllRequestBean bean : data) {
			deWmsDataService.resolute(bean);
		}
	}
}
