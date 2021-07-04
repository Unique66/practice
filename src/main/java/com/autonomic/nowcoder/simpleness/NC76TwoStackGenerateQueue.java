/*
 * Copyright (c) 2021.  User:SXH  File:NC76TwoStackGenerateQueue.java
 * Date:2021/07/05 00:24:05
 */

package com.autonomic.nowcoder.simpleness;

import java.util.Stack;

/**
 * @author Unique66
 * @description NC76 用两个栈实现队列  考察点：栈
 * @date 2021/7/5 0:24
 *
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=117&&tqId=37774&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 用两个栈来实现一个队列，分别完成在队列尾部插入整数(push)和在队列头部删除整数(pop)的功能。
 * 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
 *
 * 示例:
 * 输入: ["PSH1","PSH2","POP","POP"]
 * 返回: 1,2
 * 解析:
 * "PSH1":代表将1插入队列尾部
 * "PSH2":代表将2插入队列尾部
 * "POP“:代表删除一个元素，先进先出=>返回1
 * "POP“:代表删除一个元素，先进先出=>返回2
 *
 * 示例1
 * 输入：["PSH1","PSH2","POP","POP"]
 * 返回值：1,2
 */
public class NC76TwoStackGenerateQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {

    }

    public int pop() {
        return -1;
    }
}
