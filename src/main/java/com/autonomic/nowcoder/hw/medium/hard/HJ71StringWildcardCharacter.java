/*
 * Copyright (c) 2021.  User:Unique66 File:HJ71StringWildcardCharacter.java
 * Date:2021/07/28 23:58:28
 */

package com.autonomic.nowcoder.hw.medium.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Unique66
 * @description HJ71 字符串通配符
 * @date 2021/7/28 23:58
 * <p>
 * https://www.nowcoder.com/practice/43072d50a6eb44d2a6c816a283b02036?tpId=37&&tqId=21294&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。
 * 现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，下同）
 * ？：匹配1个字符
 * <p>
 * 注意：匹配时不区分大小写。
 * <p>
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 * 输出：
 * <p>
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 * <p>
 * 本题含有多组样例输入！
 * 输入描述：
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 * <p>
 * 输出描述：
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 * <p>
 * 示例1
 * 输入：
 * te?t*.*
 * txt12.xls
 * 输出：
 * false
 * <p>
 * 示例2
 * 输入：
 * z
 * zz
 * 输出：
 * false
 * <p>
 * 示例3
 * 输入：
 * pq
 * pppq
 * 输出：
 * false
 * <p>
 * 示例4
 * 输入：
 * **Z
 * 0QZz
 * 输出：
 * true
 */
public class HJ71StringWildcardCharacter {
    // 三种方式
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while ((in = br.readLine()) != null) {
            String temp = br.readLine();
            //System.out.println(isMatch(temp,in));
            System.out.println(getOc(in, temp));
            //System.out.println(getOc(in,temp,0,0));
        }
    }

    public static boolean getOc(String s1, String s2, int p1, int p2) {
        //递归求解
        //base case
        if (p1 == s1.length() && p2 == s2.length()) {
            return true;
        } else if (p1 == s1.length() || p2 == s2.length()) {
            return false;
        }
        //遇到'*'两种情况，要不就各跳过一个比较后面，要不就s2继续往后跳先不比较
        if (s1.charAt(p1) == '*') {
            return getOc(s1, s2, p1, p2 + 1) || getOc(s1, s2, p1 + 1, p2 + 1);
            //遇到'?'跟两个一样操作一样，直接指针都往后移一个继续比较
        } else if (s1.charAt(p1) == '?' || s1.charAt(p1) == s2.charAt(p2)) {
            return getOc(s1, s2, p1 + 1, p2 + 1);
        } else {
            return false;
        }
    }//method end

    public static boolean getOc(String in, String temp) {
        //字符串通配符
        in = in.replaceAll("\\?", "[0-9A-Za-z]{1}");
        in = in.replaceAll("\\*", "[0-9A-Za-z]{0,}");
        //in = in.replaceAll("\\.", "\\\\.");
        return temp.matches(in);
    }

    public static boolean isMatch(String s, String p) {
        //动态规划
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() != 0 && p.length() == 0) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 2; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char a = s.charAt(i - 1), b = p.charAt(j - 1);
                if (a == b || b == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (b == '*') {
                    if (j >= 2) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    }

                } else dp[i][j] = false;
            }
        }
        return dp[s.length()][p.length()];
    }
}
