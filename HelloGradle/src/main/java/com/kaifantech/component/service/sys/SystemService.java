package com.kaifantech.component.service.sys;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class SystemService implements ISystemService, ServletContextAware {

	private ServletContext servletContext = null;

	@Override
	public boolean isDevelopMode() {
		if ("true".equals(servletContext.getInitParameter("developMode"))) {
			return true;
		} else if ("false".equals(servletContext.getInitParameter("developMode"))) {
			return false;
		}
		return false;
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		servletContext = arg0;
	}

}
