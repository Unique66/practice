package com.autonomic.datastructures.stack;/**
 * Created by SXH on 2020/4/28 23:41.
 */

import java.util.Scanner;

/**
 * @author SXH
 * @description 数组来模拟栈
 * 也可以用链表来实现，待实现
 * @date 2020/4/28 23:41.
 */
public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(5);
		String key = ""; // 键入的指令
		boolean loop = true; // 控制是否退出菜单
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("show：表示显示栈");
			System.out.println("exit：表示退出程序");
			System.out.println("push：表示添加数据到栈（入栈）");
			System.out.println("pop：表示从栈取数据（出栈）");
			System.out.println("请输入你的选择：");
			key = scanner.next();
			switch (key) {
				case "show":
					stack.list();
					break;
				case "push":
					int value = scanner.nextInt();
					stack.push(value);
					break;
				case "pop":
					try {
						int res = stack.pop();
						System.out.printf("出栈的值为：%d", res);
					} catch (RuntimeException e) {
						e.printStackTrace();
					}
					break;
				case "exit":
					scanner.close();
					loop = false;
					break;
				default:
					System.out.println("命令异常，请重新输入~");
			}
		}
		System.out.println("程序退出~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}

// 定义一个ArrayStack 表示栈
class ArrayStack {
	private int maxSize; // 栈的大小
	private int [] stack; // 数组来模拟栈，数据就放到数组里
	private  int top = -1; // 栈顶，初始化-1

	// 构造器
	public ArrayStack (int maxSize) {
		this.maxSize = maxSize;
		stack = new int [this.maxSize];
	}

	// 栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// 栈空
	public boolean isEmpty() {
		return top == -1;
	}

	// 入栈
	public void push(int num) {
		if (isFull()) {
			System.out.println("栈满，不能添加数据");
			return;
		}
		top++;
		stack[top] = num;
	}

	// 出栈 将栈顶数据返回
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈空，不能出栈操作");
		}
		int value = stack[top];
		top--;
		return value;
	}
	// 遍历栈
	public void list() {
		if (isEmpty()) {
			System.out.println("没有数据");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
}
