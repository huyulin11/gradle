package com.ytgrading.bean.wms;

import java.util.Date;

import com.ytgrading.util.AppTool;

public class WmsStockInfo {
	private String id;// 唯一编号
	private String keyid;// 商品条码信息（对于封箱信息为其箱号）
	private Integer warehouse;// 所在仓库（SYS_WAREHOUSE）
	private Integer amount;// 数量
	private Integer updateuserid;// 修改人编号
	private Date updatetime;// 修改时间
	private Integer createuserid;// 创建人编号
	private Date createtime;// 期望出库时间
	private Integer delflag;// 删除标志（DELFLAG）

	public WmsStockInfo() {
	}

	public WmsStockInfo(String keyid, Integer amount, Integer createuserid,
			Integer warehouse) {
		this.keyid = keyid;
		this.amount = amount;
		this.createuserid = createuserid;
		this.updateuserid = createuserid;
		this.warehouse = warehouse;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKeyid() {
		return keyid;
	}

	public void setKeyid(String keyid) {
		this.keyid = keyid;
	}

	public Integer getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Integer warehouse) {
		this.warehouse = warehouse;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getUpdateuserid() {
		return updateuserid;
	}

	public void setUpdateuserid(Integer updateuserid) {
		this.updateuserid = updateuserid;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(Integer createuserid) {
		this.createuserid = createuserid;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getDelflag() {
		return delflag;
	}

	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}

	public boolean isNull() {
		if (AppTool.isNullStr(id) || AppTool.isNullStr(keyid)) {
			return true;
		}
		return false;
	}
}