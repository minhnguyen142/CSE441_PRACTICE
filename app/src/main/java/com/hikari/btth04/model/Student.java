package com.hikari.btth04.model;

public class Student {
    private String mssv;
    private String hoten;
    private String lop;
    private double diem;

    public Student() {
        // Default constructor required for calls to DataSnapshot.getValue(Student.class)
    }

    public Student(String mssv, String hoten, String lop, double diem) {
        this.mssv = mssv;
        this.hoten = hoten;
        this.lop = lop;
        this.diem = diem;
    }

    public String getMssv() {
        return mssv;
    }

    public String getHoten() {
        return hoten;
    }

    public String getLop() {
        return lop;
    }

    public double getDiem() {
        return diem;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
}


