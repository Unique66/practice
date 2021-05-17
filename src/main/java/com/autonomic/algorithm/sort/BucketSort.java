/*
 * Copyright (c) 2021.  User:SXH  File:BucketSort.java
 * Date:2021/05/17 20:49:17
 */

package com.autonomic.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author SXH
 * @description 《漫画算法》 4.5.4 桶排序
 * @date 2021/5/17 20:49
 */
public class BucketSort {
    public static void main(String[] args) {
        double[] arr = new double[]{4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        double[] sortedArray = bucketSort(arr);
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * 创建的桶数量等于原始数列的元素数量，除最后一个桶只包含数列最大值之外，前面各个桶的区间按比例来确定
     * 区间跨度 = （最大值-最小值）/（桶的数量-1）
     * 如{4.5, 0.84, 3.25, 2.18, 0.5}
     * 可拆分5个桶： [0.5, 1.5) [1.5, 2.5) [2.5, 3.5) [3.5, 4.5) [4.5, 4.5]
     *
     * @param: arr
     */
    public static double[] bucketSort(double[] arr) {
        // 1、得到数列的最大值和最小值，并算出差值d
        double max = arr[0];
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        double d = max - min;

        // 2、初始化桶
        int bucketNum = arr.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        // 3、遍历原始数组，将每个元素放入桶中
        for (double v : arr) {
            int num = (int) ((v - min) * (bucketNum - 1) / d); // 计算元素下标 ※
            bucketList.get(num).add(v);
        }

        // 4、对每个桶内部进行排序
        for (LinkedList<Double> doubles : bucketList) {
            // JDK 底层采用了归并排序或归并的优化版本
            Collections.sort(doubles);
        }

        // 5、输出全部元素
        double[] sortedArray = new double[arr.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (Double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }
}
