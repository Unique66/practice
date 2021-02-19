/*
 * Copyright (c) 2021.  User:SXH  File:Test7QuickSort.java
 * Date:2021/02/11 10:31:11
 */

package com.autonomic.algorithm.sort;

import com.autonomic.util.SortUtils;

/**
 * @author SXH
 * @description 练习快速排序
 * @date 2021/2/11 10:31
 */
public class Test7QuickSort {
    public static void main(String[] args) {
        int[] array = {9, 3, 4, 10, 20, 1, 200, 21};
        sort1(array, 0, array.length - 1);
        SortUtils.printArray(array);
        // 创建80000个随机数的数组
        int MAX_SIZE = 8000000;
        int[] arr = new int[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        sort1(arr, 0, arr.length - 1);
//        SortUtils.printArray(arr);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms"); // 8万数据大概耗时 20ms 80万耗时100ms
    }

    // 2021年2月19日23:03:32
    public static void sort1(int[] arr, int l, int r) {
        // 思想：快速排序就是取出一个数作为中间值，比如取出第一个元素为中间值，将剩下的元素比它小的放到左边，比它大的放在右边
        // 和挖坑，填坑一样，这样再左右递归一下，就可以完成排序了
        if (l < r) {
            // 取第一个元素为基准值
            int standard = arr[l];
            // 接下来，从右边开始，找到比基准值小的数，交换
            int left = l;
            int right = r;
            while (left < right) {
                // 从右边开始
                while (left < right && arr[right] > standard) {
                    right--;
                }
                // 跑完上面的while 循环后，就说明要么left 和 right相遇，要么找到了右边比基准值小的数了
                if (left < right) {
                    // 填坑，将比基准值小的那个元素放到基准值的位置
                    arr[left++] = arr[right];
                }
                // 接着开始处理左边
                while (left < right && arr[left] < standard) {
                    left++;
                }
                // 跑完上面的循环后，说明要么left 和right 相遇，要么找到了左边比基准值小的数
                if (left < right) {
                    // 将左边的元素，填到上次的坑里
                    arr[right--] = arr[left];
                }
            }
            // 跳出上面循环，说明 left == right，此刻将基准值放到该处
            arr[left] = standard;

            // 递归调用该方法，完成排序
            sort1(arr, l, left - 1); // ※ 此处是left - 1 ，而非left，基准值不用再次排序
            sort1(arr, left + 1, r);
        }
    }
}
