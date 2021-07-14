/*
 * Copyright (c) 2021.  User:Unique66 File:HJ73CalculateDateToDay.java
 * Date:2021/07/15 00:15:15
 */

package com.autonomic.nowcoder.hw.simpleness;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ73 计算日期到天数转换
 * @date 2021/7/15 0:15
 *
 * https://www.nowcoder.com/practice/769d45d455fe40b385ba32f97e7bcded?tpId=37&&tqId=21296&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 根据输入的日期，计算是这一年的第几天。
 *
 *
 * 输入描述：
 * 输入一行，每行空格分割，分别是年，月，日
 *
 * 输出描述：
 * 输出是这一年的第几天
 *
 * 示例1
 * 输入：2012 12 31
 * 输出：366
 *
 * 示例2
 * 输入：1982 3 4
 * 输出：63
 */
public class HJ73CalculateDateToDay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String[] date = a.split(" ");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            boolean isRun = year % 4 == 0 && year % 100 != 0 || year % 400 == 0; // 闰年
            int sum = 0;
            for (int i = 1; i < month; i++) {
                if (i == 1 || i == 3 || i == 5 || i ==  7 || i == 8 || i == 10 || i == 12) {
                    sum += 31;
                } else if (i == 2) {
                    if (isRun) {
                        sum += 29;
                    } else {
                        sum += 28;
                    }
                } else {
                    sum += 30;
                }
            }
            sum += day;
            System.out.println(sum);
        }
    }
}
