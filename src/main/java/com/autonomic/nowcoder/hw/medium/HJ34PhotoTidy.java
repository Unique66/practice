/*
 * Copyright (c) 2021.  User:Unique66 File:HJ34PhotoTidy.java
 * Date:2021/07/26 01:29:26
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ34 图片整理
 * @date 2021/7/26 1:29
 * <p>
 * https://www.nowcoder.com/practice/2de4127fda5e46858aa85d254af43941?tpId=37&&tqId=21257&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
 * <p>
 * 本题含有多组样例输入。
 * <p>
 * <p>
 * 输入描述：
 * Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 * <p>
 * 输出描述：
 * Lily的所有图片按照从小到大的顺序输出
 * <p>
 * 示例1
 * 输入：Ihave1nose2hands10fingers
 * 输出：0112Iaadeeefghhinnnorsssv
 */
public class HJ34PhotoTidy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            // 对字符串排序
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = i;
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[index] > chars[j]) {
                        index = j; // 记录目前最小char 元素所在位置
                    }
                }
                // 遍历完毕，替换
                if (index != i) {
                    char temp = chars[index];
                    chars[index] = chars[i];
                    chars[i] = temp;
                }
            }
            System.out.println(new String(chars));
        }
    }
}
