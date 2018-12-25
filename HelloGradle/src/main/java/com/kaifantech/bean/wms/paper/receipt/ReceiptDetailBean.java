package com.kaifantech.bean.wms.paper.receipt;

import java.util.Comparator;

import com.kaifantech.bean.wms.paper.base.WmsPaperDetailBean;

public class ReceiptDetailBean extends WmsPaperDetailBean implements Comparator<ReceiptDetailBean> {
	private String item;
	private String itemname;
	private String itemcount;
	private String sprice;
	private String inventorysts;
	private String expirationdate;
	private String lot;
	private String remark;
	private String userdef2;
	private String userdef3;
	private String userdef4;
	private Integer agvid;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemcount() {
		return itemcount;
	}

	public void setItemcount(String itemcount) {
		this.itemcount = itemcount;
	}

	public String getSprice() {
		return sprice;
	}

	public void setSprice(String sprice) {
		this.sprice = sprice;
	}

	public String getInventorysts() {
		return inventorysts;
	}

	public void setInventorysts(String inventorysts) {
		this.inventorysts = inventorysts;
	}

	public String getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUserdef2() {
		return userdef2;
	}

	public void setUserdef2(String userdef2) {
		this.userdef2 = userdef2;
	}

	public String getUserdef3() {
		return userdef3;
	}

	public void setUserdef3(String userdef3) {
		this.userdef3 = userdef3;
	}

	public String getUserdef4() {
		return userdef4;
	}

	public void setUserdef4(String userdef4) {
		this.userdef4 = userdef4;
	}

	public Integer getAgvid() {
		return agvid;
	}

	public void setAgvid(Integer agvid) {
		this.agvid = agvid;
	}

	@Override
	public int compare(ReceiptDetailBean h1, ReceiptDetailBean h2) {
		return h1.getSequence().compareTo(h2.getSequence());
	}
}