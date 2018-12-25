package com.ytgrading.component.controller.basicsysinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reportmanager/")
public class ReportmanagerController {

	@RequestMapping("view")
	public String view(HttpServletRequest request, HttpServletResponse resp,
			Model model) throws Exception {
		return "reportmanage/view";
	}

	@RequestMapping("routing")
	public String routing(HttpServletRequest request, HttpServletResponse resp,
			Model model) throws Exception {
		return "reportmanage/routing";
	}

	@RequestMapping("data")
	public String data(HttpServletRequest request, HttpServletResponse resp,
			Model model) throws Exception {
		return "reportmanage/data";
	}

}
