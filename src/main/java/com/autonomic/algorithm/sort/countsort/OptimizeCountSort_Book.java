/*
 * Copyright (c) 2021.  User:SXH  File:OptimizeCountSort.java
 * Date:2021/05/10 22:34:10
 */

package com.autonomic.algorithm.sort.countsort;


import java.util.Arrays;

/**
 * @author SXH
 * @description 《漫画算法》 4.5 - 优化后的计数排序
 * @date 2021/5/10 22:34
 */
public class OptimizeCountSort_Book {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 7, 3, 6, 2};
        int[] sortedArray = optimizeCountSort(arr);
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * 计数排序3.0
     * 优化的计数排序
     *
     * @param arr 待排序数组
     */
    public static int[] optimizeCountSort(int[] arr) {
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
        // 初始化统计数组
        int[] tempArray = new int[len];
        for (int k : arr) {
            tempArray[k - offset]++;
        }
        // 3、统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < tempArray.length; i++) {
            tempArray[i] += tempArray[i-1];
        }
        // 4、倒序遍历原始数列，从统计数组找到正确的位置，输出到结果数组
        int[] sortedArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArray[tempArray[arr[i] - min] - 1] = arr[i]; // 排第一位，实际存储的下标是0，所以要减1
            tempArray[arr[i] - min]--; // 统计数组对应的元素值减1，向前遍历遇到相同的元素时，该元素的排名就在前一位了
        }
        return sortedArray;
    }
}
