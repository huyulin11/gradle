package com.ytgrading.dto;

public class ReservationType {
	private String reservationtypeid;
	private String reservationtypename;
	private String reservationtypeinfo;
	private String starttime;
	private String endtime;
	private String entitytype;
	private String reservfeetype;
	private String reservsubtype;
	private Integer needcoupon;
	private Integer usetimes;
	private Integer usedtimes;
	private Integer requestusetimes;

	private String delflag;

	public String getReservationtypeid() {
		return reservationtypeid;
	}

	public void setReservationtypeid(String reservationtypeid) {
		this.reservationtypeid = reservationtypeid;
	}

	public String getReservfeetype() {
		return reservfeetype;
	}

	public void setReservfeetype(String reservfeetype) {
		this.reservfeetype = reservfeetype;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getReservationtypename() {
		return reservationtypename;
	}

	public void setReservationtypename(String reservationtypename) {
		this.reservationtypename = reservationtypename;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getEntitytype() {
		return entitytype;
	}

	public void setEntitytype(String entitytype) {
		this.entitytype = entitytype;
	}

	public String getReservsubtype() {
		return reservsubtype;
	}

	public void setReservsubtype(String reservsubtype) {
		this.reservsubtype = reservsubtype;
	}

	public Integer getNeedcoupon() {
		return needcoupon;
	}

	public void setNeedcoupon(Integer needcoupon) {
		this.needcoupon = needcoupon;
	}

	public Integer getUsetimes() {
		return usetimes;
	}

	public void setUsetimes(Integer usetimes) {
		this.usetimes = usetimes;
	}

	public String getReservationtypeinfo() {
		return reservationtypeinfo;
	}

	public void setReservationtypeinfo(String reservationtypeinfo) {
		this.reservationtypeinfo = reservationtypeinfo;
	}

	public Integer getUsedtimes() {
		return usedtimes;
	}

	public void setUsedtimes(Integer usedtimes) {
		this.usedtimes = usedtimes;
	}

	public Integer getRequestusetimes() {
		return requestusetimes;
	}

	public void setRequestusetimes(Integer requestusetimes) {
		this.requestusetimes = requestusetimes;
	}

}