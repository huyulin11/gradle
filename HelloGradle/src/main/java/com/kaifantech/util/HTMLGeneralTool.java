package com.kaifantech.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.kaifantech.bean.dic.SysDic;

public class HTMLGeneralTool {
	public static String getInputColumnStr(String inputtype, String chncolname,
			String columnname, boolean isaddmust, String dictype,
			List<SysDic> sysDictionaryList,boolean isNum,int maxLength ) {
		Map<String,Object> attributes = new HashMap<String,Object>();
		Map<Object,String> selectOptions = new HashMap<Object,String>() ;
		attributes.put("data-isNum",isNum);
		attributes.put("data-maxLength",maxLength);
		if ("BOOLEAN".equalsIgnoreCase(dictype)){
			selectOptions.put("请选择","");
			selectOptions.put("是","1");
			selectOptions.put("否","0");
		}
		return genFormTableRow(inputtype,columnname,chncolname,isaddmust,attributes,selectOptions);
	}
	
	public static String genFormTableRow(String inputtype, String name,String description,
			boolean isaddmust, Map<String,Object> attributes,
			Map<Object,String> selectOptions ) {
		StringBuffer html = new StringBuffer();
		if ("id".equals(name)){
			html.append("<tr class='hiddenThis' >\n");
		}else{
			html.append("<tr>\n");
		}
		html.append("\t<th>" + description
			+ 		((isaddmust) ? "<span class='red'>*</span>" : "") 
			+ 		"\t</th>\n" );
		html.append("\t<td>\n" );
		
		if ("TEXT".equalsIgnoreCase(inputtype)){
			html.append("\t\t<input type=\"TEXT\" ");
		}else if("SELECT".equalsIgnoreCase(inputtype)){
			html.append("\t\t<select ");
		}else if("TEXTAREA".equalsIgnoreCase(inputtype)){
			html.append("\t\t<textarea ");
		}/*else {
			throw new Exception( "<p>ERROR:Not support " + inputtype + " type." 
				+"Please check the inputtype column in sys_tables_maintain_info table</p>");
		}*/
		
		html.append("id='" + name + "' name='" + name + "' "
				+ ((isaddmust) ? " data-notNull='true' " : "" ) );
		if ( attributes != null && !attributes.isEmpty() ){
			Iterator<String> iter = attributes.keySet().iterator();
			while(iter.hasNext()){
				String key = iter.next();
				Object value = attributes.get(key);
				/*
				if ( value instanceof Boolean && value.equals(false)){
					; // do nothing
				}*/
				/* 后续补充：对DateTime类型的转换 */
				html.append(" " + key + "='" + value.toString() + "' ");
			}
		}
		if ("TEXT".equalsIgnoreCase(inputtype)){
			html.append(" />\n");
		}else if ("SELECT".equalsIgnoreCase(inputtype)){
			html.append(">");
			html.append("\t\t\t<option selected='selected'>请选择</option>\n");
			if ( selectOptions != null && !selectOptions.isEmpty()){
				Iterator<Object> iter = selectOptions.keySet().iterator();
				while(iter.hasNext()){
					Object value = iter.next();
					String text = selectOptions.get(value);
					if (value != null){ 
						html.append("\t\t\t<option value='"+ value +"'>"+ text +"</option>\n");
					}else{// 例如“请选择”
						html.append("\t\t\t<option>"+ text +"</option>\n");
					}
					
				}
			}
			html.append("</select>\n");
			
		}else if ("TEXTAREA".equalsIgnoreCase(inputtype)){ 
			html.append("></textarea>\n");
		}
		
		html.append("\t\t<span class=\"red\"></span>\n");
		html.append("\t</td>\n" + "</tr>\n");
		return html.toString();
	}
	/** 表单中SELECT输入的选择项 chnOrUsa：0-中文；1-英文；2-中英文； */
	public static String getOptionDetailForSelectByDicName(String dicType,
			String chnOrUsa, String defaultValue, String nullValue,
			List<SysDic> sysDictionaryList) {
		StringBuffer sb = new StringBuffer();
		boolean hasDefaultValue = false;
		for (SysDic sysDictionary : sysDictionaryList) {
			boolean isdefalut = sysDictionary.getKey().equals(defaultValue);
			if (isdefalut) {
				hasDefaultValue = true;
			}
			sb.append("<option value='"
					+ sysDictionary.getKey()
					+ "' "
					+ (isdefalut ? "selected='selected'" : "")
					+ ">"
					+ ("0".equals(chnOrUsa) ? sysDictionary.getValue() : ("1"
							.equals(chnOrUsa) ? sysDictionary.getValueUs()
							: sysDictionary.getValue()
									+ sysDictionary.getValueUs()))
					+ "</option>");
		}
		if (!hasDefaultValue) {
			String tmpNullValue = "请选择";
			if (nullValue != null && !"".equals(nullValue)) {
				tmpNullValue = nullValue;
			}
			sb = new StringBuffer("<option value='' selected='selected'>"
					+ tmpNullValue + "</option>").append(sb);
		}
		return sb.toString();
	}

	public static String getInputColumnStr(String inputtype, String chncolname,
			String columnname, String isaddmust, String dictype,
			List<SysDic> sysDictionaryList) {
		StringBuffer value = new StringBuffer();
		if ("TEXT".equals(inputtype)) {
			value.append("<tr>"
					+ "<th>"
					+ chncolname
					+ ("1".equals(isaddmust) ? "<span class='red'>*</span>"
							: "") + "</th>" + "<td>" + "<input id='"
					+ columnname + "' name='" + columnname + "'"
					+ ("1".equals(isaddmust) ? " class='mustnotnull' " : "")
					+ " type='" + inputtype + "' />" + "</td>" + "</tr>");
		} else if ("SELECT".equals(inputtype)) {
			value.append("<tr>"
					+ "<th>"
					+ chncolname
					+ ("1".equals(isaddmust) ? "<span class='red'>*</span>"
							: "")
					+ "</th>"
					+ "<td>"
					+ "<select id='"
					+ columnname
					+ "' name='"
					+ columnname
					+ "'"
					+ ("1".equals(isaddmust) ? " class='mustnotnull' " : "")
					+ " >"
					+ getOptionDetailForSelectByDicName(dictype, "0", null,
							null, sysDictionaryList) + "</select>" + "</td>"
					+ "</tr>");
		} else if ("TEXTAREA".equals(inputtype)) {
			value.append("<tr>"
					+ "<th>"
					+ chncolname
					+ ("1".equals(isaddmust) ? "<span class='red'>*</span>"
							: "") + "</th>" + "<td>" + "<textarea id='"
					+ columnname + "' name='" + columnname + "'"
					+ ("1".equals(isaddmust) ? " class='mustnotnull' " : "")
					+ " >" + "</textarea>" + "</td>" + "</tr>");
		}
		return value.toString();
	}
}
