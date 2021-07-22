/*
 * Copyright (c) 2021.  User:Unique66 File:HJ9ExtractNonRedundantNumber.java
 * Date:2021/07/23 00:06:23
 */

package com.autonomic.nowcoder.hw.medium.done;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ9 提取不重复的整数
 * @date 2021/7/23 0:00
 *
 * https://www.nowcoder.com/practice/253986e66d114d378ae8de2e6c4577c1?tpId=37&&tqId=21232&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 * 输入描述：
 * 输入一个int型整数
 *
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入：
 * 9876673
 * 输出：
 * 37689
 */
public class HJ9ExtractNonRedundantNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            String numStr = num + "";
            int[] cache = new int[10]; // 0-9 是个数字
            StringBuilder sb = new StringBuilder();
            for (int i = numStr.length() - 1; i >= 0 ; i--) {
                int n = numStr.charAt(i) - 48; // char '0' 对应的十进制是48，所以转换int 要 -48
                if (cache[n] == 0) {
                    sb.append(n);
                    cache[n] = 1;
                }
                // 跳过该数（已重复）
            }
            System.out.println(sb.toString());
        }
    }
}
