/*
 * Copyright (c) 2021.  User:Unique66 File:NC145Packsack0And1.java
 * Date:2021/07/10 22:55:10
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC145 01背包 考察点：动态规划
 * @date 2021/7/10 22:55
 *
 * https://www.nowcoder.com/practice/2820ea076d144b30806e72de5e5d4bbf?tpId=117&&tqId=37856&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 已知一个背包最多能容纳物体的体积为V
 * 现有n个物品第i个物品的体积为v_i第i个物品的重量为w_i
 * 求当前背包最多能装多大重量的物品
 *
 * 示例1
 * 输入：10,2,[[1,3],[10,4]]
 * 返回值：4
 *
 * 说明：
 * 第一个物品的体积为1，重量为3，第二个物品的体积为10，重量为4。只取第二个物品可以达到最优方案，取物重量为4
 *
 * 备注：
 * 1 ≤ V ≤ 200
 * 1 ≤ n ≤ 200
 * 1 ≤ v_i ≤ 200
 * 1 < w_i ≤ 200
 */
public class NC145Knapsack0And1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算01背包问题的结果
     * @param V int整型 背包的体积
     * @param n int整型 物品的个数
     * @param vw int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
     * @return int整型
     */
    public int knapsack (int V, int n, int[][] vw) {
        // write code here
        return -1;
    }
}
