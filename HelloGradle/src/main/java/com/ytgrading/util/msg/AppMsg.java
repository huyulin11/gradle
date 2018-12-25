package com.ytgrading.util.msg;

import com.ytgrading.util.AppTool;

import net.sf.json.JSONObject;

public class AppMsg {
	private Integer code;
	private String msg;
	private boolean isSuccess = false;
	private Object object;

	public AppMsg() {
	}

	public AppMsg(MsgFromWMS msgFromWMS) {
	}

	public static AppMsg success() {
		AppMsg msg = new AppMsg();
		msg.setSuccess(true);
		msg.setCode(1);
		return msg;
	}

	public static AppMsg fail() {
		AppMsg msg = new AppMsg();
		msg.setSuccess(false);
		msg.setCode(-1);
		return msg;
	}

	public AppMsg(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
		setSuccess(code >= 0);
	}

	public Integer getCode() {
		return code;
	}

	public AppMsg setCode(Integer code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public AppMsg setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("msg", msg);
		return json;
	}

	public String toString() {
		return (!AppTool.isNull(code) ? "code：" + code : "") + (!AppTool.isNull(msg) ? "msg：" + msg : "");
	}

	public com.alibaba.fastjson.JSONObject toAlbbJson() {
		com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
		json.put("code", code);
		json.put("msg", msg);
		return json;
	}

	public Object getObject() {
		return object;
	}

	public AppMsg setObject(Object object) {
		this.object = object;
		return this;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public AppMsg setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
		return this;
	}
}