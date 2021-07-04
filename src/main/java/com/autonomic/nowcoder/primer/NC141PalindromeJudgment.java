/*
 * Copyright (c) 2021.  User:SXH  File:NC141PalindromeJudgment.java
 * Date:2021/07/04 23:09:04
 */

package com.autonomic.nowcoder.primer;

/**
 * @author Unique66
 * @description NC141 判断回文
 * @date 2021/7/4 23:09
 *
 * 描述
 * 给定一个字符串，请编写一个函数判断该字符串是否回文。如果回文请返回true，否则返回false。
 *
 * 示例1
 * 输入："absba"
 * 返回值：true
 *
 * 示例2
 * 输入："ranko"
 * 返回值：false
 *
 * 示例3
 * 输入："yamatomaya"
 * 返回值：false
 *
 * 示例4
 * 输入："a"
 * 返回值：true
 *
 * 备注：
 * 字符串长度不大于1000000，且仅由小写字母组成
 */
public class NC141PalindromeJudgment {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge (String str) {
        if (str == null) {
            return false;
        }
        // write code here
        int len = str.length();
        for (int i = 0; i < len/2; i++) {
            if (str.charAt(i) != str.charAt(len-1-i)) {
                return false;
            }
        }
        return true;
    }

//     public boolean judge2 (String str) {
//         if (str == null) {
//             return false;
//         }
//         // write code here
//         StringBuilder sb = new StringBuilder(str);
//         return str.equals(sb.reverse().toString());
//     }
}
