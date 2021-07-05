/*
 * Copyright (c) 2021.  User:Unique66 File:NC48SearchTargetInRotatedOrderedArray.java
 * Date:2021/07/06 00:43:06
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC48 在旋转过的有序数组中寻找目标值 考察点：二分
 * @date 2021/7/6 0:43
 *
 * https://www.nowcoder.com/practice/87c0e7abcbda41e7963660fa7d020995?tpId=117&&tqId=37744&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 给定一个整数数组nums，按升序排序，数组中的元素各不相同。
 * nums数组在传递给search函数之前，会在预先未知的某个下标 t（0 <= t <= nums.length-1）上进行旋转，
 * 让数组变为[nums[t], nums[t+1], ..., nums[nums.length-1], nums[0], nums[1], ..., nums[t-1]]。
 * 比如，数组[0,2,4,6,8,10]在下标3处旋转之后变为[6,8,10,0,2,4]
 * 现在给定一个旋转后的数组nums和一个整数target，请你查找这个数组是不是存在这个target，如果存在，
 * 那么返回它的下标，如果不存在，返回-1
 *
 * 示例1
 * 输入：[6,8,10,0,2,4],10
 * 返回值：2
 *
 * 示例2
 * 输入：[6,8,10,0,2,4],3
 * 返回值：-1
 *
 * 示例3
 * 输入：[2],1
 * 返回值：-1
 *
 * 备注：
 * 1 <= nums.length <= 4000
 */
public class NC48SearchTargetInRotatedOrderedArray {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search (int[] nums, int target) {
        // write code here
        return -1;
    }
}
