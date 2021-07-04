/*
 * Copyright (c) 2021.  User:SXH  File:NC61SumOfTwoNumbers.java
 * Date:2021/07/04 23:23:04
 */

package com.autonomic.nowcoder.simpleness;

import java.util.HashMap;

/**
 * @author Unique66
 * @description NC61 两数之和
 * @date 2021/7/4 23:23
 *
 * https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=117&&tqId=37756&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 *
 * 例如：
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 *
 *
 * 示例1
 * 输入：[3,2,4],6
 * 返回值：[2,3]
 *
 * 说明：
 * 因为 2+4=6 ，而 2的下标为2 ， 4的下标为3 ，又因为 下标2 < 下标3 ，所以输出[2,3]
 */
public class NC61SumOfTwoNumbers {
    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        // 使用hashMap 来存储sub目标值的其中一个
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int sub = target - numbers[i];
            if (hash.containsKey(sub)) {
                // 从hashMap 中找到的下标必然是较小的那一个，加1 是因为题目要求下标从1开始
                return new int[]{hash.get(sub) + 1, i + 1};
            }
            hash.put(numbers[i], i);
        }
        return null;
    }
}
