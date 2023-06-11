/*
 * Copyright (c) 2022.  User:Unique66 File:JTSTest.java
 * Date:2022/12/11 23:54:11
 */

package com.sxh.work.gis;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.index.strtree.STRtree;

import java.util.List;

public class JTSTest {
    public static void main(String[] args) {
        STRtree strTree = new STRtree();
        GeometryFactory geometryFactory = new GeometryFactory();

        Point p1 = geometryFactory.createPoint(new Coordinate(180, 180));
        Point p2 = geometryFactory.createPoint(new Coordinate(170, 180));
        Point p3 = geometryFactory.createPoint(new Coordinate(179.456, 180));
        Point p4 = geometryFactory.createPoint(new Coordinate(180.324, 180));
        strTree.insert(p1.getEnvelopeInternal(), p1);
        strTree.insert(p2.getEnvelopeInternal(), p2);
        strTree.insert(p3.getEnvelopeInternal(), p3);
        strTree.insert(p4.buffer(0.022).getEnvelopeInternal(), p4);

        System.out.println(strTree.depth());
        Point queryP = geometryFactory.createPoint(new Coordinate(180.324, 180-0.023));
        List query = strTree.query(queryP.getEnvelopeInternal());
        for (Object obj : query) {
            System.out.println(obj);
        }

//        for (int i = 0; i < 50; i++) {
//            for (int j = 0; j < 50; j++) {
//                //新建一个点
//                Point p = geometryFactory.createPoint(new Coordinate(i, j));
//                //以点为中心，取一个半径为1.0的圆，插入RTree
//                //insert(Envelope itemEnv, Object item)
//                strTree.insert(p.buffer(300.0).getEnvelopeInternal(), p.buffer(300.0));
//            }
//        }
//        //构建RTree
//        strTree.build();
//        //查询点[1,1]落在哪些圆中
//        List querys = strTree.query(
//                geometryFactory.createPoint(
//                        new Coordinate(1, 1)).getEnvelopeInternal());
//        for (Object obj : querys) {
//            System.out.println(obj);
//        }
    }
}

