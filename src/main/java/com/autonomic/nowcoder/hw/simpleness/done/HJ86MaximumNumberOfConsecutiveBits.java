/*
 * Copyright (c) 2021.  User:Unique66 File:HJ86MaximumNumberOfConsecutiveBits.java
 * Date:2021/07/16 00:13:16
 */

package com.autonomic.nowcoder.hw.simpleness.done;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ86 求最大连续bit数
 * @date 2021/7/14 0:28
 *
 * https://www.nowcoder.com/practice/4b1658fd8ffb4217bc3b7e85a38cfaf2?tpId=37&&tqId=21309&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 *
 * 本题含有多组样例输入。
 *
 * 输入描述：
 * 输入一个byte数字
 *
 * 输出描述：
 * 输出转成二进制之后连续1的个数
 *
 * 示例1
 * 输入：
 * 3
 * 5
 * 输出：
 * 2
 * 1
 * 说明：
 * 3的二进制表示是11，最多有2个连续的1。
 * 5的二进制表示是101，最多只有1个连续的1。
 */
public class HJ86MaximumNumberOfConsecutiveBits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int input = in.nextInt();
            int max = 0; // 最大连续1 的个数
            int count = 0;
            while (input != 0) {
                if (input % 2 == 0) {
                    if (count > max) {
                        max = count;
                    }
                    count = 0;
                } else {
                    count++;
                }
                input /= 2;
            }
            if (count > max) { // 避免都是1，根本没有进到上面的max 赋值处
                max = count;
            }
            System.out.println(max);
        }
    }
}
