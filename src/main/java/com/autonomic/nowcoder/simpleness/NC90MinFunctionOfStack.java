/*
 * Copyright (c) 2021.  User:Unique66 File:NC90MinFunctionOfStack.java
 * Date:2021/07/06 00:47:06
 */

package com.autonomic.nowcoder.simpleness;

import java.util.Stack;

/**
 * @author Unique66
 * @description NC90 包含min函数的栈 考察点：栈
 * @date 2021/7/6 0:47
 *
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=117&&tqId=37793&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数，并且调用 min函数、push函数
 * 及 pop函数 的时间复杂度都是 O(1)
 * push(value):将value压入栈中
 * pop():弹出栈顶元素
 * top():获取栈顶元素
 * min():获取栈中最小元素
 *
 * 示例:
 * 输入:    ["PSH-1","PSH2","MIN","TOP","POP","PSH1","TOP","MIN"]
 * 输出:    -1,2,1,-1
 * 解析:
 * "PSH-1"表示将-1压入栈中，栈中元素为-1
 * "PSH2"表示将2压入栈中，栈中元素为2，-1
 * “MIN”表示获取此时栈中最小元素==>返回-1
 * "TOP"表示获取栈顶元素==>返回2
 * "POP"表示弹出栈顶元素，弹出2，栈中元素为-1
 * "PSH-1"表示将1压入栈中，栈中元素为1，-1
 * "TOP"表示获取栈顶元素==>返回1
 * “MIN”表示获取此时栈中最小元素==>返回-1
 *
 * 示例1
 * 输入：["PSH-1","PSH2","MIN","TOP","POP","PSH1","TOP","MIN"]
 * 返回值：-1,2,1,-1
 */
public class NC90MinFunctionOfStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>(); // 用来存储栈中每一层对应的最小值，以便返回

    public void push(int node) {
        stack.push(node);
        // 需要操作minStack 存储最小值
        if (minStack.isEmpty()) { // 首次存储，直接放入
            minStack.push(node);
        } else {
            if (minStack.peek() < node) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(node);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
