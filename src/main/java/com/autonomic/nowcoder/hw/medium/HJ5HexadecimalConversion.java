/*
 * Copyright (c) 2021.  User:Unique66 File:HJ5HexadecimalConversion.java
 * Date:2021/07/21 23:13:21
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ5 进制转换
 * @date 2021/7/21 23:13
 *
 * https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&&tqId=21228&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 输入描述：
 * 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。
 *
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 * 示例1
 * 输入：
 * 0xA
 * 0xAA
 * 输出：
 * 10
 * 170
 *
 */
public class HJ5HexadecimalConversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String input = in.nextLine(); // 16进制
            int prefix = 2;
            boolean negtive = false;
            if (input.contains("-")) { // 负数
                prefix = 3;
                negtive = true;
            }
            long result = 0L; // 转换结果
            for (int i = 0; i < input.length() - prefix; i++) {
                char c = input.charAt(input.length() - 1 - i);
                result += Math.pow(16, i) *  convert(c);
            }
            if (negtive) {
                result = -1 * result;
            }
            System.out.println(result);
        }
    }

    public static int convert(char c) {
        // 准备一个转换逻辑 A-10、B-11 ... F-15，将十六进制的数对应十进制
        // A 对应的十进制是65 所以需要-55
        // 0-9 字符对应的十进制是 48-57，所以需要-48 获得对应的16进制转十进制关系
        if (c >= 65) {
            return c - 55;
        }
        return c - 48;
    }
}
