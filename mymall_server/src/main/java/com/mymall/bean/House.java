package com.mymall.bean;

import java.sql.Timestamp;

public class House {
     private int id;
     private String distric;
     private int storey;
     private int area;
     private int price;
     private String homeownerid;
     private boolean rentedflag;
     private boolean sharflag;
     private String gender;
     private String icon;
     private String introduction;
     private String brifintroduction;
     private Timestamp created_at;
     private Timestamp updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistric() {
        return distric;
    }

    public void setDistric(String distric) {
        this.distric = distric;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHomeownerid() {
        return homeownerid;
    }

    public void setHomeownerid(String homeownerid) {
        this.homeownerid = homeownerid;
    }

    public boolean isRentedflag() {
        return rentedflag;
    }

    public void setRentedflag(boolean rentedflag) {
        this.rentedflag = rentedflag;
    }

    public boolean isSharflag() {
        return sharflag;
    }

    public void setSharflag(boolean sharflag) {
        this.sharflag = sharflag;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBrifintroduction() {
        return brifintroduction;
    }

    public void setBrifintroduction(String brifintroduction) {
        this.brifintroduction = brifintroduction;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", distric='" + distric + '\'' +
                ", storey=" + storey +
                ", area=" + area +
                ", price=" + price +
                ", homeownerid='" + homeownerid + '\'' +
                ", rentedflag=" + rentedflag +
                ", sharflag=" + sharflag +
                ", gender='" + gender + '\'' +
                ", icon='" + icon + '\'' +
                ", introduction='" + introduction + '\'' +
                ", brifintroduction='" + brifintroduction + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }

    public House(int id, String distric, int storey, int area, int price, String homeownerid, boolean rentedflag, boolean sharflag, String gender, String icon, String introduction, String brifintroduction, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.distric = distric;
        this.storey = storey;
        this.area = area;
        this.price = price;
        this.homeownerid = homeownerid;
        this.rentedflag = rentedflag;
        this.sharflag = sharflag;
        this.gender = gender;
        this.icon = icon;
        this.introduction = introduction;
        this.brifintroduction = brifintroduction;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }


    public House() {
    }
}
