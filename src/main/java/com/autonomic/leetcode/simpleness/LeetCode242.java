/*
 * Copyright (c) 2022.  User:Unique66 File:LeetCode242.java
 * Date:2022/01/05 23:07:05
 */

package com.autonomic.leetcode.simpleness;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2022/1/5 23:07
 */
public class LeetCode242 {
    // 题解思路
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if (len != t.length()) {
            return false;
        }
        int [] tmp = new int[26]; // 英文字符只有26个，初始化一个26长度的数组，记录s 和t 字符出现的次数
        for (int i = 0; i < len; i++) {
            tmp[s.charAt(i) - 'a']++;
            tmp[t.charAt(i) - 'a']--;
        }

        // 遍历完毕两个字符串后，检查tmp 数组，元素都为0，则返回true
        for (int j : tmp) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    // 初见解法
    public boolean isAnagram1(String s, String t) {
        // 思路：如果两个字符串长度不相等，则直接返回false
        // 提供一个map，以字符为key，出现次数为value
        int len = s.length();
        if (len != t.length()) {
            return false;
        }
        Map<Character, Integer> recordMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            recordMap.merge(s.charAt(i), 1, Integer::sum); // 每次+1
        }

        for (int i = 0; i < len; i++) {
            if (recordMap.get(t.charAt(i)) == null) {
                return false;
            } else {
                recordMap.put(t.charAt(i), recordMap.get(t.charAt(i)) - 1);
            }
        }

        for (Integer value : recordMap.values()) {
            if (value == null || value != 0) {
                return false;
            }
        }
        return true;
    }
}
