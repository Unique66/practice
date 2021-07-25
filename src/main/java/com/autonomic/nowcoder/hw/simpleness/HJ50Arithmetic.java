/*
 * Copyright (c) 2021.  User:Unique66 File:HJ50Arithmetic.java
 * Date:2021/07/26 01:08:26
 */

package com.autonomic.nowcoder.hw.simpleness;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Unique66
 * @description HJ50 四则运算
 * @date 2021/7/26 1:08
 * <p>
 * https://www.nowcoder.com/practice/9999764a61484d819056f807d2a91f1e?tpId=37&&tqId=21273&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 * <p>
 * <p>
 * <p>
 * 输入描述：
 * 输入一个算术表达式
 * <p>
 * 输出描述：
 * 得到计算结果
 * <p>
 * 示例1
 * 输入：3+2*{1+2*[-4/(8-6)+7]}
 * 输出：25
 */
public class HJ50Arithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int pos = 0;
            System.out.println(getInnerResult(s));
        }
    }

    static int pos;

    //递归，消消乐，算括号里面的(无括号的)数字的结果
    public static int getInnerResult(String s) {
        Stack<Integer> val = new Stack<>();
        int num = 0;
        char opt = '+';
        while (pos < s.length()) {
            //遇到括号，开始递归 ，从括号里面开始算，消消乐
            if (s.charAt(pos) == '{' || s.charAt(pos) == '[' || s.charAt(pos) == '(') {
                pos++;
                num = getInnerResult(s);
            }

            //得到数字num
            while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
                //这步操作是 num是几位就得到几位的num。
                num = num * 10 + s.charAt(pos) - '0';
                pos++;
            }

            //按照题目意思，正常合法的表达式字符串的话，数字后面一定会是跟运算符。
            //所以这里判断运算符
            //这一步的终极目的是把栈里面全部变成+ 号的运算，
            switch (opt) {
                case '+':
                    val.push(num);
                    break;
                //- 号的时候变成负数
                case '-':
                    val.push(-num);
                    break;
                //乘号的时候出栈先做乘法运算后把得到的结果 再入栈
                case '*':
                    val.push(val.pop() * num);
                    break;
                //同上面的乘号
                case '/':
                    val.push(val.pop() / num);
                    break;
            }
            num = 0;
            if (pos < s.length()) {
                //数字后面有可能是运算符或者括号
                //如果下面没有被break，这里opt是取得的下一个运算符
                opt = s.charAt(pos);
                //如果这里是括号，就break，那么opt的值会在一开始被初始化成+
                if (s.charAt(pos) == '}' || s.charAt(pos) == ']' || s.charAt(pos) == ')') {
                    pos++;
                    break;
                }
            }
            pos++;
        }
        int sum = 0;
        while (!val.empty()) {
            sum += val.pop();
        }
        return sum;
    }
}
