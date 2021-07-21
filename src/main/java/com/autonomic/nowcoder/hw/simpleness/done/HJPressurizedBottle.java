/*
 * Copyright (c) 2021.  User:Unique66 File:HJPressurizedBottle.java
 * Date:2021/07/21 22:38:21
 */

package com.autonomic.nowcoder.hw.simpleness.done;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ22 汽水瓶
 * @date 2021/7/21 22:37
 *
 * https://www.nowcoder.com/practice/fe298c55694f4ed39e256170ff2c205f?tpId=37&&tqId=21245&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，
 * 她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，
 * 喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，
 * 喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 * 输入描述：
 * 输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），
 * 表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。
 *
 * 输出描述：
 * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
 *
 * 示例1
 * 输入：
 * 3
 * 10
 * 81
 * 0
 *
 * 输出：
 * 1
 * 5
 * 40
 */
public class HJPressurizedBottle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt(); // 空瓶子数量
            if (n == 0) { // 如果是0 跳出循环
                break;
            }
            int result = 0;
            while (n >= 2) {
                if (n == 2) {
                    result += 1; // 如果只剩余两个空瓶子，按题意可以借一个空瓶子，所以最后结果+1
                    break;
                }
                int full = n / 3; // 换到的饮料个数
                int empty = n % 3; // 换完饮料后，未喝前剩余空瓶子个数
                result += full; // 换到的饮料可以加到最后的总数上
                n = full + empty; // 换完的饮料喝完加上之前剩下来的空瓶子，就是手里所有的空瓶子
            }
            System.out.println(result);
        }
    }
}
