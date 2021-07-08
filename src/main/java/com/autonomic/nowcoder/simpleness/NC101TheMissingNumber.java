/*
 * Copyright (c) 2021.  User:Unique66 File:NC101TheMissingNumber.java
 * Date:2021/07/07 00:26:07
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC101 缺失数字 考察点：位运算、数组、数学、二分
 * @date 2021/7/7 0:26
 *
 * https://www.nowcoder.com/practice/9ce534c8132b4e189fd3130519420cde?tpId=117&&tqId=37825&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 从0,1,2,...,n这n+1个数中选择n个数，找出这n个数中缺失的那个数，要求O(n)尽可能小。
 *
 * 示例1
 * 输入：[0,1,2,3,4,5,7]
 * 返回值：6
 *
 * 示例2
 * 输入：[0,2,3]
 * 返回值：1
 */
public class NC101TheMissingNumber {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 找缺失数字
     * @param a int整型一维数组 给定的数字串
     * @return int整型
     */
    public int solve (int[] a) {
        // write code here
        // 如果我们把这个数组添加从0~n的n+1个元素，就变成了数组中只有一个数出现了一次，
        // 其他数字都出现了2次，让我们求这个只出现一次的数字。这题使用位运算是最容易解决的
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            res ^= (a[i] ^ i);
        }
        return res ^ a.length;
    }
}
