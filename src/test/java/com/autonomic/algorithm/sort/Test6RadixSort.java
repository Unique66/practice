/*
 * Copyright (c) 2021.  User:SXH  File:Test6RadixSort.java
 * Date:2021/02/11 10:31:11
 */

package com.autonomic.algorithm.sort;

import com.autonomic.util.SortUtils;

/**
 * @author SXH
 * @description 练习基数排序 空间换时间，不能排序负数
 * @date 2021/2/19 21:50
 */
public class Test6RadixSort {
    public static void main(String[] args) {
        int[] array = {3, 9, 4, 10, 20};
        sort2(array);
        SortUtils.printArray(array);
        // 创建80000个随机数的数组
//        int MAX_SIZE = 800000;
//        int[] arr = new int[MAX_SIZE];
//        for (int i = 0; i < MAX_SIZE; i++) {
//            arr[i] = (int) (Math.random() * 8000000);
//        }
//        long start = System.currentTimeMillis();
//        sort1(arr);
////        SortUtils.printArray(arr);
//        long end = System.currentTimeMillis();
//        System.out.println((end - start) + "ms"); // 八万数据大概耗时 20ms  80万数据耗时60ms
    }

    // 2021年5月22日12:38:26
    public static void sort2(int[] arr) {
        // 基数排序就是找到待排序元素中最大值，算出位数，然后从个位开始拿一遍，放到准备的0-9 桶中
        // 然后再取回来放入到原数组，接着算十位，依次类推，最终排序完毕

        // 准备十个桶
        int[][] bucket = new int[10][arr.length];
        int[] helper = new int[10]; // 记录每个桶中存放的元素个数，默认0

        // 先找到最大值
        int max = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxLen = (max + "").length(); // 最大位数
        // 从个位开始比较
        for (int i = 0, x = 1; i < maxLen; i++, x *= 10) { // 循环maxLen 次
            // 计算元素个位数
            for (int j = 0; j < arr.length - 1; j++) {
                int digit = arr[j] / x % 10;
                bucket[digit][helper[digit]++] = arr[j];
            }
            // 循环一次后将元素从10 个桶中放回到原数组
            int index = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < helper[j]; k++) {
                    arr[index++] = bucket[j][k];
                }
                helper[j] = 0; // 重置为0，保证下次十位或其他位使用
            }
        }
    }

    // 2021年2月19日21:51:40
    public static void sort1(int[] arr) {
        // 基本思路：0-9 10个桶，首先按arr 元素中的个位的数值，依次放入0-9 10个桶中，然后依次从0-9 取出放入到arr 中
        // 接着就是按arr 元素中的十位数为基准，放入的10个桶中，直到arr 中最大元素的最大位数为止，放完到10 个桶中，取出即为从小到大的排序

        // 1.准备10 个桶
        int[][] bucket = new int[10][arr.length]; // 二维数组中，第二个是表示此时0-9 的桶中分别有多少元素的
        // 2.记录每个桶中都放几个元素
        int[] bucketCount = new int[10]; // 最大是同一位的元素都是同一个桶中，也就是arr 数组的长度
        // 3.找到arr 数组中最大的那个数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        // 循环完毕后，即找到了最大的那个元素
        // 4.最大元素有几位？
        int size = (max + "").length();
        // 5.从个位开始循环处理
        for (int i = 0, n = 1; i < size; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                // 计算出个位的值
                int k = arr[j] / n % 10;
                bucket[k][bucketCount[k]++] = arr[j]; // 将元素依次放入到桶中
            }
            // 放完后，需要依次取出放回arr
            int index = 0;
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < bucketCount[x]; y++) {
                    arr[index++] = bucket[x][y];
                }
                // 取完一个桶，就把负责记录该桶元素个数的临时变量 bucketCount[x] 置为0，以便下次处理十位用
                bucketCount[x] = 0;
            }
        }
    }
}
