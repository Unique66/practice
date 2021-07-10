/*
 * Copyright (c) 2021.  User:Unique66 File:NC31FirstCharThatAppearsOnlyOnce.java
 * Date:2021/07/11 00:23:11
 */

package com.autonomic.nowcoder.simpleness.done;

import java.util.HashMap;

/**
 * @author Unique66
 * @description NC31 第一个只出现一次的字符 考察点：字符串
 * @date 2021/7/10 22:38
 *
 * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=117&&tqId=37762&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 *
 * 示例1
 * 输入："google"
 * 返回值：4
 */
public class NC31FirstCharThatAppearsOnlyOnce {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.merge(str.charAt(i), 1, Integer::sum); // 每次+1
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
