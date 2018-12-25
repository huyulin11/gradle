package com.kaifantech.component.service.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.kaifantech.component.dao.de.DeWmsResponseDao;
import com.kaifantech.init.sys.SystemURL;
import com.kaifantech.util.log.AppFileLogger;
import com.kaifantech.util.thread.ThreadTool;

@Component
public class WmsRestService {

	@Autowired
	private DeWmsResponseDao dao;

	public static WmsRestService one = new WmsRestService();

	public synchronized static String load(String url, String query) throws Exception {
		URL restURL = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		conn.setDoOutput(true);
		conn.setAllowUserInteraction(false);
		PrintStream ps = new PrintStream(conn.getOutputStream());
		ps.print(query);
		ps.close();
		BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line, resultStr = "";
		while (null != (line = bReader.readLine())) {
			resultStr += line;
		}
		AppFileLogger.wmsInfo("WMS反馈消息---" + resultStr);
		bReader.close();
		return resultStr;
	}

	public void sendToWms(String jsonStr) {
		try {
			String response = WmsRestService.load(SystemURL.MSG_TO_WMS, jsonStr);
			JSONObject json = JSONObject.parseObject(response);
			if (!json.get("Success").equals("true")) {
				ThreadTool.sleep(5000);
				sendToWms(jsonStr);
			}
			dao.add(jsonStr, response);
		} catch (Exception e) {
			dao.add(jsonStr, e.getMessage());
			AppFileLogger.wmsErr(e.getMessage() + "同步消息到WMS失败，内容" + jsonStr);
		}
	}

	public String logToWms(String jsonStr) {
		try {
			return WmsRestService.load(SystemURL.LOG_TO_WMS, jsonStr);
		} catch (Exception e) {
			return null;
		}
	}

	public void receiptErrToWms(String jsonStr) {
		try {
			String response = WmsRestService.load(SystemURL.RECEIPT_ERR_TO_WMS, jsonStr);
			JSONObject json = JSONObject.parseObject(response);
			if (!json.get("Success").equals("true")) {
				ThreadTool.sleep(5000);
				receiptErrToWms(jsonStr);
			}
			dao.add(jsonStr, response);
		} catch (Exception e) {
			dao.add(jsonStr, e.getMessage());
			AppFileLogger.wmsErr(e.getMessage() + "同步入库错误消息到WMS失败，内容" + jsonStr);
			ThreadTool.sleep(5000);
			receiptErrToWms(jsonStr);
		}
	}

	public String inventoryResultToWms(String jsonStr) {
		try {
			return WmsRestService.load(SystemURL.INVENTORY_RESULT_TO_WMS, jsonStr);
		} catch (Exception e) {
			AppFileLogger.wmsErr(e.getMessage() + "同步盘点数据到WMS失败，内容" + jsonStr);
			return null;
		}
	}

	public static void main(String[] args) {
		try {
			while (true) {
				String tosend = "{\"PaperId\":\"122333333\",\"ItemList\": [" + "{\"AllocInfo\":\"02-02-02-03\"},"
						+ "{\"AllocInfo\":\"02-02-02-04\"},{\"AllocInfo\":\"02-02-02-06\"}" + "]}";
				WmsRestService.load(SystemURL.RECEIPT_ERR_TO_WMS, tosend);
				// WmsRestService.one.receiptErrToWms(tosend);
				ThreadTool.sleepOneSecond();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
