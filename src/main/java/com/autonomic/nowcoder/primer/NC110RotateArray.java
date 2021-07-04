/*
 * Copyright (c) 2021.  User:SXH  File:NC110RotateArray.java
 * Date:2021/07/04 23:14:04
 */

package com.autonomic.nowcoder.primer;

/**
 * @author Unique66
 * @description NC110 旋转数组
 * @date 2021/7/4 23:14
 *
 * 描述
 * 一个数组A中存有N（N&gt0）个整数，在不允许使用另外数组的前提下，将每个整数循环向右移M（M>=0）个位置，
 * 即将A中的数据由（A0 A1 ……AN-1 ）变换为（AN-M …… AN-1 A0 A1 ……AN-M-1 ）（最后M个数循环移至最前面的M个位置）。
 * 如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
 *
 * 示例1
 * 输入：6,2,[1,2,3,4,5,6]
 * 返回值：[5,6,1,2,3,4]
 */
public class NC110RotateArray {
    /**
     * 旋转数组
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public int[] solve (int n, int m, int[] a) {
        // write code here
        int mov = m % n;
        if (mov == 0) {
            return a;
        }
        int temp;
        if (n/ 2 > mov) { // mov 较小，就从左向右边 移动mov下
            for (int i = 0; i < mov; i++) {
                temp = a[n-1];
                for (int j = n - 1; j > 0; j--) {
                    a[j] = a[j - 1];
                }
                a[0] = temp;
            }
        } else { // mov 较大，就从右向左移动 n-mov 下
            for (int i = 0; i < n-mov; i++) {
                temp = a[0];
                for (int j = 0; j < n - 1; j++) {
                    a[j] = a[j + 1];
                }
                a[n-1] = temp;
            }
        }
        return a;
    }
}
