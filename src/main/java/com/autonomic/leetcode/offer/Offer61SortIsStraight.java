/*
 * Copyright (c) 2021.  User:Unique66 File:Offer61SortIsStraight.java
 * Date:2021/12/01 23:07:01
 */

package com.autonomic.leetcode.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
 * A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 * 
 * 限制：
 * 数组长度为 5
 *
 * 数组的数取值为 [0, 13] .
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Unique66
 * @since 2021/12/1 23:07
 */
public class Offer61SortIsStraight {
    public static void main(String[] args) {

    }

    public boolean isStraight(int[] nums) {
        // 可以有5个大小王。。。
        Arrays.sort(nums);
        // 除大小王外，如果重复，那么就不可能组成同花顺
        // 除大小王外，没有重复，那么比较最大值与最小值之间的间隙与大小王个数
        int zeroNum = 0;
        int diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zeroNum++;
                continue;
            }
            // 不是零但是前后相等，那么不会是同花顺
            if (nums[i] == nums[i + 1]) {
                return false;
            }
            diff+= nums[i + 1] - nums[i];
        }
        if (zeroNum == 0) { // 如果没有大小王，那么最大与最小值的差应该是4，不是则不是同花顺
            return diff == 4;
        } else { // 如果存在大小王（0）,那么就需要保证最大与最小值的差小于等于4
            return diff <= 4;
        }
    }
}
