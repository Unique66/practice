/*
 * Copyright (c) 2021.  User:Unique66 File:NC22MergesTwoOrderedArrays.java
 * Date:2021/07/06 00:31:06
 */

package com.autonomic.nowcoder.simpleness.done;

/**
 * @author Unique66
 * @description NC22 合并两个有序的数组  考察点：数组、双指针
 * @date 2021/7/6 0:15
 *
 * https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665?tpId=117&&tqId=37727&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 给出一个整数数组A 和有序的整数数组B ，请将数组B 合并到数组A 中，变成一个有序的升序数组
 * 注意：
 * 1.可以假设A 数组有足够的空间存放B 数组的元素，A 和B 中初始的元素数目分别为m 和n ，A 的数组空间大小为 m + n
 * 2.不要返回合并的数组，返回是空的，将数组B 的数据合并到A 里面就好了
 * 3.A 数组在[0,m-1]的范围也是有序的
 *
 * 例1:
 * A: [1,2,3,0,0,0]，m=3
 * B: [2,5,6]，n=3
 * 合并过后A为:
 * A: [1,2,2,3,5,6]
 *
 * 示例1
 * 输入：[4,5,6],[1,2,3]
 * 返回值：[1,2,3,4,5,6]
 */
public class NC22MergesTwoOrderedArrays {
    public void merge(int A[], int m, int B[], int n) {
        // 因为题目明确说了A数组足够大，所以直接在A数组操作
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1; // AB合并后最后一个元素所在位置
        while(i >= 0 && j >= 0) { //AB合并，谁大就先放谁
            A[index--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while(j >= 0) { // 如果B没有遍历完，那么直接放在A数组里面
            A[index--] = B[j--];
        }
    }

    // 比较直接的方式
    public void merge1(int A[], int m, int B[], int n) {
        // 先将数组B 合并到数组A
        for (int i = 0; i < n; i++) {
            A[m + i] = B[i];
        }
        // 利用排序算法将数组A 排序
        sort(A);
    }

    public void sort(int[] arr) {
        // 使用选择排序
        for (int i = 0; i < arr.length; i++) {
            // 假设 arr[i] 为最小值元素
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
