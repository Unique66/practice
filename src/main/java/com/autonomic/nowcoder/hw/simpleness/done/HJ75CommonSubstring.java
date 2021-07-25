/*
 * Copyright (c) 2021.  User:Unique66 File:HJ75CommonSubstring.java
 * Date:2021/07/15 22:58:15
 */

package com.autonomic.nowcoder.hw.simpleness.done;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ75 公共子串计算
 * @date 2021/7/15 22:46
 *
 * https://www.nowcoder.com/practice/98dc82c094e043ccb7e0570e5342dd1b?tpId=37&&tqId=21298&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 *
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 *
 * 输入描述：
 * 输入两个只包含小写字母的字符串
 *
 * 输出描述：
 * 输出一个整数，代表最大公共子串的长度
 *
 * 示例1
 * 输入：
 * asdfas
 * werasdfaswer
 * 输出：6
 */
public class HJ75CommonSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String input1 = in.nextLine();
        String input2 = in.nextLine();
        if (input1.length() > input2.length()) {
            String temp = input1;
            input1 = input2;
            input2 = temp;
        }
        // 对长度较小的做遍历
        int maxLen = 0;
        for (int i = 0; i < input1.length(); i++) {
            // ※比如"123".subString(0,1) 取的是1，所以推论，j 要从1开始（从0开始没有意义）一直要走到和字符串长度一致位置
            for (int j = i + 1; j <= input1.length(); j++) {
                if (input2.contains(input1.substring(i, j)) && j - i > maxLen) {
                    maxLen = j - i;
                }
            }
        }
        System.out.println(maxLen);
    }
}
