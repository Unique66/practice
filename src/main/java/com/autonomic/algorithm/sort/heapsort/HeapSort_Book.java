/*
 * Copyright (c) 2021.  User:SXH  File:HeapSort_Book.java
 * Date:2021/05/10 20:49:10
 */

package com.autonomic.algorithm.sort.heapsort;

import java.util.Arrays;

/**
 * @author SXH
 * @description 《漫画算法》- 4.4 堆排序：基于二叉堆实现
 * @date 2021/5/10 20:49
 */
public class HeapSort_Book {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 1, 3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

        // 创建800万个随机数的数组
        int MAX_SIZE = 8000000;
        int[] arrMax = new int[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            arrMax[i] = (int) (Math.random() * 8000000);
        }
        long start = System.currentTimeMillis();
        heapSort(arrMax);
        long end = System.currentTimeMillis();
        System.out.println((end - start)); // 800W 数据 1722 ms
//        System.out.println(Arrays.toString(arrMax));
    }

    // 堆排序 从小到大排序
    public static void heapSort(int[] arr) {
        // 首先将arr 调整为二叉堆
        int noLeafIndex = arr.length / 2 - 1;
        for (int i = noLeafIndex; i >= 0; i--) {
            downAdjust(arr, i, arr.length);
        }
        // 取堆顶，也就是下标为0 的元素，与最后一位元素交换位置
        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            // 交换完元素后，下降堆顶新元素，将二叉树调整为大顶堆
            downAdjust(arr, 0, i);
        }
    }

    /**
     * 堆节点向下调整 大顶堆为例
     *
     * @param arr 待调整的堆
     * @param parentIndex 向下调整的元素下标
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] arr, int parentIndex, int length) {
        // 记录待处理元素值
        int tmp = arr[parentIndex];
        // 获得其左孩子节点下标
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            // 比较待处理元素左右孩子节点的大小，将大的找出来
            if (childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]) {
                childIndex++;
            }
            // 将较大的孩子节点值与待处理元素值相比
            if (arr[childIndex] < tmp) { // 如果父节点元素大，说明已经OK了，不用再向下调整
                break;
            }
            // 否则就要向下调整元素，孩子节点上移
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        // 该循环走完后，说明已经找到了tmp 应该存放的位置了
        arr[parentIndex] = tmp;
    }
}
