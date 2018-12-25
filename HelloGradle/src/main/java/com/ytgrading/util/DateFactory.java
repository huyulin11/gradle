package com.ytgrading.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFactory {
	private static int addedHours = 0;

	/** 服务器时间比正常使用时间晚了八小时 */
	public static Date getNowDate() {
		return new Date(System.currentTimeMillis() + addedHours * 3600 * 1000);
	}

	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * 
	 * @return String
	 */
	public static String getCurrTime() {
		Date now = new Date(System.currentTimeMillis() + addedHours * 3600 * 1000);
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}

	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * 
	 * @return String
	 */
	public static String getTodaysTime() {
		Date now = new Date(System.currentTimeMillis() + addedHours * 3600 * 1000);
		SimpleDateFormat outFormat = new SimpleDateFormat("HHmmss");
		String s = outFormat.format(now);
		return s;
	}

	/**
	 * 获取当前时间 yyyyMMdd
	 * 
	 * @return String
	 */
	public static String getCurrDate() {
		Date now = new Date(System.currentTimeMillis() + addedHours * 3600 * 1000);
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMdd");
		String s = outFormat.format(now);
		return s;
	}

	/**
	 * 获取当前时间 yyyyMMdd
	 * 
	 * @return String
	 */
	public static String getNextDate() {
		Date now = new Date(System.currentTimeMillis() + 24 * 3600 * 1000);
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMdd");
		String s = outFormat.format(now);
		return s;
	}

	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * 
	 * @return String
	 */
	public static String getCurrTime(String format) {
		String tmpFormat = "yyyy-MM-dd HH:mm:ss(SSS)";
		if (!AppTool.isNullStr(format)) {
			tmpFormat = format;
		}
		Date now = new Date(System.currentTimeMillis() + addedHours * 3600 * 1000);
		SimpleDateFormat outFormat = new SimpleDateFormat(tmpFormat);
		String s = outFormat.format(now);
		return s;
	}

	/**
	 * 获取当前日期 yyyyMMdd
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String strDate = formatter.format(date);
		return strDate;
	}

	/**
	 * 取出一个指定长度大小的随机正整数.
	 * 
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}

	/**
	 * 获取unix时间，从1970-01-01 00:00:00开始的秒数
	 * 
	 * @param date
	 * @return long
	 */
	public static long getUnixTime(Date date) {
		if (null == date) {
			return 0;
		}

		return date.getTime() / 1000;
	}

	/**
	 * 获取unix时间，从1970-01-01 00:00:00开始的秒数
	 * 
	 * @param date
	 * @return long
	 */
	public static long getCurrentUnixTime() {
		Date date = new Date(System.currentTimeMillis() + addedHours * 3600 * 1000);
		return getUnixTime(date);
	}

	/**
	 * 时间转换成字符串
	 * 
	 * @param date
	 *            时间
	 * @param formatType
	 *            格式化类型
	 * @return String
	 */
	public static String date2String(Date date, String formatType) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);
		return sdf.format(date);
	}

	/**
	 * 时间转换成字符串
	 * 
	 * @param date
	 *            时间
	 * @param formatType
	 *            格式化类型
	 * @return String
	 */
	public static String currentDate2String(String formatType) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);
		return sdf.format(getNowDate());
	}

}
