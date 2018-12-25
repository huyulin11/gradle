package com.ytgrading.dto;

import java.util.Date;

public class LogisticsTransfer {
	private String status;
	private String transferfromname;
	private String transfertoname;
    public String getTransferfromname() {
		return transferfromname;
	}

	public void setTransferfromname(String transferfromname) {
		this.transferfromname = transferfromname;
	}

	public String getTransfertoname() {
		return transfertoname;
	}

	public void setTransfertoname(String transfertoname) {
		this.transfertoname = transfertoname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
    private String id;

    private Integer transferfrom;

    private Integer transferto;

    private Date occurrencetime;

    private String type;

    private Integer goodsid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTransferfrom() {
        return transferfrom;
    }

    public void setTransferfrom(Integer transferfrom) {
        this.transferfrom = transferfrom;
    }

    public Integer getTransferto() {
        return transferto;
    }

    public void setTransferto(Integer transferto) {
        this.transferto = transferto;
    }

    public Date getOccurrencetime() {
        return occurrencetime;
    }

    public void setOccurrencetime(Date occurrencetime) {
        this.occurrencetime = occurrencetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }
}