/*
 * Copyright (c) 2021.  User:Unique66 File:HJ99SelfControlledNumber.java
 * Date:2021/07/29 22:18:29
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ99 自守数
 * @date 2021/7/29 22:18
 * <p>
 * https://www.nowcoder.com/practice/88ddd31618f04514ae3a689e83f3ab8e?tpId=37&&tqId=21322&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
 * <p>
 * 功能: 求出n以内的自守数的个数
 * <p>
 * 输入参数：
 * int n
 * <p>
 * 返回值：
 * n以内自守数的数量。
 * <p>
 * 输入描述：
 * int型整数
 * <p>
 * 输出描述：
 * n以内自守数的数量。
 * <p>
 * 示例1
 * 输入：2000
 * 输出：8
 */
public class HJ99SelfControlledNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            int res = 0;
            for (int i = 0; i <= num; i++) {
                if ((i * i + "").endsWith(i + "")) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
