/*
 * Copyright (c) 2022.  User:Unique66 File:LeetCode88.java
 * Date:2022/01/04 22:29:04
 */

package com.autonomic.leetcode.simpleness;

/**
 * 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 *
 * 示例 3：
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2022/1/4 22:29
 */
public class LeetCode88 {
    public static void main(String[] args) {

        int[] nums1 = {};
        int[] nums2 = {};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前，哪个大，哪个放最后
        int lastIndex = nums1.length - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (index2 >= 0 && index1 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[lastIndex] = nums1[index1];
                index1--;
            } else {
                nums1[lastIndex] = nums2[index2];
                index2--;
            }
            lastIndex--;
        }
        // 可能存在num1 中的元素已经处理完了，num2 还有元素未处理，统一放到num1 前面就行
        if (index2 >= 0) {
            for (int i = 0; i <= index2; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
}
