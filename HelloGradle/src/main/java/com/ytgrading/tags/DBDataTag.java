package com.ytgrading.tags;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ytgrading.util.AppTool;

/**
 * 分页标签
 */
public class DBDataTag extends SimpleTagSupport {

	protected String sql;

	protected Integer numOfOnePage;

	protected Integer defaultNumOfOnePage;

	protected Integer currentPage;

	protected String tableName;

	protected JdbcTemplate jdbcTemplate;

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public void doTag() throws JspException {
		JspWriter out = getJspContext().getOut();
		try {

			if (jdbcTemplate == null) {
				jdbcTemplate = getBean(JdbcTemplate.class);
			}

			System.out.println("" + sql + " limit " + (currentPage - 1) * numOfOnePage + "," + numOfOnePage);

			List<Map<String, Object>> query = jdbcTemplate
					.queryForList("" + sql + " limit " + (currentPage - 1) * numOfOnePage + "," + numOfOnePage);

			List<Map<String, Object>> queryCount = jdbcTemplate
					.queryForList("select count(*) cnt from (" + sql + ") gagaga  ");
			Long cnt = (Long) queryCount.get(0).get("cnt");
			String msg = "总数:" + cnt + "，总页数：" + ((cnt - 1) / numOfOnePage + 1) + "，当前页码：" + currentPage + "，每页："
					+ numOfOnePage;

			DBDataTagTool tool = new DBDataTagTool();
			String html = tool.doTagTool(query, msg);

			out.println(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void setNumOfOnePage(Integer numOfOnePage) {
		this.numOfOnePage = numOfOnePage;
		if (AppTool.isNull(numOfOnePage) || numOfOnePage <= 0) {
			if (AppTool.isNull(this.defaultNumOfOnePage) || this.defaultNumOfOnePage <= 0) {
				this.numOfOnePage = 10;
			} else {
				this.numOfOnePage = this.defaultNumOfOnePage;
			}
		}
	}

	public void setDefaultNumOfOnePage(Integer defaultNumOfOnePage) {
		this.defaultNumOfOnePage = defaultNumOfOnePage;
		if (AppTool.isNull(this.defaultNumOfOnePage) || this.defaultNumOfOnePage <= 0) {
			this.defaultNumOfOnePage = 10;
		}
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
		if (AppTool.isNull(currentPage) || currentPage <= 0) {
			this.currentPage = 1;
		}
	}

	// 获取Spring Bean
	public <T> T getBean(Class<T> clazz) {
		ServletRequest request = ((PageContext) getJspContext()).getRequest();
		// Spring 根容器
		ApplicationContext rootContext = WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext());
		// 当前DispatcherServlet的容器
		ApplicationContext servletContext = RequestContextUtils.getWebApplicationContext(request);
		if (servletContext.getBean(clazz) != null) {
			return servletContext.getBean(clazz);
		} else {
			return rootContext.getBean(clazz);
		}
	}

}
