/*
 * Copyright (c) 2021.  User:Unique66 File:NC156NumberAppearOnceInArray.java
 * Date:2021/07/10 23:00:10
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC156 数组中只出现一次的数（其它数出现k次） 考察点：位运算
 * @date 2021/7/10 23:00
 *
 * 描述
 * 给定一个整型数组 arr 和一个整数 k(k>1)k(k>1)。
 * 已知 arr 中只有 1 个数出现一次，其他的数都出现 k 次。
 * 请返回只出现了 1 次的数。
 *
 * 示例1
 * 输入：[5,4,1,1,5,1,5],3
 * 返回值：4
 */
public class NC156NumberAppearOnceInArray {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param arr int一维数组
     * @param k int
     * @return int
     */
    public int foundOnceNumber (int[] arr, int k) {
        // write code here
        // 思路：整型数组中所有数变为二进制，然后所有二进制的数同位相加，如果是重复的，那么/k 是可以被整除的，
        // 所以这个存放32 位二进制相加结果的int[32] 数组的所有元素被k 除，余数就是那个单独的整数的二进制
        // 将此二进制变为十进制即可
        int[] res = new int[32];
        for (int i = 0; i < res.length; i++) {
            int sum = 0;
            // 对arr 数组遍历，求arr.length 个元素的二进制同位相加的结果
            for (int value : arr) {
                sum += (value >> i & 1); // 右移元素，得到该二进制位数
            }
            // 遍历完arr 整型数组，的倒i 这个二进制位的所有元素二进制位i 和
            res[i] = sum;
        }

        int result = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] % k != 0) {
                result += 1 << i; // 左移恢复
            }
        }
        return result;
    }
}
