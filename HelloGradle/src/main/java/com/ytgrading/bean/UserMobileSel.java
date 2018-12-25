package com.ytgrading.bean;

public class UserMobileSel {
    private String id;

    private String userid;

    private String telephone;

    private String isdefault;

    private String status;

    private String delflag;

    private String remark;

    private String sortname;
    
    private String sortorder;
    
    private int pagenum;
    
    private int pageSize;
    
    private String sortid;
    private String sortuserid;
    private String sorttelephone;
    private String sortisdefault;
    private String sortstatus;
    
    public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortid() {
		return sortid;
	}

	public void setSortid(String sortid) {
		this.sortid = sortid;
	}

	public String getSortuserid() {
		return sortuserid;
	}

	public void setSortuserid(String sortuserid) {
		this.sortuserid = sortuserid;
	}

	public String getSorttelephone() {
		return sorttelephone;
	}

	public void setSorttelephone(String sorttelephone) {
		this.sorttelephone = sorttelephone;
	}

	public String getSortisdefault() {
		return sortisdefault;
	}

	public void setSortisdefault(String sortisdefault) {
		this.sortisdefault = sortisdefault;
	}

	public String getSortstatus() {
		return sortstatus;
	}

	public void setSortstatus(String sortstatus) {
		this.sortstatus = sortstatus;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
