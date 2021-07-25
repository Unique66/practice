/*
 * Copyright (c) 2021.  User:Unique66 File:HJ38SmallBallFallRebound.java
 * Date:2021/07/26 01:34:26
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ38 求小球落地5次后所经历的路程和第5次反弹的高度
 * @date 2021/7/26 1:34
 *
 * https://www.nowcoder.com/practice/2f6f9339d151410583459847ecc98446?tpId=37&&tqId=21261&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 *
 * 最后的误差判断是小数点6位
 *
 *
 *
 * 输入描述：
 * 输入起始高度，int型
 *
 * 输出描述：
 * 分别输出第5次落地时，共经过多少米第5次反弹多高
 *
 * 示例1
 * 输入：1
 * 输出：
 * 2.875
 * 0.03125
 */
public class HJ38SmallBallFallRebound {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int hight = in.nextInt();
            double len = hight;
            double lastHight = hight;
            for (int i = 0; i < 5; i++) {
                lastHight /= 2;
                len += 2 * lastHight;
            }
            System.out.println(exchange(len - lastHight * 2));
            System.out.println(exchange(lastHight));
        }
    }

    public static double exchange(double d) {
        String str = d + "";
        if (str.contains(".")) {
            String[] strArray = str.split("\\.");
            if (strArray[1].length() > 6) {
                strArray[1] = strArray[1].substring(0, 6);
            }
            return Double.parseDouble(strArray[0] + "." + strArray[1]);
        }
        return d;
    }
}
