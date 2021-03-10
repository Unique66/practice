/*
 * Copyright (c) 2021.  User:SXH  File:LeetCode1.java
 * Date:2021/03/10 23:02:10
 */

package com.autonomic.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SXH
 * @date 2021/3/10 23:02
 * @description 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum1(nums, 9);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 暴力破解  时间复杂度过高:O(n²)
     *
     * @param: nums 待查找数组
     * @param: target 目标和
     * @return int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return new int[0];
    }

    /**
     * 最优解，hash 时间复杂度：O(n)
     *
     * @param: nums 待查找数组
     * @param: target 目标和
     * @return int[]
     */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 算出此时对应的第二个数
            int secondNum = target - nums[i];
            if (tempMap.containsKey(secondNum)) {
                // 如果map 集合中存在这样的第二个数，那么就找到了
                return new int[]{tempMap.get(secondNum), i};
            }
            // 如果在集合中没找到第二个额数，那么就把第一个数存到map 集合中
            // 值作为key，下标作为value
            tempMap.put(nums[i], i);
        }
        return new int[0];
    }
}
