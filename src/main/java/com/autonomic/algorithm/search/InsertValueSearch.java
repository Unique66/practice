package com.autonomic.algorithm.search;

import java.util.Arrays;

/**
 * 插值查找
 * @date 2020/11/16 22:43
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        // 初始化一个1-100 的数组
        int [] arr = new int[100];
        for (int i = 0 ; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(findValue(arr, 0, arr.length - 1, 98));
    }

    /**
     * 思想：
     * 二分查找是从中间开始查找，插值查找对mid 下标重新定义，使查找数值紧凑的有序数组时效率更高
     */
    public static int findValue(int [] arr, int left, int right, int findVal) {
        // 设置递归退出条件
        if (left > right || findVal < arr[left] || findVal > arr[right]) {
            return -1;
        }
        System.out.println("find times");
        // 找到mid 值
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        // 递归查找
        if (findVal > midVal) {
            // 向右找
            return findValue(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            // 向左找
            return findValue(arr, left, mid, findVal);
        } else {
            return mid;
        }
    }
}
