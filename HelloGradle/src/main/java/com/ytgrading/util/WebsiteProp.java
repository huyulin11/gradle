package com.ytgrading.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** 系统配置文件管理类 */
public class WebsiteProp {

	private static Properties websiteProperty;

	private static Properties imgProperty;

	private static Properties smsProperty;

	private static Properties wmsProperty;

	private static Properties init(String prop) {
		Properties tmpProperty = new Properties();
		InputStream in = WebsiteProp.class.getResourceAsStream(prop);
		tmpProperty = new Properties();
		try {
			tmpProperty.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tmpProperty;
	}

	public static String get(String key) {
		if (websiteProperty == null || websiteProperty.isEmpty()) {
			websiteProperty = init("/content/website.properties");
		}
		String value = websiteProperty.getProperty(key);
		if (AppTool.isNullStr(value)) {
			return "";
		}
		return value;
	}

	public static Properties getIMGProp() {
		if (imgProperty == null || imgProperty.isEmpty()) {
			imgProperty = init("/content/IMGPath.properties");
		}
		return imgProperty;

	}

	public static Properties getSMSProp() {
		if (smsProperty == null || smsProperty.isEmpty()) {
			smsProperty = init("/content/SMS.properties");
		}
		return smsProperty;

	}

	public static Properties getWMSProp() {
		if (wmsProperty == null || wmsProperty.isEmpty()) {
			wmsProperty = init("/content/wms.properties");
		}
		return wmsProperty;

	}

	public static void main(String[] args) {
		System.out.println(WebsiteProp.getWMSProp().getProperty(
				"URL_FROM_YTERP_TO_WMS"));
	}
}
