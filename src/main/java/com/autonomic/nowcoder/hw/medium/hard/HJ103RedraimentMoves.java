/*
 * Copyright (c) 2021.  User:Unique66 File:HJ103RedraimentMoves.java
 * Date:2021/07/29 23:03:29
 */

package com.autonomic.nowcoder.hw.medium.hard;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ103 Redraiment的走法 动态规划
 * @date 2021/7/29 23:03
 * <p>
 * https://www.nowcoder.com/practice/24e6243b9f0446b081b1d6d32f2aa3aa?tpId=37&&tqId=21326&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 * <p>
 * 本题含有多组样例输入
 * <p>
 * <p>
 * 输入描述：
 * 输入多组数据，1组有2行，第1行先输入数组的个数，第2行再输入梅花桩的高度
 * <p>
 * 输出描述：
 * 一组输出一个结果
 * <p>
 * 示例1
 * 输入：
 * 6
 * 2 5 1 5 4 5
 * 3
 * 3 2 1
 * 输出：
 * 3
 * 1
 * 说明：
 * 6个点的高度各为 2 5 1 5 4 5
 * 如从第1格开始走,最多为3步, 2 4 5
 * 从第2格开始走,最多只有1步,5
 * 而从第3格开始走最多有3步,1 4 5
 * 从第5格开始走最多有2步,4 5
 * 所以这个结果是3。
 */
public class HJ103RedraimentMoves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            //dp[i] 保留了从第一个到第i-1个庄子能走的最大步数
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i]) {
                        //最终dp[i]的值为其前面的最大的dp[j] + 1；
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int max = 1;
            for (int i = 0; i < n; i++) {
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            System.out.println(max);
        }
        sc.close();
    }
}
