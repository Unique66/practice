package com.sxh.test;/**
 * Created by SXH on 2020/4/1 15:04.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SXH
 * @description
 * @date 2020/4/1 15:04.
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// bacd    abcd
		while (in.hasNextLine()) {
			String tmp = in.nextLine();
			char[] chars = tmp.toCharArray();
			Arrays.sort(chars);
			System.out.println(chars);
		}
	}
}
