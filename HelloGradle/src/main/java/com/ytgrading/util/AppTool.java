package com.ytgrading.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class AppTool {

	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-real-ip");
		if (AppTool.isNull(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List trimList(List list) {
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		for (int i = list.size() - 1; i >= 0; i--) {
			Object o = list.get(i);
			if (list1.indexOf(o) == -1) {
				list1.add(0, o);
				list2.add(i);
			}
		}
		return list2;
	}

	public static String listToString(List<?> list, char separator) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if (i < list.size() - 1) {
				sb.append(separator);
			}
		}
		return sb.toString();
	}

	/**
	 * 去除字符串最后一个逗号,若传入为空则返回空字符串
	 * 
	 * @descript
	 * @param para
	 * @return
	 * 
	 * @date 2015年3月29日
	 * @version 1.0
	 */
	public static String trimComma(String para) {
		if (StringUtils.isNotBlank(para)) {
			if (para.endsWith(",")) {
				return para.substring(0, para.length() - 1);
			} else {
				return para;
			}
		} else {
			return "";
		}
	}

	/**
	 * 金额格式化
	 * 
	 * @param getMoney
	 *            金额
	 * @return 格式后的金额
	 */
	public static String formatMoney(Double getMoney) {
		String balance = "0.00";
		DecimalFormat myformat = new DecimalFormat();
		myformat.applyPattern("##,###.00");
		if (null == getMoney || 0 == getMoney) {
			balance = "0.00";
		} else if (getMoney > 0 & getMoney < 1) {
			balance = "0" + myformat.format(getMoney);
		} else if (getMoney < 0 & getMoney > -1) {
			balance = "-0" + myformat.format(getMoney).substring(1);
		} else {
			balance = myformat.format(getMoney);
		}
		return balance;
	}

	/**
	 * 金额去掉“,”
	 * 
	 * @param s
	 *            金额
	 * @return 去掉“,”后的金额
	 */
	public static String delComma(String s) {
		String formatString = "";
		if (s != null && s.length() >= 1) {
			formatString = s.replaceAll(",", "");
		}
		return formatString;
	}

	public static String formatStr(String str) {
		if ("".equals(str)) {
			return str;
		} else if (str.startsWith("\"")) {
			return str;
		} else if (str.startsWith("[")) {
			str = str.substring(str.indexOf("[") + 1, str.lastIndexOf("]"));
			if (str.contains("\"\"")) {
				str = str.replace("\"\"", "%%");
			}
			str = str.replace("\"", "");
			str = str.replace("%%", "");
			return str;
		}
		return "";
	}

	/**
	 * 获取用户IP地址
	 * 
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static boolean isNullStr(String str) {
		if ("".equals(str) || null == str || " ".equals(str) || "undefined".equals(str)) {
			return true;
		}
		return false;
	}

	public static String v(Object obj) {
		if ("".equals(obj) || null == obj || " ".equals(obj) || "undefined".equals(obj)) {
			return "";
		}
		return obj.toString();
	}

	public static String v(String str) {
		if ("".equals(str) || null == str || " ".equals(str) || "undefined".equals(str)) {
			return "";
		}
		return str;
	}

	public static String v(Integer v) {
		if ("".equals(v) || null == v || " ".equals(v) || "undefined".equals(v)) {
			return "";
		}
		return v.toString();
	}

	public static boolean isNull(List<?> obj) {
		if (null == obj || obj.size() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isNull(Map<?, ?> obj) {
		if (null == obj || obj.size() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isNull(Object obj) {
		if (null == obj || "".equals(obj.toString())) {
			return true;
		}
		return false;
	}

	public static boolean ifAnd(boolean... ifs) {
		for (Boolean one : ifs) {
			if (!one) {
				return false;
			}
		}
		return true;
	}

	public static boolean ifOr(boolean... ifs) {
		for (Boolean one : ifs) {
			if (one) {
				return true;
			}
		}
		return false;
	}

	public static boolean isAllNull(Object... objs) {
		if (null == objs || "".equals(objs.toString())) {
			return true;
		}
		if (objs.length > 0) {
			for (Object obj : objs) {
				if (!isNull(obj)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isAnyNull(Object... objs) {
		if (null == objs || "".equals(objs.toString())) {
			return false;
		}
		if (objs.length > 0) {
			for (Object obj : objs) {
				if (isNull(obj)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isAnyNull(List<?>... objs) {
		if (null == objs) {
			return false;
		}
		if (objs.length > 0) {
			for (List<?> obj : objs) {
				if (isNull(obj)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean equals(Object obj, Object... objs) {
		if (null == objs || obj == null) {
			return false;
		}
		if (objs.length > 0) {
			for (Object tmp : objs) {
				if (obj.equals(tmp)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isEmpty(String s) {
		if (null == s || "".equals(s) || "".equals(s.trim()) || "null".equalsIgnoreCase(s)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 是否为整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric1(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	public static boolean isNullObj(Object obj) {
		if (null == obj || (obj instanceof String && "".equals(obj.toString()))) {
			return true;
		}
		return false;
	}

	public static BigDecimal strTobigDecimal(String str) {
		str = str.replace(",", "");
		return new BigDecimal(str);
	}

	public static void main(String[] args) throws ParseException {
		Integer id = 476;
		if (AppTool.equals(id, 474, 475, 476, 477, 478)) {
			System.out.println(1);
		}
	}

	/**
	 * 数字金额大写转换，思想先写个完整的然后将如零拾替换成零 要用到正则表达式
	 */
	public static String digitUppercase(BigDecimal m) {
		double n = m.doubleValue();
		String fraction[] = { "角", "分" };
		String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String unit[][] = { { "元", "万", "亿" }, { "", "拾", "佰", "仟" } };

		String head = n < 0 ? "负" : "";
		n = Math.abs(n);

		String s = "";
		for (int i = 0; i < fraction.length; i++) {
			s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");
		}
		if (s.length() < 1) {
			s = "整";
		}
		int integerPart = (int) Math.floor(n);

		for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
			String p = "";
			for (int j = 0; j < unit[1].length && n > 0; j++) {
				p = digit[integerPart % 10] + unit[1][j] + p;
				integerPart = integerPart / 10;
			}
			s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
		}
		return head + s.replaceAll("^(零.)+", "").replaceAll("(零.)*零元", "元").replaceAll("(零.)+", "零").replaceAll("^整$",
				"零元整");
	}
}
