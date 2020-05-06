package com.autonomic.datastructures.recursion;/**
 * Created by SXH on 2020/5/6 21:39.
 */

/**
 * @author SXH
 * @description 递归调用机制理解
 * @date 2020/5/6 21:39.
 */
public class RecursionTest {
	public static void main(String[] args) {
		// test(n)
		test(4);
		// factorial(n)
		System.out.println(factorial(4));
	}

	public static void test(int n) {
		if (n > 2) {
			test(n - 1);
		}
//		else {
			System.out.println("n=" + n);
//		}
	}

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return factorial(n - 1) * n;
		}
	}
}
