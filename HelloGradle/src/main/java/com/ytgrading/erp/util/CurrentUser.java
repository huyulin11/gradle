package com.ytgrading.erp.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ytgrading.dao.CustomerMapper;
import com.ytgrading.dto.Users;

// 从request、session获取当前用户信息
// 暂先完成大致程序框架，具体代码以后再实现
// 前台：当前登录用户：保存“userid”属性到session访问
// 后台：当前被操作用户：保存“userid”参数在request请求中
// 前后台以sessionType区分，sessionType保存在session范围内
// 后台登陆账号为内部员工,保存"employeeid"到session访问

public class CurrentUser {

	public static final String SESSIONTYPE_BACKSTAGE = "1";
	public static final String SESSIONTYPE_FRONT = "0";

	public static String getSessionType(HttpServletRequest request) {
		return (String) request.getSession().getAttribute("sessionType");
	}

	public static boolean isFrontSession(HttpServletRequest request) {
		return SESSIONTYPE_FRONT.equals(getSessionType(request));
	}

	public static boolean isBackStageSession(HttpServletRequest request) {
		return SESSIONTYPE_BACKSTAGE.equals(getSessionType(request));
	}

	// 获取有效id，“有效id”满足的条件：
	// 1 不能为空
	// 2 是在系统中已注册userid
	// 3 如果是前台系统，session中有userid属性
	public static String getSecureUserid() {
		Users users = getCurrentUser();
		if (users != null) {
			return users.getId();
		} else {
			return null;
		}
	}

	public static String getUserid() {
		return getUserid(getRequest());
	}

	public static String getUserid(HttpServletRequest request) {
		String userid = null;
		if (isBackStageSession(request)) {
			userid = request.getParameter("userid");
		} else {
			userid = (String) request.getSession().getAttribute("userid");
		}
		if (userid == null || userid.trim().length() == 0 || userid.equals("null")) {
			userid = null;
		}
		return userid;
	}

	public static Users getCurrentUser() {
		return getCurrentUser(getRequest());
	}

	public static Users getCurrentUser(HttpServletRequest request, String userid) {
		Users user = null;
		if (userid != null && !"".equals(userid)) {
			CustomerMapper mapper = getBean(request, CustomerMapper.class);
			user = mapper.getUserById(userid);
		}
		return user;
	}

	public static Users getCurrentUser(String userid) {
		Users user = null;
		if (userid != null && !"".equals(userid)) {
			CustomerMapper mapper = getBean(getRequest(), CustomerMapper.class);
			user = mapper.getUserById(userid);
		}
		return user;
	}

	public static Users getCurrentUser(HttpServletRequest request) {
		String userid = getUserid(request);
		return getCurrentUser(request, userid);
	}

	public static int getOwnid(HttpServletRequest request) {
		return Integer.parseInt((String) request.getSession().getAttribute("ownid"));
	}

	public static Integer getEmployeeId(HttpServletRequest request) {
		Object userid = request.getSession().getAttribute("userid");
		Integer employeeid = 0;
		if (isBackStageSession(request)) {
			try {
				employeeid = Integer.parseInt((String) userid);
			} catch (Exception e) {
				;
			}
		}
		return employeeid;
	}

	public static String getOpUserid(HttpServletRequest request) {
		Object opid = null;
		if (isBackStageSession(request)) {
			opid = getEmployeeId(request);
		} else {
			opid = getUserid(request);
		}
		return (opid != null && !"".equals(opid)) ? opid.toString() : null;
	}

	// 获取Spring Bean
	public static <T> T getBean(HttpServletRequest request, Class<T> clazz) {
		// Spring 根容器
		ApplicationContext rootContext = WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext());
		// 当前DispatcherServlet的容器
		ApplicationContext servletContext = RequestContextUtils.findWebApplicationContext(request);
		if (servletContext.getBean(clazz) != null) {
			return servletContext.getBean(clazz);
		} else {
			return rootContext.getBean(clazz);
		}
	}

	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
}
