package com.kaifantech.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.kaifantech.bean.dic.SysDic;
import com.ytgrading.util.AppTool;

/**
 * 分页标签
 * 
 */
public class SysDicValueTag extends AbstractSysDicTag {

	/** 如果选择的值不存在怎么显示 */
	private String allowOuter = "false";
	private String outerName = "";

	@Override
	public void doTag() throws JspException {
		JspWriter out = getJspContext().getOut();
		setComponent();

		String html = "";

		List<String> dicValArr = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;

			public String toString() {
				StringBuffer sb = new StringBuffer();
				for (String s : this) {
					sb.append("," + s);
				}
				if (this != null && this.size() > 0) {
					sb.deleteCharAt(0);
				}
				return sb.toString().trim();
			}
		};

		html = "";
		boolean isChoosedValOut = true;
		for (String dicKey : dicValue.split(",")) {
			List<SysDic> dicList;
			if ("COUNTRY".equals(dicType)) {
				dicList = getFromSysCountryList(sysCountryMapper
						.getAllCountry());
			} else {
				dicList = sysDicMapper.getSysDictionaries(new SysDic(
						dicType, dicKey));
			}
			if (dicList == null || dicList.size() != 1) {
			} else {
				isChoosedValOut = false;
				dicValArr.add(dicList.get(0).getValue());
			}
		}

		if (isChoosedValOut && "true".equals(allowOuter)
				&& !AppTool.isNullStr(dicValue)) {
			if (outerName.indexOf("**dicValue**") >= 0) {
				outerName = outerName.replace("**dicValue**", dicValue);
			}
			dicValArr.add(outerName);
		}

		html = dicValArr.toString();

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
