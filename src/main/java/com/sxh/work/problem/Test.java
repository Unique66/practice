/*
 * Copyright (c) 2022.  User:Unique66 File:Test.java
 * Date:2022/12/11 19:46:11
 */

package com.sxh.work.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        CranRoomInfo cranRoomInfo1 = new CranRoomInfo();
        CranRoomInfo cranRoomInfo2 = new CranRoomInfo();

        List<CranRoomInfo> list1 = new ArrayList<>();
        List<CranRoomInfo> list2 = new ArrayList<>();
        System.out.println(cranRoomInfo1);
        list1.add(cranRoomInfo1);
        list2.add(cranRoomInfo1);
        cranRoomInfo1.setId("1");
        System.out.println(list1.get(0));
        System.out.println(list2.get(0));


        Set<CranRoomInfo> set = new HashSet<>();
        set.add(cranRoomInfo1);
        set.add(cranRoomInfo1);
        set.add(list2.get(0));
        System.out.println(set.size());

        test();
    }


    public static void test() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
//                System.out.println("i: " + i + " j: " + j);
                Math.random();
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("spend: " + (end - start));
    }
}
