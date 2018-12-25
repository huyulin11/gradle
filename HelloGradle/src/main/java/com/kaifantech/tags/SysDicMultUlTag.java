package com.kaifantech.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.kaifantech.bean.dic.SysDic;
import com.ytgrading.util.AppTool;

/**
 * 分页标签
 * 
 */
public class SysDicMultUlTag extends AbstractSysDicTag {
	private String checkboxName;

	@Override
	public void doTag() throws JspException {
		JspWriter out = getJspContext().getOut();
		setComponent();

		List<SysDic> dicList;
		if ("COUNTRY".equals(dicType)) {
			dicList = getFromSysCountryList(sysCountryMapper.getAllCountry());
		} else {
			dicList = sysDicMapper.getSysDictionaries(new SysDic(
					dicType, null));
		}
		String html = "";
		if (dicList == null || dicList.size() <= 0) {
			html = "";
		} else {
			StringBuffer sb = new StringBuffer();
			for (SysDic sysDictionary : dicList) {
				List<String> selectedOpt = new ArrayList<String>();
				if (!AppTool.isNullStr(this.dicValue)) {
					Collections.addAll(selectedOpt, dicValue.split(","));
				}
				sb.append("<li>"
						+ "<input type='checkbox' name='"
						+ checkboxName
						+ "' value='"
						+ sysDictionary.getKey()
						+ "'"
						+ "' data-value='"
						+ sysDictionary.getValue()
						+ "'"
						+ ((selectedOpt.contains(sysDictionary.getKey())) ? " checked "
								: "") + ">" + sysDictionary.getValue()
						+ "</li>");

			}
			html = sb.toString();
		}
		try {
			out.println(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setCheckboxName(String checkboxName) {
		this.checkboxName = checkboxName;
	}
}
