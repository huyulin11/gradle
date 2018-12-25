package com.kaifantech.util.json;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.ytgrading.util.AppTool;

public class JsonUtil {
	@SuppressWarnings("unchecked")
	public static Map<String, Object> toMap(JSONObject requestJson, boolean notNull) {
		Map<String, Object> obj = new HashMap<>();
		for (String key : requestJson.keySet()) {
			int index1 = key.indexOf('[');
			int index2 = key.indexOf(']');
			if (!AppTool.isNull(key)) {
				if (index1 > 0 && index2 > index1) {
					if (notNull && AppTool.isNull(requestJson.getString(key))) {
						return null;
					}
					String index = key.substring(index1 + 1, index2);
					Map<String, String> map = (Map<String, String>) obj.get(index);
					if (AppTool.isNull(map)) {
						map = new HashMap<>();
					}
					map.put(key.substring(0, index1), requestJson.getString(key));
					obj.put(index, map);
				} else if (index1 < 0 && index2 < 0) {
					obj.put(key, requestJson.getString(key));
				}
			} else {
				continue;
			}
		}
		return obj;
	}
}
