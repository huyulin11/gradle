package com.kaifantech.component.service.json.open;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kaifantech.util.json.JsonUtil;
import com.ytgrading.util.AppTool;
import com.ytgrading.util.msg.AppMsg;

@Service
public class OpenApiService {
	public synchronized AppMsg cacheTask(JSONObject requestJson) {
		try {
			Map<String, Object> obj = JsonUtil.toMap(requestJson, true);
			if (AppTool.isNull(obj)) {
				return new AppMsg(-1, "数据不符合规范！");
			}
			return new AppMsg(0, "缓存成功！");
		} catch (Exception e) {
			return new AppMsg(-1, "处理过程中出现错误！" + e.getMessage());
		}
	}
}
