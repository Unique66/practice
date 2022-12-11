/*
 * Copyright (c) 2022.  User:Unique66 File:DranRoomInfo.java
 * Date:2022/12/08 00:08:08
 */

package com.sxh.work.problem;

public class CranRoomInfo extends Location{
    private String id;
    private int bbuNum; // BBU数量

    private String siteNum;

    private double distance;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBbuNum() {
        return bbuNum;
    }

    public void setBbuNum(int bbuNum) {
        this.bbuNum = bbuNum;
    }

    public String getSiteNum() {
        return siteNum;
    }

    public void setSiteNum(String siteNum) {
        this.siteNum = siteNum;
    }
}
