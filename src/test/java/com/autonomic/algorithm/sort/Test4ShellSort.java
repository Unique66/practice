/*
 * Copyright (c) 2021.  User:SXH  File:Test4ShellSort.java
 * Date:2021/02/11 10:30:11
 */

package com.autonomic.algorithm.sort;

import com.autonomic.util.SortUtils;

/**
 * @author SXH
 * @description 练习希尔排序
 * @date 2021/2/11 10:30
 */
public class Test4ShellSort {
    public static void main(String[] args) {
        int[] array = {3, 9, -1, 10, 20, 4, 1, 4};
        sort2(array);
        SortUtils.printArray(array);
        // 创建80000个随机数的数组
//        int MAX_SIZE = 80000;
//        int[] arr = new int[MAX_SIZE];
//        for (int i = 0; i < MAX_SIZE; i++) {
//            arr[i] = (int) (Math.random() * 8000000);
//        }
//        long start = System.currentTimeMillis();
//        sort1(arr);
////        SortUtils.printArray(arr);
//        long end = System.currentTimeMillis();
//        System.out.println((end - start) + "ms"); // 八万数据大概耗时 1000s
    }

    // 2021年5月22日12:11:18
    public static void sort2(int[] arr) {
        // 希尔排序就是在插入排序的基础上添加了对数组分组，减少原始数组初始元素位置不合适导致的最差时间复杂度
        // 对分组后的元素每组都来一遍插入排序
        // 长度为n 的元素，首次分n/2 组，依次类推，直到为一组
        int len = arr.length;
        while ((len /= 2) > 0) {
            for (int i = len; i < arr.length; i += len) {
                int insertIndex = i;
                int insertValue = arr[i];
                while (insertIndex - len >= 0 && arr[insertIndex - len] > insertValue) {
                    arr[insertIndex] = arr[insertIndex - len];
                    insertIndex -= len;
                }
                if (insertIndex != i) {
                    arr[insertIndex] = insertValue;
                }
            }
        }
    }

    // 2021年2月11日12:15:02
    public static void sort1(int[] arr) {
        // 思想：在插入排序的基础上，提前处理好待排序数组的元素复杂性问题，将数组拆分为一个个小数组，做多次插入排序
        // 比如有arr 有10 个元素，那么先将其分为 10/2=5 组，2个元素一组，做插入排序，然后再分为5/2=2 组，五个元素一组，做插入排序
        // 最后分为2/2=1 ，arr 再做一次插入排序
        int len = arr.length;
        while ((len /= 2) != 0) {
            // 引入插入排序逻辑（注：就不是按顺序的排序了，分组后，每组元素两两之间可能相隔几个下标位）
            // 不过还是遍历到最后一个数组
            for (int i = len; i < arr.length; i += len) {
                int insertIndex = i;
                int insertValue = arr[insertIndex];
                while (insertIndex - len >= 0 && arr[insertIndex - len] > insertValue) {
                    // 向后移动有序数组大于待插入元素的元素下标
                    arr[insertIndex] = arr[insertIndex - len];
                    insertIndex -= len;
                }
                if (insertIndex != i) {
                    arr[insertIndex] = insertValue;
                }
            }
        }
    }
}
