package com.sxh.interviewquestion.characterstring;/**
 * Created by SXH on 2020/3/30 23:19.
 */

import java.util.Scanner;

/**
 * @author SXH
 * @description
	链接：https://ac.nowcoder.com/acm/contest/320/D
	来源：牛客网

	输入数据包括多组。
	每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
	接下来n个正整数,即需要求和的每个正整数。
 * @date 2020/3/30 23:19.
 */
public class CharacterTest5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String s = in.nextLine();
			String[] split = s.split("\\s+");
			if (!(Integer.parseInt(split[0]) == 0 || split[0] == null)) {
				int tmp = 0;
				for (int i = 1; i < split.length; i++) {
					tmp+= Integer.parseInt(split[i]);
				}
				System.out.println(tmp);
			} else {
				break;
			}
		}
	}
}
