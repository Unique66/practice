/*
 * Copyright (c) 2021.  User:Unique66 File:Offer39AppearNotNolyHalf.java
 * Date:2021/12/01 22:30:01
 */

package com.autonomic.leetcode.offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 限制：
 * 1 <= 数组长度 <= 50000
 *
 * @author Unique66
 * @since 2021/12/1 22:30
 */
public class Offer39SortAppearNotOnlyHalf {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    public static int majorityElement(int[] nums) {
        // 遍历一遍，对阵
        int tmp = nums[0];
        int n = 1; // 数量
        for (int i = 1; i < nums.length; i++) {
            if (n > nums.length / 2) { // 如果个数已经多于一半了，那么就找到了
                break;
            }
            if (n == 0) { // 有可能两军两败俱伤，需要加入新的阵营
                tmp = nums[i];
                n++;
                continue;
            }
            // 没有多于一半，就要两军交战了
            if (tmp == nums[i]) {
                n++;
            } else {
                n--;
            }
        }
        return tmp;
    }
}
