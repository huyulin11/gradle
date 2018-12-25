package com.kaifantech.util.constant.pi.detail;

import java.util.ArrayList;
import java.util.List;

public class ClashArea extends Area {

	private List<Area> addedAreaList = new ArrayList<>();

	public ClashArea(Area centerArea, int warningXDistance, int warningYDistance, List<Area> addedAreaList) {
		this.setLeftXaxis(centerArea.getLeftXaxis() - warningXDistance);
		this.setRightXaxis(centerArea.getRightXaxis() + warningXDistance);
		this.setDownYaxis(centerArea.getDownYaxis() - warningYDistance);
		this.setUpYaxis(centerArea.getUpYaxis() + warningYDistance);
		this.setAddedAreaList(addedAreaList);
	}

	public ClashArea(Area centerArea, int warningXDistance, int warningYDistance) {
		this.setLeftXaxis(centerArea.getLeftXaxis() - warningXDistance);
		this.setRightXaxis(centerArea.getRightXaxis() + warningXDistance);
		this.setDownYaxis(centerArea.getDownYaxis() - warningYDistance);
		this.setUpYaxis(centerArea.getUpYaxis() + warningYDistance);
	}

	public ClashArea(Area centerArea) {
		this.setLeftXaxis(centerArea.getLeftXaxis());
		this.setRightXaxis(centerArea.getRightXaxis());
		this.setDownYaxis(centerArea.getDownYaxis());
		this.setUpYaxis(centerArea.getUpYaxis());
	}

	public List<Area> getAddedAreaList() {
		return addedAreaList;
	}

	private void setAddedAreaList(List<Area> addedAreaList) {
		this.addedAreaList = addedAreaList;
	}

	public ClashArea addLeftXaxis(int addedXaxis) {
		this.setLeftXaxis(this.getLeftXaxis() + addedXaxis);
		return this;
	}

	public ClashArea addRightXaxis(int addedXaxis) {
		this.setRightXaxis(this.getRightXaxis() + addedXaxis);
		return this;
	}

	public ClashArea addDownYaxis(int addedXaxis) {
		this.setDownYaxis(this.getDownYaxis() + addedXaxis);
		return this;
	}

	public ClashArea addUpYaxis(int addedXaxis) {
		this.setUpYaxis(this.getUpYaxis() + addedXaxis);
		return this;
	}
}
