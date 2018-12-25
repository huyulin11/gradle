package com.ytgrading.tags;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ytgrading.util.AppTool;

public class DBDataTagTool {

	public String doTagTool(List<Map<String, Object>> query, String msg) {
		StringBuffer sb = new StringBuffer();
		if (!query.isEmpty()) {
			sb.append("<tr class='行0'>");
			for (Entry<String, Object> entry : query.get(0).entrySet()) {
				sb.append("<th class='" + entry.getKey() + "'>"
						+ entry.getKey() + "</th>");
			}
			sb.append("</tr>");
			int n = 1;
			for (Map<String, Object> map : query) {
				sb.append("<tr class='行" + n + "'>");
				for (Entry<String, Object> entry : map.entrySet()) {
					sb.append("<td class='"
							+ entry.getKey()
							+ "'>"
							+ (AppTool.isNull(entry.getValue()) ? "" : entry
									.getValue()) + "</td>");
				}
				sb.append("</tr>");
				n++;
			}
		} else {
			sb.append("<span class='str'>未查到符合数据</span>");
		}
		String html = new StringBuffer("<table id='dataTable'>" + "<caption>"
				+ msg + "</caption>").append(sb).append("</table>").toString();
		return html;
	}

}
