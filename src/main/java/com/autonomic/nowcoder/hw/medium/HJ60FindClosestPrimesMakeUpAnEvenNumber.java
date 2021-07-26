/*
 * Copyright (c) 2021.  User:Unique66 File:HJ60FindClosestPrimesMakeUpAnEvenNumber.java
 * Date:2021/07/27 00:09:27
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ60 查找组成一个偶数最接近的两个素数
 * @date 2021/7/27 0:09
 *
 * https://www.nowcoder.com/practice/f8538f9ae3f1484fb137789dec6eedb9?tpId=37&&tqId=21283&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 * 本题含有多组样例输入。
 * 输入描述：
 * 输入一个偶数
 *
 * 输出描述：
 * 输出两个素数
 *
 * 示例1
 * 输入：
 * 20
 * 输出：
 * 7
 * 13
 */
public class HJ60FindClosestPrimesMakeUpAnEvenNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            int prime1 = num / 2;
            int prime2 = num - prime1;
            // 从中间开始找
            while (isNotPrime(prime1) || isNotPrime(prime2)) {
                prime1--; // 不是则一点一点找，也就是+1 -1
                prime2++;
            }
            // 此时是就找到了满足条件的两个素数
            System.out.println(prime1);
            System.out.println(prime2);
        }
    }

    // 判断是否为素数
    public static boolean isNotPrime(int num) {
        for (int i = 2; i <= num / i; i++) { // xue微有点疑问
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }
}
