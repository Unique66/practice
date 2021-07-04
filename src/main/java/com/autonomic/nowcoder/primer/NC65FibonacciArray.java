/*
 * Copyright (c) 2021.  User:SXH  File:FibonacciArray.java
 * Date:2021/07/04 23:04:04
 */

package com.autonomic.nowcoder.primer;

/**
 * @author Unique66
 * @description 斐波那契数列 NC65
 * @date 2021/7/4 23:04
 *
 * 描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n ≤39
 *
 * 示例1
 * 输入：4
 * 返回值：3
 */
public class NC65FibonacciArray {
    public int Fibonacci(int n) {
        if (n < 0) {
            System.out.println("Illegal parameter.");
            return 0;
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int[] fibonacci = new int[n + 1]; // 从0 开始的，所以要+1
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
        }
        return fibonacci[n];
    }
}
