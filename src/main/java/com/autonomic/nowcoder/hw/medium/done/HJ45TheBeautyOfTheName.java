/*
 * Copyright (c) 2021.  User:Unique66 File:HJ45TheBeautyOfTheName.java
 * Date:2021/07/26 21:28:26
 */

package com.autonomic.nowcoder.hw.medium.done;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ45 名字的漂亮度
 * @date 2021/7/26 19:25
 *
 * https://www.nowcoder.com/practice/02cb8d3597cf416d9f6ae1b9ddc4fde3?tpId=37&&tqId=21268&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 给出一个名字，该名字有26个字符组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
 *
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 *
 * 本题含有多组数据。
 *
 * 输入描述：
 * 整数N，后续N个名字
 *
 * 输出描述：
 * 每个名称可能的最大漂亮程度
 *
 * 示例1
 * 输入：
 * 2
 * zhangsan
 * lisi
 * 输出：
 * 192
 * 101
 */
public class HJ45TheBeautyOfTheName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            for (int i = 0; i < n; i++) {
                String str = in.nextLine();
                System.out.println(getLatestLevel(str));
            }
        }
    }

    public static int getLatestLevel(String str) {
        String strLower = str.toLowerCase();
        int[] cache = new int[26];
        for (int i = 0; i < strLower.length(); i++) {
            cache[strLower.charAt(i)-'a']++;
        }
        Arrays.sort(cache);
        int sum = 0;
        int level = 26;
        for (int i = cache.length - 1; i >= 0; i--) {
            if (cache[i] == 0) {
                break;
            }
            sum += cache[i] * level--;
        }
        return sum;
    }
}
