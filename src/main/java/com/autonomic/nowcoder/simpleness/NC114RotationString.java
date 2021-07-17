/*
 * Copyright (c) 2021.  User:Unique66 File:NC114RotationString.java
 * Date:2021/07/10 22:52:10
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC114 旋转字符串 考察点：字符串
 * @date 2021/7/10 22:52
 * <p>
 * https://www.nowcoder.com/practice/80b6bb8797644c83bc50ac761b72981c?tpId=117&&tqId=37838&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 字符串旋转:
 * 给定两字符串A和B，如果能将A从中间某个位置分割为左右两部分字符串（都不为空串），
 * 并将左边的字符串移动到右边字符串后面组成新的字符串可以变为字符串B时返回true。
 * 例如：如果A=‘youzan’，B=‘zanyou’，A按‘you’‘zan’切割换位后得到‘zanyou’和B相同返回true。
 * <p>
 * 示例1
 * 输入："youzan","zanyou"
 * 返回值：true
 * <p>
 * 示例2
 * 输入："youzan","zyouan"
 * 返回值：false
 */
public class NC114RotationString {
    /**
     * 旋转字符串
     *
     * @param A string字符串
     * @param B string字符串
     * @return bool布尔型
     */
    /*
        题解中很离谱的一种解法
        1、假如 A="abcd" 则 A+A = "abcdabcd"
        2、如果B 满足 题目的条件，则B 一定属于 A+A 里面的一个子串
    */
    public boolean solve(String A, String B) {
        //特殊情况处理
        if (A == null || B == null || A.length() < 2 || B.length() < 2 || A.length() != B.length()) {
            return false;
        }
        return (A + A).contains(B);
    }

    public boolean solve1(String A, String B) {
        // write code here
        if (A == null || B == null || A.length() < 2 || B.length() < 2 || A.length() != B.length()) {
            return false;
        }
        int len = A.length();
        for (int i = 0; i < len - 1; i++) {
            String temp1 = A.substring(0, i + 1);
            String temp2 = A.substring(i + 1);
            if (B.equals(temp2 + temp1)) {
                return true;
            }
        }
        return false;
    }
}
