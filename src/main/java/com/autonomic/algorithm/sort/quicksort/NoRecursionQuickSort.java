/*
 * Copyright (c) 2021.  User:SXH  File:NoRecursionQuickSort.java
 * Date:2021/05/09 11:02:09
 */

package com.autonomic.algorithm.sort.quicksort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author SXH
 * @description 非递归实现（借助栈）快速排序  双边循环获取排序后pivot基准值下标
 * @date 2021/5/9 11:02
 */
public class NoRecursionQuickSort {

    public static void main(String[] args) {
        int [] arr1 = {-9, 78, 0, 23, -567, 70, 1};
        System.out.println(Arrays.toString(arr1));
        noRecursionSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void noRecursionSort(int[] arr, int left, int right) {
        Stack<Map<String, Integer>> stack = new Stack<>(); // 用栈回溯的特性实现递归的效果
        // 首先将初始的左右边界放入到stack 中
        HashMap<String, Integer> root = new HashMap<>();
        root.put("left", left);
        root.put("right", right);
        stack.push(root);
        while (!stack.isEmpty()) { // 只要栈不为空，就继续处理
            Map<String, Integer> pop = stack.pop();
            // 获取到当前的左右边界下 数组的基准值下标位置
            Integer l = pop.get("left");
            Integer r = pop.get("right");

            int pivotIndex = getPivotIndex(arr, pop.get("left"), pop.get("right"));
            // 根据基准元素分成两部分，把每一部分的起止下标存入栈中
            if (l < pivotIndex - 1) {
                HashMap<String, Integer> leftMap = new HashMap<>();
                leftMap.put("left", l);
                leftMap.put("right", pivotIndex - 1);
                stack.push(leftMap);
            }

            if (r > pivotIndex + 1) {
                HashMap<String, Integer> rightMap = new HashMap<>();
                rightMap.put("left", pivotIndex + 1);
                rightMap.put("right", r);
                stack.push(rightMap);
            }
        }
    }

    public static int getPivotIndex(int[] arr, int left, int right) {
        // 定义基准值
        int pivot = arr[left];
        // 记录左右处理元素的下标位置
        int l = left;
        int r = right;

        while (l < r) {
            // 从右向左遍历 如果元素大于基准值，右下标就向前移动一位
            while (l < r && pivot < arr[r]) {
                r--;
            }
            // 从左向右遍历 如果元素小于、等于基准值，左下标向后移动一位
            while (l < r && pivot >= arr[l]) {
                l++;
            }
            // 两个while 循环走完，并且左下标小于右下标，说明已经找到可以交换位置的左右两个元素下标了
            if (l < r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }
        // 处理完毕后，将基准值移动到中间
        arr[left] = arr[l];
        arr[l] = pivot;
        return l;
    }
}
