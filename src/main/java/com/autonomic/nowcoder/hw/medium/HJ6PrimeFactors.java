/*
 * Copyright (c) 2021.  User:Unique66 File:HJ6PrimeFactors.java
 * Date:2021/07/26 01:20:26
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ6 质数因子
 * @date 2021/7/26 1:20
 * <p>
 * https://www.nowcoder.com/practice/196534628ca6490ebce2e336b47b3607?tpId=37&&tqId=21229&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * <p>
 * 最后一个数后面也要有空格
 * <p>
 * 输入描述：
 * 输入一个long型整数
 * <p>
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 * <p>
 * 示例1
 * 输入：180
 * 输出：2 2 3 3 5
 */
public class HJ6PrimeFactors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLong()) { // 注意 while 处理多个 case
            long input = in.nextLong();
            long sqrt = (long) Math.sqrt(input);
            for (int i = 2; i <= sqrt; i++) {
                while (input % i == 0) {
                    System.out.print(i + " ");
                    input /= i;
                }
            }
            System.out.println(input == 1 ? "" : input + " ");
        }
    }
}
