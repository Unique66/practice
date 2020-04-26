package com.sxh.interviewquestion.characterstring;/**
 * Created by SXH on 2020/3/30 23:19.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SXH
 * @description
	链接：https://ac.nowcoder.com/acm/contest/320/J
	来源：牛客网

	输入描述:
	多个测试用例，每个测试用例一行。
	每行通过,隔开，有n个字符，n＜100
	输出描述:
	对于每组用例输出一行排序后的字符串，用','隔开，无结尾空格
 * @date 2020/3/30 23:19.
 */
public class CharacterTest11 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String lineString = in.nextLine();
			String[] split = lineString.split("\\s+");
			Arrays.sort(split);
			for (int i = 0,n=split.length; i < n; i++) {
				if (i < n - 1) {
					System.out.print(split[i] + ",");
				} else {
					System.out.println(split[i]);
				}
			}
		}
	}
}
