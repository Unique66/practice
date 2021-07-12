/*
 * Copyright (c) 2021.  User:Unique66 File:HJ15BinaryOfIntegerContainsOneNumber.java
 * Date:2021/07/12 23:41:12
 */

package com.autonomic.nowcoder.hw.primer;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ15 求int型正整数在内存中存储时1的个数
 * @date 2021/7/12 23:41
 *
 * https://www.nowcoder.com/practice/440f16e490a0404786865e99c6ad91c9?tpId=37&&tqId=21238&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 输入描述：
 *  输入一个整数（int类型）
 *
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入：5
 * 输出：2
 */
public class HJ15BinaryOfIntegerContainsOneNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int input = in.nextInt();
        // 将输入的int 转换二进制
        int count = 0;
        while (input != 0) {
            if (input % 2 == 1) {
                count++;
            }
            input = input / 2;
        }
        System.out.println(count);
    }
}
