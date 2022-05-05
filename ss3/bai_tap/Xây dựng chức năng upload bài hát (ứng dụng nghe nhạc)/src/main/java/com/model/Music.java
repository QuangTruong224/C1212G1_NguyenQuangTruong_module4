package com.model;

public class Music {
    private String tenBaiHat;
    private String ngheSi;
    private String theLoaiNhac;
    private String file;

    public Music() {
    }

    public Music(String tenBaiHat, String ngheSi, String theLoaiNhac, String file) {
        this.tenBaiHat = tenBaiHat;
        this.ngheSi = ngheSi;
        this.theLoaiNhac = theLoaiNhac;
        this.file = file;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getNgheSi() {
        return ngheSi;
    }

    public void setNgheSi(String ngheSi) {
        this.ngheSi = ngheSi;
    }

    public String getTheLoaiNhac() {
        return theLoaiNhac;
    }

    public void setTheLoaiNhac(String theLoaiNhac) {
        this.theLoaiNhac = theLoaiNhac;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
