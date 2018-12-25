package com.kaifantech.component.cache.worker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ytgrading.util.AppTool;

public class StaticBeanFactory {
	private static ApplicationContext applicationContext;

	public static Object getBean(Class<?> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	public static ApplicationContext getApplicationContext() {
		if (AppTool.isNull(applicationContext)) {
			applicationContext = new FileSystemXmlApplicationContext("classpath:spring-application.xml");
		}
		return applicationContext;
	}
}
