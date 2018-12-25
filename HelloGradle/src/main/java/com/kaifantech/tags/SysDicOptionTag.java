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
public class SysDicOptionTag extends AbstractSysDicTag {

	/** 如果选择的值不存在怎么显示 */
	private String allowOuter = "false";
	private String outerName = "";

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
		boolean isChoosedValOut = true;
		if (dicList == null || dicList.size() <= 0) {
			html = "";
		} else {
			StringBuffer sb = new StringBuffer();
			for (SysDic sysDictionary : dicList) {
				List<String> selectedOpt = new ArrayList<String>();
				if (!AppTool.isNullStr(this.dicValue)) {
					Collections.addAll(selectedOpt, dicValue.split(","));
				}
				String choosedStr = "";
				if (selectedOpt.contains(sysDictionary.getKey())) {
					choosedStr = " selected='selected' ";
					isChoosedValOut = false;
				}
				sb.append("<option value='" + sysDictionary.getKey() + "'"
						+ choosedStr + ">" + sysDictionary.getValue()
						+ "</option>");
			}
			if (isChoosedValOut && "true".equals(allowOuter)) {
				if (outerName.indexOf("**dicValue**") >= 0) {
					outerName = outerName.replace("**dicValue**", dicValue);
				}
				sb.append("<option value='" + dicValue + "'"
						+ " selected='selected' " + ">" + outerName
						+ "</option>");
			}
			html = sb.toString();
		}
		try {
			out.println(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setAllowOuter(String allowOuter) {
		this.allowOuter = allowOuter;
	}

	public void setOuterName(String outerName) {
		this.outerName = outerName;
	}

}
