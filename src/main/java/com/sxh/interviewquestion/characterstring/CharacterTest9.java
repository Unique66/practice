package com.sxh.interviewquestion.characterstring;/**
 * Created by SXH on 2020/3/30 23:19.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SXH
 * @description
	链接：https://ac.nowcoder.com/acm/contest/320/H
	来源：牛客网

	输入描述:
	输入有两行，第一行n

	第二行是n个空格隔开的字符串
	输出描述:
	输出一行排序后的字符串，空格隔开，无结尾空格
 * @date 2020/3/30 23:19.
 */
public class CharacterTest9 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String [] array = new String[n];
		for (int i = 0; i < n; i++) {
			array[i] = in.next();
		}
		Arrays.sort(array);
		for (int i = 0; i < n; i++) {
			if (i < n - 1) {
				System.out.print(array[i] + " ");
			} else {
				System.out.print(array[i]);
			}
		}
	}
}
