/*
 * Copyright (c) 2021.  User:SXH  File:SpiralMatrix.java
 * Date:2021/07/04 23:03:04
 */

package com.autonomic.nowcoder.primer;

import java.util.ArrayList;

/**
 * @author Unique66
 * @description 螺旋矩阵 NC38
 * @date 2021/7/4 23:03
 *
 * 描述
 * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
 *
 * 示例1
 * 输入：[1,2,3],[4,5,6],[7,8,9]]
 * 返回值：[1,2,3,6,9,8,7,4,5]
 */
public class NC38SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        // 获取位置信息
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top < (matrix.length + 1) / 2 && left < (matrix[0].length + 1) / 2) {
            // top 从左向右
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            // right 从上向下
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            // bottom 从右向左
            for (int i = right - 1; i >= left && top != bottom; i--) {
                result.add(matrix[bottom][i]);
            }
            // left 从下向上
            // bottom - 1 是因为从右向左时，最后一位遍历的就是从下向上遍历的第一个数，故不用遍历
            // top + 1 是因为第一次从左向右时，第一次遍历的数就是此次遍历的最后一个数，故不用遍历
            for (int i = bottom -1; i >= (top + 1)&& left != right; i--) {
                result.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return result;
    }
}
