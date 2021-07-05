/*
 * Copyright (c) 2021.  User:SXH  File:NC68JumpSteps.java
 * Date:2021/07/05 00:27:05
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC68 跳台阶 考察点：递归
 * @date 2021/7/5 0:27
 *
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=117&&tqId=37764&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 示例1
 * 输入：2
 * 返回值：2
 *
 * 示例2
 * 输入：7
 * 返回值：21
 */
public class NC68JumpSteps {
    // 1、递归方式，优点：方法简单，思路容易理解。 缺点：存在重复计算，占内存
    /*
        思路：
        假设f[i]表示在第i个台阶上可能的方法数。逆向思维。如果我从第n个台阶进行下台阶，下一步有2中可能，
        一种走到第n-1个台阶，一种是走到第n-2个台阶。所以f[n] = f[n-1] + f[n-2].
     */
    public int jumpFloor(int target) {
        if(target <= 2){
            return target;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    // 2、存储需要计算的内容，避免空间占用
    /*
        计算f[5]的时候只用到了f[4]和f[3], 没有用到f[2]...f[0],所以保存f[2]..f[0]是浪费了空间。
        只需要用3个变量即可。
     */
    public int jumpFloor1(int target) {
        if(target <= 2){
            return target;
        }
        int pre1 = 1, pre2 = 2; // pre1 在前，pre2 在后
        for (int i = 3; i <= target; i++) {
            int cur = pre1 + pre2; // 相当于 f(n) = f(n-1) + f(n-2)
            pre1 = pre2; // f(n+1) = f(n) + f(n-1) pre1向后移动，变为pre2
            pre2 = cur; // pre2 直接变为 f(n)
        }
        return  pre2;
    }
}
