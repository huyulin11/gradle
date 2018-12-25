package com.ytgrading.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CoinInfo {
	/**
	 * request_coin id
	 */
	private String id;
	/**
	 * 钱币在字典表中的id
	 */
	private int coinid;
	/**
	 * 钱币编号
	 */
	private String coincode;
	/**
	 * 钱币（request_coin表）备注
	 */
	private String coinremark;
	/**
	 * 评审等级（1为一审、2为二审）
	 */
	private String level;
	/**
	 * 硬币评分
	 */
	private BigDecimal score;
	/**
	 * 评分说明
	 */
	private String scoreremark;

	/**
	 * 评分人code
	 */
	private int scoreby;
	/**
	 * 国家
	 */
	private String guojia;
	/**
	 * 年份
	 */
	private String years;
	/**
	 * 钱币估价
	 */
	private BigDecimal evaluate;
	/**
	 * 发行量
	 */
	private int amountofissue;
	/**
	 * 制造工艺
	 */
	private String mprocess;
	/**
	 * 题材全称
	 */
	private String fullsubject;
	/**
	 * 钱币重量
	 */
	private String zhongliang;
	/**
	 * 质量
	 */
	private String zhiliang;
	/**
	 * 材质
	 */
	private String caizhi;
	/**
	 * 版别
	 */
	private String version;
	/**
	 * 面值
	 */
	private BigDecimal facevalue;
	/**
	 * 成分说明
	 */
	private Date scoretime;

	private String components;
	private String ratingreasondis;// 评级原因
	private String difversion; // 后台输入版别
	/**
	 * 订单号
	 */
	private String requestid;
	// 评级类型
	private String serviceid; // 送评类型
	private String levelStatus; // backdetail内部状态
	private String struts; // 钱币状态
	private int employeeid; // 当前员工id
	private String dataNum;
	private String imgtype;
	private String entitytype;// 申请单类型
	private String facevaluedis; // 显示面值
	private String blockNum; // 冠字号
	private String size; // 尺寸
	private String shading; // 票面底纹
	private String placenames; // 地名
	private String sign; // 签名
	private String wmk; // 水印
	private String whetherSample; // 是否票样
	private String grade; // 古币等级
	private String dynasty; // 朝代
	private String customSize; // 评审保存后的尺寸
	private int difversioncode;// 冠字号id
	private String color;
	private String zhino;
	private String coinspecialtype;
	private String issuetime;
	private String issuedate;
	private String coincover;
	private String coincovernewold;
	private String coinpostmark;
	private String coinstampjointype;
	private String coinhole;
	private String coinplatemode;
	private String coinseriesnum;
	private String country;
	private String coinmotto;
	private String gum;
	private String coinissuingquantity;
	private String coinsummary;
	private String remark;
	private String coinprintingpaper;
	private String coinfullsubject;
	private String coinfeatures;
	private String detinformation;
	private String scores;
	private String addremarks;
	private String newinformation; 
	

	public String getCoinfeatures() {
		return coinfeatures;
	}

	public void setCoinfeatures(String coinfeatures) {
		this.coinfeatures = coinfeatures;
	}

	public String getCoinfullsubject() {
		return coinfullsubject;
	}

	public void setCoinfullsubject(String coinfullsubject) {
		this.coinfullsubject = coinfullsubject;
	}

	public String getCoinprintingpaper() {
		return coinprintingpaper;
	}

	public void setCoinprintingpaper(String coinprintingpaper) {
		this.coinprintingpaper = coinprintingpaper;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGum() {
		return gum;
	}

	public void setGum(String gum) {
		this.gum = gum;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getZhino() {
		return zhino;
	}

	public void setZhino(String zhino) {
		this.zhino = zhino;
	}

	public String getIssuetime() {
		return issuetime;
	}

	public void setIssuetime(String issuetime) {
		this.issuetime = issuetime;
	}

	public String getCoincovernewold() {
		return coincovernewold;
	}

	public void setCoincovernewold(String coincovernewold) {
		this.coincovernewold = coincovernewold;
	}

	public String getCoinspecialtype() {
		return coinspecialtype;
	}

	public void setCoinspecialtype(String coinspecialtype) {
		this.coinspecialtype = coinspecialtype;
	}

	public String getCoincover() {
		return coincover;
	}

	public void setCoincover(String coincover) {
		this.coincover = coincover;
	}

	public String getCoinpostmark() {
		return coinpostmark;
	}

	public void setCoinpostmark(String coinpostmark) {
		this.coinpostmark = coinpostmark;
	}

	public String getCoinstampjointype() {
		return coinstampjointype;
	}

	public void setCoinstampjointype(String coinstampjointype) {
		this.coinstampjointype = coinstampjointype;
	}

	public String getCoinhole() {
		return coinhole;
	}

	public void setCoinhole(String coinhole) {
		this.coinhole = coinhole;
	}

	public String getCoinplatemode() {
		return coinplatemode;
	}

	public void setCoinplatemode(String coinplatemode) {
		this.coinplatemode = coinplatemode;
	}

	public String getCoinseriesnum() {
		return coinseriesnum;
	}

	public void setCoinseriesnum(String coinseriesnum) {
		this.coinseriesnum = coinseriesnum;
	}

	public String getCoinmotto() {
		return coinmotto;
	}

	public void setCoinmotto(String coinmotto) {
		this.coinmotto = coinmotto;
	}

	public String getCoinissuingquantity() {
		return coinissuingquantity;
	}

	public void setCoinissuingquantity(String coinissuingquantity) {
		this.coinissuingquantity = coinissuingquantity;
	}

	public String getCoinsummary() {
		return coinsummary;
	}

	public void setCoinsummary(String coinsummary) {
		this.coinsummary = coinsummary;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDifversioncode() {
		return difversioncode;
	}

	public void setDifversioncode(int difversioncode) {
		this.difversioncode = difversioncode;
	}

	public String getCustomSize() {
		return customSize;
	}

	public void setCustomSize(String customSize) {
		this.customSize = customSize;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDynasty() {
		return dynasty;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}

	public String getFacevaluedis() {
		return facevaluedis;
	}

	public void setFacevaluedis(String facevaluedis) {
		this.facevaluedis = facevaluedis;
	}

	public String getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(String blockNum) {
		this.blockNum = blockNum;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getShading() {
		return shading;
	}

	public void setShading(String shading) {
		this.shading = shading;
	}

	public String getPlacenames() {
		return placenames;
	}

	public void setPlacenames(String placenames) {
		this.placenames = placenames;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getWmk() {
		return wmk;
	}

	public void setWmk(String wmk) {
		this.wmk = wmk;
	}

	public String getWhetherSample() {
		return whetherSample;
	}

	public void setWhetherSample(String whetherSample) {
		this.whetherSample = whetherSample;
	}

	public String getRatingreasondis() {
		return ratingreasondis;
	}

	public void setRatingreasondis(String ratingreasondis) {
		this.ratingreasondis = ratingreasondis;
	}

	public String getDifversion() {
		return difversion;
	}

	public void setDifversion(String difversion) {
		this.difversion = difversion;
	}

	public Date getScoretime() {
		return scoretime;
	}

	public void setScoretime(Date scoretime) {
		this.scoretime = scoretime;
	}

	public String getEntitytype() {
		return entitytype;
	}

	public void setEntitytype(String entitytype) {
		this.entitytype = entitytype;
	}

	public String getLevelStatus() {
		return levelStatus;
	}

	public void setLevelStatus(String levelStatus) {
		this.levelStatus = levelStatus;
	}

	public String getStruts() {
		return struts;
	}

	public void setStruts(String struts) {
		this.struts = struts;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getDataNum() {
		return dataNum;
	}

	public void setDataNum(String dataNum) {
		this.dataNum = dataNum;
	}

	public String getImgtype() {
		return imgtype;
	}

	public void setImgtype(String imgtype) {
		this.imgtype = imgtype;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	public synchronized String getCoincode() {
		return coincode;
	}

	public synchronized void setCoincode(String coincode) {
		this.coincode = coincode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCoinid() {
		return coinid;
	}

	public void setCoinid(int coinid) {
		this.coinid = coinid;
	}

	public String getCoinremark() {
		return coinremark;
	}

	public void setCoinremark(String coinremark) {
		this.coinremark = coinremark;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public String getScoreremark() {
		return scoreremark;
	}

	public void setScoreremark(String scoreremark) {
		this.scoreremark = scoreremark;
	}

	public String getGuojia() {
		return guojia;
	}

	public void setGuojia(String guojia) {
		this.guojia = guojia;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public BigDecimal getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(BigDecimal evaluate) {
		this.evaluate = evaluate;
	}

	public int getAmountofissue() {
		return amountofissue;
	}

	public void setAmountofissue(int amountofissue) {
		this.amountofissue = amountofissue;
	}

	public String getMprocess() {
		return mprocess;
	}

	public void setMprocess(String mprocess) {
		this.mprocess = mprocess;
	}

	public String getFullsubject() {
		return fullsubject;
	}

	public void setFullsubject(String fullsubject) {
		this.fullsubject = fullsubject;
	}

	public String getZhongliang() {
		return zhongliang;
	}

	public void setZhongliang(String zhongliang) {
		this.zhongliang = zhongliang;
	}

	public String getZhiliang() {
		return zhiliang;
	}

	public void setZhiliang(String zhiliang) {
		this.zhiliang = zhiliang;
	}

	public String getCaizhi() {
		return caizhi;
	}

	public void setCaizhi(String caizhi) {
		this.caizhi = caizhi;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public BigDecimal getFacevalue() {
		return facevalue;
	}

	public void setFacevalue(BigDecimal facevalue) {
		this.facevalue = facevalue;
	}

	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
	}

	public int getScoreby() {
		return scoreby;
	}

	public void setScoreby(int scoreby) {
		this.scoreby = scoreby;
	}

	public String getServiceid() {
		return serviceid;
	}

	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}

	public String getDetinformation() {
		return detinformation;
	}

	public void setDetinformation(String detinformation) {
		this.detinformation = detinformation;
	}

	public String getScores() {
		return scores;
	}

	public void setScores(String scores) {
		this.scores = scores;
	}

	public String getAddremarks() {
		return addremarks;
	}

	public void setAddremarks(String addremarks) {
		this.addremarks = addremarks;
	}

	public String getNewinformation() {
		return newinformation;
	}

	public void setNewinformation(String newinformation) {
		this.newinformation = newinformation;
	}
	
	

}
