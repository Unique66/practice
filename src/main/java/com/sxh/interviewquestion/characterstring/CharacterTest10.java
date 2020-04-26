package com.sxh.interviewquestion.characterstring;/**
 * Created by SXH on 2020/3/30 23:19.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SXH
 * @description
	链接：https://ac.nowcoder.com/acm/contest/320/I
	来源：牛客网

	输入描述:
	多个测试用例，每个测试用例一行。

	每行通过空格隔开，有n个字符，n＜100
	输出描述:
	对于每组测试用例，输出一行排序过的字符串，每个字符串通过空格隔开
 * @date 2020/3/30 23:19.
 */
public class CharacterTest10 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String lineString = in.nextLine();
			String[] split = lineString.split("\\s+");
			Arrays.sort(split);
			for (int i = 0,n=split.length; i < n; i++) {
				if (i < n - 1) {
					System.out.print(split[i] + " ");
				} else {
					System.out.println(split[i]);
				}
			}
		}
	}
}
