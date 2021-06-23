/*
 * Copyright (c) 2021.  User:SXH  File:Test8HeapSort.java
 * Date:2021/02/11 10:31:11
 */

package com.autonomic.algorithm.sort;

import com.autonomic.util.SortUtils;

/**
 * @author SXH
 * @description 练习计数
 * @date 2021年5月22日13:05:12
 */
public class Test10CountSort {
    public static void main(String[] args) {
        int[] array = {9, 3, 4, 10, 20, 1, 200, 21};
        sort1(array);
        SortUtils.printArray(array);
    }

    // 较为优化的方法
    public static void sort1(int[] arr) {
        // 1、找到最大值和最小值
        int max = arr[0];
        int min = arr[0];
        for (int a : arr) {
            if (max < a) {
                max = a;
            }
            if (min > a) {
                min = a;
            }
        }
        // 2、初始化一个长度为 max-min + 1 的数组
        int[] temp = new int[max - min + 1];
        for (int k : arr) {
            temp[k - min]++;
        }
        // 3、将元素从临时数组拿出来
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i]; j++) {
                arr[index++] = i + min;
            }
        }
    }
}
