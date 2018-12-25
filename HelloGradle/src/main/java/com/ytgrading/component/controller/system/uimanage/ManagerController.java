package com.ytgrading.component.controller.system.uimanage;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaifantech.component.controller.base.BaseController;
import com.ytgrading.util.FormMap;

/**
 * 进行管理后台框架界面的类
 * 
 * @author lijianning 2015-04-05
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/")
public class ManagerController extends BaseController<FormMap<String, Object>> {
	@ResponseBody
	@RequestMapping({ "ytgrading" })
	public void ytgrading(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/x-javascript;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String s = request.getParameter("callback");
		out.println(s + "({\"msg\":\"false\"})");
		out.close();
	}

	// @RequestMapping("install") 不用时注释，防止外部暴力破解获取
	// public String install() throws Exception {
	//
	// try {
	// Properties props = Resources
	// .getResourceAsProperties("jdbc.properties");
	// String url = props.getProperty("jdbc.url");
	// String driver = props.getProperty("jdbc.driverClass");
	// String username = props.getProperty("jdbc.username");
	// String password = props.getProperty("jdbc.password");
	// System.out.println(url);
	// Class.forName(driver).newInstance();
	// Connection conn = (Connection) DriverManager.getConnection(url,
	// username, password);
	// ScriptRunner runner = new ScriptRunner(conn);
	// runner.setErrorLogWriter(null);
	// runner.setLogWriter(null);
	// runner.runScript(Resources.getResourceAsReader("intall.sql"));
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// return "初始化失败！请联系管理员" + e;
	// }
	//
	// return "/install";
	// }

	@RequestMapping("docs")
	@ResponseBody
	public String docs(HttpServletRequest request) {
		return "帮助文档正在建设中……";
	}

	@RequestMapping("tips")
	@ResponseBody
	public String tips(HttpServletRequest request) {
		return "提醒功能正在建设中……";
	}
}
