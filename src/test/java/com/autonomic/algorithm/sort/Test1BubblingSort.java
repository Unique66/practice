/*
 * Copyright (c) 2021.  User:SXH  File:BubblingSortTest.java
 * Date:2021/02/11 10:28:11
 */

package com.autonomic.algorithm.sort;

import com.autonomic.util.SortUtils;

/**
 * @author SXH
 * @description 练习冒泡排序
 * @date 2021/2/11 10:28
 */
public class Test1BubblingSort {
    public static void main(String[] args) {
        int[] array = {3, 9, -1, 10, 20};
        sort2(array);
        SortUtils.printArray(array);
        // 创建80000个随机数的数组
        int MAX_SIZE = 80000;
        int[] arr = new int[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        sort1(arr);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms"); // 八万数据大概耗时 10000ms
    }

    // 2021年5月7日21:06:28
    public static void sort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // 遍历的次数
            for (int j = 0; j < arr.length - 1 - i; j++) { // 从头到尾遍历，每遍历一遍，就有一个元素找到自己的位置，之后不用遍历该位置元素
                if (arr[j] > arr[j + 1]) {
                    SortUtils.exchangeElement(arr, j, j + 1);
                }
            }
        }
    }

    // 2021年2月11日10:40:01
    public static void sort1(int[] arr) {
        // 思想：冒泡排序就是从前到后两两对比，找出最大的放后面，经过一次遍历，arr 中最大的元素就会放到arr 最后面
        // 依次遍历len - 1 次，即可排序完毕
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtils.exchangeElement(arr, j, j + 1);
                }
            }
        }
    }
}
