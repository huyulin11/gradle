package com.ytgrading.dto;

public class CoinWithBLOBs extends Coin {
    private String fullsubject;

    private String shortsubject;

    private String components;

    public String getFullsubject() {
        return fullsubject;
    }

    public void setFullsubject(String fullsubject) {
        this.fullsubject = fullsubject;
    }

    public String getShortsubject() {
        return shortsubject;
    }

    public void setShortsubject(String shortsubject) {
        this.shortsubject = shortsubject;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }
}