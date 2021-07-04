/*
 * Copyright (c) 2021.  User:SXH  File:NC107SearchPeak.java
 * Date:2021/07/04 23:12:04
 */

package com.autonomic.nowcoder.primer;

/**
 * @author SXH
 * @description NC107 寻找峰值
 * @date 2021/7/4 23:12
 *
 * 描述
 * 山峰元素是指其值大于或等于左右相邻值的元素。给定一个输入数组nums，任意两个相邻元素值不相等，
 * 数组可能包含多个山峰。找到索引最大的那个山峰元素并返回其索引。
 *
 * 假设 nums[-1] = nums[n] = -∞。
 *
 * 示例1
 * 输入：[2,4,1,2,7,8,4]
 * 返回值：5
 */
public class NC107SearchPeak {
    /**
     * ※※※ 寻找最后的山峰
     * @param a int整型一维数组
     * @return int整型
     */
    public int solve (int[] a) {
        // write code here
        // 注意坑！※※※ 如果是最后一位，不用考虑右边，只需要大于左边，也是山峰元素
        // 从后向前找，效率更高
        for (int i = a.length - 1; i >= 0; i--) {
            if (i == a.length - 1) {
                if (a[i] >= a[i - 1]) {
                    return i;
                }
            } else if (i == 0 && a[i] >= a[i + 1]) {
                return i;
            } else {
                if (a[i] >= a[i + 1] && a[i] >= a[i - 1]) {
                    return i;
                }
            }
        }
        return -1;
    }
}
