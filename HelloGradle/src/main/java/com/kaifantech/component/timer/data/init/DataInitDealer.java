package com.kaifantech.component.timer.data.init;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kaifantech.component.service.data.init.csy.CsyDataInitService;
import com.kaifantech.component.service.data.init.inoma.InomaDataInitService;
import com.kaifantech.init.sys.SystemClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-shiro.xml", "classpath:spring-application.xml",
		"classpath:spring-mvc-scan.xml" })
@Component
public class DataInitDealer {
	@Autowired
	private CsyDataInitService csyDataInitService;

	@Autowired
	private InomaDataInitService inomaDataInitService;

	@Test
	public void resolute() {
		try {
			if (SystemClient.CLIENT.equals(SystemClient.Client.INOMA)) {
				inomaDataInitService.initData();
			}
			if (SystemClient.CLIENT.equals(SystemClient.Client.CSY)) {
				csyDataInitService.initData();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
