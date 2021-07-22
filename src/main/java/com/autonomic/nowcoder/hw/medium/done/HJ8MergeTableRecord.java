/*
 * Copyright (c) 2021.  User:Unique66 File:HJ8MergeTableRecord.java
 * Date:2021/07/22 23:48:22
 */

package com.autonomic.nowcoder.hw.medium.done;

import java.util.*;

/**
 * @author Unique66
 * @description HJ8 合并表记录
 * @date 2021/7/22 23:45
 *
 * https://www.nowcoder.com/practice/de044e89123f4a7482bd2b214a685201?tpId=37&&tqId=21231&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，
 * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述：
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述：
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入：
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 *
 * 输出：
 * 0 3
 * 1 2
 * 3 4
 */
public class HJ8MergeTableRecord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        HashSet<Integer> set = new HashSet<>(); // 存放键值（去重）
        HashMap<Integer, Integer> map = new HashMap<>(); // 存放key value
        int line = in.nextInt(); // 行数
        while (in.hasNextLine() && line > 0) { // 注意 while 处理多个 case
            int key = in.nextInt();
            int value = in.nextInt();
            set.add(key);
            map.merge(key, value, Integer::sum);
            line--;
        }
        // 遍历完毕也就处理好了存储，接下来开始遍历处理
        LinkedList<Integer> list = new LinkedList<>(set);
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer + " " + map.get(integer));
        }
    }
}
