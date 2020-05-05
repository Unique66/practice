package com.autonomic.datastructures.stack;/**
 * Created by SXH on 2020/5/5 18:42.
 */

import java.util.*;

/**
 * @author SXH
 * @description 逆波兰表达式（中缀转后缀）等实现
 *				注：逆波兰表达式就是后缀表达式
 *					波兰表达式就是前缀表达式
 * @date 2020/5/5 18:42.
 */
public class PolandNotation {
	public static void main(String[] args) {
		// 1 2 3 + 4 * + 5 -       3 4 + 5 * 6 -
//		String suffixExpresion = "3 4 + 5 * 6 -";
//		System.out.println(getListString(suffixExpresion));
//		System.out.println(getListString(suffixExpresion).getClass());
//
//		System.out.println(calc(getListString(suffixExpresion)));
//		// 测试中缀表达式转list 功能
//		System.out.println(toInfixExpressionList("(44+3)*40+33*66"));

		// 测试中缀转后缀表达式功能
		List<String> infix = toInfixExpressionList("(44+3)*40+33*66");
		System.out.println("中缀表达式对应的List：" + infix);
		List<String> suffix = toSuffixExpression(infix);
		System.out.println("后缀表达式对应的List：" + suffix);
		System.out.println(calc(suffix));
	}

	/* 中缀表达式转换为后缀表达式：
		1）初始化两个栈：运算符栈s1 和存储中间结果的栈s2；
		2）从左至右扫描中缀表达式；
		3）遇到操作数时，将其压s2；
		4）遇到运算符时，比较其与s1 栈顶运算符的优先级：
			（1）如果s1 为空，或栈顶运算符为左括号“(”，则直接将运算符入栈；
			（2）否则，若优先级比栈顶运算符的高，也将运算符压入s1；
			（3）否则，将s1 栈顶的运算符弹出并压入到s2 中，再次转到（4-1）与s1 中新的栈顶运算符相比较；
		5）遇到括号时：
			（1）如果是左括号“(”，则直接压入s1;
			（2）如果是右括号“)”，则依次弹出s1 栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃;
		6）重复步骤2至5，直到表达式的最右边;
		7）将s1 中剩余的运算符依次弹出并压入s2;
		8）依次弹出s2 中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
	 * @Date 2020/5/5  22:57
	 **/
	public static List<String> toSuffixExpression(List<String> list) {
		Stack<String> s1 = new Stack<String>();
		List<String> s2 = new ArrayList<String>(); // s2 可以用链表来代替
		for (String ele : list) {
			if (ele.matches("\\d+")) { // 遇到操作数时，将其压s2；
				s2.add(ele);
			} else if ("(".equals(ele)) {
				s1.push(ele);
			} else if (")".equals(ele)) {
				// 如果是右括号“)”，则依次弹出s1 栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃;
				while (!"(".equals(s1.peek())) {
					s2.add(s1.pop());
				}
				s1.pop(); // 将左括号弹出s1 栈，消除括号
			} else {
				// 当ele 的优先级小于等于 s1 栈顶运算符，将 s1 栈顶的运算符弹出并加入到 s2 中，再次转到（4-1）与s1 中新的栈顶运算符相比较；
				// 此时就需要一个优先级的方法
				while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(ele)) {
					s2.add(s1.pop());
				}
				s1.push(ele);
			}
		}
		// 将s1 剩余的运算符依次弹出并加入s2
		while (s1.size() != 0) {
			s2.add(s1.pop());
		}
		return s2;
	}

	// 将中缀表达式转为对应的List
	public static List<String> toInfixExpressionList(String s) {
		// 定义一个List，存放中缀表达式对应的内容
		List<String> ls = new ArrayList<>();
		int i = 0; // 这是一个指针，用于比那里中缀表达式字符串
		String str; // 对多位数的拼接 如699
		char c; // 每遍历一个字符，就放到c
		do {
			// 如果c 是一个非数字，我们直接加入到ls 中
			if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				ls.add("" + c);
				i++;
			} else { // 如果是数，需要考虑多位数问题
				str = ""; // 首先将str 置为""
				while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) { // 如果是多位数需要拼接
					str +=  c;
					i++;
				}
				ls.add(str);
			}
		} while (i < s.length());
		return ls;
	}

	// 将传入的逆波兰表达式的数据和运算符依次放到ArrayList 中
	public static List<String> getListString(String suffixExpression) {
		// 将后缀表达式分割
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<>();
		for (String ele : split) {
			list.add(ele);
		}
		return list;
	}

	// 逆波兰表达式运算 例如：(3+4)*5-6  ->  3 4 + 5 * 6 -
	/* 思路：
		从左至右扫描表达式，遇到数字时，将数字压入堆栈，遇到符号运算符时，弹出栈顶的两个数，
		用运算符对它们进行相应的运算（次顶元素 和 栈顶元素），并将结果入栈；重复上述过程，直到
		表达式最右端，最后运算得出的值即为表达式的结果。
	  实际应用：
		1）从左向右扫描，将3 和4 压入堆栈；
		2）遇到 + 运算符，因此弹出4 和3 （4为栈顶元素，3为次顶元素），计算出3+4的值，
			得7，再将7 入栈；
		3）将5入栈；
		4）接下来 * 运算符，因此弹出5和7，计算出 7 * 5 =35，将35 入栈；
		5）将6 入栈
		6）最后是 - 运算符，计算出35 - 6 = 29，由此得出最终结果
	 */
	public static int calc(List<String> list) {
		// 创建一个栈存数据
		Stack<String> stack = new Stack<>();
		// 遍历list
		for (String l : list) {
			// 正则匹配数字
			if (l.matches("\\d+")) {
				stack.push(l);
			} else {
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				if ("*".equals(l)) {
					res = num1 * num2;
				} else if ("-".equals(l)) {
					res = num1 - num2;
				} else if ("+".equals(l)) {
					res = num1 + num2;
				} else if ("/".equals(l)) {
					res = num1 / num2;
				} else {
					throw new RuntimeException("异常符号");
				}
				stack.push("" + res);
			}
		}
		return Integer.parseInt(stack.peek());
	}
}
// 编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation {
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;

	// 写一个方法，返回对应优先级
	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
			case "+" :
				result = ADD;
				break;
			case "-" :
				result = SUB;
				break;
			case "*" :
				result = MUL;
				break;
			case "/" :
				result = DIV;
				break;
			default:
				System.out.println("不存在该运算符");
				break;
		}
		return result;
	}
}
