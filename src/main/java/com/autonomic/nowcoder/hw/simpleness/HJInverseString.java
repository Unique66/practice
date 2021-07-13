/*
 * Copyright (c) 2021.  User:Unique66 File:HJInverseString.java
 * Date:2021/07/13 23:34:13
 */

package com.autonomic.nowcoder.hw.simpleness;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ106 字符逆序
 * @date 2021/7/13 23:34
 *
 * https://www.nowcoder.com/practice/cc57022cb4194697ac30bcb566aeb47b?tpId=37&&tqId=21329&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。
 *
 * 输入描述：
 * 输入一个字符串，可以有空格
 *
 * 输出描述：
 * 输出逆序的字符串
 *
 * 示例1
 * 输入：I am a student
 * 输出：tneduts a ma I
 */
public class HJInverseString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine(); // ※※※※※ 要是用nextLine 获取整行数据
        StringBuilder sb = new StringBuilder();
        for (int i = (input.length()- 1); i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
