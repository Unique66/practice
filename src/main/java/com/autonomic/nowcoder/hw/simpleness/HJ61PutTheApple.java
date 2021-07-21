/*
 * Copyright (c) 2021.  User:Unique66 File:HJ61PutTheApple.java
 * Date:2021/07/21 22:55:21
 */

package com.autonomic.nowcoder.hw.simpleness;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ61 放苹果
 * @date 2021/7/21 22:55
 *
 * https://www.nowcoder.com/practice/bfd8234bb5e84be0b493656e390bdebf?tpId=37&&tqId=21284&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 题目描述
 *
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 *
 * 数据范围：0<=m<=10，1<=n<=10。
 * 本题含有多组样例输入。
 *
 *
 * 输入描述：
 * 输入两个int整数
 *
 * 输出描述：
 * 输出结果，int型
 *
 * 示例1
 * 输入：7 3
 * 输出：8
 */
public class HJ61PutTheApple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) {
            int m = in.nextInt(); // 苹果个数
            int n = in.nextInt(); // 盘子个数
            System.out.println(count(m, n));
        }
    }

    /*
        思路：分为存在盘子是空和盘子不为空
            1、盘子为空，那么就是 m 个苹果在 n-1 个盘子放的逻辑，可递归
            2、盘子不为空，每个盘子至少有一个苹果，那么就是 m-n 个苹果放到 n 个盘子的逻辑，可递归
    */
    public static int count(int m, int n) {
        if (m < 0 || n <= 0) {
            return 0;
        }
        // 按上述思路，细分到苹果个数为1（2情况）或盘子个数为1（1情况），都返回1
        if (m == 1 || n == 1 || m == 0) {
            return 1;
        }
        return count(m, n - 1) + count(m - n, n);
    }
}
