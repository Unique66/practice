/*
 * Copyright (c) 2022.  User:Unique66 File:Problem1.java
 * Date:2022/12/08 00:03:08
 */

package com.sxh.work.problem;

import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1 {
    public static void main(String[] args) {
        List<CranRoomInfo> cranRoomInfos = new ArrayList<>();
        List<DranRoomInfo> dranRoomInfos = new ArrayList<>();
        List<BbuLocation> bbuLocations = new ArrayList<>();


        CranRoomInfo cranRoomInfo1 = new CranRoomInfo();
        cranRoomInfo1.setDistance(1.2);
        CranRoomInfo cranRoomInfo2 = new CranRoomInfo();
        cranRoomInfo2.setDistance(1.2);
        CranRoomInfo cranRoomInfo3 = new CranRoomInfo();
        cranRoomInfo3.setDistance(1.3);
        cranRoomInfos.add(cranRoomInfo1);
        cranRoomInfos.add(cranRoomInfo2);
        cranRoomInfos.add(cranRoomInfo3);
        cranRoomInfos.sort(Comparator.comparingDouble(CranRoomInfo::getDistance));
        System.out.println(cranRoomInfos);
        System.out.println(cranRoomInfos.get(0).getDistance());
        System.out.println(cranRoomInfos.get(0));
        System.out.println(cranRoomInfos.get(2).getDistance());
        System.out.println(cranRoomInfos.get(2));

        DranRoomInfo dranRoomInfo = new DranRoomInfo();
        dranRoomInfo.setDistance(1.5);

        List<Location> locations = new ArrayList<>();
        locations.add(cranRoomInfo1);
        locations.add(dranRoomInfo);

        System.out.println(locations.get(0));
        System.out.println(locations.get(1));
        if (locations.get(0) instanceof CranRoomInfo) {
            CranRoomInfo temp = (CranRoomInfo) locations.get(0);
            System.out.println(temp.getDistance());
        }
    }

    public void calculateBbu(List<DranRoomInfo> dranRoomInfos, List<CranRoomInfo> cranRoomInfos,
                              List<BbuLocation> bbuLocations) {
        // 将BBU 根据站址号匹配
        List<BbuLocation> filterSiteNumBbuLocations =
                bbuLocations.stream().filter(bbuLocation -> !StringUtils.isEmpty(bbuLocation.getSiteNum()))
                        .collect(Collectors.toList());
        bbuLocations.removeAll(filterSiteNumBbuLocations);

        Map<String, List<DranRoomInfo>> dranSiteNumGroupByMap =
                dranRoomInfos.stream().collect(Collectors.groupingBy(DranRoomInfo::getSiteNum));
        Map<String, List<CranRoomInfo>> cranSiteNumGroupBy =
                cranRoomInfos.stream().collect(Collectors.groupingBy(CranRoomInfo::getSiteNum));
        for (BbuLocation bbuLocation : filterSiteNumBbuLocations) {
            List<DranRoomInfo> dranRoomInfos1 = dranSiteNumGroupByMap.get(bbuLocation.getSiteNum());
            // 置bbu name
            dranRoomInfos1.get(0).setBbuName(StringUtils.isEmpty(dranRoomInfos1.get(0).getBbuName()) ?
                    bbuLocation.getBbuName() :
                    dranRoomInfos1.get(0).getBbuName() + "," + bbuLocation.getBbuName());
            // 将其移除
            filterSiteNumBbuLocations.remove(bbuLocation);
        }



        // 将BBU 根据经纬度匹配  距离小于300m
        /**
         * Map<String, List<RoomInfo>>   循环BBU 列表，找到与BBU 距离匹配的所有机房，后续 计算BBU个数或名称列表
         * GeoHash算法  https://blog.csdn.net/hik_zxw/article/details/46238971
         */
        Map<String, List<BbuLocation>> collect = bbuLocations.stream().collect(Collectors.groupingBy(BbuLocation::getId));
        Map<String, List<DranRoomInfo>> tempDranBbuMap = new HashMap<>();
        List<Location> locations = new ArrayList<>();
        locations.addAll(dranRoomInfos);
        locations.addAll(cranRoomInfos);
        for (BbuLocation bbuLocation : bbuLocations) {
            // 获取离BBU最近的 CRAN或者DRAN机房，然后判断是否小于300m的
            List<Location> candidateRoom = new ArrayList<>();
            for (Location location : locations) {
                double distance = getDistance();
                if (distance <= 300) {
                    candidateRoom.add(location);
                }
            }
            // 根据距离排序，获取距离最近的机房，并记录
            candidateRoom.sort(Comparator.comparingDouble(Location::getDistance));
            Location location = candidateRoom.get(0);
        }
    }

    // 2. 根据DRAN和CRAN集合 ，获取DRAN TOP3的候选CRAN机房信息，同时计算CRAN机房和DRAN机房的距离
    public void calculateCran(List<DranRoomInfo> dranRoomInfos, List<CranRoomInfo> cranRoomInfos) {
        // 暴力
        for (DranRoomInfo dranRoomInfo : dranRoomInfos) {
            // 计算当前DRAN 附近3个 CRAN
            setCranRoom(dranRoomInfo, cranRoomInfos);
        }
    }

    private void setCranRoom(DranRoomInfo dranRoomInfo, List<CranRoomInfo> cranRoomInfos) {
        // 优化点：需要在这里获取附近的CRAN机房列表（根据geohash 算法？）
        for (CranRoomInfo cranRoomInfo: cranRoomInfos) {
            double distance = getDistance();
            cranRoomInfo.setDistance(distance);
        }
        // 排序，然后获取前三个
        cranRoomInfos.sort(Comparator.comparingDouble(CranRoomInfo::getDistance));
        setCranInfo(dranRoomInfo, cranRoomInfos, 0);
        setCranInfo(dranRoomInfo, cranRoomInfos, 1);
        setCranInfo(dranRoomInfo, cranRoomInfos, 2);
    }

    private void setCranInfo(DranRoomInfo dranRoomInfo, List<CranRoomInfo> cranRoomInfos, int index) {
        CranRoomInfo cranRoomInfo = cranRoomInfos.get(index);
        if (cranRoomInfo == null) {
            return;
        }
        // 将候选的三个CRAN机房放入到DRAN机房信息中去
        dranRoomInfo.setDistance(cranRoomInfo.getDistance());
    }

    // 传经纬度信息即可（可以使用继承的经纬度类）
    private double getDistance() {
        return 1;
    }
}
