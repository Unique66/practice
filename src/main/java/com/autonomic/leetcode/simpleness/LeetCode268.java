/*
 * Copyright (c) 2022.  User:Unique66 File:LeetCode268.java
 * Date:2022/01/06 22:49:06
 */

package com.autonomic.leetcode.simpleness;

/**
 * 丢失的数字
 *
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 *
 * 进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/1/6 22:49
 */
public class LeetCode268 {
    public static void main(String[] args) {
        // 测试异或
        System.out.println(1 ^ 1);
        System.out.println(1 ^ 0);
    }

    // 题解思路
    public int missingNumber1(int[] nums) {
        // 使用异或，两数相同取异或则为0
        int result = 0;
        int len = nums.length;

        for (int num : nums) {
            result ^= num;
        }
        for (int i = 0; i <= len; i++) {
            result ^= i;
        }
        return result;
    }

    // 初见解法
    public int missingNumber(int[] nums) {
        // 使用额外空间，记录存储出现的次数，找到没有出现（也就是临时数组元素为零）的下标
        int[] tmpArr = new int[nums.length + 1];
        for (int num : nums) {
            tmpArr[num]++;
        }
        for (int i = 0; i < tmpArr.length; i++) {
            if (tmpArr[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
