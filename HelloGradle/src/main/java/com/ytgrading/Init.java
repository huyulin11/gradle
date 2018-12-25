package com.ytgrading;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.ytgrading.util.DateFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;

@WebServlet(name = "init", loadOnStartup = 0, urlPatterns = { "/init" }, initParams = {
		@WebInitParam(name = "developMode", value = "true"),
		@WebInitParam(name = "static-resources-location", value = "/s"),
		@WebInitParam(name = "js-resources-location", value = "/s/j"),
		@WebInitParam(name = "css-resources-location", value = "/s/c"),
		@WebInitParam(name = "image-resources-location", value = "/s/i"),
		@WebInitParam(name = "front-resources-location", value = "/s/f") })
public class Init extends HttpServlet {

	@Override
	public void init(ServletConfig config) {
		boolean debug = false;
		ServletContext application = config.getServletContext();
		String contextPath = application.getContextPath();
		String staticPath = config.getInitParameter("static-resources-location");
		String jsPath = config.getInitParameter("js-resources-location");
		String cssPath = config.getInitParameter("css-resources-location");
		String frontPath = config.getInitParameter("front-resources-location");
		String imagePath = config.getInitParameter("image-resources-location");
		/* 首先查看web.xml设置 -> 若没有，使用servlet初始化参数 -> 再为空，取false */
		if ("true".equals(application.getInitParameter("developMode"))) {
			debug = true;
		} else if ("false".equals(application.getInitParameter("developMode"))) {
			debug = false;
		} else if ("true".equals(config.getInitParameter("developMode"))) {
			debug = true;
		}
		String staticFileVersion = DateFactory.getCurrTime();
		application.setAttribute("staticFileVersion", staticFileVersion);
		application.setAttribute("ctx", contextPath);
		application.setAttribute("ctx_static", staticPath);
		application.setAttribute("ctx_images", imagePath);
		application.setAttribute("ctx_js", jsPath);
		application.setAttribute("ctx_css", cssPath);
		application.setAttribute("ctx_front", frontPath);
		application.setAttribute("enableDebug", debug); // indicate it's in
														// debugging
		// System.out.println((debug?"enable":"disable") + " debug");
		this.destroy(); // destroy this servlet
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	}

	private static final long serialVersionUID = 1L;
}
