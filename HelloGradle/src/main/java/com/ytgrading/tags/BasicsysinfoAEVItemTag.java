package com.ytgrading.tags;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ytgrading.component.service.basicsysinfo.BasicsysinfoService;
import com.ytgrading.component.service.basicsysinfo.IBasicsysinfoService;

/**
 * 分页标签
 */
public class BasicsysinfoAEVItemTag extends SimpleTagSupport {

	protected String tableName;

	protected IBasicsysinfoService basicsysinfoService;

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public void doTag() throws JspException {
		JspWriter out = getJspContext().getOut();
		try {
			// IBasicsysinfoService service = getBean(getRequest(), BasicsysinfoService.class);
			if(basicsysinfoService == null){
				basicsysinfoService = getBean(BasicsysinfoService.class);
			}
			String html = basicsysinfoService.getHtmlFormAEV(tableName);
			out.println(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 获取Spring Bean
	public <T> T getBean(Class<T> clazz){
		ServletRequest request = ((PageContext)getJspContext()).getRequest();
		// Spring 根容器
		ApplicationContext rootContext = WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext());
		// 当前DispatcherServlet的容器
		ApplicationContext servletContext = 
				RequestContextUtils.getWebApplicationContext(request);
		if (servletContext.getBean(clazz) != null){
			return servletContext.getBean(clazz);
		}else{
			return rootContext.getBean(clazz);
		}
	}
	
}
