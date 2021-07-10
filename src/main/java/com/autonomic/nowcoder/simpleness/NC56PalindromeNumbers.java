/*
 * Copyright (c) 2021.  User:Unique66 File:NC56PalindromeNumbers.java
 * Date:2021/07/08 01:20:08
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC56 回文数字 考察点：数学
 * @date 2021/7/8 1:20
 *
 * https://www.nowcoder.com/practice/35b8166c135448c5a5ba2cff8d430c32?tpId=117&&tqId=37753&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 在不使用额外的内存空间的条件下判断一个整数是否是回文数字
 * 提示：
 * 负整数可以是回文吗？（比如-1）
 * 如果你在考虑将数字转化为字符串的话，请注意一下不能使用额外空间的限制
 * 你可以将整数翻转。但是，如果你做过题目“反转数字”，你会知道将整数翻转可能会出现溢出的情况，你怎么处理这个问题？
 *
 * 示例1
 * 输入：121
 * 返回值：true
 */
public class NC56PalindromeNumbers {
    /**
     *
     * @param x int整型
     * @return bool布尔型
     */
    public boolean isPalindrome (int x) {
        // write code here
        if (x < 0) {
            return false;
        }
        // 将 x 翻转，int 翻转时可能会溢出，所以需要使用long 类型来接收
        long res = 0L;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        // 上面循环遍历完毕后，会将x 倒置
        return (int) res == res;
    }
}
