/*
 * Copyright (c) 2021.  User:Unique66 File:GenerateParentheses.java
 * Date:2021/09/01 23:31:01
 */

package com.autonomic.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Unique66
 * @description 括号生成
 * @date 2021/9/1 23:31
 *
 * https://leetcode-cn.com/classic/problems/generate-parentheses/description/
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * 提示：
 * 1 <= n <= 8
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(validParentheses("(()))"));
        System.out.println(validParentheses("(()(()))"));
        System.out.println(validParentheses("()(())"));
        System.out.println(validParentheses("())(()"));
        System.out.println(generateParenthesis(3).toString());
    }

    static List<String> result = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        // 从左括号开始，n 个左括号，然后 n-1 左括号情况，直到一个左括号情况
        // 还需要有一个判断组合合法的校验
        dfs(n, n, "");
        return result;
    }

    public static void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) {
            result.add(curStr);
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) {
            dfs(left, right - 1, curStr + ")");
        }
    }

    public static boolean validParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(str.charAt(i));
            } else {
                if (')' == str.charAt(i) && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(str.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }
}
