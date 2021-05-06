/*
 * Copyright (c) 2021.  User:SXH  File:Test8HeapSort.java
 * Date:2021/02/11 10:31:11
 */

package com.autonomic.algorithm.sort;

import com.autonomic.util.SortUtils;

/**
 * @author SXH
 * @description 练习堆排序
 * @date 2021/2/11 10:31
 */
public class Test8HeapSort {
    public static void main(String[] args) {
        int[] array = {9, 3, 4, 10, 20, 1, 200, 21};
        sort1(array);
        SortUtils.printArray(array);
        // 创建80000个随机数的数组
        int MAX_SIZE = 8000000;
        int[] arr = new int[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        sort1(arr);
//        SortUtils.printArray(arr);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms"); // 8万数据大概耗时 20ms 80万耗时100ms
    }

    // 2021年2月19日23:03:59
    public static void sort1(int[] arr) {
        // 思想：堆排序的底层逻辑是利用了 大顶堆 或者 小顶堆 排序的思想
        // 大顶堆：树的根（arr[0]）为arr 最大值，将其提出，与arr 中的最后一位交换位置，然后将剩余的元素再组成一个大顶堆，
        // 直到arr 待处理元素个数为1

        // 那么首先就需要将arr 变为大顶堆
        // 找到树的最后一个非叶子节点，获取公式：arr.length / 2 - 1
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            // 从最后一个非叶子节点开始，对比找到最大的元素，慢慢的将其移动到堆顶，构造大顶堆

        }


    }

    /***
     *  将arr 数组构造为大顶堆
     *
     * @param: arr 剩余待处理的arr 元素
     * @param: i 最后一个非叶子节点所在数组下标
     * @param: length 剩余未排序的数组的长度
     */
    public static void exchangeNode1(int[] arr, int i, int length) {
        // 已知最后一个非叶子节点，则将其与其左右子节点对比
        int temp = arr[i]; // 记录该值（挖坑），以便后续替换
        // i 对应的左子节点下标为 2*i+1
        for (int k = 2*i+1; k < length; k = k*2+1) {

        }
    }
}
