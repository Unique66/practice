/*
 * Copyright (c) 2021.  User:Unique66 File:NC73AppearMoreThanHalfInArray.java
 * Date:2021/07/07 00:14:07
 */

package com.autonomic.nowcoder.simpleness;

import java.util.HashMap;

/**
 * @author Unique66
 * @description NC73 数组中出现次数超过一半的数字 考察点：数组、哈希
 * @date 2021/7/7 0:14
 *
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=117&&tqId=37770&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。你可以假设数组是非空的，并
 * 且给定的数组总是存在多数元素。1<=数组长度<=50000
 *
 * 示例1
 * 输入：[1,2,3,2,2,2,5,4,2]
 * 返回值：2
 *
 * 示例2
 * 输入：[3,3,3,3,2,2,2]
 * 返回值：3
 *
 * 示例3
 * 输入：[1]
 * 返回值：1
 */
public class NC73AppearMoreThanHalfInArray {
    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 0;
        int win = array[0]; // 胜利者
        for (int a : array) { // 待进入战场
            // 战场没人
            if (count == 0) {
                win = a; // 待对决的士兵
                count = 1;
            } else {
                // 如果是同一阵营
                if (win == a) {
                    count++;
                } else { // 不同阵营，就需要相互抵消了
                    count--;
                }
            }
        }
        // 遍历完毕后，调出最终胜利者，但也可能存在根本没有任何一个阵营超过总人数一半的情况
        int sum = 0;
        for (int a : array) {
            if (a == win) {
                sum++;
            }
        }
        return sum > array.length / 2 ? win : -1;
    }

    public int MoreThanHalfNum_Solution1(int [] array) {
        // hashmap 的key 存储元素，value 存储元素出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 遍历数组
        for (int a : array) {
            // 已经出现过一次了，直接put value+1
            map.merge(a, 1, Integer::sum);
        }
        // 处理完毕后，遍历HashMap，找到大于数组长度一半的value 对应的key
        int len = array.length;
        for (int a : array) {
            if (len / 2 < map.get(a)) {
                return a;
            }
        }
        return  -1;
    }
}
