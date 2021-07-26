/*
 * Copyright (c) 2021.  User:Unique66 File:HJ14StringSort.java
 * Date:2021/07/23 00:28:23
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ14 字符串排序
 * @date 2021/7/23 0:28
 *
 * https://www.nowcoder.com/practice/5af18ba2eb45443aa91a11e848aa6723?tpId=37&&tqId=21237&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 *
 * 示例1
 * 输入：
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 *
 * 输出：
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 */
public class HJ14StringSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // ※※此处如使用nextInt() 方法不会换行，对于题目输入是有问题的，
        // 所以使用nextLine() 然后Integer 转换的方式获取整数值
        int line = Integer.parseInt(in.nextLine());
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < line; i++) {
            String str = in.nextLine();
            list.add(str);
        }
        Collections.sort(list);
        for (String l : list) {
            System.out.println(l);
        }
    }

//    Scanner in = new Scanner(System.in);
//    int n = Integer.valueOf(in.nextLine());
//    String[] array = new String[n];
//        for (int i = 0; i < n; i++) {
//        array[i] = in.nextLine();
//    }
//        Arrays.sort(array);
//        for (String str : array) {
//        System.out.println(str);
//    }
}
