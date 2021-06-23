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
//        int MAX_SIZE = 8000000;
//        int[] arr = new int[MAX_SIZE];
//        for (int i = 0; i < MAX_SIZE; i++) {
//            arr[i] = (int) (Math.random() * 8000000);
//        }
//        long start = System.currentTimeMillis();
//        sort1(arr);
////        SortUtils.printArray(arr);
//        long end = System.currentTimeMillis();
//        System.out.println((end - start) + "ms"); // 8万数据大概耗时 20ms 80万耗时100ms
    }

    // 2021年5月22日17:45:33
    // 2021年2月19日23:03:593
    public static void sort1(int[] arr) {
        // 思想：堆排序的底层逻辑是利用了 大顶堆 或者 小顶堆 排序的思想
        // 大顶堆：树的根（arr[0]）为arr 最大值，将其提出，与arr 中的最后一位交换位置，然后将剩余的元素再组成一个大顶堆，
        // 直到arr 待处理元素个数为1

        // 那么首先就需要将arr 变为大顶堆
        // 找到树的最后一个非叶子节点，获取公式：arr.length / 2 - 1
        // ※※构造大顶堆本质是非叶子节点从后向前依次下沉的一个过程。
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            // 从最后一个非叶子节点开始，对比找到最大的元素，慢慢的将其移动到堆顶，构造大顶堆
            exchangeNode1(arr, arr.length, i);
        }
        // 跑完循环造出大顶堆，将最前面的元素（堆顶）与当前数组有效元素的最后一位交换位置
        for (int len = arr.length - 1; len > 0; len--) {
            int temp = arr[0];
            arr[0] = arr[len];
            arr[len] = temp;

            // 替换完后，将数组（长度len - 1）重新改为大顶堆
            exchangeNode1(arr, len, 0);
        }
    }

    /**
     * 造大顶堆（首先待处理树一定是个完全二叉树），需要找到最后一个非叶子节点
     * 拿左右子节点较大的那个节点和自身比较，
     * 如果子节点大，就将
     *
     * @param: arr 待处理数组
     * @param: length 当前数组可处理长度
     * @param: index 最后一个非叶子节点下标
     */
    public static void bigHeap(int[] arr, int length, int parentIndex) {
        int parent = arr[parentIndex]; // 记录最后一个非叶子节点的值，留坑
        int childL = parentIndex * 2 + 1;
        // 首次是最后一个非叶子节点的处理，所以可定能保证以最后一个非叶子节点为根节点的树
        // 在调整后，自己为一个大顶堆
        while (childL < length) {
            if (childL + 1 < length && arr[childL] < arr[childL + 1]) {
                // 说明右子节点更大
                childL++;
            }
            // 较大的子节点，与父节点比较
            if (parent > arr[childL]) { // 如果父节点已经大于最大的子节点了，那么就处理完毕了
                break;
            }
            arr[parentIndex] = arr[childL]; // 将较大的子节点放到父节点上
            parentIndex = childL; // 父节点下标向下沉
            childL = parentIndex * 2 + 1; // 向跳出循环的方向发展
        }
        // 循环完毕，将最初的那个坑填上
        arr[parentIndex] = parent;
    }

    /***
     *  将arr 数组构造为大顶堆
     *
     * @param: arr 剩余待处理的arr 元素
     * @param: i 最后一个非叶子节点所在数组下标
     * @param: length 剩余未排序的数组的长度
     */
    public static void exchangeNode1(int[] arr, int length, int i) {
        // 已知最后一个非叶子节点，则将其与其左右子节点对比
        int temp = arr[i]; // 记录该值（挖坑），以便后续替换
        // i 对应的左子节点下标为 2*i+1
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] < temp) {
                break;
            }
            arr[i] = arr[k];
            i = k;
        }
        // 循环完毕，将坑填上
        arr[i] = temp;
    }
}
