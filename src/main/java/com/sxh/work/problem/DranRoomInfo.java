/*
 * Copyright (c) 2022.  User:Unique66 File:DranRoomInfo.java
 * Date:2022/12/08 00:08:08
 */

package com.sxh.work.problem;

public class DranRoomInfo extends Location{
    private String id;
    private String bbuName; // BBU
    private String siteNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBbuName() {
        return bbuName;
    }

    public void setBbuName(String bbuName) {
        this.bbuName = bbuName;
    }

    public String getSiteNum() {
        return siteNum;
    }

    public void setSiteNum(String siteNum) {
        this.siteNum = siteNum;
    }
}
