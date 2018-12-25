package com.ytgrading.util;


import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Pageable implements Serializable {

	private int pageSize;

	private int page; //

	private List<?> data; //

	private int length; //

	public Pageable() {

	}

	public Pageable(int page, int pageSize, int length, List<?> data) {
		this.page = page;
		this.pageSize = pageSize;
		this.length = length;
		this.data = data;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<?> getData() {
		return data;
	}

	public int getLength() {
		return length;
	}

	public int getPage() {
		return page;
	}

	public int getPageSize() {
		return pageSize;
	}
	/**
	 * 总页数
	 * @return
	 */
	public int getTotalPage() {
		return (length + pageSize - 1) / pageSize;
	}
}