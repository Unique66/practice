/*
 * Copyright (c) 2021.  User:Unique66 File:NC112ConversionOfNumberSystems.java
 * Date:2021/07/07 23:53:07
 */

package com.autonomic.nowcoder.simpleness.done;

/**
 * @author Unique66
 * @description NC112 进制转换 考察点：位运算
 * @date 2021/7/7 0:17
 *
 * https://www.nowcoder.com/practice/2cc32b88fff94d7e8fd458b8c7b25ec1?tpId=117&&tqId=37836&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 *
 * 示例1
 * 输入：7,2
 * 返回值："111"
 *
 * 备注：
 * M是32位整数，2<=N<=16.
 */
public class NC112ConversionOfNumberSystems {
    public static void main(String[] args) {
        char a = 'A';
        Character f = (char)65;
        System.out.println(f.toString());
        System.out.println(f);
    }
    /**
     * 进制转换
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve (int M, int N) {
        // write code here
        if (M == 0) {
            return "0";
        }
        // 对M 求比值
        StringBuilder sb = new StringBuilder("");
        boolean f = false; // 是否为负数
        if (M < 0) {
            M = -M;
            f = true;
        }
        while (M != 0) {
            sb.append(invert(M % N)); // 余数
            M = M / N; // 除数
        }
        if (f) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    // 转换关系
    private char invert(int i) {
//        if (i < 10) {
//            return i + "";
//        } else {
//            // 10-16 分别对应 A/B/C/D/E/F    A 的ASCII 是65
//            return Character.toString((char)(55 + i));
//        }
        String s = "0123456789ABCDEF";
        return s.charAt(i);
    }
}
