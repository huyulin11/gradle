package com.kaifantech.bean.taskexe;

public class SkuInfoBean {
	private Integer id;
	private String type;
	private String name;

	private Integer layerHeight;
	private String weight;
	private Integer numInPallet;
	private Integer layerNum;
	private boolean currentSku = false;
	private String delflag;
	private int environment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer skuId) {
		this.id = skuId;
	}

	public String getType() {
		return type;
	}

	public void setType(String skuType) {
		this.type = skuType;
	}

	public String getName() {
		return name;
	}

	public void setName(String skuName) {
		this.name = skuName;
	}

	public int getEnvironment() {
		return environment;
	}

	public void setEnvironment(int environment) {
		this.environment = environment;
	}

	public Integer getLayerHeight() {
		return layerHeight;
	}

	public void setLayerHeight(Integer layerHeight) {
		this.layerHeight = layerHeight;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Integer getNumInPallet() {
		return numInPallet;
	}

	public void setNumInPallet(Integer numInPallet) {
		this.numInPallet = numInPallet;
	}

	public Integer getLayerNum() {
		return layerNum;
	}

	public void setLayerNum(Integer layerNum) {
		this.layerNum = layerNum;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public boolean getCurrentSku() {
		return currentSku;
	}

	public void setCurrentSku(boolean isCurrentSku) {
		this.currentSku = isCurrentSku;
	}

}
