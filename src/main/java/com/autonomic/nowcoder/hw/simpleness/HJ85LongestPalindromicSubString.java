/*
 * Copyright (c) 2021.  User:Unique66 File:HJ85LongestPalindromicSubString.java
 * Date:2021/07/14 00:29:14
 */

package com.autonomic.nowcoder.hw.simpleness;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ85 最长回文子串
 * @date 2021/7/14 0:29
 * <p>
 * https://www.nowcoder.com/practice/12e081cd10ee4794a2bd70c7d68f5507?tpId=37&&tqId=21308&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
 * 所谓回文串，指左右对称的字符串。
 * 所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
 * （注意：记得加上while处理多个测试用例）
 * <p>
 * 输入描述：
 * 输入一个仅包含小写字母的字符串
 * <p>
 * 输出描述：
 * 返回最长回文子串的长度
 * <p>
 * 示例1
 * 输入：
 * cdabbacc
 * 输出：
 * 4
 * 说明：
 * abba为最长的回文子串
 */
public class HJ85LongestPalindromicSubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) {
            String str = in.nextLine();
            int max = 0;
            for (int i = 0; i < str.length(); i++) {
                for (int j = i + 1; j <= str.length(); j++) {
                    if (judge(str.substring(i, j))) {
                        if (j - i > max) {
                            max = j - i;
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }

    public static boolean judge(String str) {
        if (str == null) {
            return false;
        }
        // write code here
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
