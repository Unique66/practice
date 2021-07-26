/*
 * Copyright (c) 2021.  User:Unique66 File:HJ55Search7.java
 * Date:2021/07/26 23:20:26
 */

package com.autonomic.nowcoder.hw.medium.done;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ55 挑7
 * @date 2021/7/26 23:20
 *
 * https://www.nowcoder.com/practice/ba241b85371c409ea01ac0aa1a8d957b?tpId=37&&tqId=21278&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）
 * 的个数（一组测试用例里可能有多组数据，请注意处理）
 *
 * 输入描述：
 * 一个正整数N。(N不大于30000)
 *
 * 输出描述：
 * 不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
 *
 * 示例1
 * 输入：
 * 20
 * 10
 * 输出：
 * 3
 * 1
 */
public class HJ55Search7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            int count = 0;
            for (int i = 7; i <= num; i++) {
                if ((i + "").contains("7") || i % 7 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
