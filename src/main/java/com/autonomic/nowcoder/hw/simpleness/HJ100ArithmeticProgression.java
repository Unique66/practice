/*
 * Copyright (c) 2021.  User:Unique66 File:HJ100ArithmeticProgression.java
 * Date:2021/07/13 23:59:13
 */

package com.autonomic.nowcoder.hw.simpleness;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ100 等差数列
 * @date 2021/7/13 23:59
 *
 * https://www.nowcoder.com/practice/f792cb014ed0474fb8f53389e7d9c07f?tpId=37&&tqId=21323&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 功能:等差数列 2，5，8，11，14。。。。
 *
 * 输入:正整数N >0
 *
 * 输出:求等差数列前N项和
 *
 * 本题为多组输入，请使用while(cin>>)等形式读取数据
 *
 * 输入描述：
 * 输入一个正整数。
 *
 * 输出描述：
 * 输出一个相加后的整数。
 *
 * 示例1
 * 输入：2
 * 输出：7
 */
public class HJ100ArithmeticProgression {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) {
            int input = in.nextInt();
            System.out.println(2 * input + (input - 1) * input / 2 * 3);
        }
    }
}
