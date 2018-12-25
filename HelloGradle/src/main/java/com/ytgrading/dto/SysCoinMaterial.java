package com.ytgrading.dto;

public class SysCoinMaterial {
    private Integer id;

    private String tag;

    private Integer contentunit;

    private Integer content;

    private Integer measurement;

    private Integer measurementunit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getContentunit() {
        return contentunit;
    }

    public void setContentunit(Integer contentunit) {
        this.contentunit = contentunit;
    }

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public Integer getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Integer measurement) {
        this.measurement = measurement;
    }

    public Integer getMeasurementunit() {
        return measurementunit;
    }

    public void setMeasurementunit(Integer measurementunit) {
        this.measurementunit = measurementunit;
    }
}