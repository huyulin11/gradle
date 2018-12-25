package com.kaifantech.bean.info.agv;

public class AGVBeanWithLocation extends AgvBean {
	private Integer gotIt;
	private int nextXaxis;
	private int nextLocation;
	private int currentLocation;
	private int currentXaxis;
	private int inCurrentXaxis;
	private int lastXaxis;

	public Integer getGotIt() {
		return gotIt;
	}

	public void setGotIt(Integer gotIt) {
		this.gotIt = gotIt;
	}

	public int getNextXaxis() {
		return nextXaxis;
	}

	public void setNextXaxis(int nextXaxis) {
		this.nextXaxis = nextXaxis;
	}

	public int getCurrentXaxis() {
		return currentXaxis;
	}

	public void setCurrentXaxis(int currentXaxis) {
		this.currentXaxis = currentXaxis;
	}

	public int getLastXaxis() {
		return lastXaxis;
	}

	public void setLastXaxis(int lastXaxis) {
		this.lastXaxis = lastXaxis;
	}

	public int getInCurrentXaxis() {
		return inCurrentXaxis;
	}

	public void setInCurrentXaxis(int inCurrentXaxis) {
		this.inCurrentXaxis = inCurrentXaxis;
	}

	public int getNextLocation() {
		return nextLocation;
	}

	public void setNextLocation(int nextLocation) {
		this.nextLocation = nextLocation;
	}

	public int getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(int currentLocation) {
		this.currentLocation = currentLocation;
	}
}
