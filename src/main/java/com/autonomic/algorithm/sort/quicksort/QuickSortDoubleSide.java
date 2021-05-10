/*
 * Copyright (c) 2021.  User:SXH  File:QuickSortDoubleSide.java
 * Date:2021/05/07 23:31:07
 */

package com.autonomic.algorithm.sort.quicksort;

import java.util.Arrays;

/**
 * @author SXH
 * @description 双边循环法实现快速排序
 * @date 2021/5/7 23:31
 */
public class QuickSortDoubleSide {

    public static void main(String[] args) {
		int [] arr1 = {-9, 78, 0, 23, -567, 70, 1};
        System.out.println(Arrays.toString(arr1));
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = getPivotIndex(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    // 双边循环法实现
    public static int getPivotIndex(int[] arr, int left, int right) {
        // 将第一个元素作为基准值
        int pivot = arr[left];
        int l = left;
        int r = right;
        while (l < r) {
            // 从右向左
            while (l < r && pivot < arr[r]) {
                r--;
            }
            // 从左向右
            while (l < r && pivot >= arr[l]) {
                l++;
            }
            // 两个while 循环遍历完后，找到可以交换的元素
            if (l < r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }
        // 跳出循环，说明l == r ，已经处理完当前数组，将基准值与l 的元素交换位置
        arr[left] = arr[l];
        arr[l] = pivot;
        return l;
    }
}
