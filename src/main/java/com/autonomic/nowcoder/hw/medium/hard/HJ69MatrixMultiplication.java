/*
 * Copyright (c) 2021.  User:Unique66 File:HJ69MatrixMultiplication.java
 * Date:2021/07/28 00:24:28
 */

package com.autonomic.nowcoder.hw.medium.hard;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ69 矩阵乘法
 * @date 2021/7/28 0:24
 * <p>
 * https://www.nowcoder.com/practice/ebe941260f8c4210aa8c17e99cbc663b?tpId=37&&tqId=21292&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。
 * 这个矩阵的每个元素是由下面的公式决定的
 * 矩阵的大小不超过100*100
 * 输入描述：
 * 输入包含多组数据，每组数据包含：
 * 第一行包含一个正整数x，代表第一个矩阵的行数
 * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 * 第三行包含一个正整数z，代表第二个矩阵的列数
 * 之后x行，每行y个整数，代表第一个矩阵的值
 * 之后y行，每行z个整数，代表第二个矩阵的值
 * <p>
 * 输出描述：
 * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 * 示例1
 * 输入：
 * 2
 * 3
 * 2
 * 1 2 3
 * 3 2 1
 * 1 2
 * 2 1
 * 3 3
 * <p>
 * 输出：
 * 14 13
 * 10 11
 * 复制
 * 说明：
 * 1 2 3
 * 3 2 1
 * 乘以
 * 1 2
 * 2 1
 * 3 3
 * 等于
 * 14 13
 * 10 11
 */
public class HJ69MatrixMultiplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            int[][] mat1 = new int[x][y];
            int[][] mat2 = new int[y][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    mat1[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < z; j++) {
                    mat2[i][j] = in.nextInt();
                }
            }
            int[][] res = mul(mat1, mat2);
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] mul(int[][] mat1, int[][] mat2) {
        int x = mat1.length, y = mat2.length, z = mat2[0].length;
        int[][] res = new int[x][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                for (int k = 0; k < y; k++) {
                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return res;
    }
}
