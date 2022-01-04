/*
 * Copyright (c) 2021.  User:Unique66 File:Offer21SortArrayOddEven.java
 * Date:2021/11/30 23:19:30
 */

package com.autonomic.leetcode.offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 提示：
 *
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Unique66
 * @since 2021/11/30 23:19
 */
public class Offer21SortArrayOddEven {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(exchange(nums)));
    }

    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 要么是奇数，要么是偶数
        int tmp;
        while (left <= nums.length - 1 && right >= 0 && left < right) {
            // 从左边开始
            if (isOdd(nums[left])) {
                left++;
            } else { // 如果不是奇数（是偶数） 需要将偶数放到后半部分
                while (!isOdd(nums[right]) && left < right) {
                    right--;
                }
                tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        return nums;
    }

    private static boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
