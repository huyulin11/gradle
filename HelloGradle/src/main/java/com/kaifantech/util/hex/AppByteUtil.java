package com.kaifantech.util.hex;

import com.ytgrading.util.AppTool;

import io.netty.buffer.ByteBuf;

//字节的转换  
public class AppByteUtil {
	// 将字节数组转换为short类型，即统计字符串长度
	public static short bytes2Short2(byte[] b) {
		short i = (short) (b[0] & 0xff);
		return i;
	}

	public static int charToHex(char c) {
		int k = 0;
		if (c >= '0' && c <= '9') {
			k = c - '0';
		} else if (c >= 'A' && c <= 'F') {
			k = c - 'A' + 10;
		} else if (c >= 'a' && c <= 'f') {
			k = c - 'a' + 10;
		} else {
			return -1;
		}
		return k;
	}

	// 将字节数组转换为16进制字符串
	public static String BinaryToHexString(byte[] bytes) {
		String hexStr = "0123456789ABCDEF";
		String result = "";
		String hex = "";
		for (byte b : bytes) {
			hex = String.valueOf(hexStr.charAt((b & 0xF0) >> 4));
			hex += String.valueOf(hexStr.charAt(b & 0x0F));
			result += hex + " ";
		}
		return result;
	}

	public static String int2Str4(int i) {
		if (i >= 256 * 256 || i < 0) {
			return null;
		}
		int pre = i % 256;
		int suf = i / 256 % 256;
		return String.format("%2s", String.format("%x", pre)).replaceAll("\\s", "0")
				+ String.format("%2s", String.format("%x", suf)).replaceAll("\\s", "0");
	}

	public static String int2Str2(int i) {
		int pre = i % 256;
		return String.format("%2s", String.format("%x", pre)).replaceAll("\\s", "0");
	}

	public static String int2Str4Reverse(int i) {
		if (i >= 256 * 256 || i < 0) {
			return null;
		}
		int pre = i % 256;
		int suf = i / 256 % 256;
		return String.format("%2s", String.format("%x", suf)).replaceAll("\\s", "0")
				+ String.format("%2s", String.format("%x", pre)).replaceAll("\\s", "0");
	}

	public static Integer str42IntReverse(String s) {
		if (s.length() != 4) {
			return null;
		}
		return hexStringToInt(s.substring(2, 4) + s.substring(0, 2));
	}

	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		// toUpperCase将字符串中的所有字符转换为大写
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		// toCharArray将此字符串转换为一个新的字符数组。
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	// charToByte返回在指定字符的第一个发生的字符串中的索引，即返回匹配字符
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	public static String getHexStrFrom(ByteBuf in) {
		byte[] bytes = new byte[in.readableBytes()];
		in.readBytes(bytes);
		String s = BinaryToHexString(bytes);
		if (!AppTool.isNull(s.trim())) {
			s = s.replaceAll(" ", "");
		}
		return s;
	}

	public static int bytesToInt(byte[] src, int offset) {
		int length = src.length;
		int value = 0x00;
		for (int i = 0; i < length; i++) {
			value = ((src[i] & 0xFF) << ((length - i - 1) * 8)) | value;
		}
		return value;
	}

	public static int hexStringToInt(String hexString) {
		byte[] bs = hexStringToBytes(hexString);
		int val = bytesToInt(bs, 0);
		return val;
	}

	public static double hex4StringToPoint2(String hexString) {
		if (hexString.length() != 4) {
			return 0.0;
		}
		int val1 = hexStringToInt(hexString.substring(0, 2));
		int val2 = hexStringToInt(hexString.substring(2, 4));

		return val1 + ((double) (val2) / 10);
	}

	public static void main(String[] args) {
		String msg = "0000000200040007";
		String newMsg = "";
		for (int i = 0; i < msg.length(); i = i + 4) {
			String s = msg.substring(i, i + 4);
			newMsg = newMsg + "-" + AppByteUtil.hexStringToInt(s);
		}
		System.out.println(newMsg);
	}
}