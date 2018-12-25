package com.ytgrading.bean.wxxcx;

import java.util.Date;

public class WxUserInfo {
	private String nickName;
	private int gender;//性别 0：未知、1：男、2：女 
	private String country;
	private String province;
	private String city;
	private String language;
	private String avatarUrl;
	private Date firstLandingTime;
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public Date getFirstLandingTime() {
		return firstLandingTime;
	}
	public void setFirstLandingTime(Date firstLandingTime) {
		this.firstLandingTime = firstLandingTime;
	}
	
	
}
