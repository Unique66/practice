/*
 * Copyright (c) 2021.  User:SXH  File:QuickSortDoubleSide.java
 * Date:2021/05/07 23:31:07
 */

package com.autonomic.algorithm.sort.quicksort;

import java.util.Arrays;

/**
 * @author SXH
 * @description 单边循环实现全速排序
 * @date 2021/5/7 23:31
 */
public class QuickSortSingleSide {

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

    // 单边循环法实现  从小到大排序
    public static int getPivotIndex(int[] arr, int left, int right) {
        // 第一个元素为基准元素
        int pivot = arr[left];
        // 初始化Mark 的index  代表小于基准元素的区域边界
        int markIndex = left;
        // 从第二个元素遍历数组
        for (int i = markIndex + 1; i <= right; i++) {
            // 如果元素大于基准值，markIndex 不动；
            // 小于基准元素，markIndex 向右移动，并且将markIndex 对应元素和遍历到的元素交换
            if (arr[i] < pivot) {
                markIndex++;
                int tmp = arr[i];
                arr[i] = arr[markIndex];
                arr[markIndex] = tmp;
            }
        }
        // 遍历完毕后，将markIndex 对应元素和基准值做交换
        arr[left] = arr[markIndex];
        arr[markIndex] = pivot;
        return markIndex;
    }
}
