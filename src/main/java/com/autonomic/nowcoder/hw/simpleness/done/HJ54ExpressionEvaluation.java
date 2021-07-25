/*
 * Copyright (c) 2021.  User:Unique66 File:HJ54ExpressionEvaluation.java
 * Date:2021/07/14 23:13:14
 */

package com.autonomic.nowcoder.hw.simpleness.done;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Unique66
 * @description HJ54 表达式求值
 * @date 2021/7/14 22:26
 * <p>
 * https://www.nowcoder.com/practice/9566499a2e1546c0a257e885dfdbf30d?tpId=37&&tqId=21277&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 给定一个字符串描述的算术表达式，计算出结果值。
 *
 * 输入字符串长度不超过100，合法的字符包括”+, -, *, /, (, )”，”0-9”，
 * 字符串内容的合法性及表达式语法的合法性由做题者检查。本题目只涉及整型计算。
 *
 * 输入描述：
 * 输入算术表达式
 *
 * 输出描述：
 * 计算出结果值
 *
 * 示例1
 * 输入：400+5
 * 输出：405
 *
 * 注：可能存在-1*(-1-1)   以负数打头的
 */
public class HJ54ExpressionEvaluation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String input = in.next();
        System.out.println(calculate(input));

        System.out.println("-1".matches("^(-)?\\d+$"));
    }

    // 公式计算
    public static int calculate(String equation) {
        boolean flag = false; // 负号开头
        if (equation.charAt(0) == '-') {
            flag = true;
            equation = equation.substring(1);
        }
        // 1、将输入字符串转为中缀表达式的String[]
        List<String> infix = toInfixExpressionList(equation);
        System.out.println("中缀表达式对应的List：" + infix);
        // 2、中缀表达式转后缀表达式
        List<String> suffix = toSuffixExpression(infix);
        System.out.println("后缀表达式对应的List：" + suffix);
        // 3、拿到后缀表达式，进行计算，返回最终结果
        return flag ? -1 * calc(suffix) : calc(suffix);
    }

    // 1、将输入字符串转为中缀表达式的String[]
    // 将中缀表达式转为对应的List
    private static List<String> toInfixExpressionList(String s) {
        // 定义一个List，存放中缀表达式对应的内容
        List<String> ls = new ArrayList<>();
        int i = 0; // 这是一个指针，用于比那里中缀表达式字符串
        StringBuilder str; // 对多位数的拼接 如699
        char c; // 每遍历一个字符，就放到c
        do {
            // 如果c 是一个非数字，我们直接加入到ls 中
            if (((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57)
                    && !(i != 0 && s.charAt(i - 1) == '(' && s.charAt(i) == '-')) {
                ls.add("" + c);
                i++;
            } else { // 如果是数，需要考虑多位数问题
                str = new StringBuilder(); // 首先将str 置为""
                // 如果前一个是括号，当前是-号
                if (i != 0 && s.charAt(i - 1) == '(' && s.charAt(i) == '-') {
                    str.append(s.charAt(i));
                    i++;
                }
                while (i < s.length() && s.charAt(i) >= 48 && (c = s.charAt(i)) <= 57) { // 如果是多位数需要拼接
                    str.append(c);
                    i++;
                }
                ls.add(str.toString());
            }
        } while (i < s.length());
        return ls;
    }

    // 2、中缀表达式转后缀表达式
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
    private static List<String> toSuffixExpression(List<String> list) {
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>(); // s2 可以用链表来代替
        for (String ele : list) {
            if (ele.matches("^(-)?\\d+$")) { // 遇到操作数时，将其压s2；
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
                while (s1.size() != 0 && priority(s1.peek()) >= priority(ele)) {
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

    // 3、拿到后缀表达式，进行计算，返回最终结果
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
    private static int calc(List<String> list) {
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

    // 优先级越高返回的int 越大
    private static int priority(String oper) {
        if ("*".equals(oper) || "/".equals(oper)) {
            return 1;
        } else if ("+".equals(oper) || "-".equals(oper)) {
            return 0;
        } else {
            return -1; // 假定目前只有 + - * / 四种运算符
        }
    }
}
