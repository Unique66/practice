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
 * 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组, 如果输入为0 0则结束输入
 * @date 2020/3/30 23:19.
 */
public class CharacterTest4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int a = in.nextInt();
			int b = in.nextInt();
			if (a ==0 && b==0) {
				break;
			}
			System.out.println(a + b);
		}
	}
}
