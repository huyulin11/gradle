package com.ytgrading.dto;

public class SysProvinceWithBLOBs extends SysProvince {
    private String name;

    private String shortname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }
}