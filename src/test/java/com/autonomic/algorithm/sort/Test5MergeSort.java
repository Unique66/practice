/*
 * Copyright (c) 2021.  User:SXH  File:Test5MergeSort.java
 * Date:2021/02/11 10:30:11
 */

package com.autonomic.algorithm.sort;

import com.autonomic.util.SortUtils;

/**
 * @author SXH
 * @description 练习归并排序
 * @date 2021/2/11 10:30
 */
public class Test5MergeSort {
    public static void main(String[] args) {
        int[] array = {3, 5, 8, 10, 1, 2, 6, 9, -1};
        int[] temp = new int[array.length];
        sort2(array, 0, array.length - 1, temp);
        SortUtils.printArray(array);
        // temp 数组是空间换时间的做法
        // 创建80000个随机数的数组
//        int MAX_SIZE = 800000;
//        int[] arr = new int[MAX_SIZE];
//        for (int i = 0; i < MAX_SIZE; i++) {
//            arr[i] = (int) (Math.random() * 8000000);
//        }
//        int[] temp1 = new int[MAX_SIZE];
//        long start = System.currentTimeMillis();
//        sort1(arr, 0, MAX_SIZE - 1, temp1);
////        SortUtils.printArray(arr);
//        long end = System.currentTimeMillis();
//        System.out.println((end - start) + "ms"); // 八万数据大概耗时 10ms   80万数据耗时100ms
    }

    // 2021年5月22日12:22:19
    // 时间复杂度：nlogn   空间复杂度：O(n)
    public static void sort2(int[] arr, int l, int r, int[] temp) {
        // 归并排序可以将长度为n 的数组先拆成 n 个长度为1 的数组
        // 这n 个数组都是有序的，所以可以将两个有序数组进行合并，左右读取元素，谁大存temp，然后tempIndex++
        if (l < r) {
            int mid = (l + r) / 2;
            sort2(arr, l, mid, temp); // 左拆分
            sort2(arr, mid + 1, r, temp); // 右拆分
            merge2(arr, l, mid, r, temp);
        }
    }

    public static void merge2(int[] arr, int l, int m, int r, int[] temp) {
        // 遍历左右两个数组，合并
        int left = l;
        int mid = m + 1;
        int tempIndex = 0;
        while (left <= m && mid <= r) {
            if (arr[left] < arr[mid]) {
                temp[tempIndex++] = arr[left++];
            } else {
                temp[tempIndex++] = arr[mid++];
            }
        }
        // 上面遍历完后，一定有一边的数组元素没有处理完毕，需要处理
        while (left <= m) {
            temp[tempIndex++] = arr[left++];
        }
        while (mid <= r) {
            temp[tempIndex++] = arr[mid++];
        }
        // 到此已经将两个有序数组合并到temp 中并保证有序性
        // 将元素从temp 中移动到原数组中去
        int index = 0;
        for (int i = l; i <= r; i++) {
            arr[i] = temp[index++];
        }
    }

    // 2021年2月11日10:59:47
    public static void sort1(int[] arr, int l, int r, int[] temp) {
        // 思想：就是将arr 分为len 个长度为1 的数组，这样左右合并为有序数组
        if (l < r) {
            // 向左递归
            sort1(arr, l, (l + r) / 2, temp);
            // 向右递归
            sort1(arr, (l + r) / 2 + 1, r, temp);
            // 最后做合并操作
            merge1(arr, l, (l + r) / 2, r, temp);
        }
    }

    public static void merge1(int[] arr, int l, int m, int r, int[] temp) {
        // 假定最后一次合并，左右两个有序数组合并
        int left = l; // 左边有序数组的第一个下标
        int mid = m + 1; // 右边有序数组的第一个下标
        int tempIndex = 0;
        while (left <= m && mid <= r) {
            if (arr[left] < arr[mid]) {
                temp[tempIndex++] = arr[left++];
            } else {
                temp[tempIndex++] = arr[mid++];
            }
        }
        // 跳出上面while 循环后，说明其中一个边的数组已经全部放入到了temp 临时数组中去了
        while (left <= m) { // 左边数组没有处理完，则遍历处理移入temp 中
            temp[tempIndex++] = arr[left++];
        }
        while (mid <= r) { // 右边数组没有处理完，则遍历处理移入temp 中
            temp[tempIndex++] = arr[mid++];
        }
        // 全部移入到temp 中，此时temp 是个有序数组，从小到大
        // 将temp 中的元素悉数移入arr 中 从 l - r
        for (int i = 0; i < tempIndex; i++) {
            arr[l++] = temp[i];
        }
    }
}
