/*
 * Copyright (c) 2021.  User:SXH  File:TestQueue8.java
 * Date:2021/06/24 22:51:24
 */

package com.autonomic.datastructures.recursion;

import java.util.Arrays;

/**
 * @author SXH
 * @description 八皇后问题
 * @date 2021/6/24 22:51
 */
public class TestQueue8 {

    // 8*8 的棋盘格可以使用length=8 的一维数组表示
    public static int[] queue = new int[8];
    public static int count = 0; // 记录一共有多少种摆放方式
    public static int judgeCount = 0; // 记录一共判定了多少次

    public static void main(String[] args) {
        find(0);// 从0,0 开始
        System.out.printf("一共有%d种摆放方式\n", count);
        System.out.printf("一共判断了%d次", judgeCount);
    }

    public static void find(int n) { // n 控制列
        if (n == 8) {
            count++;
            System.out.println(Arrays.toString(queue));
            return;
        }
        // 0-7行元素位置
        for (int i = 0; i < queue.length; i ++) {
            queue[n] = i; // 先将第一个皇后放到第i 行，初始是0
            // 同列、同行、同斜线都不行
            if (isOk(n)) {
                find(n + 1);
            }
        }
    }

    // 判断位置是否符合条件
    public static boolean isOk(int n) {
        // 判断之前的皇后与该皇后的位置关系是否OK
        for (int i = 0; i < n; i++) {
            judgeCount++;
            if (queue[i] == queue[n] || Math.abs(n-i) == Math.abs(queue[n] - queue[i])) {
                return false;
            }
        }
        return true;
    }
}
