package com.ytgrading.bean;

public class Pay {
	private int test; // 提交地址
	private String Mer_code;//商户号
	private String Mer_key; // 商户证书
	private String Billno;//订单号
	private String Amount; // 金额
	private String DispAmount;//显示金额
	private String Date; // 日期
	private String Currency_Type;//支付币种
	private String Gateway_Type; // 支付方式
	private String Lang;//语言
	private String Merchanturl; // 支付成功返回URL
	private String FailUrl;//支付失败返回URL
	private String ErrorUrl; // 支付错误返回URL
	private String Attach; //商户附加数据包
	private String OrderEncodeType; // 订单支付加密方式
	private String RetEncodeType; // 交易返回加密方式
	private String Rettype; // 是否提供Server返回方式
	private String ServerUrl; // Server to Server返回页面
	public int getTest() {
		return test;
	}
	public void setTest(int test) {
		this.test = test;
	}
	public String getMer_code() {
		return Mer_code;
	}
	public void setMer_code(String mer_code) {
		Mer_code = mer_code;
	}
	public String getMer_key() {
		return Mer_key;
	}
	public void setMer_key(String mer_key) {
		Mer_key = mer_key;
	}
	public String getBillno() {
		return Billno;
	}
	public void setBillno(String billno) {
		Billno = billno;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getDispAmount() {
		return DispAmount;
	}
	public void setDispAmount(String dispAmount) {
		DispAmount = dispAmount;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getCurrency_Type() {
		return Currency_Type;
	}
	public void setCurrency_Type(String currency_Type) {
		Currency_Type = currency_Type;
	}
	public String getGateway_Type() {
		return Gateway_Type;
	}
	public void setGateway_Type(String gateway_Type) {
		Gateway_Type = gateway_Type;
	}
	public String getLang() {
		return Lang;
	}
	public void setLang(String lang) {
		Lang = lang;
	}
	public String getMerchanturl() {
		return Merchanturl;
	}
	public void setMerchanturl(String merchanturl) {
		Merchanturl = merchanturl;
	}
	public String getFailUrl() {
		return FailUrl;
	}
	public void setFailUrl(String failUrl) {
		FailUrl = failUrl;
	}
	public String getErrorUrl() {
		return ErrorUrl;
	}
	public void setErrorUrl(String errorUrl) {
		ErrorUrl = errorUrl;
	}
	public String getAttach() {
		return Attach;
	}
	public void setAttach(String attach) {
		Attach = attach;
	}
	public String getOrderEncodeType() {
		return OrderEncodeType;
	}
	public void setOrderEncodeType(String orderEncodeType) {
		OrderEncodeType = orderEncodeType;
	}
	public String getRetEncodeType() {
		return RetEncodeType;
	}
	public void setRetEncodeType(String retEncodeType) {
		RetEncodeType = retEncodeType;
	}
	public String getRettype() {
		return Rettype;
	}
	public void setRettype(String rettype) {
		Rettype = rettype;
	}
	public String getServerUrl() {
		return ServerUrl;
	}
	public void setServerUrl(String serverUrl) {
		ServerUrl = serverUrl;
	}
}
