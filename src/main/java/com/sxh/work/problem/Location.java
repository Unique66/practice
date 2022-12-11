/*
 * Copyright (c) 2022.  User:Unique66 File:Location.java
 * Date:2022/12/11 23:08:11
 */

package com.sxh.work.problem;

public class Location {
    private double longitude; // 经度
    private double latitude; // 纬度

    private double distance;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
