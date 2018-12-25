package com.ytgrading.dto;

public class RequestReasonData {
	private String requestid;
	private String requestcoinid;
	private Integer netreasoncode;
	public String getRequestid() {
		return requestid;
	}
	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}
	public String getRequestcoinid() {
		return requestcoinid;
	}
	public void setRequestcoinid(String requestcoinid) {
		this.requestcoinid = requestcoinid;
	}
	public Integer getNetreasoncode() {
		return netreasoncode;
	}
	public void setNetreasoncode(Integer netreasoncode) {
		this.netreasoncode = netreasoncode;
	}
}
