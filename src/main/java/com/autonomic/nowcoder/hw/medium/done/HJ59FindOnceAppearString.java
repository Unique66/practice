/*
 * Copyright (c) 2021.  User:Unique66 File:HJ59FindOnceApearString.java
 * Date:2021/07/26 23:58:26
 */

package com.autonomic.nowcoder.hw.medium.done;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ59 找出字符串中第一个只出现一次的字符
 * @date 2021/7/26 23:58
 * <p>
 * https://www.nowcoder.com/practice/e896d0f82f1246a3aa7b232ce38029d4?tpId=37&&tqId=21282&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 找出字符串中第一个只出现一次的字符
 * <p>
 * 输入描述：
 * 输入几个非空字符串
 * <p>
 * 输出描述：
 * 输出第一个只出现一次的字符，如果不存在输出-1
 * <p>
 * 示例1
 * 输入：
 * asdfasdfo
 * aabb
 * 复制
 * 输出：
 * o
 * -1
 */
public class HJ59FindOnceAppearString {
    // 取巧的一种方式，效率高
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            boolean none = true;
            for (int i = 0; i < str.length(); i++) {
                if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                    System.out.println(str.charAt(i));
                    none = false;
                    break;
                }
            }
            if (none) {
                System.out.println(-1);
            }
        }
    }

    // 效率过于低下
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                map.merge(str.charAt(i), 1, Integer::sum);
            }
            boolean none = true;
            for (int i = 0; i < str.length(); i++) {
                if (map.get(str.charAt(i)) == 1) {
                    System.out.println(str.charAt(i));
                    none = false;
                    break;
                }
            }
            if (none) {
                System.out.println("-1");
            }
        }
    }
}
