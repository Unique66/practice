package com.sxh.test;/**
 * Created by SXH on 2020/4/1 15:50.
 */

import com.sxh.designMode.designpractic.decoratorpattern.Test;

/**
 * @author SXH
 * @description
 * @date 2020/4/1 15:50.
 */
public class Test2 {
	private static int i =0;

	public static void main(String[] args) {
		Test2 test21 = new Test2();
		Test2.i++;

		A a1 = new A();
		A a2 = new B();
		A a3 = new C();
	}
}
