/*
 * Copyright (c) 2021.  User:Unique66 File:HJ35SerpentineMatrix.java
 * Date:2021/07/26 01:30:26
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ35 蛇形矩阵
 * @date 2021/7/26 1:30
 *
 * https://www.nowcoder.com/practice/649b210ef44446e3b1cd1be6fa4cab5e?tpId=37&&tqId=21258&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 例如，当输入5时，应该输出的三角形为：
 *
 * 1 3 6 10 15
 *
 * 2 5 9 14
 *
 * 4 8 13
 *
 * 7 12
 *
 * 11
 *
 *
 * 请注意本题含有多组样例输入。
 *
 * 输入描述：
 * 输入正整数N（N不大于100）
 *
 * 输出描述：
 * 输出一个N行的蛇形矩阵。
 *
 * 示例1
 * 输入：4
 * 输出：
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 */
public class HJ35SerpentineMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int line = in.nextInt();
            // 首行第一个值
            int pre = 1;
            for (int i = 1; i <= line; i++) {
                int next = pre; // 记录横向第i 行的每一个数字
                for (int j = 1; j <= line - i + 1; j++) {
                    System.out.print(next);
                    if (j != line - i + 1) {
                        System.out.print(" ");
                    }
                    next = next + i + j; // 横向数字的变化规律
                }
                System.out.println(""); // 每遍历完毕一行就换行
                pre += i; // 记录下一行数字开始的那一个数
            }
        }
    }
}
