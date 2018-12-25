package com.ytgrading.dto;

public class EmailAddress {
	private Integer id;
	private String email_suffix;
	private String email_login_address;
	private String belong_company;
	public synchronized Integer getId() {
		return id;
	}
	public synchronized void setId(Integer id) {
		this.id = id;
	}
	public synchronized String getEmail_suffix() {
		return email_suffix;
	}
	public synchronized void setEmail_suffix(String email_suffix) {
		this.email_suffix = email_suffix;
	}
	public synchronized String getEmail_login_address() {
		return email_login_address;
	}
	public synchronized void setEmail_login_address(String email_login_address) {
		this.email_login_address = email_login_address;
	}
	public synchronized String getBelong_company() {
		return belong_company;
	}
	public synchronized void setBelong_company(String belong_company) {
		this.belong_company = belong_company;
	}
}
