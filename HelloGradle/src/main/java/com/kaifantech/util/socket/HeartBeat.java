package com.kaifantech.util.socket;

public class HeartBeat {
	private boolean isSendHeartBeat = true;
	private boolean isHeartBeatHex = false;
	private String heartBeatStr = "";
	private int heartBeatInterval = 2000;

	private HeartBeat() {
	}

	public String getHeartBeatStr() {
		return heartBeatStr;
	}

	public HeartBeat setHeartBeatStr(String heartBeatStr) {
		this.heartBeatStr = heartBeatStr;
		return this;
	}

	public boolean isSendHeartBeat() {
		return isSendHeartBeat;
	}

	public HeartBeat setSendHeartBeat(boolean isSendHeartBeat) {
		this.isSendHeartBeat = isSendHeartBeat;
		return this;
	}

	public boolean isHeartBeatHex() {
		return isHeartBeatHex;
	}

	public HeartBeat setHeartBeatHex(boolean isHeartBeatHex) {
		this.isHeartBeatHex = isHeartBeatHex;
		return this;
	}

	public int getHeartBeatInterval() {
		return heartBeatInterval;
	}

	public HeartBeat setHeartBeatInterval(int heartBeatInterval) {
		this.heartBeatInterval = heartBeatInterval;
		return this;
	}

	public static HeartBeat createOne() {
		return new HeartBeat().setHeartBeatStr("HEARTBEAT").setHeartBeatInterval(2000);
	}
}