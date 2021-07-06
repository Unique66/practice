/*
 * Copyright (c) 2021.  User:Unique66 File:NC32SquareRoot.java
 * Date:2021/07/06 00:39:06
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC32 求平方根 考察点：数学、二分
 * @date 2021/7/6 0:39
 *
 * 描述
 * 实现函数 int sqrt(int x).
 * 计算并返回x的平方根（向下取整）
 *
 * 示例1
 * 输入：2
 * 返回值：1
 */
public class NC32SquareRoot {
    /**
     *
     * @param x int整型
     * @return int整型
     */
    public int sqrt (int x) {
        // write code here
        if (x <= 0) {
            return 0;
        }

        int left = 1, right = x;
        while (true) {
            int middle = (left + right) >> 1;
            if (middle <= x / middle && (middle+1) > x / (middle+1)) {
                return (int) middle;
            } else if (middle < x / middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
    }

    // 自己的笨方法
    public int sqrt1 (int x) {
        // write code here
        int n = 0;
        if (x == 0) {
            return n;
        }
        while (n * n <= x) {
            n++;
        }
        return n - 1;
    }
}
