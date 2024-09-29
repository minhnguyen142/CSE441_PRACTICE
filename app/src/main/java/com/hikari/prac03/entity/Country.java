package com.hikari.prac03.entity;

public class Country {
    private int flag;
    private String name;
    private String capital;
    private double population;
    private double area;
    private int density;
    private double worldShare;


    public Country() {
    }

    public Country(int flag, String name, String capital, double population, double area, int density, double worldShare) {
        this.flag = flag;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.density = density;
        this.worldShare = worldShare;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public double getWorldShare() {
        return worldShare;
    }

    public void setWorldShare(double worldShare) {
        this.worldShare = worldShare;
    }
}
