package com.sxh.interviewquestion.characterstring;/**
 * Created by SXH on 2020/3/30 23:19.
 */

import java.util.Scanner;

/**
 * @author SXH
 * @description
	链接：https://ac.nowcoder.com/acm/contest/320/G
	来源：牛客网

	输入描述:
	输入数据有多组, 每行表示一组输入数据。

	每行不定有n个整数，空格隔开。(1 <= n <= 100)。
	输出描述:
	每组数据输出求和的结果
 * @date 2020/3/30 23:19.
 */
public class CharacterTest8 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String s = in.nextLine();
			String[] split = s.trim().split("\\s+");
			int tmp = 0;
			for (int i = 0; i < split.length; i++) {
				tmp+= Integer.parseInt(split[i]);
			}
			System.out.println(tmp);
		}
	}
}
