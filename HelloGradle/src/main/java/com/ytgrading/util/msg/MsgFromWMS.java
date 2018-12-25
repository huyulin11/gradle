package com.ytgrading.util.msg;

import net.sf.json.JSONObject;

import com.ytgrading.util.AppTool;

/** ERP与WMS系统数据交互时反馈交互情况的载体 */
public class MsgFromWMS {

	private String Success;

	private String Code;

	private String Description;

	public MsgFromWMS(String success, String code, String description) {
		this.Code = code;
		this.Success = success;
		this.Description = description;
	}

	public MsgFromWMS(MsgFromWMS msg) {
		this.Code = msg.Code;
		this.Success = msg.Success;
		this.Description = msg.Description;
	}

	public MsgFromWMS(AppMsg msg) {
		this.Code = msg.getCode() >= 0 ? "200" : "-1";
		this.Success = msg.getCode() >= 0 ? "true" : "false";
		this.Description = msg.getMsg();
	}

	public MsgFromWMS newMsg(String addedInfo) {
		MsgFromWMS msg = new MsgFromWMS(this);
		msg.Code = this.Code;
		msg.Success = this.Success;
		msg.Description = this.Description + (AppTool.isNull(addedInfo) ? "" : addedInfo);
		return msg;
	}

	public String isSuccess() {
		return Success;
	}

	public void setSuccess(String success) {
		this.Success = success;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public MsgFromWMS() {
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		this.Code = code;
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("Success", Success);
		json.put("Code", Code);
		json.put("Description", Description);
		return json;
	}

	public com.alibaba.fastjson.JSONObject toAlbbJson() {
		com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
		json.put("Success", Success);
		json.put("Code", Code);
		json.put("Description", Description);
		return json;
	}

	public String toString() {
		return this.toJson().toString();
	}

	public static MsgFromWMS fromJson(JSONObject json) {
		if (json.isEmpty()) {
			return new MsgFromWMS();
		}
		MsgFromWMS msgFromWMS = new MsgFromWMS();
		try {
			msgFromWMS.setSuccess(
					AppTool.isNullStr(json.optString("Success")) ? json.optString("Success") : json.optString("Success"));
			msgFromWMS
					.setCode(AppTool.isNullStr(json.optString("Code")) ? json.optString("Code") : json.optString("Code"));
			msgFromWMS.setDescription(AppTool.isNullStr(json.optString("Description")) ? json.optString("Description")
					: json.optString("Description"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msgFromWMS;
	}
}