package com.kaifantech.util.constant.pi.detail;

public class Area {
	private int leftXaxis;
	private int rightXaxis;
	private int downYaxis;
	private int upYaxis;

	public Area(int leftXaxis, int rightXaxis, int downYaxis, int upYaxis) {
		this.leftXaxis = leftXaxis;
		this.rightXaxis = rightXaxis;
		this.downYaxis = downYaxis;
		this.upYaxis = upYaxis;
	}

	public Area() {
	}

	public int getLeftXaxis() {
		return leftXaxis;
	}

	public void setLeftXaxis(int leftXaxis) {
		this.leftXaxis = leftXaxis;
	}

	public int getRightXaxis() {
		return rightXaxis;
	}

	public void setRightXaxis(int rightXaxis) {
		this.rightXaxis = rightXaxis;
	}

	public int getDownYaxis() {
		return downYaxis;
	}

	public void setDownYaxis(int downYaxis) {
		this.downYaxis = downYaxis;
	}

	public int getUpYaxis() {
		return upYaxis;
	}

	public void setUpYaxis(int upYaxis) {
		this.upYaxis = upYaxis;
	}

}
