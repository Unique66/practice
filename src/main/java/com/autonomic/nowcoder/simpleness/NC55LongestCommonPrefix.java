/*
 * Copyright (c) 2021.  User:Unique66 File:NC55LongestCommonPrefix.java
 * Date:2021/07/08 01:18:08
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC55 最长公共前缀 考察点：字符串
 * @date 2021/7/8 1:18
 *
 * https://www.nowcoder.com/practice/28eb3175488f4434a4a6207f6f484f47?tpId=117&&tqId=37752&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 示例1
 * 输入：["abca","abc","abca","abc","abcc"]
 * 返回值："abc"
 */
public class NC55LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println("01".substring(0, 2));
    }
    /**
     *
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix (String[] strs) {
        // write code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = "";
        for (int i = 0; i < strs[0].length(); i++) {
            res = strs[0].substring(0, i + 1);
            for (int j = 1; j < strs.length; j++) {
                if (res.length() > strs[j].length()
                        || !res.equals(strs[j].substring(0, i + 1))) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
