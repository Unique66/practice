/*
 * Copyright (c) 2021.  User:Unique66 File:HJ7GetSimilarValue.java
 * Date:2021/07/12 22:25:12
 */

package com.autonomic.nowcoder.hw.primer;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ7 取近似值 考点：数学、语法题
 * @date 2021/7/12 22:25
 *
 * https://www.nowcoder.com/practice/3ab09737afb645cc82c35d56a5ce802a?tpId=37&&tqId=21230&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,
 * 向上取整；小于5，则向下取整。
 *
 * 输入描述：
 * 输入一个正浮点数值
 *
 * 输出描述：
 * 输出该数值的近似整数值
 *
 * 示例1
 * 输入：5.5
 * 输出：6
 */
public class HJ7GetSimilarValue {
    // 有点秀的方法
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();
        System.out.println((int)(input + 0.5));
    }

    // 方法一：第一次自己写的
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            double input = scanner.nextDouble();
            int x = Integer.parseInt((input + "").split("\\.")[0]);
            int y = input * 10 % 10 >= 5 ? 1 : 0;
            System.out.println(x + y);
        }
    }
}
