package com.kaifantech.util.constants.plc;

public class PlcParamBean {
	private String allow;
	private String type;
	private String agvLayer;
	private String window;
	private String windowLayer;
	private String robot;
	private String fork;
	private String frame;
	private String piece;

	private boolean fillZero = true;

	public PlcParamBean(String allow) {
		this.allow = allow;
	}

	public String getType() {
		return type;
	}

	public PlcParamBean setType(String type) {
		this.type = type;
		return this;
	}

	public String getAgvLayer() {
		return agvLayer;
	}

	public PlcParamBean setAgvLayer(String agvLayer) {
		this.agvLayer = agvLayer;
		return this;
	}

	public String getWindow() {
		return window;
	}

	public PlcParamBean setWindow(String window) {
		this.window = window;
		return this;
	}

	public String getWindowLayer() {
		return windowLayer;
	}

	public PlcParamBean setWindowLayer(String windowLayer) {
		this.windowLayer = windowLayer;
		return this;
	}

	public String getRobot() {
		return robot;
	}

	public PlcParamBean setRobot(String robot) {
		this.robot = robot;
		return this;
	}

	public String getFork() {
		return fork;
	}

	public PlcParamBean setFork(String fork) {
		this.fork = fork;
		return this;
	}

	public String getFrame() {
		return frame;
	}

	public PlcParamBean setFrame(String frame) {
		this.frame = frame;
		return this;
	}

	public String getPiece() {
		return piece;
	}

	public PlcParamBean setPiece(String piece) {
		this.piece = piece;
		return this;
	}

	public boolean isFillZero() {
		return fillZero;
	}

	public PlcParamBean setFillZero(boolean fillZero) {
		this.fillZero = fillZero;
		return this;
	}

	public String getAllow() {
		return allow;
	}

	public void setAllow(String allow) {
		this.allow = allow;
	}

}
