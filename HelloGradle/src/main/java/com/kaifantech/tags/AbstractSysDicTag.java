package com.kaifantech.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kaifantech.bean.dic.SysDic;
import com.kaifantech.mappings.SysDicMapper;
import com.ytgrading.dao.SysCountryMapper;
import com.ytgrading.dto.SysCountry;
import com.ytgrading.util.AppTool;

/**
 * 分页标签
 * 
 */
public abstract class AbstractSysDicTag extends SimpleTagSupport {
	protected String dicType;
	protected String dicValue;

	protected SysDicMapper sysDicMapper;
	SysCountryMapper sysCountryMapper;

	/** 加载获取数据的spring组件 */
	public void setComponent() {
		if (AppTool.isNull(sysDicMapper)) {
			PageContext pageContext = (PageContext) this.getJspContext();
			ServletContext servletContext = pageContext.getServletContext();
			ApplicationContext ctx = WebApplicationContextUtils
					.getRequiredWebApplicationContext(servletContext);
			this.sysDicMapper = (SysDicMapper) ctx.getBean("sysDictMapper");
			this.sysCountryMapper = (SysCountryMapper) ctx
					.getBean("sysCountryMapper");
		}
	}

	public void setDicType(String dicType) {
		this.dicType = dicType;
	}

	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}

	public SysDic getFromSysCountry(SysCountry sysCountry) {
		SysDic sysDictionary = new SysDic();
		sysDictionary.setKey(((Integer) (sysCountry.getId())).toString());
		sysDictionary.setValue(sysCountry.getFullname());
		return sysDictionary;
	}

	public List<SysDic> getFromSysCountryList(
			List<SysCountry> sysCountryList) {
		List<SysDic> sysDictionaryList = new ArrayList<SysDic>();
		for (SysCountry sysCountry : sysCountryList) {
			SysDic sysDictionary = new SysDic();
			sysDictionary.setKey(((Integer) (sysCountry.getId())).toString());
			sysDictionary.setValue(sysCountry.getFullname());
			sysDictionaryList.add(sysDictionary);
		}
		return sysDictionaryList;
	}
}
