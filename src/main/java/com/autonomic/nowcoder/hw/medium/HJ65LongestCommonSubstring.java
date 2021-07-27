/*
 * Copyright (c) 2021.  User:Unique66 File:HJ65LongestCommonSubstring.java
 * Date:2021/07/27 23:23:27
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ65 查找两个字符串a,b中的最长公共子串
 * @date 2021/7/27 23:23
 * <p>
 * https://www.nowcoder.com/practice/181a1a71c7574266ad07f9739f791506?tpId=37&&tqId=21288&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！
 * <p>
 * 本题含有多组输入数据！
 * 输入描述：
 * 输入两个字符串
 * <p>
 * 输出描述：
 * 返回重复出现的字符
 * 示例1
 * 输入：
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 * 输出：
 * jklmnop
 */
public class HJ65LongestCommonSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            //判断长度
            String longStr = (str1.length() > str2.length()) ? str1 : str2;
            String shortStr = (str1.length() < str2.length()) ? str1 : str2;
            String maxLenStr = "";
            for (int i = 0; i < shortStr.length(); i++) {
                for (int j = i + 1; j < shortStr.length(); j++) {
                    //找到最长的公共子串
                    String subStr = shortStr.substring(i, j + 1);
                    if (longStr.contains(subStr) && subStr.length() > maxLenStr.length()) {
                        //开始找到最长的公共子串的处理。
                        maxLenStr = subStr;
                    }
                }
            }
            System.out.println(maxLenStr);
        }
    }
}
