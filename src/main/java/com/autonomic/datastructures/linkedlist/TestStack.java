package com.autonomic.datastructures.linkedlist;/**
 * Created by SXH on 2020/4/23 23:02.
 */

import java.util.Stack;

/**
 * @author SXH
 * @description 栈的基本用法
 * @date 2020/4/23 23:02.
 */
public class TestStack {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.add("jack");
		stack.add("tom");
		stack.add("smith");
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
}
