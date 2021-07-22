/*
 * Copyright (c) 2021.  User:Unique66 File:HJ10CharacterCount.java
 * Date:2021/07/23 00:11:23
 */

package com.autonomic.nowcoder.hw.medium.done;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ10 字符个数统计
 * @date 2021/7/23 0:11
 *
 * https://www.nowcoder.com/practice/eb94f6a5b2ba49c6ac72d40b5ce95f50?tpId=37&&tqId=21233&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ASCII码范围内(0~127，包括0和127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 * 输入描述：
 * 输入一行没有空格的字符串。
 *
 * 输出描述：
 * 输出 输入字符串 中范围在(0~127，包括0和127)字符的种数。
 *
 * 示例1
 * 输入：abc
 * 输出：3
 */
public class HJ10CharacterCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        HashSet<Character> set = new HashSet<>(); // 利用set 不存在重复元素的特性
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str  = in.nextLine();
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }
            System.out.println(set.size());
        }
    }
}
