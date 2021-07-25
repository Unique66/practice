/*
 * Copyright (c) 2021.  User:Unique66 File:HJ26StringSort.java
 * Date:2021/07/26 01:26:26
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ26 字符串排序
 * @date 2021/7/26 1:26
 * <p>
 * https://www.nowcoder.com/practice/5190a1db6f4f4ddb92fd9c365c944584?tpId=37&&tqId=21249&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 * <p>
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * <p>
 * 如，输入： Type 输出： epTy
 * <p>
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * <p>
 * 如，输入： BabA 输出： aABb
 * <p>
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * <p>
 * <p>
 * 如，输入： By?e 输出： Be?y
 * <p>
 * <p>
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 * <p>
 * <p>
 * 输入描述：
 * 输入字符串
 * 输出描述：
 * 输出字符串
 * <p>
 * 示例1
 * 输入：A Famous Saying: Much Ado About Nothing (2012/8).
 * 输出：A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */
public class HJ26StringSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            // 找出所有的英文字母存起来
            List<Character> list = new ArrayList<>(str.length());
            for (char c : str.toCharArray()) {
                if (Character.isLetter(c)) {
                    list.add(c);
                }
            }
            // 排序
            list.sort(Comparator.comparingInt(Character::toLowerCase));
            // 排序完毕，遍历str 输入字符串，是字母的放入，不是的就取str 所在位置的
            StringBuilder sb = new StringBuilder();
            for (int i = 0, j = 0; i < str.length(); i++) {
                if (Character.isLetter(str.charAt(i))) {
                    sb.append(list.get(j++));
                } else {
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
