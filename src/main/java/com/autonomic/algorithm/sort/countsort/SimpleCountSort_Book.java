/*
 * Copyright (c) 2021.  User:SXH  File:SimpleCountSort.java
 * Date:2021/05/10 22:33:10
 */

package com.autonomic.algorithm.sort.countsort;

import java.util.Arrays;

/**
 * @author SXH
 * @description 《漫画算法》 4.5 - 简单的计数排序
 * @date 2021/5/10 22:33
 */
public class SimpleCountSort_Book {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 7, 3, 6, 2};
        countSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[]{95, 94, 91, 99, 92, 90};
        optimizeCountSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * 计数排序1.0
     * 最原始的计数排序
     *
     * 缺点：如果数组是 {95, 94, 91, 99, 92, 90} 这样的存储情况，那么就需要临时数组的长度为100，而其中很大一部分空间是浪费掉的
     *
     * @param arr 待排序数组
     */
    public static void countSort(int[] arr) {
        // 1、arr 元素的前提：都是0-9 的正整数，设置一个数组
        int[] tempArray = new int[10];
        // 2、遍历arr 数组，tempArray 对应元素值下标的元素+1
        for (int element : arr) {
            tempArray[element]++;
        }
        // 3、处理完后，遍历tempArray 即可
        int index = 0;
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray[i]; j++) {
                arr[index++] = i;
            }
        }
    }

    /**
     * 计数排序2.0
     * 稍微优化的计数排序
     * 简单计数排序存在的问题：
     * 如果数组是 {95, 94, 91, 99, 92, 90} 这样的存储情况，那么就需要临时数组的长度为100，而其中很大一部分空间是浪费掉的
     * 我们可以找到最大值和最小值，不再以输入数列的最大值+1 作为统计数组的长度，而是以 数列最大值-最小值+1 作为统计数组的长度
     * 同时，数列的最小值作为一个偏移量，用于计算整数在统计数组中的下标。
     *
     * 缺点：不稳定
     *
     * @param arr 待排序数组
     */
    public static void optimizeCountSort(int[] arr) {
        // 1、遍历arr 元素，找到最大值和最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];

            }
        }
        System.out.println("max:" + max + " min:" + min);
        // 2、计算数组长度和偏移量
        int len = max - min + 1;
        int offset = min; // 用于计算整数在统计数组中的下标
        // 初始化临时数组
        int[] tempArray = new int[len];
        for (int k : arr) {
            tempArray[k - offset]++;
        }
        // 3、处理完后，遍历tempArray 即可
        int index = 0;
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray[i]; j++) {
                arr[index++] = i + offset;
            }
        }
    }
}
