/*
 * Copyright (c) 2021.  User:SXH  File:SortUtils.java
 * Date:2021/02/11 10:33:11
 */

package com.autonomic.util;

import java.util.Arrays;

/**
 * @author SXH
 * @description 排序工具类
 * @date 2021/2/11 10:33
 */
public class SortUtils {
    /**
     * 交换数组中两个下标对应的元素
     *
     * @param arr 待处理数组
     * @param indexI 元素下标 i
     * @param indexJ 元素下标 j
     */
    public static void exchangeElement(int[] arr, int indexI, int indexJ) {
        int temp = arr[indexI]; // 定义临时变量存储下标i 元素
        arr[indexI] = arr[indexJ];
        arr[indexJ] = temp;
    }

    /**
     * 打印数组
     *
     * @param arr 待打印数组
     */
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
