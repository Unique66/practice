/*
 * Copyright (c) 2021.  User:SXH  File:Test8HeapSort.java
 * Date:2021/02/11 10:31:11
 */

package com.autonomic.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author SXH
 * @description 练习桶排序
 * @date 2021/2/11 10:31
 */
public class Test9BucketSort {
    public static void main(String[] args) {
        double[] array = {4.3, 2.1, 3.3, 4.5, 0.5, 1.7};
        System.out.println(Arrays.toString(sort1(array)));
    }

    public static double[] sort1(double[] arr) {
        // 找到最大值和最小值，将元素分为几个段
        double max = arr[0];
        double min = arr[0];
        for (double a : arr) {
            if (max < a) {
                max = a;
            }
            if (min > a) {
                min = a;
            }
        }
        // 去差值后，分段
        double segment = (max - min) / (arr.length - 1);
        // 创建桶，并初始化
        ArrayList<LinkedList<Double>> bucket = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            bucket.add(new LinkedList<>());
        }
        // 遍历原始数组，将元素放到合适的segment 桶编号中
        for (double v : arr) { // min 指游标值，从min开始处理
            int index = (int)((v - min) / segment);
            bucket.get(index).add(v);
        }
        // 将每个桶内部进行排序
        for (LinkedList<Double> doubles : bucket) {
            Collections.sort(doubles);
        }
        // 依次输出元素
        double[] sortedArray = new double[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (Double d : bucket.get(i)) {
                sortedArray[index++] = d;
            }
        }
        return sortedArray;
    }
}
