/*
 * Copyright (c) 2021.  User:Unique66 File:HJ84CountCapitalLetters.java
 * Date:2021/07/14 00:31:14
 */

package com.autonomic.nowcoder.hw.simpleness.done;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ84 统计大写字母个数
 * @date 2021/7/14 0:31
 *
 * https://www.nowcoder.com/practice/434414efe5ea48e5b06ebf2b35434a9c?tpId=37&&tqId=21307&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 找出给定字符串中大写字符(即'A'-'Z')的个数。
 *
 * 输入描述：
 * 本题含有多组样例输入
 * 对于每组样例，输入一行，代表待统计的字符串
 *
 * 输出描述：
 * 对于每组样例，输出一个整数，代表字符串中大写字母的个数
 *
 * 示例1
 * 输入：
 * add123#$%#%#O
 * 150175017(&^%&$vabovbao
 * 输出：
 * 1
 * 0
 */
public class HJ84CountCapitalLetters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String input = in.nextLine();
            int count = 0; // 大写字母个数
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
