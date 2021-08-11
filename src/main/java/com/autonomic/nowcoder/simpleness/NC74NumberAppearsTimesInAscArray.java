/*
 * Copyright (c) 2021.  User:Unique66 File:NC74NumberAppearsTimsInAscArray.java
 * Date:2021/07/10 22:43:10
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC74 数字在升序数组中出现的次数
 * @date 2021/7/10 22:43
 * <p>
 * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=117&&tqId=37772&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 统计一个数字在升序数组中出现的次数。
 * <p>
 * 示例1
 * 输入：[1,2,3,3,3,3,4,5],3
 * 返回值：4
 */
public class NC74NumberAppearsTimesInAscArray {
    public int GetNumberOfK(int [] array , int k) {
        // 通过二分查找找到其下标，然后向左向右找共有几个
        int size = 0; // 出现次数
        int index = getIndex(array, k, 0, array.length - 1); // 其中一个下标
        if (index == -1) {
            return size;
        } else {
            int left = index - 1;
            int right = index + 1;
            while (left >= 0 && array[left--] == k) {
                size++;
            }
            while (right <= array.length - 1 && array[right++] == k) {
                size++;
            }
            return size + 1;
        }
    }

    public int getIndex(int[] array, int k, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
