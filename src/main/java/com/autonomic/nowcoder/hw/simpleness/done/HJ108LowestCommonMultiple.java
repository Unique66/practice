/*
 * Copyright (c) 2021.  User:Unique66 File:HJ108LowestCommonMultiple.java
 * Date:2021/07/13 00:44:13
 */

package com.autonomic.nowcoder.hw.simpleness.done;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ108 求最小公倍数
 * @date 2021/7/13 0:42
 *
 * https://www.nowcoder.com/practice/22948c2cad484e0291350abad86136c3?tpId=37&&tqId=21331&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 输入描述：
 * 输入两个正整数A和B。
 *
 * 输出描述：
 * 输出A和B的最小公倍数。
 *
 * 示例1
 * 输入：5 7
 * 输出：35
 */
public class HJ108LowestCommonMultiple {
    /*
      最小公倍数：在求出最大公约数后 两个数相乘除以最大公约数就是最小公倍数
     */
    // 欧几里得方式
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int a = in.nextInt();
        int b = in.nextInt();
        int ab = a * b;
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        // 此时a 较大，b 较小
        // 使用算法
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        // 此时b 就是最小公倍数
        System.out.println(ab / b);
    }

    // 另外一种方式：更相减损（九章算术）
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int int1= scanner.nextInt();
        int int2= scanner.nextInt();
        System.out.println(int1*int2/methods(int1,int2));
    }
    public static int methods(int int1,int int2){
        if(int1 == int2){
            return int2;
        }
        if(int1 > int2){
            int differ= int1-int2;
            return methods(int2,differ);
        }else{
            int differ= int2-int1;
            return methods(int1,differ);
        }
    }
}
