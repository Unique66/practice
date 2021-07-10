/*
 * Copyright (c) 2021.  User:Unique66 File:NC106MaxProductOfThreeNumbers.java
 * Date:2021/07/10 22:51:10
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC106 三个数的最大乘积 考察点：数组、数学
 * @date 2021/7/10 22:51
 * <p>
 * https://www.nowcoder.com/practice/8ae05c2913fe438b8b14f3968f64fc0b?tpId=117&&tqId=37830&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)。
 * <p>
 * 示例1
 * 输入：[3,4,1,2]
 * 返回值：24
 */
public class NC106MaxProductOfThreeNumbers {
    /**
     * 最大乘积
     *
     * @param A int整型一维数组
     * @return long长整型
     */
    public long solve(int[] A) {
        // write code here
        // thinking:要么就是最小的两个负数*最大的正数，要么就是三个最大的正数
        // 最大的第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        //最小的和第二小的（负数的时候要用）
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int j : A) {
            if (j < min1) {//更新最小值
                min2 = min1;
                min1 = j;
            } else if (j < min2) {//更新第二小
                min2 = j;
            }
            if (j > max1) {//更新最大值
                max3 = max2;
                max2 = max1;
                max1 = j;
            } else if (j > max2) {//更新第二大
                max3 = max2;
                max2 = j;
            } else if (j > max3) {//更新第三大
                max3 = j;
            }
        }
        return Math.max((long) min1 * min2 * max1, (long) max1 * max2 * max3);
    }
}
