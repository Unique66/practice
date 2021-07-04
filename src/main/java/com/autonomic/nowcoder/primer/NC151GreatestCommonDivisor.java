/*
 * Copyright (c) 2021.  User:SXH  File:NC151GreatestCommonDivisor.java
 * Date:2021/07/04 23:17:04
 */

package com.autonomic.nowcoder.primer;

/**
 * @author Unique66
 * @description NC151 最大公约数
 * @date 2021/7/4 23:17
 *
 * https://www.nowcoder.com/practice/cf4091ca75ca47958182dae85369c82c?tpId=117&&tqId=37861&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 求出两个数的最大公约数，如果有一个自然数a能被自然数b整除，则称a为b的倍数，b为a的约数。
 * 几个自然数公有的约数，叫做这几个自然数的公约数。公约数中最大的一个公约数，称为这几个自然数的最大公约数。
 *
 * 示例1
 * 输入：3,6
 * 返回值：3
 *
 * 示例2
 * 输入：8,12
 * 返回值：4
 *
 * 备注：
 * a和b的范围是[1-109]
 */
public class NC151GreatestCommonDivisor {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 求出a、b的最大公约数。
     * @param a int
     * @param b int
     * @return int
     */
    // 欧几里得
    public int gcd (int a, int b) {
        // write code here
        // 保证大的 % 小的
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        // 开始欧几里得的算法处理
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    // 欧几里得算法
    public int gcd1 (int a, int b) {
        // write code here
        // 欧几里得算法
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a%b);
        }
    }

    // 九章算术算法
    public int gcd2 (int a, int b) {
        // write code here
        if (a % b == 0 || b % a == 0) {
            return a % b == 0 ? b : a;
        }
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
