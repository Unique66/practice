package com.sxh.interviewquestion.characterstring;/**
 * Created by SXH on 2020/3/30 23:19.
 */

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author SXH
 * @description 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组
 * @date 2020/3/30 23:19.
 */
public class CharacterTest2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(a + b);
		}
	}
}
