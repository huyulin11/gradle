package com.kaifantech.component.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WMSController {
	@RequestMapping("agvalloc")
	public String agvalloc() throws Exception {
		return "/agvmgr/alloc";
	}

}
