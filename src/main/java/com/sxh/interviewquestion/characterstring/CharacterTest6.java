package com.sxh.interviewquestion.characterstring;/**
 * Created by SXH on 2020/3/30 23:19.
 */

import java.util.Scanner;

/**
 * @author SXH
 * @description
	链接：https://ac.nowcoder.com/acm/contest/320/E
	来源：牛客网

	输入的第一行包括一个正整数t(1 <= t <= 100), 表示数据组数。
	接下来t行, 每行一组数据。
	每行的第一个整数为整数的个数n(1 <= n <= 100)。
	接下来n个正整数, 即需要求和的每个正整数。
 * @date 2020/3/30 23:19.
 */
public class CharacterTest6 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int line = in.nextInt();
		for (int i = 0; i < line; i++) {
			int n = in.nextInt();
			int tmp = 0;
			for (int j = 0; j < n; j++) {
				tmp += in.nextInt();
			}
			System.out.println(tmp);
		}
	}
}
