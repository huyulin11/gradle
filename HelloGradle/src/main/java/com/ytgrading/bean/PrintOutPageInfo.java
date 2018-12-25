package com.ytgrading.bean;

public class PrintOutPageInfo {
	private int thisPageConCoin;//本页国家的币数量
	private String country; //国别
	private String requestCode;  //申请单号
	private String startCoincode; //打印开始编号  001
	private String endCoincode;  //打印结束编号  030
	private int coinNum;  //打印数量
	private String startPosition; //打印起始位置
	private int nowPage;  //当前页码
	private int pageCount;  //总页数
	private int startPositionNum;
	private String realEndCoincode;
	private String XSeat; //x轴位置 
	private String YSeat; //y轴位置
	public String getXSeat() {
		return XSeat;
	}
	public void setXSeat(String xSeat) {
		XSeat = xSeat;
	}
	public String getYSeat() {
		return YSeat;
	}
	public void setYSeat(String ySeat) {
		YSeat = ySeat;
	}
	public int getThisPageConCoin() {
		return thisPageConCoin;
	}
	public void setThisPageConCoin(int thisPageConCoin) {
		this.thisPageConCoin = thisPageConCoin;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRealEndCoincode() {
		return realEndCoincode;
	}
	public void setRealEndCoincode(String realEndCoincode) {
		this.realEndCoincode = realEndCoincode;
	}
	public int getStartPositionNum() {
		return startPositionNum;
	}
	public void setStartPositionNum(int startPositionNum) {
		this.startPositionNum = startPositionNum;
	}
	public String getRequestCode() {
		return requestCode;
	}
	public void setRequestCode(String requestCode) {
		this.requestCode = requestCode;
	}
	public String getStartCoincode() {
		return startCoincode;
	}
	public void setStartCoincode(String startCoincode) {
		this.startCoincode = startCoincode;
	}
	public String getEndCoincode() {
		return endCoincode;
	}
	public void setEndCoincode(String endCoincode) {
		this.endCoincode = endCoincode;
	}
	public int getCoinNum() {
		return coinNum;
	}
	public void setCoinNum(int coinNum) {
		this.coinNum = coinNum;
	}
	public String getStartPosition() {
		return startPosition;
	}
	public void setStartPosition(String startPosition) {
		this.startPosition = startPosition;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
