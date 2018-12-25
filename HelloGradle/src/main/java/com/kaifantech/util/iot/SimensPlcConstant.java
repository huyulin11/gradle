package com.kaifantech.util.iot;

import com.kaifantech.util.hex.AppByteUtil;

public class SimensPlcConstant {
	public static final String PLC_READ_CMD = "0203" + "001A" + "0018";

	/** 6个元器件，12个字节 */
	public static final String PLC_SEND_CMD_PREFIX = "0210" + "0000" + "0008" + "10";
	public static final String PLC_SEND_CMD_PREFIX4 = "0210" + "0000" + "0004" + "08";

	public static String getCRC(String innerCmd) {
		String crcCheck = String.format("%04x", CRC.calcCrc16(AppByteUtil.hexStringToBytes(innerCmd)));
		return crcCheck.substring(2, 4) + crcCheck.substring(0, 2);
	}
}
