package com.ytgrading.component.controller.basicsysinfo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ytgrading.component.service.basicsysinfo.IBasicsysinfoService;
import com.ytgrading.erp.util.CurrentUser;
import com.ytgrading.util.AppTool;

@Controller
@RequestMapping("/basicsysinfo/")
public class BasicsysinfoController {

	@Autowired
	IBasicsysinfoService basicsysinfoService;

	/* 初始化页面 */
	@RequestMapping("login")
	public String initPage(HttpServletRequest request, HttpServletResponse resp, Model model) throws Exception {
		int dataCount;
		String tableName = null;

		List<Map<String, Object>> tableNameList = null;
		tableName = request.getParameter("tableName");
		tableNameList = basicsysinfoService.queryTableInfoList(null);
		model.addAttribute("tableNameList", tableNameList);
		model.addAttribute("userid", CurrentUser.getUserid());
		tableName = basicsysinfoService.checkTableName(tableName);
		model.addAttribute("tableName", tableName);
		dataCount = basicsysinfoService.getTableDataCount(tableName);
		model.addAttribute("dataCount", dataCount);
		model.addAttribute("count", getCount());
		return "system/basicsysinfo/basicsysinfo";
	}

	@RequestMapping("getTableInfo")
	public void getTableInfoJson(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		try {
			String tableName = basicsysinfoService.checkTableName(request.getParameter("tableName"));
			String html = basicsysinfoService.getTableDetailJSON(tableName).toString();
			response.getWriter().write(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("getTableData")
	public void getTableDataJson(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		try {
			String tableName = basicsysinfoService.checkTableName(request.getParameter("tableName"));
			int start, count;
			try {
				start = Integer.parseInt(request.getParameter("start"));
				count = Integer.parseInt(request.getParameter("count"));
				if (start >= 0 || count >= 1) { // start、count必须是有效的值
					setCount(count);
				} else {
					start = 0;
					count = 1000;
				}
			} catch (NumberFormatException e) { // 如果参数出错，则显示所有数据，将count设为一个很大的数
				start = 0;
				count = 1000;
			}
			String json = basicsysinfoService.getDataJSON(tableName, start, count).toString();
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("searchTableData")
	public void searchTableDataJson(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		try {
			String tableName = basicsysinfoService.checkTableName(request.getParameter("tableName"));
			int start, count;
			try {
				start = Integer.parseInt(request.getParameter("start"));
				count = Integer.parseInt(request.getParameter("count"));
				if (start >= 0 || count >= 1) { // start、count必须是有效的值
					setCount(count);
				} else {
					start = 0;
					count = 1000;
				}
			} catch (NumberFormatException e) { // 如果参数出错，则显示所有数据，将count设为一个很大的数
				start = 0;
				count = 1000;
			}
			String json = basicsysinfoService.searchData(tableName, start, count, request.getParameterMap()).toString();
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 查看 */
	@RequestMapping("viewTable")
	public void viewTable(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		try {
			String tableName = basicsysinfoService.checkTableName(request.getParameter("tableName"));
			int start, count;
			try {
				start = Integer.parseInt(request.getParameter("start"));
				count = Integer.parseInt(request.getParameter("count"));
				if (start >= 0 || count >= 1) { // start、count必须是有效的值
					setCount(count);
				} else {
					start = 0;
					count = 1000;
				}
			} catch (NumberFormatException e) { // 如果参数出错，则显示所有数据，将count设为一个很大的数
				start = 0;
				count = 1000;
			}
			String html = basicsysinfoService.getDataHtml(tableName, start, count);
			response.getWriter().write(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 保存 */
	@RequestMapping("saveData")
	public void saveData(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		boolean rtn = false;
		try {
			String tableName = basicsysinfoService.checkTableName(request.getParameter("tableName"));
			String operateType = request.getParameter("operateType");
			rtn = basicsysinfoService.saveData(tableName, request, operateType);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.getWriter().write(rtn ? "true" : "false");
		}
	}

	/* 删除 */
	@RequestMapping("deleteData")
	public void deleteData(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		boolean rtn = false;
		String tableName = null;
		String id = null;
		boolean isIdNum = false;
		try {
			tableName = basicsysinfoService.checkTableName(request.getParameter("tableName"));
			id = request.getParameter("id");
			if (request.getParameter("isIdNum") != null && "true".equals(request.getParameter("isIdNum"))) {
				isIdNum = true;
			}
			if (!AppTool.isNullStr(id)) {
				rtn = basicsysinfoService.deleteData(tableName, id, isIdNum);
				response.getWriter().write(rtn ? "true" : "false");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 以表格分页显示数据时，每页显示的数据条数。 需求：将用户上次设置的count值保存下来，下次打开网页不用重复设置。
	 * 数据流程：BasicsysinfoController初始化时，初始化count并赋予其一个初始值。
	 * 请求页面（RequestMapping）时，以request下属性的方式将count值添加到页面中设置count的input框。
	 * 每次ajax请求数据时，服务器读取来自客户端的count值并保存到此类中的count属性。
	 * 下次RequestMapping请求直接从取count值。
	 * 缺陷：1、多session操作下，一个用户设置count会影响到其他用户的操作。2、没有实现持久化。
	 * 解决办法：使用数据库，将不同用户设置的count存入到该用户对应的数据表中，每次从数据库取值。
	 */
	private int count = 50;

	protected void setCount(int count) {
		this.count = count;
	}

	protected int getCount() {
		return this.count;
	}

}
