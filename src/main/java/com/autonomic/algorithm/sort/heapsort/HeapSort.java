/*
 * Copyright (c) 2021.  User:SXH  File:HeapSort.java
 * Date:2021/02/19 23:23:19
 */

package com.autonomic.algorithm.sort.heapsort;

import java.util.Arrays;

/**
 * @author SXH
 * @description 堆排序  nlogn 时间复杂度
 * @date 2020/12/2 22:38
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
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

    public static void heapSort(int[] arr) {
        int temp;
        // 逐步推导，分步完成
        // 经过下面两次交换，将最大值移动到树的顶部，接下来需要交换第一个元素和最后一个元素位置
//        exchangeNode(arr, 1, arr.length);
//        exchangeNode(arr, 0, arr.length); // 此时还没有将较大值移动到数组最后面，摘除那个元素，所以 length 还是传数组长度

        // 以代码形式实现逐步的交换 最后一个非叶子节点下标的获取公式：arr.length/2-1
        /** 1.将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆 **/
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            exchangeNode(arr, i, arr.length);
        }

        /**
         * 2.将堆顶元素与末尾元素交换，将最大元素“沉”到数组末端
         * 3.重新调整结构，使数组再次满足堆定义，继续交换堆顶元素和当前末尾元素。反复执行调整+交换步骤，直到整个序列有序
         */
        for (int j = arr.length - 1; j > 0; j--) { // ※如果数组长度是5，其实比较4次就可以排序好，所以 j > 0 不用=0
            // 2.执行交换
            temp = arr[j]; // 最后一个元素
            arr[j] = arr[0]; // arr[0] 是最大值
            arr[0] = temp;
            // 3.
            // 此处i 参数是0 ：执行交换前，数组符合堆定义，交换后，最后一个元素不用管，
            // 数组结构只有 index=0 的元素做了调整，所以传0 来调整元素位置以满足堆定义
            exchangeNode(arr, 0, j);
        }
    }

    /**
     * @param: arr 待排序数组
     * @param: i 指最后一个非叶子节点所在数组下标
     * @param: length 当前剩余未排序数组长度（
     * 大顶堆 堆排序，会将最大值移动到数组最右边，再将剩余的数组元素匹配成大顶堆，然后再摘出一个最大值）
     * 所以length 会减少
     * 以{4, 6, 8, 5, 9} 为例，第一次调整 i 对应的就是元素6 所在的下标， i = 1   length = 5
     */
    public static void exchangeNode(int[] arr, int i, int length) {
        // 首先将最后一个非叶子节点的值与其左右叶子节点对比
        int temp = arr[i]; // 记录值（挖坑），以便后续替换
        // i 对应的左子节点下标为  2 * i + 1
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            // 判断左子节点和右子节点大小 找到最大的那个节点
            // 由于for 循环条件中只有 k < length 的限制， k + 1 可能越界，所以加 k+1 < length 的条件
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++; // 保留值大的节点对应数组的下标
            }
            // 这里就找到了节点中值较大的元素，将该元素与最后一个非叶子节点的值进行比较，子节点的值大，就替换
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break; // ※子节点的值都小于最后一个非叶子节点的值，符合大顶堆的规定，不用替换
            }
        }
        // 前面只将较大子节点的值赋值给了父节点，需要将父节点的值放入到较大子节点处
        arr[i] = temp;
    }
}
