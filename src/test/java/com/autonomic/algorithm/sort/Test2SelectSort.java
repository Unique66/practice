/*
 * Copyright (c) 2021.  User:SXH  File:Test2SelectSort.java
 * Date:2021/02/11 10:29:11
 */

package com.autonomic.algorithm.sort;

import com.autonomic.util.SortUtils;

/**
 * @author SXH
 * @description 练习选择排序
 * @date 2021/2/11 10:29
 */
public class Test2SelectSort {
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
        sort2(arr);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms"); // 八万数据大概耗时 2900ms
    }

    // 2021年5月22日11:46:58
    public static void sort2(int[] arr) {
        // 选择一个较小的元素（例如arr[0]），从前向后比，找出最小那个元素，放到第一位，接着从第二位开始找
        // 所以n 长度的数组，要找n-1 次才可以排序完毕
        for (int i = 0; i < arr.length - 1; i++) {
            // 每一次以第一位为最小值，一直找到最后一位元素
            // 循环一次后，第一位元素就确认了，从第二位找，一直找到最后一位元素
            int index = i; // 最小值元素下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            // 每次循环完毕，就找到了最小值元素所在下标，与此次循环数组首位进行交换位置
            if (index != i) {
                SortUtils.exchangeElement(arr, index, i);
            }
        }
        /*
         * 选择排序时间复杂度也是O(n²)  空间复杂度是O(1)
         */
    }

    // 2021年2月11日10:49:03
    public static void sort1(int[] arr) {
        // 思想:假定第一个元素为最小元素,向后遍历,找到实际最小的那个元素的下标
        // 交换最初假定下标和最小下标的两个元素，如果遍历一遍后，最小的元素依旧是假定的那个元素，则不用交换
        // 第一次遍历就会确定arr 中最小的元素，放在第一位0，依次向后遍历，共遍历len - 1 次，即可排序完毕
        for (int i = 0; i < arr.length - 1; i++) { // 如果arr 有10个元素，遍历9次即可，也就是  i = 0-8
            // 第一次从0，第二次从1，那么 假定的元素下标就可以为i
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) { // 找到比假定的元素还小的元素，则记录次元素下标到index
                    index = j;
                }
            }
            // 遍历完毕后，确定最小元素下标
            if (index != i) {
                SortUtils.exchangeElement(arr, index, i);
            }
        }
    }
}
