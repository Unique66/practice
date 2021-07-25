/*
 * Copyright (c) 2021.  User:Unique66 File:HJ76NicochusTheorem.java
 * Date:2021/07/15 23:40:15
 */

package com.autonomic.nowcoder.hw.simpleness.done;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ76 尼科彻斯定理
 * @date 2021/7/15 23:36
 *
 * https://www.nowcoder.com/practice/dbace3a5b3c4480e86ee3277f3fe1e85?tpId=37&&tqId=21299&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 *
 * 1^3=1
 *
 * 2^3=3+5
 *
 * 3^3=7+9+11
 *
 * 4^3=13+15+17+19
 *
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 本题含有多组输入数据。
 *
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 输出分解后的string
 *
 * 示例1
 * 输入：6
 * 输出：31+33+35+37+39+41
 */
public class HJ76NicochusTheorem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) {
            int input = in.nextInt();
            int cube = input * input * input; // 立方
            // 找第一个数  等差数列公式 Sn = n*a1 + n*(n-1)*d/2
            // a1 为首项，d 为公差，此处为2，那么 首项就是公式左右除以n 可以算出来
            int first = cube / input - (input - 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input; i++) {
                sb.append(first);
                if (i != input - 1) {
                    sb.append("+");
                }
                first += 2;
            }
            System.out.println(sb.toString());
        }
    }
}
