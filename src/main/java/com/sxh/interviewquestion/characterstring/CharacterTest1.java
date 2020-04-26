package com.sxh.interviewquestion.characterstring;/**
 * Created by SXH on 2020/3/30 20:46.
 */

import java.util.Scanner;

/**
 * @author SXH
 * @description
 * @date 2020/3/30 20:46.
 */
public class CharacterTest1 {
	public static void main(String[] args) {
//		String str = "   kk kkk klaf    fsaff fsge tg sagh ger fsaga   ";
//		String regex = "\\s+";
////		String regex = "/s+/";
//		str.trim();
//		String str1 = str.replaceAll(regex, "%20");
//		String str2 = str.replace(" ", "%20");
//		System.out.println(str);
//		System.out.println(str1);
//		System.out.println(str2);
//
//		System.out.println(getResult("They are students", "  "));

		System.out.println("请输入第一个字符串：");
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		System.out.println("请输入要删除的字符串：");
		String str2 = scan.nextLine();
		System.out.println(getResult(str1, str2));

	}

	// 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
	// 例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
	public static String getResult(String str1, String str2) {
		if (str2 == null || "".equals(str2) || str1 == null || str1 == "") {
			return str1;
		}
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0,len = str1.length(); i < len; i++) {
			if (!str2.contains(str1.charAt(i) + "")) {
				stringBuffer.append(str1.charAt(i));
			}
		}
		return stringBuffer.toString();
	}
}
