package com.sxh.interviewquestion.characterstring;/**
 * Created by SXH on 2020/3/30 23:19.
 */

import java.util.Scanner;

/**
 * @author SXH
 * @description
	输入描述:
	输入有多组测试用例，每组空格隔开两个整数
	输出描述:
	对于每组数据输出一行两个整数的和
 * @date 2020/3/30 23:19.
 */
public class CharacterTest12 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			long a =in.nextLong();
			long b = in.nextLong();
			System.out.println(a + b);
		}
	}
}
