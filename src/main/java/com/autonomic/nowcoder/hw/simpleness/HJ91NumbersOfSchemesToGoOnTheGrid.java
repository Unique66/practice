/*
 * Copyright (c) 2021.  User:Unique66 File:HJ91NumbersOfSchemesToGoOnTheGrid.java
 * Date:2021/07/14 00:20:14
 */

package com.autonomic.nowcoder.hw.simpleness;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ91 走方格的方案数
 * @date 2021/7/14 0:20
 *
 * https://www.nowcoder.com/practice/e2a22f0305eb4f2f9846e7d644dba09b?tpId=37&&tqId=21314&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，
 * 总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 *
 * 本题含有多组样例输入。
 * 输入描述：
 * 每组样例输入两个正整数n和m，用空格隔开。(1≤n,m≤8)
 *
 * 输出描述：
 * 每组样例输出一行结果
 *
 * 示例1
 * 输入：
 * 2 2
 * 1 2
 * 输出：
 * 6
 * 3
 */
public class HJ91NumbersOfSchemesToGoOnTheGrid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println(methods(n, m));
        }
    }

    public static int methods(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 1;
        }
        return methods(num1 - 1, num2) + methods(num1, num2 - 1);
    }
}
