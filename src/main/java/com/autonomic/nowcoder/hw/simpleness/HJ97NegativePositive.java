/*
 * Copyright (c) 2021.  User:Unique66 File:HJ97NegativePositive.java
 * Date:2021/07/31 01:01:31
 */

package com.autonomic.nowcoder.hw.simpleness;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ97 记负均正
 * @date 2021/7/31 1:01
 * <p>
 * https://www.nowcoder.com/practice/6abde6ffcc354ea1a8333836bd6876b8?tpId=37&&tqId=21320&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 * 0即不是正整数，也不是负数，不计入计算
 * 输入描述：
 * 本题有多组输入用例。
 * 首先输入一个正整数n，
 * 然后输入n个整数。
 * <p>
 * 输出描述：
 * 输出负数的个数，和所有正整数的平均值。
 * <p>
 * 示例1
 * 输入：
 * 5
 * 1 2 3 4 5
 * 10
 * 1 2 3 4 5 6 7 8 9 0
 * 复制
 * 输出：
 * 0 3.0
 * 0 5.0
 */
public class HJ97NegativePositive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int positiveNum = 0;
            int negativeNum = 0;
            double sum = 0.0d;

            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                if (num > 0) {
                    positiveNum++;
                    sum += num;
                } else if (num < 0) {
                    negativeNum++;
                }
            }
            System.out.printf("%d %.1f\n", negativeNum, (sum / positiveNum));
        }
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int line = Integer.parseInt(in.nextLine().trim());
            String numStr = in.nextLine();
            String[] nums = numStr.split("\\s+");
            int negativeNum = 0;
            int positiveNum = 0;
            double sum = 0.0d;
            for (int i = 0; i < line; i++) {
                int n = Integer.parseInt(nums[i].trim());
                if (n < 0) {
                    negativeNum++;
                }
                if (n > 0) {
                    sum += n;
                    positiveNum++;
                }
            }
            double ave = sum / positiveNum;
            System.out.printf("%d %.1f\n", negativeNum, ave);
        }
    }
}
