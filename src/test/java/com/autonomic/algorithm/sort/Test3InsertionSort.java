/*
 * Copyright (c) 2021.  User:SXH  File:Test3InsertionSort.java
 * Date:2021/02/11 10:29:11
 */

package com.autonomic.algorithm.sort;

import com.autonomic.util.SortUtils;

/**
 * @author SXH
 * @description 练习插入排序
 * @date 2021/2/11 10:29
 */
public class Test3InsertionSort {
    public static void main(String[] args) {
        int[] array = {3, 9, -1, 10, 20, 5};
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
//        long end = System.currentTimeMillis();
//        System.out.println((end - start) + "ms"); // 八万数据大概耗时 680ms
    }

    // 2021年5月22日11:58:27
    public static void sort2(int[] arr) {
        // 插入排序将数组分为左边有序数组和右边无序数组  （从小到大）
        // 首次则第一个元素是有序数组，剩下的元素组成无序数组
        // 从无序数组取出第一位元素，放入的有序数组中去，保证有序数组继续有序
        // 也就是需要把从无序数组取出来的元素放入到有序数组中合适 的位置（首次比它小的元素后面）
        // 此方式需要对长度为n 的数组做n-1次处理
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i;
            int insertValue = arr[i];
            // 遍历有序数组   第一个判断是保证后面的判断不会出现数组下标越界
            while (insertIndex - 1 >= 0 && arr[insertIndex - 1] > insertValue) {
                // 如果有序数组前一个元素比待插入元素大，那么有序数组当前这个比较的元素向后移动insertIndex 需要向前移动一位
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            // 跳出循环说明已经找到合适的位置了
            if (insertIndex != i) {
                arr[insertIndex] = insertValue;
            }
        }
        /*
         * 插入排序的时间复杂度是最差是O(n²)
         */
    }

    // 2021年2月11日10:59:47
    public static void sort1(int[] arr) {
        // 思想：将arr 分为左边有序数组，右边无序数组，arr[0] 就可以为初始的左边有序数组，元素个数为1
        // 然后将右边无序数组的第一个元素取出，放入到左边有序数组中去，保证放入后，有序数组依然是有序的
        // 一共需要遍历len-1 次
        for (int i = 1; i < arr.length; i++) { // arr[0] 已经是有序数组了，所以从 index=1 第二个元素开始处理，直到最后一个元素位置
            // 无序数组中拿出第一个元素，与有序数组从后向前对比，并插入合适位置
            int insertIndex = i; // 待插入元素下标
            int insertValue = arr[insertIndex]; // 待插入元素值
            while (insertIndex - 1 >= 0 && arr[insertIndex - 1] > insertValue) {
                // 如果有序数组元素大于待插入元素，则将有序数组元素向后移动一位
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            // 跳出循环后，说明找到了可以插入的合适位置，只要这个位置不是初始要处理的无序数组的第一个元素的位置，就替换
            if (insertIndex != i) {
                arr[insertIndex] = insertValue;
            }
        }
    }
}
