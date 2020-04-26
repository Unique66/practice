package com.sxh.jdk8newfeature;/**
 * Created by SXH on 2020/1/18 15:33.
 */

import javax.swing.text.html.Option;
import java.util.*;

/**
 * @author SXH
 * @description Lambda 表达式
 * @date 2020/1/18 15:33.
 */
public class LambdaTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("peter", "anna", "mike", "xenia");
		sort2(list);
		System.out.println(list);
		optionalTest2();
	}

	public static void optionalTest1() {
		String nullString = null;
		Optional<String> stringOptional = Optional.ofNullable(nullString);
//		stringOptional.isPresent(System.out::println );
	}

	public static String optionalTest2() {
		String nullString = null;
		Optional<String> stringOptional = Optional.ofNullable(nullString);
		return stringOptional.orElse("orElse");
	}

	public static void sort1 (List<String> list) {
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
	}

	public static void sort2 (List<String> list) {
		Collections.sort(list, (String a, String b) -> {
			return  b.compareTo(a);
		});
	}

	public static void sort3 (List<String> list) {
		Collections.sort(list, (a, b) -> b.compareTo(a));
	}
}
