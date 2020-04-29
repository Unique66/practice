package com.autonomic.datastructures.stack;/**
 * Created by SXH on 2020/4/29 22:10.
 */

/**
 * @author SXH
 * @description 使用数组实现的栈 来完成一个简易计算器
 * @date 2020/4/29 22:10.
 */
public class Calculator {
	public static void main(String[] args) {
		System.out.println(operation("70*2+4"));
	}
	/**
	 * @Author SXH
	 * @Description
	 * 	数组实现的栈 来实现综合计算机的思路：
	 * 	1.首先使用一个index，用来遍历我们输入的计算式子
	 *  2.创建两个栈：数栈（存储数字）、符号栈（存储运算符）
	 *  3.开始遍历计算式，如果是数字，就压入数栈
	 *  4.如果是符号，就分如下情况
	 *  	a.符号栈不为空，判断当前符号的优先级 和符号栈栈顶的那个符号比，谁的优先级高：
	 * 			i.如果当前符号的优先级高，那么就压入符号栈
	 * 			ii.如果当前符号的优先级低，那么就需要把数栈中的两个数pop出来，把符号栈顶的符号pop出来，做运算处理result =  num2 符号 num1  ,得到的result push到数栈，当前符号push 到符号栈
	 * 		b.符号栈为空，直接把符号压入符号栈
	 * 	5.当计算式遍历完毕，就顺序从数栈和符号栈pop 相应的数和符号进行运算，并将结果压入数栈
	 * 	6.直到符号栈没有内容或者数栈只有一个值
	 * @Date 2020/4/29  23:21
	 **/
	public static int operation(String expression) {
		int index = 0; // 记录遍历下标
		ArrayStack2 numStack = new ArrayStack2(20); // 创建数栈
		ArrayStack2 operStack = new ArrayStack2(10); // 创建操作栈
		String keepNum = ""; // 临时变量，用于缓存处理数字是70 这种多个数字的情况
		int num1 = 0; // 数栈第一个pop 的值
		int num2 = 0; // 数栈第二个pop 的值
		int oper = ' ';
		int res = 0;
		while (true) { // 遍历表达式，把表达式的内容压入对应的栈中
			// 获取表达式 的一个字符
			char value = expression.substring(index, index + 1).charAt(0);
			// 判断是否是操作符
			if (operStack.isOps(value)) {
				// 判断符号栈是不是空的
				// 如果不为空，则需要判断当前操作符的优先级是否高于操作栈栈顶的符号
				if (!operStack.isEmpty()) {
					// 当前操作符优先级较低
					// 那么就需要把数栈中的两个数pop出来，把符号栈顶的符号pop出来，
					// 做运算处理result =  num2 符号 num1  ,得到的result push到数栈，当前符号push 到符号栈
					if (operStack.priority(value) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop(); // 数栈第一个pop 的数
						num2 = numStack.pop(); // 数栈第二个pop 的数
						oper = operStack.pop(); // 从符号操作栈pop 出符号位
						int result = operStack.calc(num1, num2, oper); // 开始计算
						numStack.push(result); // 计算完成后需要把结果放入到数栈中
						operStack.push(value); // 并且需要把当前操作符push 到符号操作栈
					} else { // 当前操作符优先级高于操作栈栈顶符号优先级，那么就压入符号栈
						operStack.push(value);
					}
				} else { // 为空，则直接把当前操作符压入符号栈中
					operStack.push(value);
				}
			} else { // 不是操作符那就是数字了
				// 先放到数字缓存中去
				keepNum += value;
				// 如果 value 是表达式的最后一位，就不用去判断该数字下一位是什么了
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else {
					// 判断当前数字的下一位是否是数字，不是数字才push 到数栈中去
					if (numStack.isOps(expression.substring(index + 1, index + 2).charAt(0))) {
						numStack.push(Integer.parseInt(keepNum));
						// 并且将temp 重新置为空以备下一次遇到此种情况
						keepNum = "";
					}
				}
			}
			index++;
			if (index == expression.length()) { // 遍历完毕，跳出循环
				break;
			}
		}

		// 遍历完表达式后，如果表达式含有+ 或 - ，数栈和符号栈就一定有数据，需要处理
		// * 和 / 已经在上面被处理了
		while (true) {
			// 直到符号操作栈为空，表示我们已经遍历完了，
			if (operStack.isEmpty()) {
				res = numStack.pop();
				break;
			} else { // 不为空，那么就需要处理数栈和符号操作栈中的数据
				num1 = numStack.pop(); // 数栈第一个pop 的数
				num2 = numStack.pop(); // 数栈第二个pop 的数
				oper = operStack.pop(); // 从符号操作栈pop 出符号位
				int result = operStack.calc(num1, num2, oper); // 开始计算
				numStack.push(result); // 计算完成后需要把结果放入到数栈中
			}
		}
		return res;
	}
}
// 定义一个ArrayStack 表示栈
class ArrayStack2 {
	private int maxSize; // 栈的大小
	private int [] stack; // 数组来模拟栈，数据就放到数组里
	private  int top = -1; // 栈顶，初始化-1

	// 构造器
	public ArrayStack2 (int maxSize) {
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
	// 显示栈顶的值
	public int peek() {
		return stack[top];
	}
	// 判断是否是符号
	public boolean isOps(char val) {
		return '+' == val || '-' == val || '*' == val || '/' == val;
	}
	// 判断优先级
	// 优先级越高返回的int 越大
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1; // 假定目前只有 + - * / 四种运算符
		}
	}

	// 运算操作
	public int calc(int num1, int num2, int oper) {
		int result = 0;
		switch (oper) {
			case  '*':
				result = num1 * num2;
				break;
			case '/':
				result = num2 / num1;// 除法要考虑顺序，后pop出来的除以前一个pop 出来的
				break;
			case '-':
				result = num2 - num1; // 减法要考虑顺序，后pop出来的减去前一个pop 出来的
				break;
			case '+':
				result = num2 + num1;
				break;
			default:
				break;
		}
		return result;
	}
}

