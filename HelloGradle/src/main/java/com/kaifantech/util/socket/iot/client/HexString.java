package com.kaifantech.util.socket.iot.client;

public class HexString {
	public static byte[] toHex(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return baKeyword;
	}

	public static String toString(byte[] baKeyword) {
		String s = "";
		try {
			s = new String(baKeyword, "utf-8");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(toHex(RoboticArmMsgStr.I_COMMAND_FROM_LAP1));
	}
}