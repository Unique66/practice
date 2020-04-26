package com.sxh.interviewquestion.characterstring;/**
 * Created by SXH on 2020/3/30 23:19.
 */

import java.util.Scanner;

/**
 * @author SXH
 * @description
	链接：https://ac.nowcoder.com/acm/contest/320/F
	来源：牛客网

	输入描述:
	输入数据有多组, 每行表示一组输入数据。
	每行的第一个整数为整数的个数n(1 <= n <= 100)。
	接下来n个正整数, 即需要求和的每个正整数。
	输出描述:
	每组数据输出求和的结果
 * @date 2020/3/30 23:19.
 */
public class CharacterTest7 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int tmp = 0;
			for (int j = 0; j < n; j++) {
				tmp += in.nextInt();
			}
			System.out.println(tmp);
		}
	}
}
