/*
 * Copyright (c) 2021.  User:Unique66 File:HJ96RepresentNumbers.java
 * Date:2021/07/29 00:42:29
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ96 表示数字
 * @date 2021/7/29 0:42
 *
 * https://www.nowcoder.com/practice/637062df51674de8ba464e792d1a0ac6?tpId=37&&tqId=21319&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 将一个字符中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
 *
 * 注意：本题有多组样例输入。
 * 输入描述：
 * 输入一个字符串
 *
 * 输出描述：
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 *
 * 示例1
 * 输入：
 * Jkdi234klowe90a3
 * 5151
 * 输出：
 * Jkdi*234*klowe*90*a*3*
 * *5151*
 */
public class HJ96RepresentNumbers {
    // 离谱的写法
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            System.out.println(input
                    .replaceAll("([0-9]+)", "*$1*"));
            //把所有的数字段提取出来，前后加上星号再放回去
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            StringBuilder sb = new StringBuilder();
            boolean star = false; // 没有星
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) { // 数字
                    if (!star) {
                        sb.append("*");
                        star = true;
                    }
                } else { // 英文
                    if (star) {
                        sb.append("*");
                        star = false;
                    }
                }
                sb.append(str.charAt(i)); // 每一轮都要将字符加到StringBuilder 中
            }
            if (Character.isDigit(str.charAt(str.length() - 1))) { // 最后一位为数字，那么需要后面加星号
                sb.append("*");
            }
            System.out.println(sb.toString());
        }
    }
}
