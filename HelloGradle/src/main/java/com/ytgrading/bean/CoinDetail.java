package com.ytgrading.bean;

public class CoinDetail {
	/**
	 * 流水线中钱币编号（申请单号+序号）
	 */
	private String number;
	/**
	 * 组合在一起的字符串
	 */
	private String detailstr;
	/**
	 * 钱币分数
	 */
	private int score;
	/**
	 * 钱币图片地址
	 */
	private String url;
	public CoinDetail(String number, String detailstr, int score, String url) {
		super();
		this.number = number;
		this.detailstr = detailstr;
		this.score = score;
		this.url = url;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDetailstr() {
		return detailstr;
	}
	public void setDetailstr(String detailstr) {
		this.detailstr = detailstr;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
