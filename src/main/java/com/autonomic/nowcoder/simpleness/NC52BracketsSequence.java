/*
 * Copyright (c) 2021.  User:Unique66 File:NC52BracketsSequence.java
 * Date:2021/07/06 00:33:06
 */

package com.autonomic.nowcoder.simpleness;

import java.util.Stack;

/**
 * @author Unique66
 * @description NC52 括号序列 考察点：栈、字符串
 * @date 2021/7/6 0:33
 *
 * https://www.nowcoder.com/practice/37548e94a270412c8b9fb85643c8ccc2?tpId=117&&tqId=37749&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 *
 * 示例1
 * 输入： "["
 * 返回值： false
 *
 * 示例2
 * 输入： "[]"
 * 返回值： true
 */
public class NC52BracketsSequence {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        // write code here
        int len = s.length(); // 字符串长度
        // 由题目可知，字符串长度一定是偶数，才能保证括号序列合法
        if (len % 2 != 0) {
            return false;
        }
        // 创建栈，用来处理char
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i); // 找到当前待处理的char
            // 处于左侧的符号，直接放入栈
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') { // 处于右侧的符号，要判断当前栈peek是否有与之对应的符号
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.peek();
                if (temp == '(' && c == ')') {
                    stack.pop();
                } else if (temp == '{' && c == '}') {
                    stack.pop();
                } else if (temp == '[' && c == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
