package com.ytgrading.bean;

import java.math.BigDecimal;

public class SysBillBasicInfo {
    private Integer id;

    private String catalogue;

    private String billnum;

    private String billtype;

    private String reign;

    private String years;

    private Integer country;

    private String bank;

    private String issuedate;
    private String issueendtime;

    private String facevaluedis;

    private String enfacevalue;

    private String size;

    private String block;

    private String seriesnum;

    private String wmk;

    private String enwmk;

    private String placenames;

    private String enplacenames;

    private String sign;

    private String ensign;

    private String version;

    private String enversion;

    private String pattern;

    private String shading;

    private String color;

    private String printingcompany;

    private String printingtechnology;

    private String printingplate;

    private String printingpaper;

    private String printingtime;

    private String circulationtime;

    private BigDecimal evaluate;
    private String fullsubject;

    private String enfullsubject;

    private String shortsubject;

    private String enshortsubject;

    private String commonlysubject;

    private String explain;

    private String remarks;
    private String guojia;
    private String boxCost;
    public String getBoxCost() {
		return boxCost;
	}

	public void setBoxCost(String boxCost) {
		this.boxCost = boxCost;
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
        this.fullsubject = fullsubject == null ? null : fullsubject.trim();
    }

    public String getEnfullsubject() {
        return enfullsubject;
    }

    public void setEnfullsubject(String enfullsubject) {
        this.enfullsubject = enfullsubject == null ? null : enfullsubject.trim();
    }

    public String getShortsubject() {
        return shortsubject;
    }

    public void setShortsubject(String shortsubject) {
        this.shortsubject = shortsubject == null ? null : shortsubject.trim();
    }

    public String getEnshortsubject() {
        return enshortsubject;
    }

    public void setEnshortsubject(String enshortsubject) {
        this.enshortsubject = enshortsubject == null ? null : enshortsubject.trim();
    }

    public String getCommonlysubject() {
        return commonlysubject;
    }
    
    public void setCommonlysubject(String commonlysubject) {
        this.commonlysubject = commonlysubject == null ? null : commonlysubject.trim();
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue == null ? null : catalogue.trim();
    }

    public String getBillnum() {
        return billnum;
    }

    public void setBillnum(String billnum) {
        this.billnum = billnum == null ? null : billnum.trim();
    }

    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype == null ? null : billtype.trim();
    }

    public String getReign() {
        return reign;
    }

    public void setReign(String reign) {
        this.reign = reign == null ? null : reign.trim();
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years == null ? null : years.trim();
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate == null ? null : issuedate.trim();
    }

    public String getIssueendtime() {
        return issueendtime;
    }

    public void setIssueendtime(String issueendtime) {
        this.issueendtime = issueendtime == null ? null : issueendtime.trim();
    }

    public String getFacevaluedis() {
        return facevaluedis;
    }

    public void setFacevaluedis(String facevaluedis) {
        this.facevaluedis = facevaluedis == null ? null : facevaluedis.trim();
    }

    public String getEnfacevalue() {
        return enfacevalue;
    }
    public void setEnfacevalue(String enfacevalue) {
        this.enfacevalue = enfacevalue == null ? null : enfacevalue.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block == null ? null : block.trim();
    }

    public String getSeriesnum() {
        return seriesnum;
    }

    public void setSeriesnum(String seriesnum) {
        this.seriesnum = seriesnum == null ? null : seriesnum.trim();
    }

    public String getWmk() {
        return wmk;
    }

    public void setWmk(String wmk) {
        this.wmk = wmk == null ? null : wmk.trim();
    }

    public String getEnwmk() {
        return enwmk;
    }

    public void setEnwmk(String enwmk) {
        this.enwmk = enwmk == null ? null : enwmk.trim();
    }

    public String getPlacenames() {
        return placenames;
    }

    public void setPlacenames(String placenames) {
        this.placenames = placenames == null ? null : placenames.trim();
    }

    public String getEnplacenames() {
        return enplacenames;
    }

    public void setEnplacenames(String enplacenames) {
        this.enplacenames = enplacenames == null ? null : enplacenames.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getEnsign() {
        return ensign;
    }

    public void setEnsign(String ensign) {
        this.ensign = ensign == null ? null : ensign.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getEnversion() {
        return enversion;
    }

    public void setEnversion(String enversion) {
        this.enversion = enversion == null ? null : enversion.trim();
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern == null ? null : pattern.trim();
    }

    public String getShading() {
        return shading;
    }

    public void setShading(String shading) {
        this.shading = shading == null ? null : shading.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getPrintingcompany() {
        return printingcompany;
    }

    public void setPrintingcompany(String printingcompany) {
        this.printingcompany = printingcompany == null ? null : printingcompany.trim();
    }

    public String getPrintingtechnology() {
        return printingtechnology;
    }

    public void setPrintingtechnology(String printingtechnology) {
        this.printingtechnology = printingtechnology == null ? null : printingtechnology.trim();
    }

    public String getPrintingplate() {
        return printingplate;
    }

    public void setPrintingplate(String printingplate) {
        this.printingplate = printingplate == null ? null : printingplate.trim();
    }

    public String getPrintingpaper() {
        return printingpaper;
    }

    public void setPrintingpaper(String printingpaper) {
        this.printingpaper = printingpaper == null ? null : printingpaper.trim();
    }

    public String getPrintingtime() {
        return printingtime;
    }

    public void setPrintingtime(String printingtime) {
        this.printingtime = printingtime == null ? null : printingtime.trim();
    }

    public String getCirculationtime() {
        return circulationtime;
    }

    public void setCirculationtime(String circulationtime) {
        this.circulationtime = circulationtime == null ? null : circulationtime.trim();
    }

    public BigDecimal getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(BigDecimal evaluate) {
        this.evaluate = evaluate;
    }
}