package com.ytgrading.bean;

/** 分页基本类 */
public class PageTurning {
	private Integer page;
	private Integer pageSize;
	private Integer startRow;

	public Integer getPage() {
		if (page == null || page == 0) {
			page = 1;
		}
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		if (pageSize == null || pageSize == 0) {
			pageSize = 100;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStartRow() {
		if (startRow == null) {
			startRow = 0;
		}
		startRow = getPageSize() * (getPage() - 1);
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

}
