/*
 * Copyright (c) 2021.  User:Unique66 File:HJ57IntegerAddition.java
 * Date:2021/07/26 23:46:26
 */

package com.autonomic.nowcoder.hw.medium.done;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ57 高精度整数加法
 * @date 2021/7/26 23:46
 * <p>
 * https://www.nowcoder.com/practice/49e772ab08994a96980f9618892e55b6?tpId=37&&tqId=21280&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 输入两个用字符串表示的整数，求它们所表示的数之和。
 * 字符串的长度不超过10000。
 * 本题含有多组样例输入。
 * 输入描述：
 * 输入两个字符串。保证字符串只含有'0'~'9'字符
 * <p>
 * 输出描述：
 * 输出求和后的结果
 * <p>
 * 示例1
 * 输入：
 * 9876543210
 * 1234567890
 * 输出：
 * 11111111100
 */
public class HJ57IntegerAddition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            // 翻转字符串，以便从个位开始计算
            str1 = new StringBuilder(str1.trim()).reverse().toString(); // 系统输入有坑，需要添加trim() 去空格
            str2 = new StringBuilder(str2.trim()).reverse().toString();
            // 利用数学中的常用加法算法
            int index = 0; // 当前处理位所在下标，从个位开始
            int pre = 0; // 前一位的进位
            StringBuilder result = new StringBuilder();
            while (index < str1.length() && index < str2.length()) {
                int sum = Integer.parseInt(str1.charAt(index) + "") +
                        Integer.parseInt(str2.charAt(index) + ""); // 获得同位相加值
                sum += pre; // 与前一位的进位相加
                result.append(sum % 10); // 取得同位相加进位后的值
                pre = sum / 10; // 获取进位值
                index++; // 下标向下一位移动
            }
            // 跳出循环说明index 已经超过了其中一个字符串的长度，只用处理一个字符串即可
            while (index < str1.length()) {
                int sum = Integer.parseInt(str1.charAt(index) + "");
                sum += pre;
                result.append(sum % 10); // 取得同位相加进位后的值
                pre = sum / 10; // 获取进位值
                index++;
            }

            while (index < str2.length()) {
                int sum = Integer.parseInt(str2.charAt(index) + "");
                sum += pre;
                result.append(sum % 10); // 取得同位相加进位后的值
                pre = sum / 10; // 获取进位值
                index++;
            }
            if (pre != 0) { // 最后可能进位1，最大位要放入1
                result.append(pre);
            }
            System.out.println(result.reverse().toString()); // 从个位计算的（个位在最前面），所以翻转字符串即可
        }
    }
}
