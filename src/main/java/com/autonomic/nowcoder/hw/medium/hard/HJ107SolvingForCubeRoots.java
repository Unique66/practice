/*
 * Copyright (c) 2021.  User:Unique66 File:HJ107SolvingForCubeRoots.java
 * Date:2021/07/30 00:09:30
 */

package com.autonomic.nowcoder.hw.medium.hard;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ107 求解立方根
 * @date 2021/7/30 0:09
 *
 * https://www.nowcoder.com/practice/caf35ae421194a1090c22fe223357dca?tpId=37&&tqId=21330&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 计算一个数字的立方根，不使用库函数。
 * 保留一位小数。
 *
 * 输入描述：
 * 待求解参数，为double类型（一个实数）
 *
 * 输出描述：
 * 输入参数的立方根。保留一位小数。
 *
 * 示例1
 * 输入：216
 * 输出：6.0
 */
public class HJ107SolvingForCubeRoots {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextDouble()) { // 注意 while 处理多个 case
            double num = in.nextDouble();
            System.out.printf("%.1f", getCubeRoot(num));
        }
    }

    /**
     * 设函数f(x) = x3 - A，若求A的平方根，则有f(x) = 0
     * 由牛顿迭代公式 x = x0 - f(x0) / f `(x0)
     * 得到下一个近似值
     * xn+1 = xn - (xn3 - A) / (3xn2)
     *      = xn - (x3 - A)/xn2 /3
     *      = xn - (xn - A/xn/xn)/3
     *      = (A/xn/xn + 2 * xn)/3
     */
    public static double getCubeRoot(double num) {
        if (num == 0) {
            return 0;
        }
        double x0 = num;
        double x1 = (2 * x0 + num / x0 / x0) / 3;
        while (Math.abs(x1 - x0) > 0.001) {
            x0 = x1;
            x1 = (2 * x0 + num / x0 / x0) / 3;
        }
        return x1;
    }
}
