/*
 * Copyright (c) 2021.  User:Unique66 File:HJ56PerfectNumberCalculation.java
 * Date:2021/07/14 23:30:14
 */

package com.autonomic.nowcoder.hw.simpleness;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ56 完全数计算
 * @date 2021/7/14 23:30
 *
 * https://www.nowcoder.com/practice/7299c12e6abb437c87ad3e712383ff84?tpId=37&&tqId=21279&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 *
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 *
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。s
 *
 * 输入n，请输出n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
 *
 *
 * 本题输入含有多组样例。
 *
 * 输入描述：
 * 输入一个数字n
 *
 * 输出描述：
 * 输出不超过n的完全数的个数
 *
 * 示例1
 * 输入：
 * 1000
 * 7
 * 100
 * 输出：
 * 3
 * 1
 * 2
 */
public class HJ56PerfectNumberCalculation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int count = 0; // 个数
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j <= i / 2; j++) {
                    if (i % j == 0) { // 可以被整除，也就是约数
                        sum += j;
                    }
                }
                // 遍历完，查看约数和是否与i 相等
                if (i == sum) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
