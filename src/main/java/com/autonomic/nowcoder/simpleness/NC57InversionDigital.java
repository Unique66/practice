/*
 * Copyright (c) 2021.  User:Unique66 File:NC57InversionDigital.java
 * Date:2021/07/07 00:23:07
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC57 反转数字 考察点：数学
 * @date 2021/7/7 0:23
 *
 * https://www.nowcoder.com/practice/1a3de8b83d12437aa05694b90e02f47a?tpId=117&&tqId=37755&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 你有注意到翻转后的整数可能溢出吗？因为给出的是32位整数，则其数值范围为[-2^31, 2^31 - 1]。
 * 翻转可能会导致溢出，如果反转后的结果会溢出就返回 0。
 *
 * 示例1
 * 输入：12
 * 返回值：21
 *
 * 示例2
 * 输入：-123
 * 返回值：-321
 *
 * 示例3
 * 输入：10
 * 返回值：1
 *
 * 示例4
 * 输入：1147483649
 * 返回值：0
 */
public class NC57InversionDigital {
    /**
     *
     * @param x int整型
     * @return int整型
     */
    public int reverse (int x) {
        // write code here
        long res = 0; // 承载翻转的数值
        while (x != 0) {
            // 从后向前的处理数据   例如：最后一位变为反转后的第一位
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (int) res == res ? (int) res : 0;
    }
}
