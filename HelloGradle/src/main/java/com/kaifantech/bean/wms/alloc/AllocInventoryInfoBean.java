package com.kaifantech.bean.wms.alloc;

import com.ytgrading.util.AppTool;

public class AllocInventoryInfoBean {
	private Integer line;
	private Integer frame;
	private Integer column;
	private Integer grid;
	private Integer siteid;

	public AllocInventoryInfoBean() {
	}

	public AllocInventoryInfoBean(String allocColumn) {
		if (AppTool.isNull(allocColumn) || allocColumn.length() < 8) {
			return;
		}
		line = Integer.parseInt(allocColumn.substring(0, 2));
		frame = Integer.parseInt(allocColumn.substring(3, 5));
		column = Integer.parseInt(allocColumn.substring(6, 8));
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public Integer getFrame() {
		return frame;
	}

	public void setFrame(Integer frame) {
		this.frame = frame;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	public Integer getGrid() {
		return grid;
	}

	public void setGrid(Integer grid) {
		this.grid = grid;
	}

	public Integer getSiteid() {
		return siteid;
	}

	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
	}

	public String toString() {
		return "" + line + "-" + frame + "-" + column + "-" + grid;
	}
}
