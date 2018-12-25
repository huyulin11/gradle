package com.ytgrading.bean;

import java.math.BigDecimal;
import java.util.List;

import com.ytgrading.util.AppTool;

public class RequestCoinBean implements Comparable<RequestCoinBean> {
	private int coinimagenum;
	private String id;
	private String coincode;
	private String years;
	private String guojia;
	private String fullsubject;
	private String zhongliang;
	private String zhiliang;
	private String caizhi;
	private String version;
	private BigDecimal facevalue;
	private String status;
	private Integer customerscore;
	private Integer score;
	private String scores;
	private BigDecimal evaluate;
	private String countryCode; // 国家代号
	private Integer enZhiliang; // 制造质量英文
	private String wmk;// 水印
	private String whetherSample;
	private String blockNum;// 冠字号
	private String dynasty;// 朝代
	private String size; // 尺寸
	private String grade; // 古币等级
	private String editBlockNum;
	private String detinformation;
	private String addremarks;

	private Integer coinid;

	private String requestid;

	private String requestdetailid;

	private String tagindex;
	private List<String> pathlist;
	private List<String> pathlistbase;
	private String remark;
	private String difversion;
	private String ratingreasondis;
	private int difversioncode; // 版别ID

	private String weight;
	private String guestWRGrade;
	private String customSize;

	private String zhino;
	private String color;
	private String issuedate;
	private String issuetime;
	private Integer coinstampjointype;
	private Integer stampjointype;
	private Integer coincovernewold;
	private String coinremark;
	private String coinmotto;
	private String coinnum;
	private Integer coinboxid;
	private BigDecimal coinevaluate;
	private String coinissuingquantity;
	private String coinfullsubject;
	private String facevaluedis;
	private String weightshow;
	private BigDecimal reqcost;

	private String amount;
	private String coinpostmark;
	private String coinfeatures;
	private String newinformation;

	public Integer getStampjointype() {
		return stampjointype;
	}

	public void setStampjointype(Integer stampjointype) {
		this.stampjointype = stampjointype;
	}

	public String getCoinissuingquantity() {
		return coinissuingquantity;
	}

	public void setCoinissuingquantity(String coinissuingquantity) {
		this.coinissuingquantity = coinissuingquantity;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getCoinimagenum() {
		return coinimagenum;
	}

	public void setCoinimagenum(int coinimagenum) {
		this.coinimagenum = coinimagenum;
	}

	public String getEditBlockNum() {
		return editBlockNum;
	}

	public void setEditBlockNum(String editBlockNum) {
		this.editBlockNum = editBlockNum;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getWhetherSample() {
		return whetherSample;
	}

	public void setWhetherSample(String whetherSample) {
		this.whetherSample = whetherSample;
	}

	public String getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(String blockNum) {
		this.blockNum = blockNum;
	}

	public Integer getEnZhiliang() {
		return enZhiliang;
	}

	public void setEnZhiliang(Integer enZhiliang) {
		this.enZhiliang = enZhiliang;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getWmk() {
		return wmk;
	}

	public void setWmk(String wmk) {
		this.wmk = wmk;
	}

	public String getRatingreasondis() {
		return ratingreasondis;
	}

	public void setRatingreasondis(String ratingreasondis) {
		this.ratingreasondis = ratingreasondis;
	}

	public String getFacevaluedis() {
		return facevaluedis;
	}

	public void setFacevaluedis(String facevaluedis) {
		this.facevaluedis = facevaluedis;
	}

	public String getWeightshow() {
		return weightshow;
	}

	public void setWeightshow(String weightshow) {
		this.weightshow = weightshow;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getGuojia() {
		return guojia;
	}

	public void setGuojia(String guojia) {
		this.guojia = guojia;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCustomerscore() {
		return customerscore;
	}

	public void setCustomerscore(Integer customerscore) {
		this.customerscore = customerscore;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getCoincode() {
		return coincode;
	}

	public void setCoincode(String coincode) {
		this.coincode = coincode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZhino() {
		return zhino;
	}

	public void setZhino(String zhino) {
		this.zhino = zhino;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getIssuetime() {
		return issuetime;
	}

	public void setIssuetime(String issuetime) {
		this.issuetime = issuetime;
	}

	public Integer getCoinid() {
		return coinid;
	}

	public void setCoinid(Integer coinid) {
		this.coinid = coinid;
	}

	public Integer getCoincovernewold() {
		return coincovernewold;
	}

	public void setCoincovernewold(Integer coincovernewold) {
		this.coincovernewold = coincovernewold;
	}

	public String getCoinremark() {
		return coinremark;
	}

	public void setCoinremark(String coinremark) {
		this.coinremark = coinremark;
	}

	public String getCoinmotto() {
		return coinmotto;
	}

	public void setCoinmotto(String coinmotto) {
		this.coinmotto = coinmotto;
	}

	public Integer getCoinboxid() {
		return coinboxid;
	}

	public void setCoinboxid(Integer coinboxid) {
		this.coinboxid = coinboxid;
	}

	public BigDecimal getCoinevaluate() {
		return coinevaluate;
	}

	public void setCoinevaluate(BigDecimal coinevaluate) {
		this.coinevaluate = coinevaluate;
	}

	public Integer getCoinstampjointype() {
		return coinstampjointype;
	}

	public void setCoinstampjointype(Integer coinstampjointype) {
		this.coinstampjointype = coinstampjointype;
	}

	public String getCoinfullsubject() {
		return coinfullsubject;
	}

	public void setCoinfullsubject(String coinfullsubject) {
		this.coinfullsubject = coinfullsubject;
	}

	public BigDecimal getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(BigDecimal evaluate) {
		this.evaluate = evaluate;
	}

	public String getCoinnum() {
		return coinnum;
	}

	public void setCoinnum(String coinnum) {
		this.coinnum = coinnum;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	public String getRequestdetailid() {
		return requestdetailid;
	}

	public void setRequestdetailid(String requestdetailid) {
		this.requestdetailid = requestdetailid;
	}

	public String getTagindex() {
		return tagindex;
	}

	public void setTagindex(String tagindex) {
		this.tagindex = tagindex;
	}

	public List<String> getPathlist() {
		return pathlist;
	}

	public void setPathlist(List<String> pathlist) {
		this.pathlist = pathlist;
	}

	public List<String> getPathlistbase() {
		return pathlistbase;
	}

	public void setPathlistbase(List<String> pathlistbase) {
		this.pathlistbase = pathlistbase;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDifversion() {
		return difversion;
	}

	public void setDifversion(String difversion) {
		this.difversion = difversion;
	}

	public int getDifversioncode() {
		return difversioncode;
	}

	public void setDifversioncode(int difversioncode) {
		this.difversioncode = difversioncode;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getGuestWRGrade() {
		return guestWRGrade;
	}

	public void setGuestWRGrade(String guestWRGrade) {
		this.guestWRGrade = guestWRGrade;
	}

	public String getCustomSize() {
		return customSize;
	}

	public void setCustomSize(String customSize) {
		this.customSize = customSize;
	}

	/** 按照coincode排序 */
	public int compareTo(RequestCoinBean o) {
		if (AppTool.isNullStr(this.coincode)) {
			return -1;
		}
		if (AppTool.isNullStr(o.coincode)) {
			return 1;
		}
		if (Integer.parseInt(this.getCoincode()) > Integer.parseInt(o
				.getCoincode())) {
			return 1;
		}
		return -1;
	}

	public BigDecimal getReqcost() {
		return reqcost;
	}

	public void setReqcost(BigDecimal reqcost) {
		this.reqcost = reqcost;
	}

	public String getCoinpostmark() {
		return coinpostmark;
	}

	public void setCoinpostmark(String coinpostmark) {
		this.coinpostmark = coinpostmark;
	}

	public String getCoinfeatures() {
		return coinfeatures;
	}

	public void setCoinfeatures(String coinfeatures) {
		this.coinfeatures = coinfeatures;
	}

	public String getDetinformation() {
		return detinformation;
	}

	public void setDetinformation(String detinformation) {
		this.detinformation = detinformation;
	}

	public String getAddremarks() {
		return addremarks;
	}

	public void setAddremarks(String addremarks) {
		this.addremarks = addremarks;
	}

	public String getScores() {
		return scores;
	}

	public void setScores(String scores) {
		this.scores = scores;
	}

	public String getNewinformation() {
		return newinformation;
	}

	public void setNewinformation(String newinformation) {
		this.newinformation = newinformation;
	}

	
	
	
	

}
