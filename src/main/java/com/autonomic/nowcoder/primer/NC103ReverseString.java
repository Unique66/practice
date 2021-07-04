/*
 * Copyright (c) 2021.  User:SXH  File:ReverseArray.java
 * Date:2021/07/04 23:01:04
 */

package com.autonomic.nowcoder.primer;

/**
 * @author SXH
 * @description 反转字符串 NC103
 * @date 2021/7/4 23:01
 *
 * 描述
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * 示例1
 * 输入："abcd"
 * 返回值："dcba"
 */
public class NC103ReverseString {
    /**
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public String solve (String str) {
        // write code here
//         StringBuilder sb = new StringBuilder(str);
//         return sb.reverse().toString();
        char[] c = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = c.length - 1; i >= 0; i--) {
            sb.append(c[i]);
        }
        return sb.toString();
    }
}
