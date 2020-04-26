package com.sxh.interviewquestion.characterstring;/**
 * Created by SXH on 2020/3/30 23:19.
 */

import java.util.Scanner;

/**
 * @author SXH
 * @description
 * 链接：https://ac.nowcoder.com/acm/contest/320/B
 * 来源：牛客网
 *
 * 输入第一行包括一个数据组数t(1 <= t <= 100)
 * 接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
 * @date 2020/3/30 23:19.
 */
public class CharacterTest3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int line = in.nextInt();
		System.out.println("共有：" + line + "组数据");
		for (int i = 0; i < line; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(a + b);
		}
	}
}
