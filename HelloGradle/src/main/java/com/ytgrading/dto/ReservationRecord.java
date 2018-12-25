package com.ytgrading.dto;

public class ReservationRecord {
	private String reservationrecordid;

	private String reservationtypeid;

	private String requestcode;

	private String userid;

	private String couponid;

	private String delflag;

	public String getReservationrecordid() {
		return reservationrecordid;
	}

	public void setReservationrecordid(String reservationrecordid) {
		this.reservationrecordid = reservationrecordid;
	}

	public String getReservationtypeid() {
		return reservationtypeid;
	}

	public void setReservationtypeid(String reservationtypeid) {
		this.reservationtypeid = reservationtypeid;
	}

	public String getRequestcode() {
		return requestcode;
	}

	public void setRequestcode(String requestcode) {
		this.requestcode = requestcode;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getCouponid() {
		return couponid;
	}

	public void setCouponid(String couponid) {
		this.couponid = couponid;
	}
}