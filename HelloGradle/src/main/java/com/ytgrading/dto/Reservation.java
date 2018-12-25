package com.ytgrading.dto;

import java.util.Date;

public class Reservation {
    private Integer id;

    private String tickettype;

    private String rescode;

    private Date restime;

    private String ticketstatus;

    private String resname;

    private String userid;

    private Integer resnum;

    private String rescontext;

    private String sendtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTickettype() {
        return tickettype;
    }

    public void setTickettype(String tickettype) {
        this.tickettype = tickettype == null ? null : tickettype.trim();
    }

    public String getRescode() {
        return rescode;
    }

    public void setRescode(String rescode) {
        this.rescode = rescode == null ? null : rescode.trim();
    }

    public Date getRestime() {
        return restime;
    }

    public void setRestime(Date restime) {
        this.restime = restime;
    }

    public String getTicketstatus() {
        return ticketstatus;
    }

    public void setTicketstatus(String ticketstatus) {
        this.ticketstatus = ticketstatus == null ? null : ticketstatus.trim();
    }

    public String getResname() {
        return resname;
    }

    public void setResname(String resname) {
        this.resname = resname == null ? null : resname.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getResnum() {
        return resnum;
    }

    public void setResnum(Integer resnum) {
        this.resnum = resnum;
    }

    public String getRescontext() {
        return rescontext;
    }

    public void setRescontext(String rescontext) {
        this.rescontext = rescontext == null ? null : rescontext.trim();
    }

    public String getSendtype() {
        return sendtype;
    }

    public void setSendtype(String sendtype) {
        this.sendtype = sendtype == null ? null : sendtype.trim();
    }
}